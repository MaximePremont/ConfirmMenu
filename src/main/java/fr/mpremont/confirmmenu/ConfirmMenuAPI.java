package fr.mpremont.confirmmenu;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.mpremont.confirmmenu.events.custom.CancelEvent;
import fr.mpremont.confirmmenu.events.custom.ConfirmEvent;
import fr.mpremont.confirmmenu.menus.ConfirmMenu;

public class ConfirmMenuAPI {
	
	private static HashMap<UUID, String> list = new HashMap<UUID, String>();
	
	public static void confirm(Player player, String action) {
		
		boolean wasOP = false;
		if(!MainClass.getInstance().getConfig().getBoolean("SkipPermsForOP")) {
			if(player.isOp()) {
				wasOP = true;
				player.setOp(false);
			}
		}
		if(player.hasPermission("confirmmenu.skip")) {
			ConfirmEvent event = new ConfirmEvent(player, getConfirmAction(player));
			Bukkit.getPluginManager().callEvent(event);
		}else {
			if(!isConfirming(player)) {
				list.put(player.getUniqueId(), action);
				ConfirmMenu.openMenu(player);
			}
		}
		if(wasOP) {
			player.setOp(true);
		}
		
	}
	
	public static void cancel(Player player) {
		
		if(isConfirming(player)) {
			
			CancelEvent event = new CancelEvent(player, getConfirmAction(player));
			list.remove(player.getUniqueId());
			Bukkit.getPluginManager().callEvent(event);
			if(player.getOpenInventory() != null) {
				player.closeInventory();
			}
			
		}
		
	}
	
	public static boolean isConfirming(Player player) {
		
		return list.containsKey(player.getUniqueId());
		
	}
	
	public static String getConfirmAction(Player player) {
		
		String result = null;
		
		if(isConfirming(player)) {
			
			result = list.get(player.getUniqueId());
			
		}
		
		return result;
		
	}
	
	public static void w(Player p) {
		
		if(isConfirming(p)) {
			
			list.remove(p.getUniqueId());
			
		}
		
	}

}
