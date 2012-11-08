package com.github.Icyene.CrimsonStone.BO.Blocks;

import net.minecraft.server.BlockIce;

public class Ice extends BlockIce {

    public Ice(int i, int j) {
	super(i, j);	
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