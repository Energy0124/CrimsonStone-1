// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CrimsonFlowing.java

package com.github.Icyene.CrimsonStone.WPC;

import java.util.Random;

import org.bukkit.Server;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.event.block.BlockFromToEvent;

import com.github.Icyene.CrimsonStone.CrimsonStone;

import net.minecraft.server.Block;
import net.minecraft.server.BlockFluids;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.Material;

public class Flowing extends BlockFluids {

    public Flowing(int i, Material material)
    {
	super(i, material);
	a = 0;
	b = new boolean[4];
	c = new int[4];
    }

    // BLOCK INHERITANCE
    public Flowing p()
    {
	r[id] = true;
	return this;
    }

    public Flowing c(float f) {
	strength = f;
	if (durability < f * 5F)
	    durability = f * 5F;
	return this;
    }
    
    public Block h(int i)
    {
        lightBlock[id] = i;
        return this;
    }

    // END

    public void l(net.minecraft.server.World world, int i, int j, int k)
    {
	int l = world.getData(i, j, k);
	world.setRawTypeIdAndData(i, j, k, id + 1, l);
	world.d(i, j, k, i, j, k);
    }

    public boolean c(IBlockAccess iblockaccess, int i, int j, int k)
    {
	return material != Material.LAVA;
    }

    public void b(net.minecraft.server.World world, int i, int j, int k,
	    Random random)
    {
	CraftWorld bworld = world.getWorld();
	Server server = world.getServer();
	org.bukkit.block.Block source = bworld != null ? bworld.getBlockAt(i,
		j, k) : null;
	int l = f_(world, i, j, k);
	byte b0 = 1;
	if (material == Material.LAVA && !world.worldProvider.d)
	    b0 = 2;
	boolean flag = true;
	if (l > 0)
	{
	    byte b1 = -100;
	    a = 0;
	    int j1 = e(world, i - 1, j, k, b1);
	    j1 = e(world, i + 1, j, k, j1);
	    j1 = e(world, i, j, k - 1, j1);
	    j1 = e(world, i, j, k + 1, j1);
	    int i1 = j1 + b0;
	    if (i1 >= 8 || j1 < 0)
		i1 = -1;
	    if (f_(world, i, j + 1, k) >= 0)
	    {
		int k1 = f_(world, i, j + 1, k);
		if (k1 >= 8)
		    i1 = k1;
		else
		    i1 = k1 + 8;
	    }
	    if (a >= 2 && material == Material.WATER)
		if (world.getMaterial(i, j - 1, k).isBuildable())
		    i1 = 0;
		else if (world.getMaterial(i, j - 1, k) == material
			&& world.getData(i, j, k) == 0)
		    i1 = 0;
	    if (material == Material.LAVA && l < 8 && i1 < 8 && i1 > l
		    && random.nextInt(4) != 0)
	    {
		i1 = l;
		flag = false;
	    }
	    if (i1 == l)
	    {
		if (flag)
		    l(world, i, j, k);
	    } else
	    {
		l = i1;
		if (i1 < 0)
		{
		    world.setTypeId(i, j, k, 0);
		} else
		{
		    world.setData(i, j, k, i1);
		    world.a(i, j, k, id, p_());
		    world.applyPhysics(i, j, k, id);
		}
	    }
	} else
	{
	    l(world, i, j, k);
	}
	if (p(world, i, j - 1, k))
	{
	    BlockFromToEvent event = new BlockFromToEvent(source,
		    BlockFace.DOWN);
	    if (server != null)
		server.getPluginManager().callEvent(event);
	    if (!event.isCancelled())
	    {
		if (material == Material.LAVA
			&& world.getMaterial(i, j - 1, k) == Material.WATER)
		{
		    world.setTypeId(i, j - 1, k, Block.STONE.id);
		    fizz(world, i, j - 1, k);
		    return;
		}
		if (l >= 8)
		    flow(world, i, j - 1, k, l);
		else
		    flow(world, i, j - 1, k, l + 8);
	    }
	} else if (l >= 0 && (l == 0 || o(world, i, j - 1, k)))
	{
	    boolean aboolean[] = n(world, i, j, k);
	    int i1 = l + b0;
	    if (l >= 8)
		i1 = 1;
	    if (i1 >= 8)
		return;
	    BlockFace faces[] = {
		    BlockFace.NORTH, BlockFace.SOUTH, BlockFace.EAST,
		    BlockFace.WEST
	    };
	    int index = 0;
	    BlockFace arr$[] = faces;
	    int len$ = arr$.length;
	    for (int i$ = 0; i$ < len$; i$++)
	    {
		BlockFace currentFace = arr$[i$];
		if (aboolean[index])
		{
		    BlockFromToEvent event = new BlockFromToEvent(source,
			    currentFace);
		    if (server != null)
			server.getPluginManager().callEvent(event);
		    if (!event.isCancelled())
			flow(world, i + currentFace.getModX(), j, k
				+ currentFace.getModZ(), i1);
		}
		index++;
	    }

	}
    }

