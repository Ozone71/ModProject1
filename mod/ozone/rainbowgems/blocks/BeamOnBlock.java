package mod.ozone.rainbowgems.blocks;

import mod.ozone.rainbowgems.entities.BeamEntity;
import mod.ozone.rainbowgems.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BeamOnBlock extends Block {

    public BeamOnBlock() {
        super(Properties.create(Material.PORTAL)
                .hardnessAndResistance(50.0f,1200.0f)
                .sound(SoundType.STONE)
                .harvestLevel(3) //Diamond
                .harvestTool(ToolType.PICKAXE)
                .lightValue(15));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return RegistryHandler.BEAM_ENTITY.get().create();
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity) {
            if (worldIn.getTileEntity(pos) instanceof BeamEntity) {
                ((BeamEntity) worldIn.getTileEntity(pos)).Beam(worldIn, pos, entityIn);
                }
            }
        }
}
