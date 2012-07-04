package com.github.Icyene.CrimsonStone.BlockOverride.Block;

import net.minecraft.server.BlockPiston;

public class Piston extends BlockPiston {

	public Piston(int i, int j, boolean flag) {
		super(i, j, flag);
	}
	
    // Render as a full block
    public boolean b() {
        return true;
    }
}
