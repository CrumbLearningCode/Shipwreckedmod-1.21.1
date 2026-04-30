package net.crumb.shipwreckedmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

import java.time.Duration;

public class ModFoodProperties {
    public static final FoodProperties RAW_MUSSEL = new FoodProperties.Builder().nutrition(1).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 400), 0.35f).build();

    public static final FoodProperties COOKED_MUSSEL = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .build();
}
