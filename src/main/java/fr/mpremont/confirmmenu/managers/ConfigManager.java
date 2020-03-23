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
			
		}else if(!version.equalsIgnoreCase("1.0.2")) {
			
			//String lang = c.getString("ConfigVersion").split("#")[1];
			String commands = c.getString("Commands");
			if(commands == null) {
				commands = "stop, reload";
			}
			String openSound = c.getString("OpenSound");
			if(openSound == null) {
				openSound = "true";
			}
			String confirmMessage = c.getString("Text.ConfirmMessage");
			if(confirmMessage == null) {
				confirmMessage = "&eAre you sure ?";
			}
			String menuTitle = c.getString("Text.MenuTitle");
			if(menuTitle == null) {
				menuTitle = "&8&lCONFIRM";
			}
			String menuConfirm = c.getString("Text.MenuConfirm");
			if(menuConfirm == null) {
				menuConfirm = "&a&lCONFIRM";
			}
			String menuCancel = c.getString("Text.MenuCancel");
			if(menuCancel == null) {
				menuCancel = "&c&lCANCEL";
			}
			
			try {
				
				PrintWriter writer = new PrintWriter("./plugins/ConfirmMenu/config.yml");
				writer.println("# ========== Confirm Menu by MaximePremont ==========\n"
						+ "\n"
						+ "# List of orders that require confirmation\n"
						+ "Commands: \""+commands+"\"\n"
						+ "\n"
						+ "# Enable open sound\n"
						+ "OpenSound: "+openSound+"\n"
						+ "\n"
						+ "# Messages ( color codes are valid )\n"
						+ "Text:\n"
						+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
						+ "    MenuTitle: \""+menuTitle+"\"\n"
						+ "    MenuConfirm: \""+menuConfirm+"\"\n"
						+ "    MenuCancel: \""+menuCancel+"\"\n"
						+ "\n"
						+ "# [Do not touch ] Configuration version\n"
						+ "ConfigVersion: 1.0.2#en");
				writer.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			MainClass.getInstance().reloadConfig();
			
		}
		
		return result;
		
	}

}
