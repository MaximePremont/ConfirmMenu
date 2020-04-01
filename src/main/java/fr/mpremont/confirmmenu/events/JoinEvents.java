package fr.mpremont.confirmmenu.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.mpremont.confirmmenu.MainClass;

public class JoinEvents implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		if(MainClass.update) {
			
			Player p = e.getPlayer();
			if(p.hasPermission("confirmmenu.update")) {
				p.sendMessage("§b[§eConfirmMenu§b] §r"+MainClass.getInstance().getConfig().getString("Text.NewVersion").replaceAll("&", "§"));
			}
			
		}
		
	}

}
