package com.github.Icyene.CrimsonStone.BlockOverride.Listeners;

import org.bukkit.Location;
import org.bukkit.Material;


import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import org.bukkit.event.entity.CreatureSpawnEvent;

public class EntitySpawnEvent implements Listener {
public EntitySpawnEvent() {
	
}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void MobSpawnGlass(CreatureSpawnEvent event) {
		Location l = event.getLocation();
		Location u = new Location(l.getWorld(), l.getX(), l.getY(), l.getZ());
		if (u.getBlock().getType() == Material.GLASS) {
			// Mobs can't spawn on glass, cancel event.
			event.setCancelled(true);
		}
	}
}


