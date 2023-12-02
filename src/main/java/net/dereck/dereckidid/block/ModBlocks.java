package net.dereck.dereckidid.block;

import java.util.function.Supplier;

import net.dereck.dereckidid.block.custom.SoundBlock;
import net.dereck.dereckidid.item.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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

    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
    () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
        .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
    () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
        .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> NETHER_SAPPHIRE_ORE = registerBlock("nether_sapphire_ore",
    () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
        .strength(1f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
        
    public static final RegistryObject<Block> END_STONE_SAPPHIRE_ORE = registerBlock("end_stone_sapphire_ore",
    () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
        .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> SOUND_BLOCK =
    registerBlock("sound_block",
    () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));


    public static final RegistryObject<Block> SAPPHIRE_STAIRS =
    registerBlock("sapphire_stairs",
    () -> new StairBlock(() -> ModBlocks.SAPPHIRE_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST))); // tenemos que poner el bloque que queremos que se use como escalera

    public static final RegistryObject<Block> SAPPHIRE_SLAB =
    registerBlock("sapphire_slab",
    () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST))); // no requiere que le cambiemos mas cosas

    public static final RegistryObject<Block> SAPPHIRE_BUTTON =
    registerBlock("sapphire_button",
    () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.AMETHYST), BlockSetType.IRON, 10, true));

    public static final RegistryObject<Block> SAPPHIRE_PRESSURE_PLATE =
    registerBlock("sapphire_pressure_plate",
    () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST), 
    BlockSetType.IRON));

    public static final RegistryObject<Block> SAPPHIRE_FENCE =
    registerBlock("sapphire_fence",
    () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> SAPPHIRE_FENCE_GATE =
    registerBlock("sapphire_fence_gate",
    () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST), SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));

    public static final RegistryObject<Block> SAPPHIRE_WALL =
    registerBlock("sapphire_wall",
    () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> SAPPHIRE_DOOR =
    registerBlock("sapphire_door",
    () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST).noOcclusion(), BlockSetType.IRON)); // noOcclusion es para que no se vea el bloque de arriba cuando se abre la puerta. o para que sea medio transparente por las rejas.

    public static final RegistryObject<Block> SAPPHIRE_TRAP_DOOR =
    registerBlock("sapphire_trap_door",
    () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST).noOcclusion(), BlockSetType.IRON));  // Despues agrega la translation key en el archivo en_US.json


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
