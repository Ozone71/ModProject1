package mod.ozone.rainbowgems.items.RainbowStaffs;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import java.util.function.Supplier;

public class StaffUtil {
    public enum StaffItemTier implements IItemTier {

        StaffTier(4, 250, 2.0f, 0.0f, 250, () -> {
            return null;
        });

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enhchantability;

        private StaffItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enhchantability, Supplier<Ingredient> repairMaterial) {
            this.harvestLevel = 0;
            this.maxUses = 250;
            this.efficiency =2.0f;
            this.attackDamage = 0;
            this.enhchantability = 250;
        };

        @Override
        public int getHarvestLevel() {
            return harvestLevel;
        }

        @Override
        public int getMaxUses() {
            return maxUses;
        }

        @Override
        public float getEfficiency() {
            return efficiency;
        }

        @Override
        public float getAttackDamage() {
            return attackDamage;
        }

        @Override
        public int getEnchantability() {
            return enhchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return null;
        }
    }
}
