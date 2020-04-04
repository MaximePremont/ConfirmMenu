package fr.mpremont.confirmmenu.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import fr.mpremont.confirmmenu.ConfirmMenuAPI;
import fr.mpremont.confirmmenu.events.custom.ConfirmEvent;

@SuppressWarnings("deprecation")
public class ChatEvents implements Listener {
	
	@EventHandler
	public void onChat(PlayerChatEvent e) {
		
		Player p = e.getPlayer();
		
		if(ConfirmMenuAPI.isConfirming(p)) {
			
			if(e.getMessage().toLowerCase().replaceAll(" ", "").equalsIgnoreCase("confirm")) {
				
				ConfirmEvent event = new ConfirmEvent(p, ConfirmMenuAPI.getConfirmAction(p));
				Bukkit.getPluginManager().callEvent(event);
				ConfirmMenuAPI.w(p);
				
			}else {
				
				ConfirmMenuAPI.cancel(p);
				
			}
			
			e.setCancelled(true);
			
		}
		
	}

}
