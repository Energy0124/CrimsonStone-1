package com.github.Icyene.CrimsonStone.BO.Blocks;

import net.minecraft.server.BlockThinFence;
import net.minecraft.server.Material;

public class ThinFence extends BlockThinFence {

    public ThinFence(int i, int j, int k, Material material, boolean flag) {
	super(i, j, k, material, flag);
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
