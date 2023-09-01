package net.battlnerd.silvestris.block;

import net.battlnerd.silvestris.SilvestrisMod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block CRYSLATE = registerBlock("cryslate",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).sounds(BlockSoundGroup.DEEPSLATE).strength(5.0f,10.0f)));
    public static final Block COBBLED_CRYSLATE = registerBlock("cobbled_cryslate",
            new Block(FabricBlockSettings.copyOf(Blocks.COBBLED_DEEPSLATE).sounds(BlockSoundGroup.DEEPSLATE).strength(5.0f,10.0f)));
    public static final Block ALLOY_FURNACE = registerBlock("alloy_furnace",
            new AlloyFurnaceBlock(FabricBlockSettings.copyOf(Blocks.FURNACE).sounds(BlockSoundGroup.DEEPSLATE_TILES).strength(5.0f,10.0f)));
    public static final Block FERROCK = registerBlock("ferrock",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.TERRACOTTA).sounds(BlockSoundGroup.TUFF).strength(2.0f,4.0f)));
    public static final Block SHALE = registerBlock("shale",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.TERRACOTTA).sounds(BlockSoundGroup.TUFF).strength(2.0f,4.0f)));
    public static final Block ERYTHITE_PILLAR = registerBlock("erythite_pillar",
            new TransparentPillarBlock(FabricBlockSettings.copyOf(Blocks.GLASS).nonOpaque().sounds(BlockSoundGroup.SCULK_CATALYST).strength(1.6f,3.2f)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(SilvestrisMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(SilvestrisMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static final Identifier ALLOY = new Identifier(SilvestrisMod.MOD_ID, "alloy_furnace");

    public static void registerModBlocks() {
        SilvestrisMod.LOGGER.info("Registering ModBlocks for " + SilvestrisMod.MOD_ID);
    }
}
