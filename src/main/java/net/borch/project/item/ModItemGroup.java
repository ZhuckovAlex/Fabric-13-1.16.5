package net.borch.project.item;

import net.borch.project.ProjectMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup SUN = FabricItemGroupBuilder.build(new Identifier(ProjectMod.MOD_ID, "sun"),
            () -> new ItemStack(ModItems.SUN));
}
