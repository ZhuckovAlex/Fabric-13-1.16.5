package net.borch.project.item;

import net.borch.project.ProjectMod;
import net.borch.project.item.custom.SunItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item SUN = registerItem("sun",
            new SunItem(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(5).saturationModifier(4f)
                    .build()).group(ModItemGroup.SUN)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ProjectMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        System.out.println("Registering Mod Items for " + ProjectMod.MOD_ID);
    }
}
