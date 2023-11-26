package net.dereck.dereckidid.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(10).fast()
        .saturationMod(0.4F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 1.0F).build();

}
