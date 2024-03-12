package com.aylanj123.fungalovergrowth.datagen;

import com.aylanj123.fungalovergrowth.FungalOvergrowthMod;
import com.aylanj123.fungalovergrowth.LangKeys;
import com.aylanj123.fungalovergrowth.registry.SoundRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class SoundsDefinitions extends SoundDefinitionsProvider {

    public SoundsDefinitions(PackOutput output, ExistingFileHelper helper) {
        super(output, FungalOvergrowthMod.MODID, helper);
    }

    @Override
    public void registerSounds() {
        add(SoundRegistry.INFECTED_CONVERT_NAME, LangKeys.INFECTED_CONVERT);
        add(SoundRegistry.DEATH_NAME, LangKeys.DEATH);
        add(SoundRegistry.HURT_NAME, LangKeys.HURT, 2);
        add(SoundRegistry.SAY_NAME, LangKeys.SAY, 2);
    }

    private void add(String name, LangKeys key) {
        add(
            location(name),
            definition().
                subtitle(key.key())
                .with(sound(location(name)))
        );
    }

    private void add(String name, LangKeys key, int count) {
        SoundDefinition definition = definition().subtitle(key.key());
        for (int i = 1; i <= count; i++)
            definition.with(sound(location(name + i)));
        add(location(name), definition);
    }

    private ResourceLocation location(String name) {
        return new ResourceLocation(FungalOvergrowthMod.MODID, name);
    }

}