    public void flow(net.minecraft.server.World world, int i, int j, int k,
	    int l)
    {
	if (p(world, i, j, k))
	{
	    int i1 = world.getTypeId(i, j, k);
	    if (i1 > 0)
		if (material == Material.LAVA)
		    fizz(world, i, j, k);
		else
		    Block.byId[i1].c(world, i, j, k, world.getData(i, j, k), 0);
	    world.setTypeIdAndData(i, j, k, id, l);
	}
    }

    public int d(net.minecraft.server.World world, int i, int j, int k, int l,
	    int i1)
    {
	int j1 = 1000;
	for (int k1 = 0; k1 < 4; k1++)
	{
	    if (k1 == 0 && i1 == 1 || k1 == 1 && i1 == 0 || k1 == 2 && i1 == 3
		    || k1 == 3 && i1 == 2)
		continue;
	    int l1 = i;
	    int i2 = k;
	    if (k1 == 0)
		l1 = i - 1;
	    if (k1 == 1)
		l1++;
	    if (k1 == 2)
		i2 = k - 1;
	    if (k1 == 3)
		i2++;
	    if (o(world, l1, j, i2) || world.getMaterial(l1, j, i2) == material
		    && world.getData(l1, j, i2) == 0)
		continue;
	    if (!o(world, l1, j - 1, i2))
		return l;
	    if (l >= 4)
		continue;
	    int j2 = d(world, l1, j, i2, l + 1, k1);
	    if (j2 < j1)
		j1 = j2;
	}

	return j1;
    }

    public boolean[] n(net.minecraft.server.World world, int i, int j, int k)
    {
	int l;
	for (l = 0; l < 4; l++)
	{
	    c[l] = 1000;
	    int i1 = i;
	    int j1 = k;
	    if (l == 0)
		i1 = i - 1;
	    if (l == 1)
		i1++;
	    if (l == 2)
		j1 = k - 1;
	    if (l == 3)
		j1++;
	    if (o(world, i1, j, j1) || world.getMaterial(i1, j, j1) == material
		    && world.getData(i1, j, j1) == 0)
		continue;
	    if (o(world, i1, j - 1, j1))
		c[l] = d(world, i1, j, j1, 1, l);
	    else
		c[l] = 0;
	}

	l = c[0];
	for (int i1 = 1; i1 < 4; i1++)
	    if (c[i1] < l)
		l = c[i1];

	for (int i1 = 0; i1 < 4; i1++)
	    b[i1] = c[i1] == l;

	return b;
    }

    public boolean o(net.minecraft.server.World world, int i, int j, int k)
    {
	int l = world.getTypeId(i, j, k);
	if (!CrimsonStone.config.Waterproof__Blocks.contains(Integer.valueOf(l))
		&& l != Block.WOODEN_DOOR.id && l != Block.IRON_DOOR_BLOCK.id
		&& l != Block.SIGN_POST.id && l != Block.LADDER.id
		&& l != Block.SUGAR_CANE_BLOCK.id)
	{
	    if (l == 0)
	    {
		return false;
	    } else
	    {
		Material material = Block.byId[l].material;
		return material != Material.PORTAL ? material.isSolid() : true;
	    }
	} else
	{
	    return true;
	}
    }

    public int e(net.minecraft.server.World world, int i, int j, int k, int l)
    {
	int i1 = f_(world, i, j, k);
	if (i1 < 0)
	    return l;
	if (i1 == 0)
	    a++;
	if (i1 >= 8)
	    i1 = 0;
	return l < 0 || i1 < l ? i1 : l;
    }

    public boolean p(net.minecraft.server.World world, int i, int j, int k)
    {
	Material material = world.getMaterial(i, j, k);
	return material != this.material ? material != Material.LAVA ? !o(
		world, i, j, k) : false : false;
    }

    public void onPlace(net.minecraft.server.World world, int i, int j, int k)
    {
	super.onPlace(world, i, j, k);
	if (world.getTypeId(i, j, k) == id)
	    world.a(i, j, k, id, p_());
    }

    int a;
    boolean b[];
    int c[];
}
