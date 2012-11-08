package com.github.Icyene.CrimsonStone.BlockOverride.Blocks;

import net.minecraft.server.BlockPiston;
import net.minecraft.server.StepSound;

public class Piston extends BlockPiston {

	// For piston armoring / overriding

	public Piston(int i, int j, boolean flag) {
		super(i, j, flag);
	}

	public boolean b() {
		return true;
	}

	public Piston a(StepSound stepsound) {
		stepSound = stepsound;
		return this;
	}

	public Piston s() {
		bS = false;
		return this;
	}

	public Piston j() {
		r[id] = true;
		return this;
	}

	public Piston b(float f) {
		durability = f * 3F;
		return this;
	}

}
