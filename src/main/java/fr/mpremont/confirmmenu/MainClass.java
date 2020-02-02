package fr.mpremont.confirmmenu;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.mpremont.confirmmenu.managers.CommandsManager;
import fr.mpremont.confirmmenu.managers.EventsManager;
import fr.mpremont.confirmmenu.managers.VersionsManager;

public class MainClass extends JavaPlugin{
	
	private static Plugin p;
	
	public void onEnable() {
		
		p = this;
		
		if(VersionsManager.setupVersion()) {
			
			EventsManager.registerEvents();
			CommandsManager.registerCommands();
			
		}else {
			
			Bukkit.getConsoleSender().sendMessage("§b[§eConfirmMenu§b] §cUnsupported minecraft version !");
			Bukkit.getPluginManager().disablePlugin(this);
			
		}
		
	}
	
	public static Plugin getInstance() {
		
		return p;
		
	}

}
