package com.github.Icyene.CrimsonStone.BO;

import org.bukkit.Bukkit;

import com.github.Icyene.CrimsonStone.CrimsonStone;
import com.github.Icyene.CrimsonStone.BO.Listeners.EntityHurtEvent;

public class Override  {
    
    public static void load(CrimsonStone plugin) {

	Bukkit.getServer().getPluginManager()
		.registerEvents(new EntityHurtEvent(), plugin);

	try {
	    ModBlocks.modify(plugin);

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    public static void unload() {
	try {
	    ModBlocks.forceUpdate();

	} catch (Exception e) {
	    e.printStackTrace();

	}
    }

}