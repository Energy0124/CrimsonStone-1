package com.github.Icyene.CrimsonStone.BO;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import net.minecraft.server.Block;
import net.minecraft.server.Material;
import net.minecraft.server.StepSound;

import org.bukkit.plugin.Plugin;

import com.github.Icyene.CrimsonStone.CrimsonStone;
import com.github.Icyene.CrimsonStone.BO.Blocks.Fences;
import com.github.Icyene.CrimsonStone.BO.Blocks.Glass;
import com.github.Icyene.CrimsonStone.BO.Blocks.Glowstone;
import com.github.Icyene.CrimsonStone.BO.Blocks.Ice;
import com.github.Icyene.CrimsonStone.BO.Blocks.Leaves;
import com.github.Icyene.CrimsonStone.BO.Blocks.Piston;
import com.github.Icyene.CrimsonStone.BO.Blocks.PistonExtension;
import com.github.Icyene.CrimsonStone.BO.Blocks.TNT;
import com.github.Icyene.CrimsonStone.BO.Blocks.ThinFence;

public class ModBlocks {

    static void modify(Plugin plugin) throws Exception {

	try {

	    Method v = Block.class.getDeclaredMethod("v");
	    Method p = Block.class.getDeclaredMethod("p");
	    Method c = Block.class.getDeclaredMethod("c", float.class);
	    Method h = Block.class.getDeclaredMethod("h", int.class);
	    Method b = Block.class.getDeclaredMethod("b", float.class);
	    Method a = Block.class.getDeclaredMethod("a", StepSound.class);
	    Method a_float = Block.class.getDeclaredMethod("a", float.class);
	    v.setAccessible(true);
	    p.setAccessible(true);
	    c.setAccessible(true);
	    h.setAccessible(true);
	    b.setAccessible(true);
	    a.setAccessible(true);
	    a_float.setAccessible(true);

	    Field shat = Material.SHATTERABLE.getClass().getDeclaredField("I");
	    shat.setAccessible(true);
	    shat.setBoolean(Material.SHATTERABLE, false);
	    Field lev = Material.LEAVES.getClass().getDeclaredField("I");
	    lev.setAccessible(true);
	    lev.setBoolean(Material.LEAVES, false);
	    Field pis = Material.PISTON.getClass().getDeclaredField("I");
	    pis.setAccessible(true);
	    pis.setBoolean(Material.PISTON, false);
	    Field tnt = Material.TNT.getClass().getDeclaredField("I");
	    tnt.setAccessible(true);
	    tnt.setBoolean(Material.TNT, false);

	    // Fences
	    if (CrimsonStone.config.Block__Override_Fence) {
		Block.byId[Block.FENCE.id] = null;

		Block FENCE = new Fences(85, 4).b("fence");
		FENCE = (Block) c.invoke(FENCE, 2.0F);
		FENCE = (Block) b.invoke(FENCE, 5F);
		FENCE = (Block) a.invoke(FENCE, Block.e);

		Block.byId[Block.FENCE.id] = FENCE;
	    }

	    // Nether fence
	    if (CrimsonStone.config.Block__Override_Nether__Fence) {

		Block.byId[Block.NETHER_FENCE.id] = null;

		Block NETHER_FENCE = new Fences(113, 224, Material.STONE)
			.b("netherFence");
		NETHER_FENCE = (Block) c.invoke(NETHER_FENCE, 2.0F);
		NETHER_FENCE = (Block) b.invoke(NETHER_FENCE, 10F);
		NETHER_FENCE = (Block) a.invoke(NETHER_FENCE, Block.h);

		Block.byId[Block.NETHER_FENCE.id] = NETHER_FENCE;

	    }
	    // Glass
	    if (CrimsonStone.config.Block__Override_Glass) {
		Block.byId[Block.GLASS.id] = null;

		Block GLASS = new Glass(20, 49, Material.SHATTERABLE, false)
			.b("glass");
		GLASS = (Block) c.invoke(GLASS, 0.3F);
		GLASS = (Block) a.invoke(GLASS, Block.j);

		Block.byId[Block.GLASS.id] = GLASS;
	    }

	    // Glowstone
	    if (CrimsonStone.config.Block__Override_GlowStone) {
		Block.byId[Block.GLOWSTONE.id] = null;

		Block GLOWSTONE = new Glowstone(89, 105, Material.SHATTERABLE)
			.b("lightgem");
		GLOWSTONE = (Block) c.invoke(GLOWSTONE, 0.3F);
		GLOWSTONE = (Block) a.invoke(GLOWSTONE, Block.j);
		GLOWSTONE = (Block) a_float.invoke(GLOWSTONE, 1.0F);

		Block.byId[Block.GLOWSTONE.id] = GLOWSTONE;
	    }

	    // Ice
	    if (CrimsonStone.config.Block__Override_Ice) {
		Block.byId[Block.ICE.id] = null;

		Block ICE = new Ice(79, 67).b("ice");
		ICE = (Block) c.invoke(ICE, 0.5F);
		ICE = (Block) h.invoke(ICE, 3);
		ICE = (Block) a.invoke(ICE, Block.j);

		Block.byId[Block.ICE.id] = ICE;
		Block.lightBlock[Block.ICE.id] = 3;
	    }
	    // Leaves
	    if (CrimsonStone.config.Block__Override_Leaves) {
		Block.byId[Block.LEAVES.id] = null;

		Block LEAVES = new Leaves(18, 52).b("leaves");
		LEAVES = (Block) c.invoke(LEAVES, 0.2F);
		LEAVES = (Block) h.invoke(LEAVES, 1);
		LEAVES = (Block) a.invoke(LEAVES, Block.g);
		LEAVES = (Block) p.invoke(LEAVES);

		Block.byId[Block.LEAVES.id] = LEAVES;

		Block.lightBlock[Block.LEAVES.id] = 1;
		Block.r[Block.LEAVES.id] = true;
	    }

	    // Piston
	    if (CrimsonStone.config.Block__Override_Pistons) {
		Block.byId[Block.PISTON.id] = null;
		Block PISTON = new Piston(Block.PISTON.id, 107, false)
			.b("pistonBase");
		Block.byId[Block.PISTON.id] = PISTON;
		Block.r[Block.PISTON.id] = true;

		// Sticky piston
		Block.byId[Block.PISTON_STICKY.id] = null;
		Block PISTON_STICKY = new Piston(Block.PISTON_STICKY.id, 106,
			true)
			.b("pistonStickyBase");
		Block.byId[Block.PISTON_STICKY.id] = PISTON_STICKY;

		// Piston Extension
		Block.byId[Block.PISTON_EXTENSION.id] = null;
		Block PISTON_EXTENSION = new PistonExtension(
			Block.PISTON_EXTENSION.id, 107);
		Block.byId[Block.PISTON_EXTENSION.id] = PISTON_EXTENSION;
		Block.r[Block.PISTON_EXTENSION.id] = true;
	    }

	    // Iron fence
	    if (CrimsonStone.config.Block__Override_Iron__Bar) {

		Block.byId[Block.IRON_FENCE.id] = null;

		Block IRON_FENCE = new ThinFence(101, 85, 85, Material.ORE,
			true).b("fenceIron");
		IRON_FENCE = (Block) c.invoke(IRON_FENCE, 5F);
		IRON_FENCE = (Block) b.invoke(IRON_FENCE, 10F);
		IRON_FENCE = (Block) a.invoke(IRON_FENCE, Block.i);

		Block.byId[Block.IRON_FENCE.id] = IRON_FENCE;
	    }

	    // Glass panes
	    if (CrimsonStone.config.Block__Override_Glass__Pane) {

		Block.byId[Block.THIN_GLASS.id] = null;
		Block THIN_GLASS = new ThinFence(102, 49, 148,
			Material.SHATTERABLE, false).b("thinGlass");
		THIN_GLASS = (Block) c.invoke(THIN_GLASS, 0.3F);
		THIN_GLASS = (Block) a.invoke(THIN_GLASS, Block.j);

	    }

	    // TNT
	    if (CrimsonStone.config.Block__Override_TNT) {
		Block.byId[Block.TNT.id] = null;

		Block TNT = new TNT(46, 8).b("tnt");
		TNT = (Block) c.invoke(TNT, 0.0F);
		TNT = (Block) a.invoke(TNT, Block.g);

		Block.byId[Block.TNT.id] = TNT;

	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    static void forceUpdate() throws IllegalArgumentException,
	    IllegalAccessException, NoSuchFieldException, SecurityException {
	try {

	    Block.byId[Block.FENCE.id] = Block.FENCE;
	    Block.byId[Block.NETHER_FENCE.id] = Block.NETHER_FENCE;
	    Block.byId[Block.LEAVES.id] = Block.LEAVES;
	    Block.byId[Block.GLOWSTONE.id] = Block.GLOWSTONE;
	    Block.byId[Block.TNT.id] = Block.TNT;
	    Block.byId[Block.THIN_GLASS.id] = Block.THIN_GLASS;
	    Block.byId[Block.IRON_FENCE.id] = Block.IRON_FENCE;
	    Block.byId[Block.PISTON.id] = Block.PISTON;
	    Block.byId[Block.PISTON_STICKY.id] = Block.PISTON_STICKY;
	    Block.byId[Block.PISTON_EXTENSION.id] = Block.PISTON_EXTENSION;
	    Block.byId[Block.PISTON_MOVING.id] = Block.PISTON_MOVING;
	    Block.byId[Block.ICE.id] = Block.ICE;

	    Field leaves = Material.LEAVES.getClass().getDeclaredField("I");
	    leaves.setAccessible(true);
	    leaves.setBoolean(Material.LEAVES, true);

	    Field glowstone = Material.SHATTERABLE.getClass().getDeclaredField(
		    "I");
	    glowstone.setAccessible(true);
	    glowstone.setBoolean(Material.SHATTERABLE, true);

	    Field tnt = Material.TNT.getClass().getDeclaredField("I");
	    tnt.setAccessible(true);
	    tnt.setBoolean(Material.TNT, true);

	    Field pistons = Material.PISTON.getClass().getDeclaredField("I");
	    pistons.setAccessible(true);
	    pistons.setBoolean(Material.PISTON, true);

	    Field ice = Material.ICE.getClass().getDeclaredField("I");
	    ice.setAccessible(true);
	    ice.setBoolean(Material.ICE, true);

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}
