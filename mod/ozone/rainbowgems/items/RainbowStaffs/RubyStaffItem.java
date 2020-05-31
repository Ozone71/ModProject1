package mod.ozone.rainbowgems.items.RainbowStaffs;

import mod.ozone.rainbowgems.RainbowGemsMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class RubyStaffItem extends SwordItem {

    public RubyStaffItem() {
        super(StaffUtil.StaffItemTier.StaffTier,0,2.0f,new Item.Properties().group(RainbowGemsMod.TAB));
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        Vec3d aim = playerIn.getLookVec();;
        FireballEntity fireball1 = new FireballEntity(worldIn, playerIn, 1,1,1);
        FireballEntity fireball2 = new FireballEntity(worldIn, playerIn, 1,1,1);
        FireballEntity fireball3 = new FireballEntity(worldIn, playerIn, 1,1,1);

        //add extra 1.5 to y axis to come from eyes, not feet
        fireball1.setPosition(playerIn.getPosX()+aim.x * 1.5d,playerIn.getPosY()+ aim.y * 1.5d + 1.5d,playerIn.getPosZ()+aim.z * 1.5d);
        fireball2.setPosition(playerIn.getPosX()+aim.x * 1.5d + aim.z * 1.25d,playerIn.getPosY()+ aim.y * 1.5d + 1.5d,playerIn.getPosZ()+aim.z * 1.5d - aim.x * 1.25d);
        fireball3.setPosition(playerIn.getPosX()+aim.x * 1.5d - aim.z * 1.25d,playerIn.getPosY()+ aim.y * 1.5d + 1.5d,playerIn.getPosZ()+aim.z * 1.5d + aim.x * 1.25d);
        fireball1.accelerationX = aim.x * 0.5;
        fireball1.accelerationY = aim.y * 0.5;
        fireball1.accelerationZ = aim.z * 0.5;

        fireball2.accelerationX = aim.x * 0.5 + aim.z * 0.05;
        fireball2.accelerationY = aim.y * 0.5;
        fireball2.accelerationZ = aim.z * 0.5 - aim.x * 0.05;;

        fireball3.accelerationX = aim.x * 0.5 - aim.z * 0.05;
        fireball3.accelerationY = aim.y * 0.5;
        fireball3.accelerationZ = aim.z * 0.5 + aim.x * 0.05;;

        worldIn.addEntity(fireball1);
        worldIn.addEntity(fireball2);
        worldIn.addEntity(fireball3);


        //worldIn.createExplosion(null, playerIn.getPosX() + 10.0*v.x, playerIn.getPosY() + 10.0*v.y +1.5, playerIn.getPosZ() + 10.0 * v.z,4.0f,true, Explosion.Mode.DESTROY);

        playerIn.swing(handIn,true);
        playerIn.getHeldItem(handIn).damageItem(10, playerIn, (entity) -> {entity.sendBreakAnimation(handIn);;});


        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}

