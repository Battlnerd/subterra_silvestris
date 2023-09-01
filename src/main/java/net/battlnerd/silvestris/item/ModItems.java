package net.battlnerd.silvestris.item;

import net.battlnerd.silvestris.SilvestrisMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PLANT_FIBRE = registerItem("plant_fibre", new Item(new FabricItemSettings()));
    public static final Item GLASS_FIBRE = registerItem("glass_fibre", new Item(new FabricItemSettings()));
    public static final Item TOPAZ = registerItem("topaz", new Item(new FabricItemSettings()));
    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new FabricItemSettings()));
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item SHARDOW_SHARD = registerItem("shardow_shard", new Item(new FabricItemSettings()));
    public static final Item GLOWING_THREAD = registerItem("glowing_thread", new Item(new FabricItemSettings()));
    public static final Item LUMINOUS_SILK = registerItem("luminous_silk", new Item(new FabricItemSettings()));
    public static final Item RAW_ROSE_GOLD = registerItem("raw_rose_gold", new Item(new FabricItemSettings()));
    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot", new Item(new FabricItemSettings()));
    public static final Item ERYTHITE_CRYSTAL = registerItem("erythite_crystal", new Item(new FabricItemSettings()));
    public static final Item GRAPES = registerItem("grapes", new Item(new FabricItemSettings().food(ModFoodComponents.GRAPES)));
    public static final Item ROSE_GRAPES = registerItem("rose_grapes", new Item(new FabricItemSettings().food(ModFoodComponents.ROSE_GRAPES)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SilvestrisMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        SilvestrisMod.LOGGER.info("Registering Mod Items for " + SilvestrisMod.MOD_ID);
    }
}
