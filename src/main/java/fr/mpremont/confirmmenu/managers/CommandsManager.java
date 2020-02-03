package fr.mpremont.confirmmenu.managers;

import java.util.ArrayList;

import fr.mpremont.confirmmenu.MainClass;

public class CommandsManager{
	
	private static ArrayList<String> commands = new ArrayList<String>();

	public static void registerCommands() {
		
		for(String s : MainClass.getInstance().getConfig().getString("Commands").replaceAll(" ", "").split(",")) {
			
			commands.add(s);
			
		}
		
	}
	
	public static boolean isRegistered(String cmd) {
		
		boolean result = false;
		
		if(commands.contains(cmd)) {
			
			result = true;
			
		}
		
		return result;
		
	}
	
}
