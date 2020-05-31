package mod.ozone.rainbowgems.items.RainbowStaffs;

import mod.ozone.rainbowgems.RainbowGemsMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;


public class SapphireStaffItem extends SwordItem {

    public SapphireStaffItem() {
        super(StaffUtil.StaffItemTier.StaffTier,0,2.0f,new Properties().group(RainbowGemsMod.TAB));
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        AxisAlignedBB bBox = new AxisAlignedBB(playerIn.getPosX()-10.0f,playerIn.getPosY()-2.0f,playerIn.getPosZ()-10.0f,
                playerIn.getPosX()+10.0f,playerIn.getPosY()+2.0f,playerIn.getPosZ()+10.0f);

        List<Entity> entityList = worldIn.getEntitiesInAABBexcluding(playerIn.getEntity(), bBox,null);

        double vx;
        double vy;
        double vz;
        double dx;
        double dy;
        double dz;
        double h;

        for (Entity value : entityList) {
            dx = value.getPosX()-playerIn.getPosX();
            dz = value.getPosZ()-playerIn.getPosZ();
            h = dx*dx+dz*dz;
            if (h==0) {
                vx = 0.0d;
                vy = 3.0d;
                vz = 0.00;
            }else{
                vx = 2.0d*dx/Math.sqrt(h);
                vy = 1.0d;
                vz = 2.0d*dz/Math.sqrt(h);
            }
            value.setMotion(vx,vy,vz);
        }

        playerIn.swing(handIn,true);
        playerIn.getHeldItem(handIn).damageItem(10, playerIn, (entity) -> {entity.sendBreakAnimation(handIn);;});


        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}

