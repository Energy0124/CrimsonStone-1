package com.github.Icyene.CrimsonStone.BlockOverride;

import java.lang.reflect.Field;

import java.util.List;

import net.minecraft.server.Block;
import net.minecraft.server.Material;

import org.bukkit.plugin.Plugin;

import com.github.Icyene.CrimsonStone.BlockOverride.Block.*;
import com.github.Icyene.CrimsonStone.BlockOverride.Block.Vegetation.*;

public class ModBlocks {

	static void fixFlowers() {
		Block.byId[Block.YELLOW_FLOWER.id] = null;
		Block.byId[Block.YELLOW_FLOWER.id] = new Flowers(
				Block.YELLOW_FLOWER.id, 13).setHardness(0.0F).setSound(Block.g)
				.a("flower");

		Block.byId[Block.RED_ROSE.id] = null;
		Block.byId[Block.RED_ROSE.id] = new Flowers(Block.RED_ROSE.id, 12)
				.setHardness(0.0F).setSound(Block.g).a("rose");

		Block.byId[Block.WATER_LILY.id] = null;
		Block.byId[Block.WATER_LILY.id] = new WaterLily(Block.WATER_LILY.id, 76)
				.setHardness(0.0F).setSound(Block.g).a("waterlily");

		Block.byId[Block.DEAD_BUSH.id] = null;
		Block.byId[Block.DEAD_BUSH.id] = new DeadBush(Block.DEAD_BUSH.id, 55)
				.setHardness(0.0F).setSound(Block.g).a("deadbush");

		Block.byId[Block.BROWN_MUSHROOM.id] = null;
		Block.byId[Block.BROWN_MUSHROOM.id] = new Mushroom(
				Block.BROWN_MUSHROOM.id, 29).setHardness(0.0F)
				.setLightValue(0.125F).setSound(Block.g).a("mushroom");

		Block.byId[Block.RED_MUSHROOM.id] = null;
		Block.byId[Block.RED_MUSHROOM.id] = new Mushroom(Block.RED_MUSHROOM.id,
				28).setHardness(0.0F).setSound(Block.g).a("mushroom");

	}

	static void modify(Plugin plugin) throws Exception {

		// modBlocks = new File("modBlocks.yml");
		// if(!modBlocks.exists()) {
		// FileOutputStream s = new FileOutputStream(modBlocks);

		List<org.bukkit.Material> blocks = Configuration.genArray(plugin);
		System.out.println(blocks);

		if (blocks.contains(org.bukkit.Material.GLASS)) {
			Block.byId[Block.GLASS.id] = null;
			Block.byId[Block.GLASS.id] = new Glass(Block.GLASS.id, 49,
					Material.SHATTERABLE, false).setHardness(0.3F)
					.setSound(Block.j).a("glass");

			Field field = Material.SHATTERABLE.getClass().getDeclaredField("I");
			field.setAccessible(true);
			field.setBoolean(Material.SHATTERABLE, false);
		}
		if (blocks.contains(org.bukkit.Material.FENCE)) {
			Block.byId[Block.FENCE.id] = null;
			Block.byId[Block.FENCE.id] = new Fences(Block.FENCE.id, 4)
					.setHardness(2.0F).setResistance(5.0F).setSound(Block.e)
					.a("fence");
		}

		if (blocks.contains(org.bukkit.Material.NETHER_FENCE)) {
			Block.byId[Block.NETHER_FENCE.id] = null;
			Block.byId[Block.NETHER_FENCE.id] = new Fences(
					Block.NETHER_FENCE.id, 224, Material.STONE)
					.setHardness(2.0F).setResistance(10.0F).setSound(Block.h)
					.a("netherFence");
		}

		if (blocks.contains(org.bukkit.Material.LEAVES)) {
			Block.byId[Block.LEAVES.id] = null;
			Block.byId[Block.LEAVES.id] = new Leaves(Block.LEAVES.id, 52)
					.setHardness(0.2F).setSound(Block.g).a("leaves");

			Field field = Material.LEAVES.getClass().getDeclaredField("I");
			field.setAccessible(true);
			field.setBoolean(Material.LEAVES, false);

			Block.lightBlock[Block.LEAVES.id] = 1;
			Block.r[Block.LEAVES.id] = true;
		}

		if (blocks.contains(org.bukkit.Material.GLOWSTONE)) {
			Block.byId[Block.GLOWSTONE.id] = null;
			Block.byId[Block.GLOWSTONE.id] = new Glowstone(Block.GLOWSTONE.id,
					105, Material.SHATTERABLE).setHardness(0.3F)
					.setLightValue(1.0F).setSound(Block.j).a("lightgem");

			Field field = Material.SHATTERABLE.getClass().getDeclaredField("I");
			field.setAccessible(true);
			field.setBoolean(Material.SHATTERABLE, false);
		}
		if (blocks.contains(org.bukkit.Material.TNT)) {
			Block.byId[Block.TNT.id] = null;
			Block.byId[Block.TNT.id] = new TNT(Block.TNT.id, 8)
					.setHardness(0.0F).setSound(Block.g).a("tnt");

			Field field = Material.TNT.getClass().getDeclaredField("I");
			field.setAccessible(true);
			field.setBoolean(Material.TNT, false);
		}
		if (blocks.contains(org.bukkit.Material.THIN_GLASS)) {
			Block.byId[Block.THIN_GLASS.id] = null;
			Block.byId[Block.THIN_GLASS.id] = new ThinFence(
					Block.THIN_GLASS.id, 49, 148, Material.SHATTERABLE, false)
					.setHardness(0.3F).setSound(Block.j).a("thinGlass");
		}
		if (blocks.contains(org.bukkit.Material.IRON_FENCE)) {
			Block.byId[Block.IRON_FENCE.id] = null;
			Block.byId[Block.IRON_FENCE.id] = new ThinFence(
					Block.IRON_FENCE.id, 85, 85, Material.ORE, true)
					.setHardness(5.0F).setResistance(10.0F).setSound(Block.i)
					.a("fenceIron");
		}
		if (blocks.contains(org.bukkit.Material.PISTON_BASE)) {
			Block.byId[Block.PISTON.id] = null;
			Block.byId[Block.PISTON.id] = new Piston(Block.PISTON.id, 107,
					false).a("pistonBase");

			Field field = Material.PISTON.getClass().getDeclaredField("I");
			field.setAccessible(true);
			field.setBoolean(Material.PISTON, false);

			Block.r[Block.PISTON.id] = true;
			if (blocks.contains(org.bukkit.Material.PISTON_STICKY_BASE)) {
				Block.byId[Block.PISTON_STICKY.id] = null;
				Block.byId[Block.PISTON_STICKY.id] = new Piston(
						Block.PISTON_STICKY.id, 106, true)
						.a("pistonStickyBase");

				field = Material.PISTON.getClass().getDeclaredField("I");
				field.setAccessible(true);
				field.setBoolean(Material.PISTON, false);

				Block.r[Block.PISTON_STICKY.id] = true;
			}
		}
	}

}
