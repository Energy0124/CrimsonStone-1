package com.github.Icyene.CrimsonStone.BO.Listeners;

//import org.bukkit.Effect;
//import org.bukkit.EntityEffect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
//import org.bukkit.event.block.BlockBreakEvent;
//import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class EntityHurtEvent implements Listener {
	public EntityHurtEvent() {

	}

	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		Block eB = event.getEntity().getLocation().getBlock();
		if (event.getCause() == DamageCause.SUFFOCATION) {

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
	//
	// @EventHandler
	// public void onBlockPlace(BlockPlaceEvent event) {
	//
	// event.getBlock().getWorld()
	// .playEffect(event.getBlock().getLocation(), Effect.SMOKE, 1);
	//
	// event.getBlock()
	// .getWorld()
	// .playEffect(event.getBlock().getLocation(), Effect.EXTINGUISH,
	// 1);
	//
	// }
	//
	// @EventHandler
	// public void onBlockBreak(BlockBreakEvent event) {
	//
	// event.getBlock()
	// .getWorld()
	// .playEffect(event.getBlock().getLocation(),
	// Effect.ENDER_SIGNAL, 1);
	// event.getBlock()
	// .getWorld()
	// .playEffect(event.getBlock().getLocation(),
	// Effect.POTION_BREAK, 1);
	//
	// }

}
