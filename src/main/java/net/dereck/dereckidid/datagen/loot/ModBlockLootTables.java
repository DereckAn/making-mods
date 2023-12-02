package net.dereck.dereckidid.datagen.loot;

import java.util.Set;

import net.dereck.dereckidid.block.ModBlocks;
import net.dereck.dereckidid.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;


/* La clase ModBlockLootTables en tu código es una clase de generación de datos que se utiliza para definir las tablas de botín para los bloques personalizados en Minecraft.

En Minecraft, una tabla de botín es una estructura de datos que define qué objetos se caen cuando un bloque es destruido. Por ejemplo, cuando destruyes un bloque de mineral de diamante, la tabla de botín para ese bloque define que se caerá un diamante.

La clase ModBlockLootTables extiende la clase BlockLootSubProvider de la API de Minecraft Forge. Esto significa que hereda todos los métodos y campos de BlockLootSubProvider, pero también puedes añadir tus propios métodos y campos personalizados.

En tu código, estás utilizando ModBlockLootTables para definir las tablas de botín para varios bloques personalizados, como SAPPHIRE_BLOCK, RAW_SAPPHIRE_BLOCK, SOUND_BLOCK, etc. */

public class ModBlockLootTables extends BlockLootSubProvider{

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

   @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.add(ModBlocks.SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.NETHER_SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.NETHER_SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.END_STONE_SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.END_STONE_SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));

        this.dropSelf(ModBlocks.SAPPHIRE_STAIRS.get());
        this.dropSelf(ModBlocks.SAPPHIRE_BUTTON.get());
        this.dropSelf(ModBlocks.SAPPHIRE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.SAPPHIRE_FENCE.get());
        this.dropSelf(ModBlocks.SAPPHIRE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.SAPPHIRE_WALL.get());
        this.dropSelf(ModBlocks.SAPPHIRE_TRAP_DOOR.get());

        this.add(ModBlocks.SAPPHIRE_DOOR.get(), (block) -> createSlabItemTable(ModBlocks.SAPPHIRE_SLAB.get()));
        this.add(ModBlocks.SAPPHIRE_SLAB.get(), (block) -> createDoorTable(ModBlocks.SAPPHIRE_DOOR.get()));


    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
