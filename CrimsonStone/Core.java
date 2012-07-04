package com.github.Icyene.CrimsonStone;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.Icyene.CrimsonStone.BlockOverride.Override;
import com.github.Icyene.CrimsonStone.WaterproofCircuits.Waterproof;

public class Core extends JavaPlugin{
	
	
	
public void onEnable() {
	System.out.println("Loading BlockOverride...");
	Override.load(this);
	System.out.println("Loading WaterproofCircuits...");
	Waterproof.load(this);
	
}
public void onDisable() {
	System.out.println("Unloading BlockOverride...");
	Override.unload();
	
	
}

}
