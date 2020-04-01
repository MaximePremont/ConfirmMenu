package fr.mpremont.confirmmenu.managers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import fr.mpremont.confirmmenu.MainClass;
import fr.mpremont.confirmmenu.events.CloseEvents;
import fr.mpremont.confirmmenu.events.CommandsEvents;
import fr.mpremont.confirmmenu.events.GlobalEvents;
import fr.mpremont.confirmmenu.events.JoinEvents;
import fr.mpremont.confirmmenu.events.MenuEvents;

public class EventsManager {
	
	public static void registerEvents() {
		
		Plugin p = MainClass.getInstance();
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new MenuEvents(), p);
		pm.registerEvents(new CloseEvents(), p);
		pm.registerEvents(new GlobalEvents(), p);
		pm.registerEvents(new CommandsEvents(), p);
		pm.registerEvents(new JoinEvents(), p);
		
	}

}
