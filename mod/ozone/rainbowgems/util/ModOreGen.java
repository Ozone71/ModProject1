package mod.ozone.rainbowgems.util;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class ModOreGen {
    public static void GenerateOre() {
        for(Biome biome : ForgeRegistries.BIOMES) {
            ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(5, 5, 5, 70));

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.RUBY_ORE.get().getDefaultState(),4))
                    .withPlacement(customConfig));

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.GARNET_ORE.get().getDefaultState(),4))
                    .withPlacement(customConfig));

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.CITRINE_ORE.get().getDefaultState(),4))
                    .withPlacement(customConfig));

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.JADE_ORE.get().getDefaultState(),4))
                    .withPlacement(customConfig));

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.TOPAZ_ORE.get().getDefaultState(),4))
                    .withPlacement(customConfig));

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.SAPPHIRE_ORE.get().getDefaultState(),4))
                    .withPlacement(customConfig));

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.AMETHYST_ORE.get().getDefaultState(),4))
                    .withPlacement(customConfig));
        }
    }
}
