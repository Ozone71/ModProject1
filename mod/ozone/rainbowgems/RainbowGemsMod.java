package mod.ozone.rainbowgems;

import mod.ozone.rainbowgems.util.ModOreGen;
import mod.ozone.rainbowgems.util.RegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("rainbowgems")
public class RainbowGemsMod
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "rainbowgems";

    public RainbowGemsMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        //Init our Items and such
        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        ModOreGen.GenerateOre();
        LOGGER.info("*** RAINBOW ORES GENERATED ***");
    }

    private void doClientStuff(final FMLClientSetupEvent event) { }


    public static final ItemGroup TAB = new ItemGroup("Gems"){
        @Override public ItemStack createIcon(){
            return new ItemStack(RegistryHandler.RUBY.get());
        }
    };

    public static int GetTopBlock(World worldIn, BlockPos posIn){

        int top = worldIn.getMaxHeight();
        BlockPos pos = new BlockPos(posIn.getX(), 0, posIn.getZ());

        while ((top > 0) && (worldIn.getBlockState(pos.add(0,top,0)).getBlock().equals(Blocks.AIR) || worldIn.getBlockState(pos.add(0,top,0)).getBlock().equals(Blocks.VOID_AIR) )){
            top = top - 1;
        }
        return top;
    }
}
