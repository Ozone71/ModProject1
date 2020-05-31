package mod.ozone.rainbowgems.items.RainbowStaffs;

import mod.ozone.rainbowgems.RainbowGemsMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;


public class JadeStaffItem extends SwordItem {

    public JadeStaffItem() {
        super(StaffUtil.StaffItemTier.StaffTier,0,2.0f,new Properties().group(RainbowGemsMod.TAB));
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        //test the side
        if(!(worldIn instanceof ServerWorld)) return new ActionResult<>(ActionResultType.PASS, playerIn.getHeldItem(handIn));


        BlockPos posPlayer = new BlockPos(playerIn.getPosX(), (Math.ceil(playerIn.getPosY()) - 1),playerIn.getPosZ());
        BlockPos pos;

        for (int i = -8; i <= 8; i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = -8; k <= 8; k++) {
                    pos = posPlayer.add(i, j, k);
                    BlockState blockstate = worldIn.getBlockState(pos);
                    if (blockstate.getBlock() instanceof IGrowable) {
                        IGrowable igrowable = (IGrowable) blockstate.getBlock();
                        if (igrowable.canGrow(worldIn, pos, blockstate, worldIn.isRemote)) {
                            if (igrowable.canUseBonemeal(worldIn, worldIn.rand, pos, blockstate)) {
                                igrowable.grow((ServerWorld) worldIn, worldIn.rand, pos, blockstate);
                            }
                        }
                    }
                }
            }
        }

        playerIn.swing(handIn,true);
        playerIn.getHeldItem(handIn).damageItem(10, playerIn, (entity) -> {entity.sendBreakAnimation(handIn);;});

        return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
    }
}

