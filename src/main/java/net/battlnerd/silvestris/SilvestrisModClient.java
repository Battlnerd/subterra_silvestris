package net.battlnerd.silvestris;

import net.battlnerd.silvestris.block.ModBlocks;
import net.battlnerd.silvestris.screen.AlloyFurnaceScreen;
import net.battlnerd.silvestris.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class SilvestrisModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ERYTHITE_PILLAR, RenderLayer.getTranslucent());
        HandledScreens.register(ModScreenHandlers.ALLOY_FURNACE_SCREEN_HANDLER, AlloyFurnaceScreen::new);
    }
}
