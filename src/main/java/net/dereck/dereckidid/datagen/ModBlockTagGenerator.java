package net.dereck.dereckidid.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import net.dereck.dereckidid.DereckIdId;
import net.dereck.dereckidid.block.ModBlocks;
import net.dereck.dereckidid.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;


/* La clase ModBlockLootTables en tu código es una clase de generación de datos que se utiliza para definir las tablas de botín para los bloques personalizados en Minecraft.

En Minecraft, una tabla de botín es una estructura de datos que define qué objetos se caen cuando un bloque es destruido. Por ejemplo, cuando destruyes un bloque de mineral de diamante, la tabla de botín para ese bloque define que se caerá un diamante.

La clase ModBlockLootTables extiende la clase BlockLootSubProvider de la API de Minecraft Forge. Esto significa que hereda todos los métodos y campos de BlockLootSubProvider, pero también puedes añadir tus propios métodos y campos personalizados.

En tu código, estás utilizando ModBlockLootTables para definir las tablas de botín para varios bloques personalizados, como SAPPHIRE_BLOCK, RAW_SAPPHIRE_BLOCK, SOUND_BLOCK, etc. */

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DereckIdId.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.SAPPHIRE_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SAPPHIRE_BLOCK.get(),
                        ModBlocks.RAW_SAPPHIRE_BLOCK.get(),
                        ModBlocks.SAPPHIRE_ORE.get(),
                        ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                        ModBlocks.NETHER_SAPPHIRE_ORE.get(),
                        ModBlocks.END_STONE_SAPPHIRE_ORE.get(),
                        ModBlocks.SOUND_BLOCK.get());


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SAPPHIRE_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_SAPPHIRE_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.NETHER_SAPPHIRE_ORE.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.END_STONE_SAPPHIRE_ORE.get());

        this.tag(BlockTags.FENCES)  // El dijo que es para conectar los bloques  -- muy importante
                .add(ModBlocks.SAPPHIRE_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.SAPPHIRE_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.SAPPHIRE_WALL.get());

        


    }

}