package fr.mpremont.confirmmenu;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.mpremont.confirmmenu.events.custom.CancelEvent;
import fr.mpremont.confirmmenu.events.custom.ConfirmEvent;
import fr.mpremont.confirmmenu.events.custom.ConfirmationType;
import fr.mpremont.confirmmenu.managers.VersionsManager;
import fr.mpremont.confirmmenu.menus.ConfirmMenu;

public class ConfirmMenuAPI {
	
	private static HashMap<UUID, String> list = new HashMap<UUID, String>();
	
	public static void confirm(Player player, String action, ConfirmationType type) {
		
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
				if(type == ConfirmationType.MENU) {
					String msg = MainClass.getInstance().getConfig().getString("Text.ConfirmMessage").replaceAll("&", "§");
					if(!msg.equalsIgnoreCase("")) {
						player.sendMessage("§b[§eConfirmMenu§b] §r"+msg);
					}
					ConfirmMenu.openMenu(player);
				}else {
					if(MainClass.getInstance().getConfig().getBoolean("OpenSound")) {
						player.playSound(player.getLocation(), VersionsManager.use().getSound("CHICKEN_EGG_POP"), 10, 1);
					}
					String message = MainClass.getInstance().getConfig().getString("Text.WriteConfirmMessage").replaceAll("&", "§");
					if(!message.equalsIgnoreCase("")) {
						player.sendMessage("§b[§eConfirmMenu§b] §r"+message);
					}
				}
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
			String message = MainClass.getInstance().getConfig().getString("Text.CancelMessage").replaceAll("&", "§");
			if(!message.equalsIgnoreCase("")) {
				player.sendMessage("§b[§eConfirmMenu§b] §r"+message);
			}
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
