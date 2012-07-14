package com.github.Icyene.CrimsonStone.WPC;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.server.Block;

import net.minecraft.server.Material;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.Icyene.CrimsonStone.Core;
import com.github.Icyene.CrimsonStone.Configuration.GenerateConfiguration;
import com.github.Icyene.CrimsonStone.WPC.Listeners.EntityInteractEvent;

public class Waterproof extends JavaPlugin {
	static List<Integer> waterproofBlocks;

	public static void load(Core plugin) {

		waterproofBlocks = genWaterproofArray(plugin);
		try {
			Bukkit.getServer().getPluginManager()
					.registerEvents(new EntityInteractEvent(), plugin);

			try {
				modify();

			} catch (Exception e) {

				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public static void unload() {
		// set waterproof blocks to null
		waterproofBlocks = null;
		// now, remod.
		try {
			modify();
		} catch (NoSuchMethodException e) {

			e.printStackTrace();
		} catch (SecurityException e) {

			e.printStackTrace();
		}
	}

	static void modify() throws NoSuchMethodException, SecurityException {

		Block.byId[Block.WATER.id] = null;
		Block.byId[Block.WATER.id] = ((Flowing) (new Flowing(8,
				Material.WATER)).c(100F).f(3).a("water")).s().j();

		Block.byId[Block.LAVA.id] = null;
		Block.byId[Block.LAVA.id] = ((Flowing) (new Flowing(10,
				Material.LAVA)).c(0.0F).f(255).a("lava")).s().j().a(1.0F);
	}

	public static List<Integer> genWaterproofArray(Plugin plugin) {
		File configFile = new File(plugin.getDataFolder(), "config.yml");
		if (!configFile.exists()) {
			System.out.println("[CrimsonStone] Config file doesn't exist, creating it.");
			GenerateConfiguration.genConfig(plugin);
		}
		FileConfiguration config = plugin.getConfig();
		List<Integer> waterproofArray = new ArrayList<Integer>();

		if (config.getBoolean("waterproofCircuits.redstoneWire"))
			waterproofArray.add(Block.REDSTONE_WIRE.id);

		if (config.getBoolean("waterproofCircuits.redstoneTorch")) {
			waterproofArray.add(Block.REDSTONE_TORCH_ON.id);
			waterproofArray.add(Block.REDSTONE_TORCH_OFF.id);
		}
		if (config.getBoolean("waterproofCircuits.diode")) {

			waterproofArray.add(Block.DIODE_ON.id);
			waterproofArray.add(Block.DIODE_OFF.id);
		}
		if (config.getBoolean("waterproofCircuits.stoneButton"))
			waterproofArray.add(Block.STONE_BUTTON.id);
		if (config.getBoolean("waterproofCircuits.rail"))
			waterproofArray.add(Block.RAILS.id);
		if (config.getBoolean("waterproofCircuits.poweredRail"))
			waterproofArray.add(Block.GOLDEN_RAIL.id);
		if (config.getBoolean("waterproofCircuits.detectorRail"))
			waterproofArray.add(Block.DETECTOR_RAIL.id);
		if (config.getBoolean("waterproofCircuits.torch"))
			waterproofArray.add(Block.TORCH.id);
		if (config.getBoolean("waterproofCircuits.lever"))
			waterproofArray.add(Block.LEVER.id);
		System.out.println("Protecting " + waterproofArray);
		return waterproofArray;

	}
}
