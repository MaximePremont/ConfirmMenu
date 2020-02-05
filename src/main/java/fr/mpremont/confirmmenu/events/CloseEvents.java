package fr.mpremont.confirmmenu.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import fr.mpremont.confirmmenu.ConfirmMenuAPI;

public class CloseEvents implements Listener {
	
	@EventHandler
	public void onClose(InventoryCloseEvent e) {
		
		Player p = (Player) e.getPlayer();
		
		if(ConfirmMenuAPI.isConfirming(p)) {
			
			if(e.getInventory() != null) {
				
				ConfirmMenuAPI.cancel(p);
				
			}
			
		}
		
	}

}
