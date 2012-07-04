package com.github.Icyene.CrimsonStone.WaterproofCircuits.Listeners;

import java.util.EnumSet;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class EntityInteractEvent implements Listener {
	private EnumSet<Material> liquids;
	public EntityInteractEvent() {
		liquids = EnumSet.of(Material.LAVA, Material.STATIONARY_LAVA, Material.WATER, Material.STATIONARY_WATER);
	}
	@EventHandler(priority = EventPriority.HIGHEST)
	public void PlayerInteractEvent(PlayerInteractEvent event) {
		//System.out.println(event.getAction() + " : " + event.getMaterial()); 
		if(event.getAction()==Action.RIGHT_CLICK_BLOCK&&event.getMaterial()==Material.REDSTONE) {
			//May have right clicked underwater
			Block b = event.getClickedBlock();
			Location n = new Location(b.getWorld(), b.getX(), b.getY()+1, b.getZ()); 
			
			if(liquids.contains(n.getBlock().getType())) {
				event.setCancelled(true);
				//handle it ourselves
				n.getBlock().setType(Material.REDSTONE_WIRE);
				event.useItemInHand();
			}
			
		}
	}

}
