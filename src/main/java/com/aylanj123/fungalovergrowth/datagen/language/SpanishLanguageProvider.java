package com.aylanj123.fungalovergrowth.datagen.language;

import com.aylanj123.fungalovergrowth.FungalOvergrowthMod;
import com.aylanj123.fungalovergrowth.LangKeys;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class SpanishLanguageProvider extends LanguageProvider {

    public SpanishLanguageProvider(PackOutput output, String locale) {
        super(output, FungalOvergrowthMod.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        //Entities
        add(LangKeys.INFECTED_ZOMBIE.key(), "Zombi Infectado");

        //Items
        add(LangKeys.INFECTED_ZOMBIE_EGG.key(), "Huevo de zombi infectado");

        //Effects
        add(LangKeys.FUNGAL_INFECTION.key(), "Infección Fúngica");

        //Sounds
        add(LangKeys.INFECTED_CONVERT.key(), "Infección convierte zombi");
        add(LangKeys.DEATH.key(), "Zombi infectado muerto");
        add(LangKeys.HURT.key(), "Zombi infectado herido");
        add(LangKeys.SAY.key(), "Gruñido de zombi infectado");
    }
}
