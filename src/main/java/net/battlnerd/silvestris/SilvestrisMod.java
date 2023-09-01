package net.battlnerd.silvestris;

import net.battlnerd.silvestris.block.ModBlocks;
import net.battlnerd.silvestris.block.entity.ModBlockEntities;
import net.battlnerd.silvestris.item.ModItemGroups;
import net.battlnerd.silvestris.item.ModItems;
import net.battlnerd.silvestris.screen.ModScreenHandlers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SilvestrisMod implements ModInitializer {
	public static final String MOD_ID = "silvestris";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerModBlockEntities();
		FuelRegistry.INSTANCE.add(ModItems.SHARDOW_SHARD, 2000);
		FuelRegistry.INSTANCE.add(ModBlocks.SHALE, 400);
	}
}