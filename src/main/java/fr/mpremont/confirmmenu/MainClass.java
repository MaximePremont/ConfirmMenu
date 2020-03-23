package fr.mpremont.confirmmenu;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.mpremont.confirmmenu.managers.CommandsManager;
import fr.mpremont.confirmmenu.managers.ConfigManager;
import fr.mpremont.confirmmenu.managers.EventsManager;
import fr.mpremont.confirmmenu.managers.VersionsManager;

public class MainClass extends JavaPlugin{
	
	private static Plugin p;
	
	public void onEnable() {
		
		p = this;
		
		if(VersionsManager.setupVersion()) {
			
			File f = new File(getDataFolder(), "config.yml");
			if(!f.exists()) {
				
				getConfig().options().copyDefaults(true);
				saveDefaultConfig();
				Bukkit.getConsoleSender().sendMessage("§b[§eConfirmMenu§b] §aConfiguration file created !");
				
			}
			
			if(ConfigManager.checkConfig()) {
				
				EventsManager.registerEvents();
				CommandsManager.registerCommands();
				
				int pluginId = 6853;
				@SuppressWarnings("unused")
				Metrics metrics = new Metrics(this, pluginId);
				
			}else {
				
				Bukkit.getPluginManager().disablePlugin(this);
				
			}
			
		}else {
			
			Bukkit.getConsoleSender().sendMessage("§b[§eConfirmMenu§b] §cUnsupported minecraft version !");
			Bukkit.getPluginManager().disablePlugin(this);
			
		}
		
	}
	
	public static Plugin getInstance() {
		
		return p;
		
	}

}
