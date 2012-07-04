package com.github.Icyene.CrimsonStone.BlockOverride;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Configuration extends JavaPlugin {

	public static void genConfig(Plugin plugin) {
		plugin.getConfig().options().copyDefaults(true);
		plugin.getConfig().set("blockOverride.glass", true);
		plugin.getConfig().set("blockOverride.leaves", true);
		plugin.getConfig().set("blockOverride.pistons", true);
		plugin.getConfig().set("blockOverride.glowstone", true);
		plugin.getConfig().set("blockOverride.tnt", true);
		plugin.getConfig().set("blockOverride.glassPanes", true);
		plugin.getConfig().set("blockOverride.ironBars", true);
		plugin.getConfig().set("blockOverride.fence", true);
		plugin.getConfig().set("blockOverride.netherFence", true);
		plugin.saveConfig();
	}

	public static List<Material> genArray(Plugin plugin) {
		File configFile = new File(plugin.getDataFolder(), "config.yml");
		if(!configFile.exists()) {
			System.out.println("---Config file doesn't exist, creating it.");
			genConfig(plugin);
		}
		
		List<Material> x = new ArrayList<Material>();
		if (plugin.getConfig().getBoolean("blockOverride.glass"))
			x.add(Material.GLASS);
		if (plugin.getConfig().getBoolean("blockOverride.leaves"))
			x.add(Material.LEAVES);
		if (plugin.getConfig().getBoolean("blockOverride.pistons")) {
			x.add(Material.PISTON_BASE);
			x.add(Material.PISTON_STICKY_BASE);
		}
		if (plugin.getConfig().getBoolean("blockOverride.glowstone"))
			x.add(Material.GLOWSTONE);
		if (plugin.getConfig().getBoolean("blockOverride.tnt"))
			x.add(Material.TNT);
		if (plugin.getConfig().getBoolean("blockOverride.glassPanes"))
			x.add(Material.THIN_GLASS);
		if (plugin.getConfig().getBoolean("blockOverride.ironBars"))
			x.add(Material.IRON_FENCE);
		if (plugin.getConfig().getBoolean("blockOverride.fence"))
			x.add(Material.FENCE);
		if (plugin.getConfig().getBoolean("blockOverride.netherFence"))
			x.add(Material.NETHER_FENCE);
		return x;

	}

}
