package com.github.Icyene.CrimsonStone.AR;

import com.github.Icyene.CrimsonStone.CrimsonStone;
import com.github.Icyene.CrimsonStone.AR.Listeners.ExplosionListener;

public class Armor {

    public static void load(CrimsonStone stone) {

	stone.getServer().getPluginManager()
		.registerEvents(new ExplosionListener(), stone);

    }

}
