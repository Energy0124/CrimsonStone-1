package com.github.Icyene.CrimsonStone.BlockOverride;

import java.lang.reflect.Field;
import java.util.List;

import net.minecraft.server.Block;
import net.minecraft.server.Material;

import org.bukkit.plugin.Plugin;

import com.github.Icyene.CrimsonStone.BlockOverride.Block.*;

import com.github.Icyene.CrimsonStone.Configuration.Load;

public class ModBlocks {

	static void modify(Plugin plugin) throws Exception {

		List<org.bukkit.Material> blocks = Load.genOverrideArray(plugin);
		
		if (blocks.contains(org.bukkit.Material.GLASS)) {
			Block.byId[Block.GLASS.id] = null;
			Block.byId[Block.GLASS.id] = new Glass(Block.GLASS.id, 49,
					Material.SHATTERABLE, false).setHardness(0.3F)
					.setSound(Block.j).a("glass");

			Field glass = Material.SHATTERABLE.getClass().getDeclaredField("I");
			glass.setAccessible(true);
			glass.setBoolean(Material.SHATTERABLE, false);
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

			Field leaves = Material.LEAVES.getClass().getDeclaredField("I");
			leaves.setAccessible(true);
			leaves.setBoolean(Material.LEAVES, false);

			Block.lightBlock[Block.LEAVES.id] = 1;
			Block.r[Block.LEAVES.id] = true;
		}

		if (blocks.contains(org.bukkit.Material.GLOWSTONE)) {
			Block.byId[Block.GLOWSTONE.id] = null;
			Block.byId[Block.GLOWSTONE.id] = new Glowstone(Block.GLOWSTONE.id,
					105, Material.SHATTERABLE).setHardness(0.3F)
					.setLightValue(1.0F).setSound(Block.j).a("lightgem");

			Field glowstone = Material.SHATTERABLE.getClass().getDeclaredField(
					"I");
			glowstone.setAccessible(true);
			glowstone.setBoolean(Material.SHATTERABLE, false);
		}
		if (blocks.contains(org.bukkit.Material.TNT)) {
			Block.byId[Block.TNT.id] = null;
			Block.byId[Block.TNT.id] = new TNT(Block.TNT.id, 8)
					.setHardness(0.0F).setSound(Block.g).a("tnt");

			Field tnt = Material.TNT.getClass().getDeclaredField("I");
			tnt.setAccessible(true);
			tnt.setBoolean(Material.TNT, false);
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

			Field piston = Material.PISTON.getClass().getDeclaredField("I");
			piston.setAccessible(true);
			piston.setBoolean(Material.PISTON, false);

			Block.r[Block.PISTON.id] = true;
			if (blocks.contains(org.bukkit.Material.PISTON_STICKY_BASE)) {
				Block.byId[Block.PISTON_STICKY.id] = null;
				Block.byId[Block.PISTON_STICKY.id] = new Piston(
						Block.PISTON_STICKY.id, 106, true)
						.a("pistonStickyBase");

				piston = Material.PISTON.getClass().getDeclaredField("I");
				piston.setAccessible(true);
				piston.setBoolean(Material.PISTON, false);

				Block.r[Block.PISTON_STICKY.id] = true;
			}
		}
	}

}
