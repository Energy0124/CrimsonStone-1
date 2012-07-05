package com.github.Icyene.CrimsonStone;
//Dont worry about this, its a different, unrelated class


import org.bukkit.plugin.java.JavaPlugin;

import com.github.Icyene.CrimsonStone.BlockOverride.Override;
import com.github.Icyene.CrimsonStone.WaterproofCircuits.Waterproof;

public class Core extends JavaPlugin {

	public void onEnable() {
		System.out.println("Loading BlockOverride...");
		Override.load(this);
		System.out.println("Loading WaterproofCircuits...");
		try {
			Waterproof.load(this);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onDisable() {
		System.out.println("Unloading BlockOverride...");
		Override.unload();

	}

}
