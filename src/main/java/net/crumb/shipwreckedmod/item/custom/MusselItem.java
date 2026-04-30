package net.crumb.shipwreckedmod.item.custom;

import net.crumb.shipwreckedmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class MusselItem extends Item {
    public MusselItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        if (blockstate.is(BlockTags.BASE_STONE_OVERWORLD)) {
            BlockPos blockpos1 = blockpos.relative(context.getClickedFace());
            level.playSound(player, blockpos1, SoundEvents.BONE_BLOCK_BREAK, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);

            ItemEntity itementity = new ItemEntity(level, blockpos.getX(), blockpos.getY(), blockpos.getZ(), ModItems.RAW_MUSSEL.toStack());
            itementity.setDeltaMovement(0.0,0.2,0.0);
            level.addFreshEntity(itementity);

            ItemStack itemstack = context.getItemInHand();
            player.awardStat(Stats.ITEM_USED.get(this));
            itemstack.consume(1, player);
            return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide()).getResult();
        }
        else {
            return InteractionResult.FAIL;
        }
    }
}
