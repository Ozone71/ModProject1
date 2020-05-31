package mod.ozone.rainbowgems.items.RainbowStaffs;

import mod.ozone.rainbowgems.RainbowGemsMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;


public class AmethystStaffItem extends SwordItem {

    public AmethystStaffItem() {
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

        //cast World to ServerWorld
        ServerWorld world = (ServerWorld) worldIn;


        ItemStack item = playerIn.getHeldItem(handIn);
        Vec3d aim = playerIn.getLookVec();
        double distance;

        for (int i = 1; i <= 5; i++) {
            distance = 2.0D + (double) i * 5.0D;
            world.createExplosion(null, playerIn.getPosX() + distance*aim.x, playerIn.getPosY() + distance*aim.y +1.5, playerIn.getPosZ() + distance * aim.z,3.0f,false, Explosion.Mode.DESTROY);
        }

        playerIn.swing(handIn,true);
        playerIn.getHeldItem(handIn).damageItem(10, playerIn, (entity) -> {entity.sendBreakAnimation(handIn);;});

        return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
    }
}

