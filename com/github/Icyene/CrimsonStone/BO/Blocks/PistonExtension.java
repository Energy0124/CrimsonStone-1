package com.github.Icyene.CrimsonStone.BO.Blocks;

import net.minecraft.server.BlockPistonExtension;

public class PistonExtension extends BlockPistonExtension {
    public PistonExtension(int i, int j) {
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
