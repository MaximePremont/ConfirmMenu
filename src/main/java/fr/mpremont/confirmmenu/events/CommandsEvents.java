package fr.mpremont.confirmmenu.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import fr.mpremont.confirmmenu.ConfirmMenuAPI;
import fr.mpremont.confirmmenu.events.custom.ConfirmationType;
import fr.mpremont.confirmmenu.managers.CommandsManager;

public class CommandsEvents implements Listener {
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		
		if(CommandsManager.isRegisteredMenu(e.getMessage().replaceAll("/", "").split(" ")[0])) {
			
			e.setCancelled(true);
			Player p = e.getPlayer();
			ConfirmMenuAPI.confirm(p, "#CME|CMD#>"+e.getMessage().replaceAll("/", ""), ConfirmationType.MENU);
			
		}else if(CommandsManager.isRegisteredWrite(e.getMessage().replaceAll("/", "").split(" ")[0])) {
			
			e.setCancelled(true);
			Player p = e.getPlayer();
			ConfirmMenuAPI.confirm(p, "#CME|CMD#>"+e.getMessage().replaceAll("/", ""), ConfirmationType.WRITE);
			
		}
		
	}

}
