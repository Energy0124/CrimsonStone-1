package com.github.Icyene.CrimsonStone.WaterproofCircuits;

import java.util.EnumSet;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

public class OnLiquidSpreadEvent implements Listener {
	private EnumSet<Material> blocks;

	public OnLiquidSpreadEvent() {
		blocks = EnumSet.of(Material.REDSTONE_WIRE, Material.REDSTONE_TORCH_ON,
				Material.REDSTONE_TORCH_OFF, Material.DIODE_BLOCK_OFF,
				Material.DIODE_BLOCK_ON, Material.LEVER, Material.STONE_BUTTON,
				Material.RAILS, Material.POWERED_RAIL, Material.DETECTOR_RAIL);
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBlockFromTo(BlockFromToEvent event) {
		if (blocks.contains(event.getToBlock().getType())) {
			event.setCancelled(true);
		}
	}
}
