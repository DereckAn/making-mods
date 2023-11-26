package net.dereck.dereckidid.item;


import net.dereck.dereckidid.DereckIdId;
import net.dereck.dereckidid.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

// Esta clase es para crear una pestana mas cuando abres el inventario de minecraft en modo creativo
public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
    DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DereckIdId.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB =
    CREATIVE_MODE_TABS.register("tutorial_tab",
    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
    .title(Component.translatable("creativetab.tutorial_tab"))
    .displayItems((pParameters, pOutput) -> {
        pOutput.accept(ModItems.SAPPHIRE.get());
        pOutput.accept(ModItems.RAW_SAPPHIRE.get());
        pOutput.accept(Items.DIAMOND);
        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
        pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get()); // note despues de agregarlo aqui tenemos que ir a los json files
        pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
        pOutput.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
        pOutput.accept(ModBlocks.NETHER_SAPPHIRE_ORE.get());
        pOutput.accept(ModBlocks.END_STONE_SAPPHIRE_ORE.get());
        pOutput.accept(ModItems.METAL_DETECTOR.get());
        pOutput.accept(ModBlocks.SOUND_BLOCK.get());
        pOutput.accept(ModItems.STRAWBERRY.get());
    })
    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
    
}