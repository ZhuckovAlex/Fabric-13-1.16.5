package net.borch.project.block;

import net.borch.project.ProjectMod;
import net.borch.project.block.custom.ModStairsBlock;
import net.borch.project.item.ModItemGroup;
import net.borch.project.block.custom.ModSaplingBlock;
import net.borch.project.world.features.ModConfiguredFeatures;
import net.borch.project.world.features.tree.RedstoneSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block MAGMA = registerBlock("magma",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2.5f)
                    .breakByTool(FabricToolTags.PICKAXES, 0).requiresTool()));

    public static final Block REDWOOD_LEAVES = registerBlock("redstone_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block REDWOOD_SAPLING = registerBlock("redstone_sapling",
            new ModSaplingBlock(new RedstoneSaplingGenerator(),
                    FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static Block LOG_REDWOOD_TREE = registerBlock("log_redstone_tree",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(1.5f)
                    .breakByTool(FabricToolTags.AXES, 0).requiresTool()));

    public static Block WOOD_REDWOOD_TREE = registerBlock("wood_redstone_tree",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(1.5f)
                    .breakByTool(FabricToolTags.AXES, 0).requiresTool()));

    public static final Block MAGMA_STAIRS = registerBlock("magma_stairs",
            new ModStairsBlock(ModBlocks.MAGMA.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(2.5f)
                            .breakByTool(FabricToolTags.PICKAXES, 0).requiresTool()));

    public static final Block MAGMA_SLAB = registerBlock("magma_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(2.5f)
                    .breakByTool(FabricToolTags.PICKAXES, 0).requiresTool()));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(ProjectMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(ProjectMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(ModItemGroup.SUN)));
    }

    public static void registerModBlocks() {
        System.out.println("Registering ModBlocks for " + ProjectMod.MOD_ID);
    }
}