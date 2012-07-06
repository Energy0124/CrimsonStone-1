package com.github.Icyene.CrimsonStone.WaterproofCircuits.Blocks;

import net.minecraft.server.BlockRedstoneTorch;
import net.minecraft.server.StepSound;

public class RedstoneTorch extends BlockRedstoneTorch {

	public RedstoneTorch(int i, int j, boolean flag) {
		super(i, j, flag);

	}

	public RedstoneTorch c(float f) {
		strength = f;
		if (durability < f * 5F)
			durability = f * 5F;
		return this;
	}

	public RedstoneTorch a(StepSound stepsound) {
		stepSound = stepsound;
		return this;
	}

	public RedstoneTorch s() {
		bS = false;
		return this;
	}

	public RedstoneTorch j() {
		r[id] = true;
		return this;
	}

	public RedstoneTorch b(float f) {
		durability = f * 3F;
		return this;
	}
	public RedstoneTorch a(float f)
    {
        lightEmission[id] = (int)(15F * f);
        return this;
    }
}
