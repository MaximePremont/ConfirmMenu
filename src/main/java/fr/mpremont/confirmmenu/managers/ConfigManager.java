package fr.mpremont.confirmmenu.managers;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;

import fr.mpremont.confirmmenu.MainClass;

public class ConfigManager {
	
	public static boolean checkConfig() {
		
		boolean result = true;
		
		Configuration c = MainClass.getInstance().getConfig();
		String version = c.getString("ConfigVersion").split("#")[0];
		
		if(version == null) {
			
			Bukkit.getConsoleSender().sendMessage("§b[§eConfirmMenu§b] §cInvalid configuration file !");
			result = false;
			
		}else if(!version.equalsIgnoreCase("1.0.1")) {
			
			//String lang = c.getString("ConfigVersion").split("#")[1];
			String commands = c.getString("Commands");
			if(commands == null) {
				commands = "stop, reload";
			}
			String confirmMessage = c.getString("ConfirmMessage");
			if(confirmMessage == null) {
				confirmMessage = "&eAre you sure ?";
			}
			String openSound = c.getString("OpenSound");
			if(openSound == null) {
				openSound = "true";
			}
			
			try {
				
				PrintWriter writer = new PrintWriter("./plugins/ConfirmMenu/config.yml");
				writer.println("# ========== Confirm Menu by MaximePremont ==========\n"
						+ "\n"
						+ "# List of orders that require confirmation\n"
						+ "Commands: \""+commands+"\"\n"
						+ "\n"
						+ "# Messages and sounds\n"
						+ "ConfirmMessage: \""+confirmMessage+"\"\n"
						+ "OpenSound: "+openSound+"\n"
						+ "\n"
						+ "# [Do not touch ] Configuration version\n"
						+ "ConfigVersion: 1.0.1#en");
				writer.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			MainClass.getInstance().reloadConfig();
			
		}
		
		return result;
		
	}

}
