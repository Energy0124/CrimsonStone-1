package com.github.Icyene.CrimsonStone.BlockOverride.Blocks;

import net.minecraft.server.Block;
import net.minecraft.server.BlockFence;
import net.minecraft.server.Material;
import net.minecraft.server.StepSound;

public class Fences extends BlockFence {
	    
    public Fences(int i, int j) {
        super(i, j, Material.WOOD);
    }

    public Fences(int i, int j, Material material) {
        super(i, j, material);
    }

    public boolean b() {
        return true;
    }
    
    public int c() {
        return 11;
    }
    
    public Fences setHardness(float f) {
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
    
    public Fences setResistance(float f) {
    	this.durability = f * 3.0F;
        return this;
    } 
}