package fr.mpremont.confirmmenu.menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.mpremont.confirmmenu.MainClass;

public class ConfirmMenu {
	
	public static void openMenu(Player p) {
		
		String title = "�8�lCONFIRM";
		if(MainClass.getInstance().getConfig().getString("Text.MenuTitle") != null || MainClass.getInstance().getConfig().getString("Text.MenuTitle") != "") {
			title = MainClass.getInstance().getConfig().getString("Text.MenuTitle").replaceAll("&", "�");
		}
		Inventory i = Bukkit.createInventory(null, 27, title);
		
		ItemStack ISc = new ItemStack(Material.SLIME_BLOCK);
		ItemMeta IMc = ISc.getItemMeta();
		IMc.setDisplayName(MainClass.getInstance().getConfig().getString("Text.MenuConfirm").replaceAll("&", "�"));
		ISc.setItemMeta(IMc);
		i.setItem(11, ISc);
		IMc.getDisplayName();
		
		ItemStack ISa = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta IMa = ISa.getItemMeta();
		IMa.setDisplayName(MainClass.getInstance().getConfig().getString("Text.MenuCancel").replaceAll("&", "�"));
		ISa.setItemMeta(IMa);
		i.setItem(15, ISa);
		
		ItemStack ISp = new ItemStack(Material.PAPER);
		ItemMeta IMp = ISp.getItemMeta();
		ArrayList<String> ALp = new ArrayList<String>();
		IMp.setDisplayName("�eConfirmMenu plugin");
		ALp.add("�eby Maxime Premont");
		ALp.add("�eon Spigot");
		IMp.setLore(ALp);
		ISp.setItemMeta(IMp);
		i.setItem(18, ISp);
		
		p.openInventory(i);
		
	}

}
