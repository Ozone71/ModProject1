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


public class TopazStaffItem extends SwordItem {

    public TopazStaffItem() {
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

        //Null entityIn to include PLayer
        List<Entity> entityList = worldIn.getEntitiesInAABBexcluding(null, bBox,null);

        for (Entity value : entityList) {
            if (value instanceof PlayerEntity){
                LivingEntity target = (LivingEntity) value;
                EffectInstance boosthealth = new EffectInstance(Effects.HEALTH_BOOST, 600,2);
                EffectInstance boosthealing = new EffectInstance(Effects.REGENERATION, 600,1);
                EffectInstance boostarms = new EffectInstance(Effects.STRENGTH, 600,1);
                EffectInstance boostlegs = new EffectInstance(Effects.SPEED, 600,1);
                EffectInstance healNow = new EffectInstance(Effects.INSTANT_HEALTH, 10,1);
                target.addPotionEffect(boosthealth);
                target.addPotionEffect(boosthealing);
                target.addPotionEffect(boostarms);
                target.addPotionEffect(boostlegs);
                target.addPotionEffect(healNow);
            }
        }


        playerIn.swing(handIn,true);
        playerIn.getHeldItem(handIn).damageItem(10, playerIn, (entity) -> {entity.sendBreakAnimation(handIn);;});


        return super.onItemRightClick(worldIn, playerIn, handIn);    }
}

