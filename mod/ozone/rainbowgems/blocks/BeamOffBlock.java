package mod.ozone.rainbowgems.blocks;

import mod.ozone.rainbowgems.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class BeamOffBlock extends Block {

    public BeamOffBlock() {
        super(Properties.create(Material.PORTAL)
                .hardnessAndResistance(50.0f,1200.0f)
                .sound(SoundType.STONE)
                .harvestLevel(3) //Diamond
                .harvestTool(ToolType.PICKAXE)
                .lightValue(0));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return RegistryHandler.BEAM_ENTITY.get().create();
    }

}
