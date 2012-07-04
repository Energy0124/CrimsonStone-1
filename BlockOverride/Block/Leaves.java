package com.github.Icyene.CrimsonStone.BlockOverride.Block;

import net.minecraft.server.Block;
import net.minecraft.server.BlockLeaves;
import net.minecraft.server.StepSound;

public class Leaves extends BlockLeaves {
	
	public Leaves(int i, int j) {
        super(i, j);
    }
	
	public Leaves setHardness(float f) {
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
