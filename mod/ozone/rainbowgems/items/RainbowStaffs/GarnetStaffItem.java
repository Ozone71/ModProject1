package mod.ozone.rainbowgems.items.RainbowStaffs;

import mod.ozone.rainbowgems.RainbowGemsMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;


public class GarnetStaffItem extends SwordItem {

    public GarnetStaffItem() {
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

        for (Entity value : entityList) {
            if (!(value instanceof PlayerEntity)){
                if (value instanceof LivingEntity){
                    LivingEntity target = (LivingEntity) value;
                    EffectInstance illness = new EffectInstance(Effects.WITHER, 1200,1);
                    EffectInstance vertigo = new EffectInstance(Effects.NAUSEA, 1200,1);
                    EffectInstance wobblyknees = new EffectInstance(Effects.SLOWNESS, 1200,1);
                    target.addPotionEffect(illness);
                    target.addPotionEffect(vertigo);
                    target.addPotionEffect(wobblyknees);
                }
            }
        }


        playerIn.swing(handIn,true);
        playerIn.getHeldItem(handIn).damageItem(10, playerIn, (entity) -> {entity.sendBreakAnimation(handIn);;});


        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}

