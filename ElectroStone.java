package com.github.Icyene.ElectroStone;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.Icyene.ElectroStone.BlockOverride.BOCore;
import com.github.Icyene.ElectroStone.WaterproofCircuits.WPCore;

public class ElectroStone extends JavaPlugin{
public void onEnable() {
	System.out.println("Loading BlockOverride...");
	BOCore.load(this);
	System.out.println("Loading WaterproofCircuits...");
	WPCore.load(this);
}
}
