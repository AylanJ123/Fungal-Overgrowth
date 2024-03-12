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
        add(LangKeys.INFECTED_ZOMBIE.key(), "Zombi Infectado");
        add(LangKeys.FUNGAL_INFECTION.key(), "Infección Fúngica");
        add(LangKeys.INFECTED_CONVERT.key(), "Infección convierte zombi");
        add(LangKeys.DEATH.key(), "Zombi Infectado muerto");
        add(LangKeys.HURT.key(), "Zombi Infectado herido");
        add(LangKeys.SAY.key(), "Gruñido de Zombi Infectado");
    }
}
