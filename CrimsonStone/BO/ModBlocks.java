package com.github.Icyene.CrimsonStone.BO;

import java.io.File;
import java.lang.reflect.Field;
import net.minecraft.server.Block;
import net.minecraft.server.Material;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import com.github.Icyene.CrimsonStone.BlockOverride.Blocks.*;

import com.github.Icyene.CrimsonStone.Configuration.GenerateConfiguration;

public class ModBlocks {

	static void modify(Plugin plugin) throws Exception {

		File configFile = new File(plugin.getDataFolder(), "config.yml");
		if (!configFile.exists()) {
			System.out.println("---Config file doesn't exist, creating it.");
			GenerateConfiguration.genConfig(plugin);
		}
		FileConfiguration config = plugin.getConfig();

		// System.out.println();
		// System.out.println(Material.WATER.getClass());
		try {
			if (config.getBoolean("blockOverride.glass")) {
				Block.byId[Block.GLASS.id] = null;
				Block.byId[Block.GLASS.id] = new Glass(Block.GLASS.id, 49,
						Material.SHATTERABLE, false).setHardness(0.3F)
						.setSound(Block.j).a("glass");

				Field glass = Material.SHATTERABLE.getClass().getDeclaredField(
						"I");
				glass.setAccessible(true);
				glass.setBoolean(Material.SHATTERABLE, false);
			}

			if (config.getBoolean("blockOverride.leaves")) {

				Block.byId[Block.LEAVES.id] = null;
				Block.byId[Block.LEAVES.id] = new Leaves(Block.LEAVES.id, 52)
						.setHardness(0.2F).setSound(Block.g).a("leaves");

				Field leaves = Material.LEAVES.getClass().getDeclaredField("I");
				leaves.setAccessible(true);
				leaves.setBoolean(Material.LEAVES, false);

				Block.lightBlock[Block.LEAVES.id] = 1;
				Block.r[Block.LEAVES.id] = true;
			}

			if (config.getBoolean("blockOverride.glowstone")) {
				Block.byId[Block.GLOWSTONE.id] = null;
				Block.byId[Block.GLOWSTONE.id] = new Glowstone(
						Block.GLOWSTONE.id, 105, Material.SHATTERABLE)
						.setHardness(0.3F).setLightValue(1.0F)
						.setSound(Block.j).a("lightgem");

				Field glowstone = Material.SHATTERABLE.getClass()
						.getDeclaredField("I");
				System.out.println(glowstone);
				glowstone.setAccessible(true);
				glowstone.setBoolean(Material.SHATTERABLE, false);
			}

			if (config.getBoolean("blockOverride.tnt")) {
				Block.byId[Block.TNT.id] = null;
				Block.byId[Block.TNT.id] = new TNT(Block.TNT.id, 8)
						.setHardness(0.0F).setSound(Block.g).a("tnt");

				Field tnt = Material.TNT.getClass().getDeclaredField("I");
				tnt.setAccessible(true);
				tnt.setBoolean(Material.TNT, false);
			}

			if (config.getBoolean("blockOverride.glassPanes")) {
				Block.byId[Block.THIN_GLASS.id] = null;
				Block.byId[Block.THIN_GLASS.id] = new ThinFence(
						Block.THIN_GLASS.id, 49, 148, Material.SHATTERABLE,
						false).setHardness(0.3F).setSound(Block.j)
						.a("thinGlass");
			}

			if (config.getBoolean("blockOverride.ironBars")) {
				Block.byId[Block.IRON_FENCE.id] = null;
				Block.byId[Block.IRON_FENCE.id] = new ThinFence(
						Block.IRON_FENCE.id, 85, 85, Material.ORE, true)
						.setHardness(5.0F).setResistance(10.0F)
						.setSound(Block.i).a("fenceIron");
			}

			if (config.getBoolean("blockOverride.fence")) {
				Block.byId[Block.FENCE.id] = null;
				Block.byId[Block.FENCE.id] = new Fences(Block.FENCE.id, 4)
						.setHardness(2.0F).setResistance(5.0F)
						.setSound(Block.e).a("fence");
			}

			if (config.getBoolean("blockOverride.netherFence")) {
				Block.byId[Block.NETHER_FENCE.id] = null;
				Block.byId[Block.NETHER_FENCE.id] = new Fences(
						Block.NETHER_FENCE.id, 224, Material.STONE)
						.setHardness(2.0F).setResistance(10.0F)
						.setSound(Block.h).a("netherFence");
			}
			if (config.getBoolean("blockOverride.ice")) {
				Block.byId[Block.ICE.id] = null;
				Block.byId[Block.ICE.id] = new Ice(Block.ICE.id, 67)
						.setHardness(0.5F).setSound(Block.j).a("ice");

				Field ice = Material.ICE.getClass().getDeclaredField("I");
				ice.setAccessible(true);
				ice.setBoolean(Material.ICE, false);

				// ICE = (new BlockIce(79, 67)).c(0.5F).f(3).a(j).a("ice");
			}

			if (config.getBoolean("blockOverride.pistons")) {
				Block.byId[Block.PISTON.id] = null;
				Block.byId[Block.PISTON.id] = new Piston(Block.PISTON.id, 107,
						false).a("pistonBase");

				// Field pistons = Material.PISTON.getClass()
				// .getDeclaredField("I");
				// pistons.setAccessible(true);
				// pistons.setBoolean(Material.PISTON, false);

				Block.r[Block.PISTON.id] = true;

				Block.byId[Block.PISTON_STICKY.id] = null;
				Block.byId[Block.PISTON_STICKY.id] = new Piston(
						Block.PISTON_STICKY.id, 106, true)
						.a("pistonStickyBase");

				// pistons = Material.PISTON.getClass().getDeclaredField("I");
				// pistons.setAccessible(true);
				// pistons.setBoolean(Material.PISTON, false);

				Block.r[Block.PISTON_STICKY.id] = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void forceUpdate() throws IllegalArgumentException,
			IllegalAccessException, NoSuchFieldException, SecurityException {
		try {

			Block.byId[Block.FENCE.id] = Block.FENCE;

			Block.byId[Block.NETHER_FENCE.id] = Block.NETHER_FENCE;

			Block.byId[Block.LEAVES.id] = Block.LEAVES;

			Field leaves = Material.LEAVES.getClass().getDeclaredField("I");
			leaves.setAccessible(true);
			leaves.setBoolean(Material.LEAVES, true);

			Block.byId[Block.GLOWSTONE.id] = Block.GLOWSTONE;

			Field glowstone = Material.SHATTERABLE.getClass().getDeclaredField(
					"I");
			glowstone.setAccessible(true);
			glowstone.setBoolean(Material.SHATTERABLE, true);

			Block.byId[Block.TNT.id] = Block.TNT;

			Field tnt = Material.TNT.getClass().getDeclaredField("I");
			tnt.setAccessible(true);
			tnt.setBoolean(Material.TNT, true);

			Block.byId[Block.THIN_GLASS.id] = Block.THIN_GLASS;

			Block.byId[Block.IRON_FENCE.id] = Block.IRON_FENCE;

			Block.byId[Block.PISTON.id] = Block.PISTON;
			Block.byId[Block.PISTON_STICKY.id] = Block.PISTON_STICKY;
			Block.byId[Block.PISTON_EXTENSION.id] = Block.PISTON_EXTENSION;
			Block.byId[Block.PISTON_MOVING.id] = Block.PISTON_MOVING;

			Field pistons = Material.PISTON.getClass().getDeclaredField("I");
			pistons.setAccessible(true);
			pistons.setBoolean(Material.PISTON, true);

			Block.byId[Block.ICE.id] = Block.ICE;

			Field ice = Material.ICE.getClass().getDeclaredField("I");
			ice.setAccessible(true);
			ice.setBoolean(Material.ICE, true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
