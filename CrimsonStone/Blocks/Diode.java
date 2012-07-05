package com.github.Icyene.CrimsonStone.Blocks;

import net.minecraft.server.BlockDiode;
import net.minecraft.server.StepSound;

public class Diode extends BlockDiode {	

	public Diode(int arg0, boolean arg1) {
		super(arg0, arg1);
		
	}
	public Diode c(float f) {
		strength = f;
		if (durability < f * 5F)
			durability = f * 5F;
		return this;
	}
	public Diode a(StepSound stepsound)
    {
        stepSound = stepsound;
        return this;
    }
	public Diode s() {
        bS = false;
        return this;
    }

    public Diode j()
    {
        r[id] = true;
        return this;
    }
    public Diode b(float f)
    {
        durability = f * 3F;
        return this;
    }
}
