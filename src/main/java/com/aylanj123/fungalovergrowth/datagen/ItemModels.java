package com.aylanj123.fungalovergrowth.datagen;

import com.aylanj123.fungalovergrowth.FungalOvergrowthMod;
import com.aylanj123.fungalovergrowth.classes.entity.InfectedZombie;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.aylanj123.fungalovergrowth.registry.ItemRegistry.EGG_FORMAT;

public class ItemModels extends ItemModelProvider {

    public static final String SPAWN_EGG_TEMPLATE = "item/template_spawn_egg";

    public ItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FungalOvergrowthMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(String.format(EGG_FORMAT, InfectedZombie.ID), SPAWN_EGG_TEMPLATE);
//        basicItem(new ResourceLocation(FungalOvergrowthMod.MODID, id));
    }

}
