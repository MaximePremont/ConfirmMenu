package fr.mpremont.confirmmenu.managers;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;

import fr.mpremont.confirmmenu.MainClass;

public class ConfigManager {
	
	public static boolean checkConfig() {
		
		boolean result = true;
		
		String confv = MainClass.getInstance().getConfig().getString("ConfigVersion");
		if(confv == null || confv == "" || (!confv.contains("#"))) {
			
			Bukkit.getConsoleSender().sendMessage("§b[§eConfirmMenu§b] §cInvalid configuration file !");
			result = false;
			
		}else {
			
			Configuration c = MainClass.getInstance().getConfig();
			String version = c.getString("ConfigVersion").split("#")[0];
			
			if(!version.equalsIgnoreCase("1.0.4")) {
				
				setBasic(c);
				MainClass.getInstance().reloadConfig();
				c = MainClass.getInstance().getConfig();
				
			}
			
			String lang = c.getString("ConfigVersion").split("#")[1];
			String current = c.getString("Language");
			
			if(!lang.equalsIgnoreCase(current)) {
				
				if(current.equalsIgnoreCase("FR")) {
					setFR(c);
				}else if(current.equalsIgnoreCase("ES")) {
					setES(c);
				}else if(current.equalsIgnoreCase("OTHER")) {
					setOTHER(c);
				}else {
					setEN(c);
				}
				
				MainClass.getInstance().reloadConfig();
				
			}
			
		}
		
		return result;
		
	}
	
	private static void setOTHER(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String confirmMessage = c.getString("Text.ConfirmMessage");
		if(confirmMessage == null || confirmMessage == "") {
			confirmMessage = "&eAre you sure ?";
		}
		String menuTitle = c.getString("Text.MenuTitle");
		if(menuTitle == null || menuTitle == "") {
			menuTitle = "&8&lCONFIRM";
		}
		String menuConfirm = c.getString("Text.MenuConfirm");
		if(menuConfirm == null || menuConfirm == "") {
			menuConfirm = "&a&lCONFIRM";
		}
		String menuCancel = c.getString("Text.MenuCancel");
		if(menuCancel == null || menuCancel == "") {
			menuCancel = "&c&lCANCEL";
		}
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			PrintWriter writer = new PrintWriter("./plugins/ConfirmMenu/config.yml");
			writer.println("# ========== Confirm Menu by MaximePremont ==========\n"
					+ "\n"
					+ "# List of commands that require confirmation\n"
					+ "Commands: \""+commands+"\"\n"
					+ "\n"
					+ "# Enable open sound\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# Messages ( color codes are valid )\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "# Changing the language will automatically change the configuration on the next reboot\n"
					+ "# Available languages : EN | FR | ES | OTHER\n"
					+ "Language : \"OTHER\"\n"
					+ "# Check for updates and send a message to the console\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [Do not touch] Configuration version\n"
					+ "ConfigVersion: 1.0.4#other");
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setES(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String confirmMessage = "&eEstas seguro ?";
		String menuTitle = "&8&lCONFIRMAR";
		String menuConfirm = "&a&lCONFIRMAR";
		String menuCancel = "&c&lCANCELAR";
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			PrintWriter writer = new PrintWriter("./plugins/ConfirmMenu/config.yml");
			writer.println("# ========== Confirm Menu de MaximePremont ==========\n"
					+ "\n"
					+ "# Lista de comandos que necesitan confirmación\n"
					+ "Commands: \""+commands+"\"\n"
					+ "\n"
					+ "# Activa el sonido de apertura del menú\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# Mensajes ( los códigos de colores funcionan )\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "# Cambiar el idioma cambiará automáticamente la configuración en el próximo reinicio\n"
					+ "# Idiomas disponibles : EN | FR | ES | OTHER\n"
					+ "Language : \"ES\"\n"
					+ "# Comprube si hay un actualización e indíquela en la consola\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [No modificar] Versión de configuración\n"
					+ "ConfigVersion: 1.0.4#es");
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setFR(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String confirmMessage = "&eÊtes-vous sûr ?";
		String menuTitle = "&8&lCONFIRMATION";
		String menuConfirm = "&a&lCONFIRMER";
		String menuCancel = "&c&lANNULER";
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			PrintWriter writer = new PrintWriter("./plugins/ConfirmMenu/config.yml");
			writer.println("# ========== Confirm Menu par MaximePremont ==========\n"
					+ "\n"
					+ "# Liste des commandes qui ont besoins d'une confirmation\n"
					+ "Commands: \""+commands+"\"\n"
					+ "\n"
					+ "# Activer le son d'ouverture du menu\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# Messages ( les codes couleurs fonctionnent )\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "# Changer la langue modifiera automatiquement la configuration au prochain redémarrage\n"
					+ "# Langages disponibles : EN | FR | ES | OTHER\n"
					+ "Language : \"FR\"\n"
					+ "# Vérifier si il y à une mise à jour et l'indiquer dans la console\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [Ne pas modifier] Version de la configuration\n"
					+ "ConfigVersion: 1.0.4#fr");
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setEN(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String confirmMessage = "&eAre you sure ?";
		String menuTitle = "&8&lCONFIRM";
		String menuConfirm = "&a&lCONFIRM";
		String menuCancel = "&c&lCANCEL";
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			PrintWriter writer = new PrintWriter("./plugins/ConfirmMenu/config.yml");
			writer.println("# ========== Confirm Menu by MaximePremont ==========\n"
					+ "\n"
					+ "# List of commands that require confirmation\n"
					+ "Commands: \""+commands+"\"\n"
					+ "\n"
					+ "# Enable open sound\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# Messages ( color codes are valid )\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "# Changing the language will automatically change the configuration on the next reboot\n"
					+ "# Available languages : EN | FR | ES | OTHER\n"
					+ "Language : \"EN\"\n"
					+ "# Check for updates and send a message to the console\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [Do not touch] Configuration version\n"
					+ "ConfigVersion: 1.0.4#en");
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setBasic(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String confirmMessage = c.getString("Text.ConfirmMessage");
		if(confirmMessage == null || confirmMessage == "") {
			confirmMessage = "&eAre you sure ?";
		}
		String menuTitle = c.getString("Text.MenuTitle");
		if(menuTitle == null || menuTitle == "") {
			menuTitle = "&8&lCONFIRM";
		}
		String menuConfirm = c.getString("Text.MenuConfirm");
		if(menuConfirm == null || menuConfirm == "") {
			menuConfirm = "&a&lCONFIRM";
		}
		String menuCancel = c.getString("Text.MenuCancel");
		if(menuCancel == null || menuCancel == "") {
			menuCancel = "&c&lCANCEL";
		}
		String language = c.getString("Language");
		if(language == null || language == "") {
			language = "EN";
		}
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			PrintWriter writer = new PrintWriter("./plugins/ConfirmMenu/config.yml");
			writer.println("# ========== Confirm Menu by MaximePremont ==========\n"
					+ "\n"
					+ "# List of commands that require confirmation\n"
					+ "Commands: \""+commands+"\"\n"
					+ "\n"
					+ "# Enable open sound\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# Messages ( color codes are valid )\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "# Changing the language will automatically change the configuration on the next reboot\n"
					+ "# Available languages : EN | FR | ES | OTHER\n"
					+ "Language : \""+language+"\"\n"
					+ "# Check for updates and send a message to the console\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [Do not touch] Configuration version\n"
					+ "ConfigVersion: 1.0.4#CREATION");
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
