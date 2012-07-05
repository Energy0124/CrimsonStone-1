package com.github.Icyene.CrimsonStone.Configuration;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class GenerateConfiguration extends JavaPlugin {

	public static void genConfig(Plugin plugin) {
		FileConfiguration config = plugin.getConfig();
		config.options().copyDefaults(true);
		// BlockOverride config
		config.set("blockOverride.glass", true);
		config.set("blockOverride.leaves", true);
		config.set("blockOverride.pistons", false);
		config.set("blockOverride.glowstone", true);
		config.set("blockOverride.tnt", true);
		config.set("blockOverride.glassPanes", true);
		config.set("blockOverride.ironBars", true);
		config.set("blockOverride.fence", true);
		config.set("blockOverride.netherFence", true);
		// WaterproofCircuits config
		config.set("waterproofCircuits.redstoneWire", true);
		config.set("waterproofCircuits.redstoneTorch", true);
		config.set("waterproofCircuits.diode", true);
		config.set("waterproofCircuits.stoneButton", true);
		config.set("waterproofCircuits.rail", true);
		config.set("waterproofCircuits.poweredRail", true);
		config.set("waterproofCircuits.detectorRail", true);
		config.set("waterproofCircuits.torch", true);
		config.set("waterproofCircuits.lever", true);
		// ArmoredRedstone config
		config.set("armoredRedstone.redstoneWire", true);
		config.set("armoredRedstone.redstoneTorch", true);
		config.set("armoredRedstone.diode", true);
		config.set("armoredRedstone.rail", true);
		config.set("armoredRedstone.poweredRail", true);
		config.set("armoredRedstone.detectorRail", true);
		plugin.saveConfig();
	}

}
