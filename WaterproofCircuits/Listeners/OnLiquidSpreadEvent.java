package com.github.Icyene.CrimsonStone.WaterproofCircuits.Listeners;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

import com.github.Icyene.CrimsonStone.Core;
import com.github.Icyene.CrimsonStone.Configuration.Configuration;

public class OnLiquidSpreadEvent implements Listener {
	public List<Material> blocks;
	
	public OnLiquidSpreadEvent(Core plugin) {
	blocks = Configuration.genWaterproofArray(plugin);
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBlockFromTo(BlockFromToEvent event) {
		if (blocks.contains(event.getToBlock().getType())) {
			event.setCancelled(true);
		}
	}
}
