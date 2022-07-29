package me.HybridPlague.CursedBlockFix;

import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public void onDisable() {

	}
	
	public boolean isArmor(ItemStack item) {
		
		if (item.getType() == Material.LEATHER_HELMET
				|| item.getType() == Material.IRON_HELMET
				|| item.getType() == Material.GOLDEN_HELMET
				|| item.getType() == Material.DIAMOND_HELMET
				|| item.getType() == Material.NETHERITE_HELMET
				|| item.getType() == Material.LEATHER_CHESTPLATE
				|| item.getType() == Material.IRON_CHESTPLATE
				|| item.getType() == Material.GOLDEN_CHESTPLATE
				|| item.getType() == Material.DIAMOND_CHESTPLATE
				|| item.getType() == Material.NETHERITE_CHESTPLATE
				|| item.getType() == Material.LEATHER_LEGGINGS
				|| item.getType() == Material.IRON_LEGGINGS
				|| item.getType() == Material.GOLDEN_LEGGINGS
				|| item.getType() == Material.DIAMOND_LEGGINGS
				|| item.getType() == Material.NETHERITE_LEGGINGS
				|| item.getType() == Material.LEATHER_BOOTS
				|| item.getType() == Material.IRON_BOOTS
				|| item.getType() == Material.GOLDEN_BOOTS
				|| item.getType() == Material.DIAMOND_BOOTS
				|| item.getType() == Material.NETHERITE_BOOTS) {
			return true;
		}
		
		return false;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		try {
			Map<Enchantment, Integer> enchants = e.getCurrentItem().getEnchantments();
			if (!this.isArmor(e.getCurrentItem())) {
				if (e.getInventory() instanceof AnvilInventory) {
					if (enchants.containsKey(Enchantment.BINDING_CURSE)) {
						if (e.getWhoClicked().isOp()) {
							e.setCancelled(true);
							e.getWhoClicked().sendMessage(ChatColor.RED + "You are not allowed to apply BINDING_CURSE to this item!");
						}
					}
				}
				
			}
			
		} catch (NullPointerException ex) {
			
		}
		
	}
	
	
}
