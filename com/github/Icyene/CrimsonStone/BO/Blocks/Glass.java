package com.github.Icyene.CrimsonStone.BO.Blocks;

import net.minecraft.server.BlockGlass;
import net.minecraft.server.Material;

public class Glass extends BlockGlass {

    public Glass(int i, int j, Material material, boolean flag) {
        super(i, j, material, flag);    
    }
    
    @Override
    public boolean d() {
	return true;
    }

    @Override
    public boolean c()
    {
	return true;
    }
 
}
