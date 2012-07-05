package com.github.Icyene.CrimsonStone.BlockOverride.Blocks;

import net.minecraft.server.Block;
import net.minecraft.server.BlockTNT;
import net.minecraft.server.StepSound;

public class TNT extends BlockTNT{

	public TNT(int i, int j) {
		super(i, j);
	}

	public TNT setHardness(float f) {
        this.strength = f;
        if (this.durability < f * 5.0F) {
            this.durability = f * 5.0F;
        }
        return this;
    }

    public Block setSound(StepSound stepsound) {
        this.stepSound = stepsound;
        return this;
    }
}
