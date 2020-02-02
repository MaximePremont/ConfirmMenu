package fr.mpremont.confirmmenu.managers;

import java.util.ArrayList;

public class CommandsManager{
	
	private static ArrayList<String> commands = new ArrayList<String>();

	public static void registerCommands() {
		
		//Special commands
		commands.add("reload");
		
	}
	
	public static boolean isRegistered(String cmd) {
		
		boolean result = false;
		
		if(commands.contains(cmd)) {
			
			result = true;
			
		}
		
		return result;
		
	}
	
}
