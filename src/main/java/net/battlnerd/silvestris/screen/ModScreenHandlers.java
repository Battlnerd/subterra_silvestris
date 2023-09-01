package net.battlnerd.silvestris.screen;

import net.battlnerd.silvestris.block.entity.ModBlockEntities;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<AlloyFurnaceScreenHandler> ALLOY_FURNACE_SCREEN_HANDLER;
    public static void registerModScreenHandlers(){
        ALLOY_FURNACE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(ModBlockEntities.ALLOY_FURNACE_ID, AlloyFurnaceScreenHandler::new);
    }
}
