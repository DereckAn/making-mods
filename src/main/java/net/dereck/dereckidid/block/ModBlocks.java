package net.dereck.dereckidid.block;

import net.dereck.dereckidid.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
    DeferredRegister.create(ForgeRegistries.BLOCKS, "dereckidid");

    // note Esta clase sera laq que crea al bloque
    public static final RegistryObject<Block> SAPPHIRE_BLOCK =
    registerBlock("sapphire_block",
    () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST))); // note aqui se esta copiando el bloque de diamante creo que solo las propiedades


    public static final RegistryObject<Block> RAW_SAPPHIRE_BLOCK =
    registerBlock("raw_sapphire_block",
    () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST))); // note  Despues de registrar el block aqui tenemos que agragarlo al tab deonde se mostraran (ModCreativeModTabs)


    private static <T extends  Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block); // note register the block
        registerBlockItem(name, toReturn); // note register the block item
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    
    // note Creo que siempre se debe de poner este metodo para registrar los bloques y luego pasarlos a la clase principal
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    
}
