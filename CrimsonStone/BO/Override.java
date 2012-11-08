package com.github.Icyene.CrimsonStone.BO;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.Icyene.CrimsonStone.Core;
import com.github.Icyene.CrimsonStone.BO.Listeners.EntityHurtEvent;
import com.github.Icyene.CrimsonStone.BO.Listeners.EntitySpawnEvent;

public class Override extends JavaPlugin {
	public static void load(Core plugin) {

		try {
			Bukkit.getServer().getPluginManager()
					.registerEvents(new EntitySpawnEvent(), plugin);
			Bukkit.getServer().getPluginManager()
					.registerEvents(new EntityHurtEvent(), plugin);

		} catch (Exception e) {

			e.printStackTrace();
		}

		// Blocks modifications

		try {
			ModBlocks.modify(plugin);

		} catch (Exception e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}

	}

	public static void unload() {
		try {
			ModBlocks.forceUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out
					.println("[CrimsonStone] Error unloading overrides. Contact me vulcainus@gmail.com for support, or leave a comment on the CrimsonStone Bukkit page");
		}
	}

}