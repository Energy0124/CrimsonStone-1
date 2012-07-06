package com.github.Icyene.CrimsonStone.WaterproofCircuits.Blocks;

import net.minecraft.server.BlockMinecartTrack;
import net.minecraft.server.StepSound;

public class Rails extends BlockMinecartTrack {

	public Rails(int i, int j, boolean flag) {
		super(i, j, flag);
		// TODO Auto-generated constructor stub
	}

	public Rails c(float f) {
		strength = f;
		if (durability < f * 5F)
			durability = f * 5F;
		return this;
	}

	public Rails a(StepSound stepsound) {
		stepSound = stepsound;
		return this;
	}

	public Rails s() {
		bS = false;
		return this;
	}

	public Rails j() {
		r[id] = true;
		return this;
	}

	public Rails b(float f) {
		durability = f * 3F;
		return this;
	}
}