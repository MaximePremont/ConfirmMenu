package fr.mpremont.confirmmenu.interfaces.versions;

import org.bukkit.Sound;

import fr.mpremont.confirmmenu.interfaces.Version;

public class V1_8_R1 implements Version{

	public Sound getSound(String sound) {
		
		return Sound.valueOf(sound);
		
	}

}
