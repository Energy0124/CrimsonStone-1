package com.github.Icyene.CrimsonStone.BO.Listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class EntityHurtEvent implements Listener {
    
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {

	if (event.getCause() == DamageCause.SUFFOCATION) {

	    final Block eB = event.getEntity().getLocation().getBlock();

	    if (eB.getRelative(BlockFace.UP).getType() == Material.FENCE
		    || eB.getRelative(BlockFace.UP).getType() == Material.NETHER_FENCE
		    || eB.getRelative(BlockFace.SELF).getType() == Material.FENCE
		    || eB.getRelative(BlockFace.SELF).getType() == Material.NETHER_FENCE
		    || eB.getRelative(BlockFace.DOWN).getType() == Material.FENCE
		    || eB.getRelative(BlockFace.DOWN).getType() == Material.NETHER_FENCE
		    || eB.getRelative(BlockFace.DOWN).getType() == Material.AIR
		    || eB.getRelative(BlockFace.SELF).getType() == Material.AIR
		    || eB.getRelative(BlockFace.SELF).getType() != Material.NETHER_FENCE
		    || eB.getRelative(BlockFace.SELF).getType() != Material.FENCE) {

		event.setCancelled(true);
	    }
	}
    }

}
