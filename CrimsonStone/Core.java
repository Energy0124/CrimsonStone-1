package com.github.Icyene.CrimsonStone;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.Icyene.CrimsonStone.AR.Armor;
import com.github.Icyene.CrimsonStone.BO.Override;
import com.github.Icyene.CrimsonStone.WPC.Waterproof;

public class Core extends JavaPlugin {

	public void onEnable() {

		Override.load(this);

		Waterproof.load(this);

		Armor.load(this);
		
		

	}

	public void onDisable() {

		Override.unload();

		Waterproof.unload();

		Armor.unload();

	}

}
