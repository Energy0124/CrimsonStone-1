package com.github.Icyene.CrimsonStone.Configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.server.Block;

import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Load extends JavaPlugin {

	public static void genConfig(Plugin plugin) {
		plugin.getConfig().options().copyDefaults(true);
		// BlockOverride config
		plugin.getConfig().set("blockOverride.glass", true);
		plugin.getConfig().set("blockOverride.leaves", true);
		plugin.getConfig().set("blockOverride.pistons", true);
		plugin.getConfig().set("blockOverride.glowstone", true);
		plugin.getConfig().set("blockOverride.tnt", true);
		plugin.getConfig().set("blockOverride.glassPanes", true);
		plugin.getConfig().set("blockOverride.ironBars", true);
		plugin.getConfig().set("blockOverride.fence", true);
		plugin.getConfig().set("blockOverride.netherFence", true);
		// WaterproofCircuits config
		plugin.getConfig().set("waterproofCircuits.redstoneWire", true);
		plugin.getConfig().set("waterproofCircuits.redstoneTorch", true);
		plugin.getConfig().set("waterproofCircuits.diode", true);
		plugin.getConfig().set("waterproofCircuits.stoneButton", true);
		plugin.getConfig().set("waterproofCircuits.rail", true);
		plugin.getConfig().set("waterproofCircuits.poweredRail", true);
		plugin.getConfig().set("waterproofCircuits.detectorRail", true);
		plugin.getConfig().set("waterproofCircuits.torch", true);
		plugin.getConfig().set("waterproofCircuits.lever", true);

		plugin.saveConfig();
	}

	public static List<Material> genOverrideArray(Plugin plugin) {
		File configFile = new File(plugin.getDataFolder(), "config.yml");
		if (!configFile.exists()) {
			System.out.println("---Config file doesn't exist, creating it.");
			genConfig(plugin);
		}

		List<Material> overrideArray = new ArrayList<Material>();
		if (plugin.getConfig().getBoolean("blockOverride.glass"))
			overrideArray.add(Material.GLASS);
		if (plugin.getConfig().getBoolean("blockOverride.leaves"))
			overrideArray.add(Material.LEAVES);
		if (plugin.getConfig().getBoolean("blockOverride.pistons")) {
			overrideArray.add(Material.PISTON_BASE);
			overrideArray.add(Material.PISTON_STICKY_BASE);
		}
		if (plugin.getConfig().getBoolean("blockOverride.glowstone"))
			overrideArray.add(Material.GLOWSTONE);
		if (plugin.getConfig().getBoolean("blockOverride.tnt"))
			overrideArray.add(Material.TNT);
		if (plugin.getConfig().getBoolean("blockOverride.glassPanes"))
			overrideArray.add(Material.THIN_GLASS);
		if (plugin.getConfig().getBoolean("blockOverride.ironBars"))
			overrideArray.add(Material.IRON_FENCE);
		if (plugin.getConfig().getBoolean("blockOverride.fence"))
			overrideArray.add(Material.FENCE);
		if (plugin.getConfig().getBoolean("blockOverride.netherFence"))
			overrideArray.add(Material.NETHER_FENCE);
		
		System.out.println("Overriding " + overrideArray);
		return overrideArray;

	}

	public static List<Integer> genWaterproofArray(Plugin plugin) {
		File configFile = new File(plugin.getDataFolder(), "config.yml");
		if (!configFile.exists()) {
			System.out.println("---Config file doesn't exist, creating it.");
			genConfig(plugin);
		}

		List<Integer> waterproofArray = new ArrayList<Integer>();

		if (plugin.getConfig().getBoolean("waterproofCircuits.redstoneWire"))
			waterproofArray.add(Block.REDSTONE_WIRE.id);
		
		if (plugin.getConfig().getBoolean("waterproofCircuits.redstoneTorch")) {
			waterproofArray.add(Block.REDSTONE_TORCH_ON.id);
			waterproofArray.add(Block.REDSTONE_TORCH_OFF.id);
		}
		if (plugin.getConfig().getBoolean("waterproofCircuits.diode")) {

			waterproofArray.add(Block.DIODE_ON.id);
			waterproofArray.add(Block.DIODE_OFF.id);
		}
		if (plugin.getConfig().getBoolean("waterproofCircuits.stoneButton"))
			waterproofArray.add(Block.STONE_BUTTON.id);
		if (plugin.getConfig().getBoolean("waterproofCircuits.rail"))
			waterproofArray.add(Block.RAILS.id);
		if (plugin.getConfig().getBoolean("waterproofCircuits.poweredRail"))
			waterproofArray.add(Block.GOLDEN_RAIL.id);
		if (plugin.getConfig().getBoolean("waterproofCircuits.detectorRail"))
			waterproofArray.add(Block.DETECTOR_RAIL.id);
		if (plugin.getConfig().getBoolean("waterproofCircuits.torch"))
			waterproofArray.add(Block.TORCH.id);
		if (plugin.getConfig().getBoolean("waterproofCircuits.lever"))
			waterproofArray.add(Block.LEVER.id);
		System.out.println("Protecting " + waterproofArray);
		return waterproofArray;

	}

}
