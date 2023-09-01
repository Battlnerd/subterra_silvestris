package net.battlnerd.silvestris.block.entity;

import net.battlnerd.silvestris.SilvestrisMod;
import net.battlnerd.silvestris.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static BlockEntityType<AlloyFurnaceBlockEntity> ALLOY_FURANCE_BLOCK_ENTITY;

    public static final Identifier ALLOY_FURNACE_ID = new Identifier(SilvestrisMod.MOD_ID, "ALLOY_FURNACE_ID");

    public static void registerModBlockEntities(){
        ALLOY_FURANCE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, ALLOY_FURNACE_ID, FabricBlockEntityTypeBuilder.create(AlloyFurnaceBlockEntity::new, ModBlocks.ALLOY_FURNACE).build(null));
    }
}