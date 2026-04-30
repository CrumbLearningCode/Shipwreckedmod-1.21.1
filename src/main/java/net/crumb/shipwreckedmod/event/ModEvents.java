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

                int air = player.getAirSupply();
                int playerY = (int) Math.floor(player.getEyeY());
                int depth = 0;

                for (int y = playerY; y <= player.level().getMaxBuildHeight(); y++) {
                    var pos = player.blockPosition().atY(y);

                    if (!player.level().getBlockState(pos).isAir()) {
                        depth++;
                    } else {
                        break;
                    }
                }

                int drain = 1;
                int extra = 0;

                int total = drain + extra;

                player.setAirSupply(air - total);

                System.out.println("Water Depth " + depth + " Air Drain " + drain);
            }
        }
    }
}