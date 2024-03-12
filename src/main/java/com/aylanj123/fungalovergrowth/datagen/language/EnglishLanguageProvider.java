package com.aylanj123.fungalovergrowth.datagen.language;

import com.aylanj123.fungalovergrowth.FungalOvergrowthMod;
import com.aylanj123.fungalovergrowth.LangKeys;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class EnglishLanguageProvider extends LanguageProvider {

    public EnglishLanguageProvider(PackOutput output, String locale) {
        super(output, FungalOvergrowthMod.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        //Entities
        add(LangKeys.INFECTED_ZOMBIE.key(), "Infected Zombie");

        //Items
        add(LangKeys.INFECTED_ZOMBIE_EGG.key(), "Infected Zombie Spawn Egg");

        //Effects
        add(LangKeys.FUNGAL_INFECTION.key(), "Fungal Infection");

        //Sounds
        add(LangKeys.INFECTED_CONVERT.key(), "Infection converts zombie");
        add(LangKeys.DEATH.key(), "Infected Zombie dies");
        add(LangKeys.HURT.key(), "Infected Zombie hurts");
        add(LangKeys.SAY.key(), "Infected Zombie groans");
    }
}
