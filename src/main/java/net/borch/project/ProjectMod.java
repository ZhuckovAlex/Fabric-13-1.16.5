package net.borch.project;

import net.borch.project.block.ModBlocks;
import net.borch.project.item.ModItems;
import net.borch.project.registries.ModRegistries;
import net.borch.project.util.ModRenderHelper;
import net.borch.project.world.features.ModConfiguredFeatures;
import net.borch.project.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;

public class ProjectMod implements ModInitializer {
	public static final String MOD_ID = "fabric_project";
	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModRegistries.registerModFuels();
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModRenderHelper.setRenderLayers();
		ModWorldGen.generateModWorldGen();
		System.out.println("Hello Fabric world!");
	}
}
