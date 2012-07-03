package com.github.Icyene.ElectroStone.WaterproofCircuits;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.Icyene.ElectroStone.ElectroStone;

public class WPCore extends JavaPlugin {
	public static void load(ElectroStone plugin) {
		System.out.println("-Loading WaterproofBlocks");
		System.out.println("--Loading Listeners...");
		try {
			Bukkit.getServer().getPluginManager()
					.registerEvents(new EntityInteractEvent(), plugin);

			try {
				Bukkit.getServer().getPluginManager()
						.registerEvents(new OnLiquidSpreadEvent(), plugin);
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
