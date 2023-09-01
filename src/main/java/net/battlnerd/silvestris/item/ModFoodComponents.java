package net.battlnerd.silvestris.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent GRAPES = new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).build();
    public static final FoodComponent ROSE_GRAPES = new FoodComponent.Builder().hunger(42).saturationModifier(2.0f).statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 200, 1), 1.0f).alwaysEdible().build();
}
