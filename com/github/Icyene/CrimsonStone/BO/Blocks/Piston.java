package com.github.Icyene.CrimsonStone.BO.Blocks;

import net.minecraft.server.BlockPiston;

public class Piston extends BlockPiston {

    public Piston(int i, int j, boolean flag) {
	super(i, j, flag);
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
