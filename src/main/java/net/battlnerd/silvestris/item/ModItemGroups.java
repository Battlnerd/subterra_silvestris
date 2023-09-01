package net.battlnerd.silvestris.item;

import net.battlnerd.silvestris.SilvestrisMod;
import net.battlnerd.silvestris.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup SILVESTRIS_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(SilvestrisMod.MOD_ID, "silvestris"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.silvestris"))
                    .icon(() -> new ItemStack(ModItems.PLANT_FIBRE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.PLANT_FIBRE);
                        entries.add(ModItems.GLASS_FIBRE);
                        entries.add(ModItems.SAPPHIRE);
                        entries.add(ModItems.TOPAZ);
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.SHARDOW_SHARD);
                        entries.add(ModItems.GLOWING_THREAD);
                        entries.add(ModItems.LUMINOUS_SILK);
                        entries.add(ModItems.RAW_ROSE_GOLD);
                        entries.add(ModItems.ROSE_GOLD_INGOT);
                        entries.add(ModItems.GRAPES);
                        entries.add(ModItems.ROSE_GRAPES);
                        entries.add(ModBlocks.CRYSLATE);
                        entries.add(ModBlocks.COBBLED_CRYSLATE);
                        entries.add(ModBlocks.ALLOY_FURNACE);
                        entries.add(ModBlocks.FERROCK);
                        entries.add(ModBlocks.SHALE);
                        entries.add(ModBlocks.ERYTHITE_PILLAR);
                        entries.add(ModItems.ERYTHITE_CRYSTAL);
                    }).build());

    public static void registerItemGroups(){
        SilvestrisMod.LOGGER.info("Registering item groups for: " + SilvestrisMod.MOD_ID);
    }
}
