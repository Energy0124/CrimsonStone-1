package com.github.Icyene.ElectroStone.BlockOverride.Block;

import net.minecraft.server.BlockPistonMoving;

public class PistonMoving extends BlockPistonMoving{

	public PistonMoving(int i) {
		super(i);
	}

    // Render as a full block
    public boolean b() {
        return true;
    }
}
