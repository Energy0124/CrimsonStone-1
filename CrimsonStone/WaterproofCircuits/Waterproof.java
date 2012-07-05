package com.github.Icyene.CrimsonStone.WaterproofCircuits;

import java.util.List;

import net.minecraft.server.Block;

import net.minecraft.server.Material;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.Icyene.CrimsonStone.Core;
import com.github.Icyene.CrimsonStone.Configuration.Load;
import com.github.Icyene.CrimsonStone.WaterproofCircuits.Listeners.EntityInteractEvent;

//import com.github.Icyene.CrimsonStone.WaterproofCircuits.CrimsonstoneWater;

public class Waterproof extends JavaPlugin {
	static List<Integer> waterproofBlocks;

	public static void load(Core plugin) {

		waterproofBlocks = Load.genWaterproofArray(plugin);
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

			// WATER = new BlockFlowing(8,
			// Material.WATER)).c(100F).f(3).a("water").s().j();

		}
	}

	public static void unload() {
		// set waterproof blocks to null
		waterproofBlocks = null;
		// now, remod.
		modify();
	}

	public static void modify() {
		Block.byId[Block.WATER.id] = null;
		Block.byId[Block.WATER.id] = ((CrimsonFlowing) (new CrimsonFlowing(8,
				Material.WATER)).c(100F).f(3).a("water")).s().j();

		Block.byId[Block.LAVA.id] = null;
		Block.byId[Block.LAVA.id] = ((CrimsonFlowing) (new CrimsonFlowing(10,
				Material.LAVA)).c(0.0F).f(255).a("lava")).s().j().a(1.0F);
	}
}
