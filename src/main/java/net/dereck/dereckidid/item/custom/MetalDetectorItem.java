package net.dereck.dereckidid.item.custom;

import java.util.List;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide){
            BlockPos positionClikced = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClikced.getY() + 64; i++){
                BlockState state = pContext.getLevel().getBlockState(positionClikced.below(i));

                if(isValuableBlock(state)){
                    outputValuableCoordinates(player, positionClikced.below(i), state.getBlock());
                    foundBlock = true;
                    break;
                }
            }

                if(!foundBlock){
                    player.sendSystemMessage(Component.literal("No valuable blocks found"));
                }
        }
        
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), player -> player.broadcastBreakEvent(player.getUsedItemHand()));
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

        pTooltipComponents.add(Component.translatable("tooltip.dereckidid.metal_detector.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private void outputValuableCoordinates(Player player, BlockPos blockpos, Block block) {
        player.sendSystemMessage(Component.literal(
            "Found" + I18n.get(block.getDescriptionId()) + "at" + blockpos.getX() + ", " + blockpos.getY() + ", " + blockpos.getZ()) );

    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(Blocks.IRON_ORE) || state.is(Blocks.GOLD_ORE) || state.is(Blocks.DIAMOND_ORE) || state.is(Blocks.EMERALD_ORE);
    }


    
}
