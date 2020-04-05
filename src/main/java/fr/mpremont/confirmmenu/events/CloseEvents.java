package fr.mpremont.confirmmenu.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import fr.mpremont.confirmmenu.ConfirmMenuAPI;
import fr.mpremont.confirmmenu.MainClass;

public class CloseEvents implements Listener {
	
	@EventHandler
	public void onClose(InventoryCloseEvent e) {
		
		Player p = (Player) e.getPlayer();
		
		if(ConfirmMenuAPI.isConfirming(p)) {
			
			String title = "§8§lCONFIRM";
			if(MainClass.getInstance().getConfig().getString("Text.MenuTitle") != null || MainClass.getInstance().getConfig().getString("Text.MenuTitle") != "") {
				title = MainClass.getInstance().getConfig().getString("Text.MenuTitle").replaceAll("&", "§");
			}
			
			if(e.getView().getTitle().equalsIgnoreCase(title)) {
				
				ConfirmMenuAPI.cancel(p);
				
			}
			
		}
		
	}

}
