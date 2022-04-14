package net.borch.project.world.features;

import net.borch.project.ProjectMod;
import net.borch.project.block.ModBlocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.UniformIntDistribution;

import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ModConfiguredFeatures
{
    public static final RegistryKey<ConfiguredFeature<?, ?>> REDWOOD_TREE_KEY = registerKey("redwood_spawn");

    public static final ConfiguredFeature<TreeFeatureConfig, ?> REDWOOD_TREE = register("redwood",
            Feature.TREE.configure((
                    new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(ModBlocks.LOG_REDWOOD_TREE.getDefaultState()),
                    new SimpleBlockStateProvider(ModBlocks.REDWOOD_LEAVES.getDefaultState()),
                    new SpruceFoliagePlacer(UniformIntDistribution.of(2, 1), UniformIntDistribution.of(0, 2), UniformIntDistribution.of(1, 1)),
                    new StraightTrunkPlacer(5, 2, 1),
                    new TwoLayersFeatureSize(2, 0, 2))).ignoreVines().build()));

    public static final ConfiguredFeature<?, ?> REDWOOD_TREE_SPAWN = register(REDWOOD_TREE
            .decorate(Decorator.HEIGHTMAP.configure(DecoratorConfig.DEFAULT)
                    .spreadHorizontally().applyChance(3)), REDWOOD_TREE_KEY);

    private static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier(ProjectMod.MOD_ID, name));
    }

    private static ConfiguredFeature<TreeFeatureConfig, ?> register(String name,
                                                                    ConfiguredFeature<TreeFeatureConfig, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(ProjectMod.MOD_ID, name),
                configuredFeature);
    }

    private static ConfiguredFeature<?, ?> register(ConfiguredFeature<?, ?> configuredFeature,
                                                    RegistryKey<ConfiguredFeature<?, ?>> key) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key.getValue(), configuredFeature);
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + ProjectMod.MOD_ID);
    }
}