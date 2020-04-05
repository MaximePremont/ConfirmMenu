package fr.mpremont.confirmmenu.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import fr.mpremont.confirmmenu.events.custom.ConfirmEvent;

public class GlobalEvents implements Listener {
	
	@EventHandler
	public void onConfirm(ConfirmEvent e) {
		
		if(e.getAction() == null) {
			
			return;
			
		}else if(e.getAction().startsWith("#CME|CMD#")) {
			
			Player p = e.getPlayer();
			String cmd = e.getAction().split(">")[1];
			p.performCommand(cmd);
			
		}
		
	}

}
