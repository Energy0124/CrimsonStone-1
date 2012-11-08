package com.github.Icyene.CrimsonStone.BO.Blocks;

import net.minecraft.server.BlockTNT;

public class TNT extends BlockTNT {

    public TNT(int i, int j) {
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
