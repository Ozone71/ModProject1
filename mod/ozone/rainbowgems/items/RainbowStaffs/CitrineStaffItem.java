package mod.ozone.rainbowgems.items.RainbowStaffs;

import mod.ozone.rainbowgems.RainbowGemsMod;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class CitrineStaffItem extends SwordItem {

    public CitrineStaffItem() {
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

        Vec3d aim = playerIn.getLookVec();
        double x1 = playerIn.getPosX() + aim.x * 6.0;
        double x2 = playerIn.getPosX() + aim.x * 8.0;
        double x3 = playerIn.getPosX() + aim.x * 10.0;
        double z1 = playerIn.getPosZ() + aim.z * 6.0;
        double z2 = playerIn.getPosZ() + aim.z * 8.0;;
        double z3 = playerIn.getPosZ() + aim.z * 10.0;;
        double y = playerIn.getPosY();
        BlockPos pos1 = new BlockPos(Math.round(x1),Math.round(y),Math.round(z1));
        BlockPos pos2 = new BlockPos(Math.round(x2),Math.round(y),Math.round(z2));
        BlockPos pos3 = new BlockPos(Math.round(x3),Math.round(y),Math.round(z3));
        double y1 = 255.0D;
        double y2 = 255.0D;
        double y3 = 255.0D;

        y1 = (double) RainbowGemsMod.GetTopBlock(worldIn,pos1);
        y2 = (double) RainbowGemsMod.GetTopBlock(worldIn,pos2);
        y3 = (double) RainbowGemsMod.GetTopBlock(worldIn,pos3);

        //cast World to ServerWorld
        ServerWorld world = (ServerWorld) worldIn;

        LightningBoltEntity bolt1 = new LightningBoltEntity(world, x1, y1, z1, false);
        LightningBoltEntity bolt2 = new LightningBoltEntity(world, x2, y2, z2, false);
        LightningBoltEntity bolt3 = new LightningBoltEntity(world, x3, y3, z3, false);

        world.addLightningBolt(bolt1);
        world.addLightningBolt(bolt2);
        world.addLightningBolt(bolt3);

        playerIn.swing(handIn, true);
        playerIn.getHeldItem(handIn).damageItem(10, playerIn, (entity) -> {entity.sendBreakAnimation(handIn);;});

        return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));

    }
}

