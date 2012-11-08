package com.github.Icyene.CrimsonStone.BO.Blocks;

import net.minecraft.server.BlockFence;
import net.minecraft.server.Material;

public class Fences extends BlockFence {

    public Fences(int i, int j) {
	super(i, j, Material.WOOD);
    }

    public Fences(int i, int j, Material material) {
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

    @Override
    public int b()
    {
	return 11;
    }

}