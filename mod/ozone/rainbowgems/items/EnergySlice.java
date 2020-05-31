package mod.ozone.rainbowgems.items;

import mod.ozone.rainbowgems.RainbowGemsMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class EnergySlice extends Item {

    public EnergySlice() {
        super(new Item.Properties().group(RainbowGemsMod.TAB)
             .food(new Food.Builder()
                .setAlwaysEdible()
                .hunger(20)
                .saturation(20f)
                .effect(() -> new EffectInstance(Effects.SPEED, 1200,2),1f)
                .effect(() -> new EffectInstance(Effects.JUMP_BOOST, 1200,2),1f)
                .effect(() -> new EffectInstance(Effects.NAUSEA, 200,1),0.1f)
                .build()
             )

        );
    }
}
