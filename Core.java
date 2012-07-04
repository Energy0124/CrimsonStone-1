package com.github.Icyene.CrimsonStone;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.Icyene.CrimsonStone.BlockOverride.BOCore;
import com.github.Icyene.CrimsonStone.WaterproofCircuits.WPCore;

public class Core extends JavaPlugin{
public void onEnable() {
	System.out.println("Loading BlockOverride...");
	BOCore.load(this);
	System.out.println("Loading WaterproofCircuits...");
	WPCore.load(this);
}
}
