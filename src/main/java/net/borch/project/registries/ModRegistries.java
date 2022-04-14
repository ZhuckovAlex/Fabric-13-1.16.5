package net.borch.project.registries;

import net.borch.project.ProjectMod;
import net.borch.project.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {

    public static void registerModFuels() {
        System.out.println("Now registering Fuels for " + ProjectMod.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.SUN, 800); // x / 20
    }
}