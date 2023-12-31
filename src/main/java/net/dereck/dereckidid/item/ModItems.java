package net.dereck.dereckidid.item;

import net.dereck.dereckidid.DereckIdId;
import net.dereck.dereckidid.item.custom.FuelItem;
import net.dereck.dereckidid.item.custom.MetalDetectorItem;
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

     public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
    () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
    () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));

    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
    () -> new FuelItem(new Item.Properties(), 400));

    public static final RegistryObject<Item> SAPPHIRE_STAFF = ITEMS.register("sapphire_staff",
    () -> new Item(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
