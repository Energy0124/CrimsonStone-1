package com.github.Icyene.CrimsonStone.AR;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import com.github.Icyene.CrimsonStone.AR.Blocks.*;
import com.github.Icyene.CrimsonStone.Configuration.GenerateConfiguration;

import net.minecraft.server.Block;

import net.minecraft.server.StepSound;

public class Armor {

	public static StepSound e = new StepSound("wood", 1.0F, 1.0F);

	public static StepSound i = new StepSound("stone", 1.0F, 1.5F);

	public static void load(Plugin plugin) {

		// The .b(2000F) gives them a resistance of 6000F (2000x3), equivalent
		// to obsidian

		File configFile = new File(plugin.getDataFolder(), "config.yml");
		if (!configFile.exists()) {
			System.out.println("[CrimsonStone] Config file doesn't exist, creating it.");
			GenerateConfiguration.genConfig(plugin);
		}
		FileConfiguration config = plugin.getConfig();

		if (config.getBoolean("armoredRedstone.redstoneWire")) {
			Block.byId[Block.REDSTONE_WIRE.id] = null;
			Block.byId[Block.REDSTONE_WIRE.id] = ((RedstoneWire) (new RedstoneWire(
					55, 164)).a("redstoneDust")).b(2000F).s().j();
		}
		if (config.getBoolean("armoredRedstone.redstoneTorch")) {
			// Redstone torch off
			Block.byId[Block.REDSTONE_TORCH_OFF.id] = null;
			Block.byId[Block.REDSTONE_TORCH_OFF.id] = ((RedstoneTorch) new RedstoneTorch(
					75, 115, false).c(0.0F).a(0.5F).a(e).a("notGate")).b(2000F)
					.j();
			// Redstone torch on
			Block.byId[Block.REDSTONE_TORCH_ON.id] = null;
			Block.byId[Block.REDSTONE_TORCH_ON.id] = ((RedstoneTorch) new RedstoneTorch(
					76, 99, true).c(0.0F).a(0.5F).a(e).a("notGate")).b(2000F)
					.j();
		}
		if (config.getBoolean("armoredRedstone.diode")) {
			// Diode off
			Block.byId[Block.DIODE_OFF.id] = null;
			Block.byId[Block.DIODE_OFF.id] = ((Diode) new Diode(93, false)
					.c(0.0F).a(e).a("diode")).s().j().b(2000F);
			// Diode on
			Block.byId[Block.DIODE_ON.id] = null;
			Block.byId[Block.DIODE_ON.id] = ((Diode) new Diode(94, true)
					.c(0.0F).a(e).a("diode")).s().j().b(2000F);
		}
		if (config.getBoolean("armoredRedstone.rail")) {
			// Diode off
			Block.byId[Block.DIODE_OFF.id] = null;
			Block.byId[Block.DIODE_OFF.id] = ((Diode) new Diode(93, false)
					.c(0.0F).a(e).a("diode")).s().j().b(2000F);
			// Diode on
			Block.byId[Block.DIODE_ON.id] = null;
			Block.byId[Block.DIODE_ON.id] = ((Diode) new Diode(94, true)
					.c(0.0F).a(e).a("diode")).s().j().b(2000F);
		}
		if (config.getBoolean("armoredRedstone.poweredRail")) {
			// Powered rails
			Block.byId[Block.GOLDEN_RAIL.id] = null;
			Block.byId[Block.GOLDEN_RAIL.id] = ((Rails) (new Rails(27, 179,
					true)).c(0.7F).a(i).a("goldenRail")).b(2000F).j();
		}
		if (config.getBoolean("armoredRedstone.detectorRail")) {
			// Detector rails
			Block.byId[Block.DETECTOR_RAIL.id] = null;
			Block.byId[Block.DETECTOR_RAIL.id] = ((Detector) (new Detector(28,
					195)).c(0.7F).a(i).a("detectorRail")).b(2000F).j();
		}

	}

	public static void unload() {
		// Redstone wire
		Block.byId[Block.REDSTONE_WIRE.id] = null;
		Block.byId[Block.REDSTONE_WIRE.id] = ((RedstoneWire) (new RedstoneWire(
				55, 164)).a("redstoneDust")).s().j();
		// Normal rails
		Block.byId[Block.RAILS.id] = null;
		Block.byId[Block.RAILS.id] = ((Rails) (new Rails(66, 128, false))
				.c(0.7F).a(i).a("rail")).j();
		// Powered rails
		Block.byId[Block.GOLDEN_RAIL.id] = null;
		Block.byId[Block.GOLDEN_RAIL.id] = ((Rails) (new Rails(27, 179, true))
				.c(0.7F).a(i).a("goldenRail")).j();
		// Detector rails
		Block.byId[Block.DETECTOR_RAIL.id] = null;
		Block.byId[Block.DETECTOR_RAIL.id] = ((Detector) (new Detector(28, 195))
				.c(0.7F).a(i).a("detectorRail")).j();
		// Redstone torch off
		Block.byId[Block.REDSTONE_TORCH_OFF.id] = null;
		Block.byId[Block.REDSTONE_TORCH_OFF.id] = ((RedstoneTorch) new RedstoneTorch(
				75, 115, false).c(0.0F).a(0.5F).a(e).a("notGate")).j();
		// Redstone torch on
		Block.byId[Block.REDSTONE_TORCH_ON.id] = null;
		Block.byId[Block.REDSTONE_TORCH_ON.id] = ((RedstoneTorch) new RedstoneTorch(
				76, 99, true).c(0.0F).a(0.5F).a(e).a("notGate")).j();
		// Diode off
		Block.byId[Block.DIODE_OFF.id] = null;
		Block.byId[Block.DIODE_OFF.id] = ((Diode) new Diode(93, false).c(0.0F)
				.a(e).a("diode")).s().j();
		// Diode on
		Block.byId[Block.DIODE_ON.id] = null;
		Block.byId[Block.DIODE_ON.id] = ((Diode) new Diode(94, true).c(0.0F)
				.a(e).a("diode")).s().j();
	}

}
