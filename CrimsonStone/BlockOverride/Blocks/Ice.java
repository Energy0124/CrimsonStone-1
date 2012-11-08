package com.github.Icyene.CrimsonStone.BlockOverride.Blocks;

import net.minecraft.server.Block;

import net.minecraft.server.BlockIce;

import net.minecraft.server.StepSound;

public class Ice extends BlockIce {

public Ice(int i, int j) {
        super(i, j);
    }
    
    public Ice setHardness(float f) {
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

    
    // Render as a full block
    public boolean b() {
        return true;
    }
}