package com.github.Icyene.CrimsonStone.AR.Listeners;

import java.util.ArrayList;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import com.github.Icyene.CrimsonStone.CrimsonStone;

public class ExplosionListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void noRedstoneDrop(EntityExplodeEvent event)
    {
      ArrayList<Block> toRemove = new ArrayList<Block>();
      
      for (Block block : event.blockList())
      {
        for (int id : CrimsonStone.config.Armored__Blocks)
        {
          if (block.getTypeId() == id) 
            toRemove.add(block);
        }
      }
      
      for (Block block : toRemove)
        event.blockList().remove(block);
    }

}
