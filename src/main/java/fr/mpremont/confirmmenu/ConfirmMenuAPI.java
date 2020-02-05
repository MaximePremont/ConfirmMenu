package fr.mpremont.confirmmenu;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.mpremont.confirmmenu.events.custom.CancelEvent;
import fr.mpremont.confirmmenu.menus.ConfirmMenu;

public class ConfirmMenuAPI {
	
	private static HashMap<Player, String> list = new HashMap<Player, String>();
	
	public static void confirm(Player player, String action) {
		
		Bukkit.broadcastMessage("§e>> "+player.getName()+" :: "+action);
		
		if(!isConfirming(player)) {
			
			Bukkit.broadcastMessage("§5Added");
			list.put(player, action);
			ConfirmMenu.openMenu(player);
			
		}
		
	}
	
	public static void cancel(Player player) {
		
		if(isConfirming(player)) {
			
			CancelEvent event = new CancelEvent(player, getConfirmAction(player));
			list.remove(player);
			Bukkit.getPluginManager().callEvent(event);
			if(player.getOpenInventory() != null) {
				player.closeInventory();
			}
			
		}
		
	}
	
	public static boolean isConfirming(Player player) {
		
		boolean result = false;
		if(list.containsKey(player)) {
			
			result = true;
			Bukkit.broadcastMessage("§dContains "+player.getName());
			
		}
		
		return result;
		
	}
	
	public static String getConfirmAction(Player player) {
		
		String result = null;
		
		if(isConfirming(player) == true) {
			
			result = list.get(player);
			
		}
		
		return result;
		
	}
	
	public static void w(Player p) {
		
		if(isConfirming(p)) {
			
			list.remove(p);
			
		}
		
	}

}
