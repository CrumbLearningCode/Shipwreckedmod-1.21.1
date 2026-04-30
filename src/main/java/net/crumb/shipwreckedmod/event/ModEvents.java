package net.crumb.shipwreckedmod.event;

import net.crumb.shipwreckedmod.ShipwreckedMod;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

@EventBusSubscriber(modid = ShipwreckedMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    @SubscribeEvent
    public static void entitytick(EntityTickEvent.Post event){
        if(event.getEntity() instanceof Player player) {

            if (player.isEyeInFluidType(Fluids.WATER.getFluidType())) {
                System.out.println("Player in water!");
            }
        }
    }
}
