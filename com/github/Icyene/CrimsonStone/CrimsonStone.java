package com.github.Icyene.CrimsonStone;

import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.Icyene.CrimsonStone.AR.Armor;
import com.github.Icyene.CrimsonStone.BO.Override;
import com.github.Icyene.CrimsonStone.WPC.Waterproof;

public class CrimsonStone extends JavaPlugin {

    public static GlobalVariables config;
    
    public void onEnable() {

	config = new GlobalVariables(this);
	config.load();
	
	try {
	    MetricsLite metrics = new MetricsLite(this);
	    metrics.start();
	} catch (IOException e) {
	    // Failed to submit the stats :-(
	}

	 Override.load(this);

	if(config.Features_Waterproof__Blocks) {
	Waterproof.load(this);
	}

	if(config.Features_Armored__Blocks) {
	Armor.load(this);
	}

    }

    public void onDisable() {
	 Override.unload();

	Waterproof.unload();	
    }
}
