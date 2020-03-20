package fr.mpremont.confirmmenu.interfaces.versions;

import org.bukkit.Sound;

import fr.mpremont.confirmmenu.interfaces.Version;

public class V1_15_R1 implements Version{

	public Sound getSound(String sound) {
		
		if(sound.equalsIgnoreCase("CHICKEN_EGG_POP")) {
			sound = "ENTITY_CHICKEN_EGG";
		}
		
		return Sound.valueOf(sound);
		
	}
	
}
