package com.github.Icyene.CrimsonStone.WaterproofCircuits;

import net.minecraft.server.Block;
import net.minecraft.server.BlockFluids;
import net.minecraft.server.Material;

public class CrimsonFlowing extends BlockFluids {

	protected CrimsonFlowing(int i, Material material) {
		super(i, material);
		a = 0;
		b = new boolean[4];
		c = new int[4];

	}

	public CrimsonFlowing f(int i) {
		lightBlock[id] = i;
		return this;
	}

	public CrimsonFlowing c(float f) {
		strength = f;
		if (durability < f * 5F)
			durability = f * 5F;
		return this;
	}

	public CrimsonFlowing s() {
		bS = false;
		return this;
	}

	public CrimsonFlowing j() {
		r[id] = true;
		return this;
	}

	public Block a(float f) {
		lightEmission[id] = (int) (15F * f);
		return this;
	}

	public boolean k(net.minecraft.server.World world, int i, int j, int k) {
		//Class for not-full block break exceptions
		int l = world.getTypeId(i, j, k);
		if (!Waterproof.waterproofBlocks.contains(l)
				&& l != Block.WOODEN_DOOR.id && l != Block.IRON_DOOR_BLOCK.id
				&& l != Block.SIGN_POST.id && l != Block.LADDER.id
				&& l != Block.SUGAR_CANE_BLOCK.id) {
			if (l == 0) {
				return false;
			} else {
				Material material = Block.byId[l].material;
				return material != Material.PORTAL ? material.isSolid() : true;
			}
		} else {
			return true;
		}
	}

	int a;
	boolean b[];
	int c[];
}
