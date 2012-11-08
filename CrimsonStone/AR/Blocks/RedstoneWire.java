package com.github.Icyene.CrimsonStone.AR.Blocks;

import net.minecraft.server.BlockRedstoneWire;

import net.minecraft.server.StepSound;

public class RedstoneWire extends BlockRedstoneWire {

	public RedstoneWire(int i, int j) {
		super(i, j);

	}

	public RedstoneWire c(float f) {
		strength = f;
		if (durability < f * 5F)
			durability = f * 5F;
		return this;
	}

	public RedstoneWire a(StepSound stepsound) {
		stepSound = stepsound;
		return this;
	}

	public RedstoneWire s() {
		bS = false;
		return this;
	}

	public RedstoneWire j() {
		r[id] = true;
		return this;
	}

	public RedstoneWire b(float f) {
		durability = f * 3F;
		return this;
	}
}
