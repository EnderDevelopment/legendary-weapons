package com.enderdevelopment.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        createGodSword();
        getLogger().info("Plugin enabled!");
    }

    @Override
    public void createGodSword() {
        ItemStack godSword = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = godSword.getItemMeta();
        meta.setDisplayName("God Sword");
        meta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 5, true);
        
        godSword.setItemMeta(meta);
        NamespacedKey key = new NamespacedKey(this, "god_sword");
        Enchantment godEnchantment = Enchantment.getByKey(key);
        if (godEnchantment != null) {
            meta.addEnchant(godEnchantment, 1, true);
            godSword.setItemMeta(meta);
        }
    }

    public void onDisable() {
        getLogger().info("Plugin disabled!");
    }
}