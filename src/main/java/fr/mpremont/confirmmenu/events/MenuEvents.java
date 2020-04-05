package fr.mpremont.confirmmenu.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.mpremont.confirmmenu.ConfirmMenuAPI;
import fr.mpremont.confirmmenu.MainClass;
import fr.mpremont.confirmmenu.events.custom.ConfirmEvent;

public class MenuEvents implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if(e.getInventory() == null) {
			
			return;
			
		}else {
			
			Player p = (Player) e.getWhoClicked();
			if(ConfirmMenuAPI.isConfirming(p)) {
				
				String title = "§8§lCONFIRM";
				if(MainClass.getInstance().getConfig().getString("Text.MenuTitle") != null || MainClass.getInstance().getConfig().getString("Text.MenuTitle") != "") {
					title = MainClass.getInstance().getConfig().getString("Text.MenuTitle").replaceAll("&", "§");
				}
				
				if(e.getView().getTitle().equalsIgnoreCase(title)) {
					
					e.setCancelled(true);
					
					if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
						
						return;
						
					}else if(e.getCurrentItem().getType() == Material.SLIME_BLOCK) {
						
						ConfirmEvent event = new ConfirmEvent(p, ConfirmMenuAPI.getConfirmAction(p));
						Bukkit.getPluginManager().callEvent(event);
						ConfirmMenuAPI.w(p);
						p.closeInventory();
						
					}else {
						
						ConfirmMenuAPI.cancel(p);
						
					}
					
				}
				
			}
			
		}
		
	}
	
}
