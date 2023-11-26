package net.dereck.dereckidid.util;

import net.dereck.dereckidid.DereckIdId;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    // Esta clase representara los tags de los bloques
    public static class Blocks{
        //Esto crea una key que podemos usar dentro del codigo
        public static final TagKey<Block>  METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(DereckIdId.MOD_ID, name));
        }
    }

    // Esta clase representara los tags de los items
    public static class Items{
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(DereckIdId.MOD_ID, name));
        }

    }
    
}
