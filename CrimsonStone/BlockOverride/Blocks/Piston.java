package com.github.Icyene.CrimsonStone.BlockOverride.Blocks;

import net.minecraft.server.BlockPiston;

public class Piston extends BlockPiston {

	public Piston(int i, int j, boolean flag) {
		super(i, j, flag);
	}
	
    public boolean b() {
        return true;
    }
}
