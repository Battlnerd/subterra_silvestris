/*
 * Decompiled with CFR 0.2.0 (FabricMC d28b102d).
 */
package net.battlnerd.silvestris.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.GlassBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;

public class TransparentPillarBlock
extends GlassBlock {
    public static final EnumProperty<Direction.Axis> AXIS = Properties.AXIS;
    public TransparentPillarBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return TransparentPillarBlock.changeRotation(state, rotation);
    }

    public static BlockState changeRotation(BlockState state, BlockRotation rotation) {
        switch (rotation) {
            case COUNTERCLOCKWISE_90, CLOCKWISE_90 -> {
                switch (state.get(AXIS)) {
                    case X -> {
                        return (BlockState) state.with(AXIS, Direction.Axis.Z);
                    }
                    case Z -> {
                        return (BlockState) state.with(AXIS, Direction.Axis.X);
                    }
                }
                return state;
            }
        }
        return state;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(AXIS, ctx.getSide().getAxis());
    }
}

