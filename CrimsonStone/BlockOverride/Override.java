package com.github.Icyene.CrimsonStone.BlockOverride;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.Icyene.CrimsonStone.Core;
import com.github.Icyene.CrimsonStone.BlockOverride.Listeners.EntitySpawnEvent;

public class Override extends JavaPlugin {
	public static void load(Core plugin) {
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
			ModBlocks.modify(plugin);
			System.out.println("-BlockOverride loaded!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		

	}

	

}