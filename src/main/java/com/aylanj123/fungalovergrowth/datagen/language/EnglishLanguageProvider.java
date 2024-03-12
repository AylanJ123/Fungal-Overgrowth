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
        add(LangKeys.INFECTED_ZOMBIE.key(), "Infected Zombie");
        add(LangKeys.FUNGAL_INFECTION.key(), "Fungal Infection");
        add(LangKeys.INFECTED_CONVERT.key(), "Infection converts zombie");
        add(LangKeys.DEATH.key(), "Infected Zombie dies");
        add(LangKeys.HURT.key(), "Infected Zombie hurts");
        add(LangKeys.SAY.key(), "Infected Zombie groans");
    }
}
