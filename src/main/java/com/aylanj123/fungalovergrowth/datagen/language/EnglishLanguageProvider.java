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
//        add(LangKeys.COMMAND_ANSWER_ENTER.key(), "You are now AFK");
    }
}
