package mod.ozone.rainbowgems.entities;
import mod.ozone.rainbowgems.blocks.BeamOffBlock;
import mod.ozone.rainbowgems.blocks.BeamOnBlock;
import mod.ozone.rainbowgems.util.RegistryHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BeamEntity extends TileEntity implements ITickableTileEntity {

    public int beam_x,beam_y,beam_z,tick;
    public int charge;
    boolean initialized = false;

    public BeamEntity(final TileEntityType<?> tileEntityTypeIn){
        super(tileEntityTypeIn);
    }

    public BeamEntity() {
        this(RegistryHandler.BEAM_ENTITY.get());
    }

    public void init() {
        if (initialized) return;
        initialized = true;
        tick = 0;
        beam_x=-684;
        beam_y=84;
        beam_z=95;
        if (this.getBlockState().getBlock() instanceof BeamOnBlock) {
            charge = 5;
        } else{
            charge = 0;
        }
        markDirty();
    }

    @Override
    public void tick() {
        if (world.getBlockState(pos).getBlock() != this.getBlockState().getBlock()) return;
        if (!initialized) init();
        tick++;
        if (tick >= 20) {
            tick = 0;
            charge++;
            if (charge >= 5) {
                charge = 5;
                if (!world.isRemote && (world.getBlockState(pos).getBlock() instanceof BeamOffBlock)) {
                    BeamOnBlock putready = new BeamOnBlock();
                    world.destroyBlock(pos, false);
                    world.removeTileEntity(pos);
                    world.setBlockState(pos, putready.getDefaultState());
                }
            }
            world.notifyBlockUpdate(pos, getBlockState(), getBlockState(), 3);
            markDirty();
            //DEBUG***
            if (world.isRemote) {
                System.out.printf("Server %d %d %d = %d\n", beam_x, beam_y, beam_z, charge);
            } else{
                System.out.printf("Render %d %d %d = %d\n", beam_x, beam_y, beam_z, charge);
            }
            //DEBUG***
        }
    }

    public void Beam(World worldIn, BlockPos pos, Entity entityIn) {
        if ((!(entityIn instanceof LivingEntity)) || (charge < 5)) return;

        if ((worldIn.isRemote) && (entityIn instanceof PlayerEntity) ||
            (!worldIn.isRemote) && !(entityIn instanceof PlayerEntity))  {
            //Teleport Entity
            BlockPos beamTo = new BlockPos(beam_x, beam_y, beam_z);
            LivingEntity traveller = (LivingEntity) entityIn;
            traveller.moveToBlockPosAndAngles(beamTo, traveller.rotationYaw, traveller.rotationPitch);
        }
        charge = 0;
        //eventually swap back to BeamOffBlock here

        if (worldIn.isRemote) {
            System.out.printf("Server %d %d %d = %d\n", beam_x, beam_y, beam_z, charge);  //DEBUG***
            world.notifyBlockUpdate(pos, getBlockState(), getBlockState(), 2);
        } else{
            System.out.printf("Render %d %d %d = %d\n", beam_x, beam_y, beam_z, charge);  //DEBUG***
        }
        markDirty();
    }

    @Override
    public void read(CompoundNBT tag) {
        super.read(tag);
        initialized = tag.getBoolean("init");
        beam_x = tag.getInt("beam_x");
        beam_y = tag.getInt("beam_y");
        beam_z = tag.getInt("beam_z");
        charge = tag.getInt("charge");
    }

    @Override
    public CompoundNBT write(CompoundNBT tag) {
        tag = super.write(tag);
        tag.putBoolean("init", initialized);
        tag.putInt("beam_x", beam_x);
        tag.putInt("beam_y", beam_y);
        tag.putInt("beam_z", beam_z);
        tag.putInt("charge", charge);
        return tag;
    }

    @Override
    public CompoundNBT getUpdateTag() {
        return this.write(new CompoundNBT());
    }

    @Override
    public SUpdateTileEntityPacket getUpdatePacket(){
        return new SUpdateTileEntityPacket(this.pos, 3, this.getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt){
        read(pkt.getNbtCompound());
    }

}
