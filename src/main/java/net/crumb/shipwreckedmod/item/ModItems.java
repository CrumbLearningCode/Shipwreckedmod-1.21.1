package net.crumb.shipwreckedmod.item;

import net.crumb.shipwreckedmod.ShipwreckedMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ShipwreckedMod.MOD_ID);

    public static final DeferredItem<Item> MUSSEL = ITEMS.register("mussel",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_MUSSEL = ITEMS.register("raw_mussel",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
