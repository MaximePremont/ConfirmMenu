package fr.mpremont.confirmmenu.managers;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;

import fr.mpremont.confirmmenu.MainClass;

public class ConfigManager {
	
	public static boolean checkConfig() {
		
		boolean result = true;
		
		Configuration c = MainClass.getInstance().getConfig();
		
		if(!c.getString("ConfigVersion").equalsIgnoreCase("1.0.0")) {
			
			Bukkit.getConsoleSender().sendMessage("§b[§eConfirmMenu§b] §cInvalid configuration file !");
			result = false;
			//Update ?
			
		}
		
		return result;
		
	}

}
