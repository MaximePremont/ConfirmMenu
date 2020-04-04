package fr.mpremont.confirmmenu.managers;

import java.util.ArrayList;

import fr.mpremont.confirmmenu.MainClass;

public class CommandsManager{
	
	private static ArrayList<String> commands = new ArrayList<String>();
	private static ArrayList<String> commandsWrite = new ArrayList<String>();

	public static void registerCommands() {
		
		for(String s : MainClass.getInstance().getConfig().getString("Commands").replaceAll(" ", "").split(",")) {
			
			commands.add(s);
			
		}
		
		for(String s : MainClass.getInstance().getConfig().getString("CommandsWrite").replaceAll(" ", "").split(",")) {
			
			commandsWrite.add(s);
			
		}
		
	}
	
	public static boolean isRegisteredMenu(String cmd) {
		
		return commands.contains(cmd);
		
	}
	
	public static boolean isRegisteredWrite(String cmd) {
		
		return commandsWrite.contains(cmd);
		
	}
	
}
