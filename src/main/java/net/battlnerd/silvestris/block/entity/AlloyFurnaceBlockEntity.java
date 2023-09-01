package net.battlnerd.silvestris.block.entity;

import com.google.common.collect.Maps;
import net.battlnerd.silvestris.item.ModItems;
import net.battlnerd.silvestris.screen.AlloyFurnaceScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class AlloyFurnaceBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    protected static final int INPUT0_SLOT_INDEX = 0;
    protected static final int INPUT1_SLOT_INDEX = 1;
    protected static final int FUEL_SLOT_INDEX = 2;
    protected static final int OUTPUT_SLOT_INDEX = 3;

    public static Map<Item, Integer> fuelTimeMap(){
        HashMap<Item, Integer> map = Maps.newHashMap();
        map.put(Items.COAL, 800);
        map.put(Blocks.COAL_BLOCK.asItem(), 8000);
        return map;
    }

    public AlloyFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ALLOY_FURANCE_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> AlloyFurnaceBlockEntity.this.progress;
                    case 1 -> AlloyFurnaceBlockEntity.this.maxProgress;
                    case 2 -> AlloyFurnaceBlockEntity.this.fuelTime;
                    case 3 -> AlloyFurnaceBlockEntity.this.maxFuelTime;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0 -> AlloyFurnaceBlockEntity.this.progress = value;
                    case 1 -> AlloyFurnaceBlockEntity.this.maxProgress = value;
                    case 2 -> AlloyFurnaceBlockEntity.this.fuelTime = value;
                    case 3 -> AlloyFurnaceBlockEntity.this.maxFuelTime = value;
                }
            }

            @Override
            public int size() {
                return 4;
            }
        };
    }

    protected final PropertyDelegate propertyDelegate;
        private int progress = 0;
        private int maxProgress = 100;
        private int fuelTime = 0;
        private int maxFuelTime = 100;



    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }


    @Override
    public Text getDisplayName() {
        return Text.translatable("container.alloy_furnace");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new AlloyFurnaceScreenHandler(syncId, playerInventory, this);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("alloy_furnace.progress", progress);
        nbt.putInt("alloy_furnace.fuelTime", fuelTime);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("alloy_furnace.progress");
        fuelTime = nbt.getInt("alloy_furnace.fuelTime");
    }
    private void resetProgress(){
        this.progress = 0;
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, AlloyFurnaceBlockEntity entity) {
        if (world.isClient){
            return;
        }
        if (!hasRecipe(entity) || entity.fuelTime <= 0 || !entity.getStack(2).isEmpty()){
            if (fuelTimeMap().containsKey(entity.getStack(2))){
                entity.fuelTime += fuelTimeMap().get(entity.getStack(2));
                entity.maxFuelTime = entity.fuelTime;
            }
        }
        if (hasRecipe(entity) && entity.fuelTime >= 1){
            entity.progress++;
            entity.fuelTime--;
            markDirty(world, blockPos, blockState);
            if (entity.progress >= entity.maxProgress){
                craftItem(entity);
            } else {
                entity.resetProgress();
                markDirty(world, blockPos, blockState);
            }
        }
    }

    private static void craftItem(AlloyFurnaceBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++){
            inventory.setStack(i, entity.getStack(i));
        }
        if (hasRecipe(entity)){
            entity.removeStack(0, 1);
            entity.removeStack(1, 1);

            entity.setStack(3, new ItemStack(ModItems.ROSE_GRAPES, entity.getStack(3).getCount()+1));
        }
    }

    private static boolean hasRecipe(AlloyFurnaceBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++){
            inventory.setStack(i, entity.getStack(i));
        }

        boolean hasGrapeInFirstSlot = entity.getStack(0).getItem() == ModItems.GRAPES;
        boolean hasGoldInFirstSlot = entity.getStack(1).getItem() == ModItems.ROSE_GOLD_INGOT;

        return
                hasGrapeInFirstSlot && hasGoldInFirstSlot
                        && canOutputAmount(inventory, 1)
                        && canOutputItem(inventory, ModItems.ROSE_GRAPES);
    }
    private static boolean canOutputAmount(SimpleInventory inventory, int count) {
        return inventory.getStack(3).getMaxCount() > inventory.getStack(3).getCount() + count;
    }
    private static boolean canOutputItem(SimpleInventory inventory, Item output) {
        return inventory.getStack(3).getItem() == output || inventory.getStack(3).isEmpty();
    }
}
