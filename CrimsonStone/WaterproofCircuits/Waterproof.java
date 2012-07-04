package com.github.Icyene.CrimsonStone.WaterproofCircuits;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.Icyene.CrimsonStone.Core;
import com.github.Icyene.CrimsonStone.WaterproofCircuits.Listeners.EntityInteractEvent;
import com.github.Icyene.CrimsonStone.WaterproofCircuits.Listeners.OnLiquidSpreadEvent;

public class Waterproof extends JavaPlugin {
	public static void load(Core plugin) {
		System.out.println("-Loading WaterproofBlocks");
		System.out.println("--Loading Listeners...");
		try {
			Bukkit.getServer().getPluginManager()
					.registerEvents(new EntityInteractEvent(), plugin);

			try {
				Bukkit.getServer().getPluginManager()
						.registerEvents(new OnLiquidSpreadEvent(plugin), plugin);
				System.out.println("--Listeners Loaded.");
			} catch (Exception e) {
				System.out
						.println("--Error loading OnLiquidSpreadEvent listener.");
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("--Error loading EntityInteractEvent listener.");
			e.printStackTrace();
		}

	}
}
