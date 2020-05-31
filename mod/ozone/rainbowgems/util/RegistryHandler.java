package mod.ozone.rainbowgems.util;

import mod.ozone.rainbowgems.RainbowGemsMod;
import mod.ozone.rainbowgems.blocks.*;
import mod.ozone.rainbowgems.entities.BeamEntity;
import mod.ozone.rainbowgems.items.EnergySlice;
import mod.ozone.rainbowgems.items.ItemBase;
import mod.ozone.rainbowgems.items.RainbowStaffs.*;
import mod.ozone.rainbowgems.blocks.*;
import mod.ozone.rainbowgems.items.RainbowStaffs.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    //declare all your items, blocks and entities

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, RainbowGemsMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, RainbowGemsMod.MOD_ID);
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, RainbowGemsMod.MOD_ID);


    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }


    // My Items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
    public static final RegistryObject<Item> GARNET = ITEMS.register("garnet", ItemBase::new);
    public static final RegistryObject<Item> CITRINE = ITEMS.register("citrine", ItemBase::new);
    public static final RegistryObject<Item> JADE = ITEMS.register("jade", ItemBase::new);
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz", ItemBase::new);
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", ItemBase::new);
    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst", ItemBase::new);

    // My Blocks
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
    public static final RegistryObject<Block> GARNET_BLOCK = BLOCKS.register("garnet_block", GarnetBlock::new);
    public static final RegistryObject<Block> CITRINE_BLOCK = BLOCKS.register("citrine_block", CitrineBlock::new);
    public static final RegistryObject<Block> JADE_BLOCK = BLOCKS.register("jade_block", CitrineBlock::new);
    public static final RegistryObject<Block> TOPAZ_BLOCK = BLOCKS.register("topaz_block", CitrineBlock::new);
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block", SapphireBlock::new);
    public static final RegistryObject<Block> AMETHYST_BLOCK = BLOCKS.register("amethyst_block", AmethystBlock::new);

    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", RubyOre::new);
    public static final RegistryObject<Block> GARNET_ORE = BLOCKS.register("garnet_ore", GarnetOre::new);
    public static final RegistryObject<Block> CITRINE_ORE = BLOCKS.register("citrine_ore", CitrineOre::new);
    public static final RegistryObject<Block> JADE_ORE = BLOCKS.register("jade_ore", CitrineOre::new);
    public static final RegistryObject<Block> TOPAZ_ORE = BLOCKS.register("topaz_ore", CitrineOre::new);
    public static final RegistryObject<Block> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore", SapphireOre::new);
    public static final RegistryObject<Block> AMETHYST_ORE = BLOCKS.register("amethyst_ore", AmethystOre::new);

    // Block Items
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", () -> new BlockItemBase(RUBY_BLOCK.get()));
    public static final RegistryObject<Item> GARNET_BLOCK_ITEM = ITEMS.register("garnet_block", () -> new BlockItemBase(GARNET_BLOCK.get()));
    public static final RegistryObject<Item> CITRINE_BLOCK_ITEM = ITEMS.register("citrine_block", () -> new BlockItemBase(CITRINE_BLOCK.get()));
    public static final RegistryObject<Item> JADE_BLOCK_ITEM = ITEMS.register("jade_block", () -> new BlockItemBase(JADE_BLOCK.get()));
    public static final RegistryObject<Item> TOPAZ_BLOCK_ITEM = ITEMS.register("topaz_block", () -> new BlockItemBase(TOPAZ_BLOCK.get()));
    public static final RegistryObject<Item> SAPPHIRE_BLOCK_ITEM = ITEMS.register("sapphire_block", () -> new BlockItemBase(SAPPHIRE_BLOCK.get()));
    public static final RegistryObject<Item> AMETHYST_BLOCK_ITEM = ITEMS.register("amethyst_block", () -> new BlockItemBase(AMETHYST_BLOCK.get()));

    public static final RegistryObject<Item> RUBY_ORE_ITEM = ITEMS.register("ruby_ore", () -> new BlockItemBase(RUBY_ORE.get()));
    public static final RegistryObject<Item> GARNET_ORE_ITEM = ITEMS.register("garnet_ore", () -> new BlockItemBase(GARNET_ORE.get()));
    public static final RegistryObject<Item> CITRINE_ORE_ITEM = ITEMS.register("citrine_ore", () -> new BlockItemBase(CITRINE_ORE.get()));
    public static final RegistryObject<Item> JADE_ORE_ITEM = ITEMS.register("jade_ore", () -> new BlockItemBase(JADE_ORE.get()));
    public static final RegistryObject<Item> TOPAZ_ORE_ITEM = ITEMS.register("topaz_ore", () -> new BlockItemBase(TOPAZ_ORE.get()));
    public static final RegistryObject<Item> SAPPHIRE_ORE_ITEM = ITEMS.register("sapphire_ore", () -> new BlockItemBase(SAPPHIRE_ORE.get()));
    public static final RegistryObject<Item> AMETHYST_ORE_ITEM = ITEMS.register("amethyst_ore", () -> new BlockItemBase(AMETHYST_ORE.get()));

    //Special Items
    public static final RegistryObject<Item> ENERGYSLICE = ITEMS.register("energy_slice", EnergySlice::new);
    public static final RegistryObject<Item> RUBYSTAFF = ITEMS.register("ruby_staff", RubyStaffItem::new);
    public static final RegistryObject<Item> GARNETSTAFF = ITEMS.register("garnet_staff", GarnetStaffItem::new);
    public static final RegistryObject<Item> CITRINESTAFF = ITEMS.register("citrine_staff", CitrineStaffItem::new);
    public static final RegistryObject<Item> JADESTAFF = ITEMS.register("jade_staff", JadeStaffItem::new);
    public static final RegistryObject<Item> TOPAZSTAFF = ITEMS.register("topaz_staff", TopazStaffItem::new);
    public static final RegistryObject<Item> SAPPHIRESTAFF = ITEMS.register("sapphire_staff", SapphireStaffItem::new);
    public static final RegistryObject<Item> AMETHYSTSTAFF = ITEMS.register("amethyst_staff", AmethystStaffItem::new);

    //Special Blocks
    public static final RegistryObject<Block> BEAM_ON_BLOCK = BLOCKS.register("beam_on_block", BeamOnBlock::new);
    public static final RegistryObject<Item> BEAM_ON_BLOCK_ITEM = ITEMS.register("beam_on_block", () -> new BlockItemBase(BEAM_ON_BLOCK.get()));
    public static final RegistryObject<Block> BEAM_OFF_BLOCK = BLOCKS.register("beam_off_block", BeamOffBlock::new);
    public static final RegistryObject<Item> BEAM_OFF_BLOCK_ITEM = ITEMS.register("beam_off_block", () -> new BlockItemBase(BEAM_OFF_BLOCK.get()));

    // My Tile Entities
    public static final RegistryObject<TileEntityType<BeamEntity>> BEAM_ENTITY = TILE_ENTITIES.register("beam_station",
            () -> TileEntityType.Builder.create(BeamEntity::new, BEAM_ON_BLOCK.get(), BEAM_OFF_BLOCK.get()).build(null));




}
