package com.github.Icyene.CrimsonStone.WaterproofCircuits.Blocks;

import net.minecraft.server.BlockMinecartDetector;
import net.minecraft.server.StepSound;

public class Detector extends BlockMinecartDetector {

	public Detector(int i, int j) {
		super(i, j);

	}

	public Detector c(float f) {
		strength = f;
		if (durability < f * 5F)
			durability = f * 5F;
		return this;
	}

	public Detector a(StepSound stepsound) {
		stepSound = stepsound;
		return this;
	}

	public Detector s() {
		bS = false;
		return this;
	}

	public Detector j() {
		r[id] = true;
		return this;
	}

	public Detector b(float f) {
		durability = f * 3F;
		return this;
	}
}