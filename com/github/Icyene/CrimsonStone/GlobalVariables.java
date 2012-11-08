package com.github.Icyene.CrimsonStone;

import java.util.Arrays;
import java.util.List;

import org.bukkit.plugin.Plugin;


public class GlobalVariables extends ReflectConfiguration {

    public GlobalVariables(Plugin cs) {
	super(cs);
    }

    public boolean Block__Override_Glass = true;
    public boolean Block__Override_Leaves = true;
    public boolean Block__Override_Pistons = true;
    public boolean Block__Override_GlowStone = true;
    public boolean Block__Override_TNT = true;
    public boolean Block__Override_Glass__Pane = true;
    public boolean Block__Override_Iron__Bar = true;
    public boolean Block__Override_Fence = true;
    public boolean Block__Override_Nether__Fence = true;
    public boolean Block__Override_Ice = true;

    public List<Integer> Armored__Blocks = Arrays.asList(new Integer[] { 27,
	    28, 37, 38, 39, 40, 50, 55, 70, 72, 75, 76, 77, 93, 94 });
    public List<Integer> Waterproof__Blocks = Arrays.asList(new Integer[] { 27,
	    28, 37, 38, 39, 40, 50, 55, 70, 72, 75, 76, 77, 93, 94 });

    // Features
    public boolean Features_Block__Override = true;
    public boolean Features_Armored__Blocks = true;
    public boolean Features_Waterproof__Blocks = true;

};
