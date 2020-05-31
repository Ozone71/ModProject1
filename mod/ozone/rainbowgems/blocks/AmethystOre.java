package mod.ozone.rainbowgems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class AmethystOre extends Block {

    public AmethystOre() {
        super(Properties.create(Material.ROCK)
            .hardnessAndResistance(3.0f,3.0f)
            .sound(SoundType.STONE)
            .harvestLevel(2) //Iron
            .harvestTool(ToolType.PICKAXE));
    }
}
