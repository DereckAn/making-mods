package net.dereck.dereckidid.item;

import net.dereck.dereckidid.DereckIdId;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// Esta clase se encarga de registrar los items
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
    DeferredRegister.create(ForgeRegistries.ITEMS, DereckIdId.MOD_ID);

    // Creando un item
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
    () -> new Item(new Item.Properties()));

    // Creando un item
     public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
    () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
