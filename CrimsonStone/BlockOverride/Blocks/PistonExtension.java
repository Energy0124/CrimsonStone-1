package com.github.Icyene.CrimsonStone.BlockOverride.Blocks;

import net.minecraft.server.BlockPistonExtension;
import net.minecraft.server.StepSound;

public class PistonExtension extends BlockPistonExtension {
	public PistonExtension(int i, int j) {
		super(i, j);
	}

	public boolean b() {
		return true;
	}

	public PistonExtension a(StepSound stepsound) {
		stepSound = stepsound;
		return this;
	}

	public PistonExtension s() {
		bS = false;
		return this;
	}

	public PistonExtension j() {
		r[id] = true;
		return this;
	}

	public PistonExtension b(float f) {
		durability = f * 3F;
		return this;
	}

}
