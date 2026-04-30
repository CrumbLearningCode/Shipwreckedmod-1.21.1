package net.crumb.shipwreckedmod.item.custom;

import net.crumb.shipwreckedmod.ShipwreckedMod;
import net.crumb.shipwreckedmod.block.ModBlocks;
import net.crumb.shipwreckedmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ShipwreckedMod.MOD_ID);

    public static final Supplier<CreativeModeTab> SHIPWRECKED_ITEMS = CREATIVE_MODE_TAB.register("shipwrecked_items",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MUSSEL.get()))
                    .title(Component.translatable("creativetab.shipwreckedmod.mussel.items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.MUSSEL);
                        output.accept(ModItems.RAW_MUSSEL);
                        output.accept(ModItems.COOKED_MUSSEL);
                        output.accept(ModBlocks.LIMESTONE_BLOCK);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}