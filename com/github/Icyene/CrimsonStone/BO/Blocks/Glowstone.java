package com.github.Icyene.CrimsonStone.BO.Blocks;

import net.minecraft.server.BlockLightStone;
import net.minecraft.server.Material;

public class Glowstone extends BlockLightStone {

    public Glowstone(int i, int j, Material material) {
	super(i, j, material);	
    }

    @Override
    public boolean d() {
	return true;
    }

    @Override
    public boolean c()
    {
	return true;
    }

}
