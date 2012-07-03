package com.github.Icyene.ElectroStone.BlockOverride;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.Icyene.ElectroStone.ElectroStone;

public class BOCore extends JavaPlugin {
	public static void load(ElectroStone plugin) {
		System.out.println("--Loading Listeners...");
		try {
			Bukkit.getServer().getPluginManager()
					.registerEvents(new EntitySpawnEvent(), plugin);
			System.out.println("--Listeners Loaded.");
		} catch (Exception e) {
			System.out.println("--Error loading EntitySpawnEvent listener.");
			e.printStackTrace();
		}

		// Blocks modifications
		System.out.println("--Modding blocks...");

		try {
			ModBlocks.modify();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ModBlocks.fixFlowers();
		System.out.println("-BlockOverride loaded!");

	}

	

}