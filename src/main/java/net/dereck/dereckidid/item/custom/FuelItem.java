package net.dereck.dereckidid.item.custom;

import org.jetbrains.annotations.Nullable;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class FuelItem extends Item {
    private int burnTime = 0;

    public FuelItem(Properties pProperties, int pBurnTime) {
        super(pProperties);
        this.burnTime = pBurnTime;
    }
    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burnTime;
    }


    
}
