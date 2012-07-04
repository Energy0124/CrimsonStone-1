package com.github.Icyene.CrimsonStone.BlockOverride.Block;

import net.minecraft.server.BlockPistonExtension;

public class PistonExtension extends BlockPistonExtension {

	public PistonExtension(int i, int j) {
		super(i, j);
	}

    // Render as a full block
    public boolean b() {
        return true;
    }
}
