package com.github.Icyene.CrimsonStone.BlockOverride.Blocks;

import net.minecraft.server.Block;
import net.minecraft.server.BlockLightStone;
import net.minecraft.server.Material;
import net.minecraft.server.StepSound;

public class Glowstone extends BlockLightStone {

	public Glowstone(int i, int j, Material material) {
		super(i, j, material);
	}
	public Glowstone setHardness(float f) {
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

	public Glowstone setLightValue(float f) {
		lightEmission[this.id] = (int)(15.0F * f);
		return this;
	}
  
    public boolean b() {
        return true;
    } 
}
