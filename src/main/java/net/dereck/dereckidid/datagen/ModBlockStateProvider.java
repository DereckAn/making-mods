package net.dereck.dereckidid.datagen;

import net.dereck.dereckidid.DereckIdId;
import net.dereck.dereckidid.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;


/* La clase ModBlockStateProvider en tu código es una clase de generación de datos que se utiliza para definir cómo se representan visualmente los bloques personalizados en Minecraft.
En Minecraft, un bloque tiene un "estado de bloque" que define cómo se ve y se comporta en el juego. Esto incluye cosas como la textura del bloque, si es transparente o no, y cómo se comporta cuando el jugador interactúa con él.
La clase ModBlockStateProvider extiende la clase BlockStateProvider de la API de Minecraft Forge. Esto significa que hereda todos los métodos y campos de BlockStateProvider, pero también puedes añadir tus propios métodos y campos personalizados.*/

public class ModBlockStateProvider extends BlockStateProvider{

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DereckIdId.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.RAW_SAPPHIRE_BLOCK);

        blockWithItem(ModBlocks.SAPPHIRE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.NETHER_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.END_STONE_SAPPHIRE_ORE);
        
        blockWithItem(ModBlocks.SOUND_BLOCK);

        stairsBlock((StairBlock) ModBlocks.SAPPHIRE_STAIRS.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get())); //tip fijate en los blocks que no se mueven. o con los que no tienes interaccion
        slabBlock((SlabBlock) ModBlocks.SAPPHIRE_SLAB.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get())); // different top texture
        buttonBlock((ButtonBlock) ModBlocks.SAPPHIRE_BUTTON.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.SAPPHIRE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));

        fenceBlock((FenceBlock) ModBlocks.SAPPHIRE_FENCE.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.SAPPHIRE_FENCE_GATE.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        wallBlock((WallBlock) ModBlocks.SAPPHIRE_WALL.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));

        doorBlockWithRenderType((DoorBlock) ModBlocks.SAPPHIRE_DOOR.get(), modLoc("block/sapphire_door_bottom"), modLoc("block/sapphire_door_top"), "cutout"); //dirrefentes texturas para la parte de abajo y la de arriba
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.SAPPHIRE_TRAP_DOOR.get(), modLoc("block/sapphire_trapdoor"), true, "cutout");





    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    
}
