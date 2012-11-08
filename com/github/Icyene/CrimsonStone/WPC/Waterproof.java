package com.github.Icyene.CrimsonStone.WPC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.minecraft.server.Block;

import net.minecraft.server.Material;

import org.bukkit.Bukkit;

import com.github.Icyene.CrimsonStone.CrimsonStone;
import com.github.Icyene.CrimsonStone.WPC.Listeners.EntityInteractEvent;

public class Waterproof {

    public static void load(CrimsonStone stone) {

	
	Bukkit.getServer().getPluginManager()
		.registerEvents(new EntityInteractEvent(), stone);

	try {
	    modify();

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    public static void unload() {	
	try {
	    //Not the right way to do this, but since its being disabled anyways it doesn't matter
	    CrimsonStone.config.Waterproof__Blocks = null;
	    modify();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    static void modify() throws NoSuchMethodException, SecurityException,
	    IllegalAccessException, IllegalArgumentException,
	    InvocationTargetException {

	Block.byId[Block.WATER.id] = null;
	Block.byId[Block.LAVA.id] = null;

	Method v = Block.class.getDeclaredMethod("v");
	Method p = Block.class.getDeclaredMethod("p");
	Method c = Block.class.getDeclaredMethod("c", float.class);
	Method h = Block.class.getDeclaredMethod("h", int.class);
	v.setAccessible(true);
	p.setAccessible(true);	
	c.setAccessible(true);
	h.setAccessible(true);

	Block WATER = new Flowing(8, Material.WATER).b("water");
	WATER = (Block) v.invoke(WATER);
	WATER = (Block) p.invoke(WATER);
	WATER = (Block) c.invoke(WATER, 100F);
	WATER = (Block) h.invoke(WATER, 3);

	Block.byId[Block.WATER.id] = WATER;

	Block LAVA = new Flowing(10, Material.LAVA).b("lava");
	LAVA = (Block) v.invoke(LAVA);
	LAVA = (Block) p.invoke(LAVA);	
	LAVA = (Block) c.invoke(LAVA, 0.0F);
	LAVA = (Block) h.invoke(LAVA, 255);
	
	Block.byId[Block.LAVA.id] = LAVA;

    }

}
