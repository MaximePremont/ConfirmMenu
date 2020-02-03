package fr.mpremont.confirmmenu.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ConfirmMenu {
	
	public static void openMenu(Player p) {
		
		p.closeInventory();
		p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 10, 1);
		
		Inventory i = Bukkit.createInventory(null, 9, "§8§lCONFIRM");
		
		ItemStack ISc = new ItemStack(Material.SLIME_BLOCK);
		ItemMeta IMc = ISc.getItemMeta();
		IMc.setDisplayName("§a§lCONFIR");
		ISc.setItemMeta(IMc);
		i.setItem(2, ISc);
		IMc.getDisplayName();
		
		ItemStack ISa = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta IMa = ISa.getItemMeta();
		IMa.setDisplayName("§c§lCANCEL");
		ISa.setItemMeta(IMa);
		i.setItem(6, ISa);
		
		p.openInventory(i);
		
	}

}
