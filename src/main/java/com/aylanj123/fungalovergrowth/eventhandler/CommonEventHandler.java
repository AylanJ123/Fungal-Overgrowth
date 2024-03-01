package com.aylanj123.fungalovergrowth.eventhandler;
import com.aylanj123.fungalovergrowth.FungalOvergrowthMod;
import com.aylanj123.fungalovergrowth.datagen.language.*;
import com.aylanj123.fungalovergrowth.networking.PacketHandler;
import net.minecraft.data.DataProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.ArrayList;
import java.util.List;

public class CommonEventHandler {

    @Mod.EventBusSubscriber(modid = FungalOvergrowthMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class CommonModEvents {

        private static final List<String> englishLocales = new ArrayList<>(List.of(
                "en_us", "en_nz", "en_gb", "en_ca", "en_au"
        ));

        private static final List<String> spanishLocales = new ArrayList<>(List.of(
                "es_ve", "es_uy", "es_mx", "es_es", "es_ec", "es_cl", "es_ar"
        ));

        private static final List<String> germanLocales = new ArrayList<>(List.of(
                "de_de", "de_at", "de_ch", "nds_de"
        ));

        private static final List<String> portugueseLocales = new ArrayList<>(List.of(
                "pt_pt", "pt_br"
        ));

        @SubscribeEvent
        static void gatherData(GatherDataEvent event) {
            FungalOvergrowthMod.LOGGER.info("Generating new data");
            for (String locale : englishLocales)
                event.getGenerator().addProvider(
                        event.includeClient(),
                        (DataProvider.Factory<EnglishLanguageProvider>)
                                output -> new EnglishLanguageProvider(output, locale)
                );
            for (String locale : spanishLocales)
                event.getGenerator().addProvider(
                        event.includeClient(),
                        (DataProvider.Factory<SpanishLanguageProvider>)
                                output -> new SpanishLanguageProvider(output, locale)
                );
            for (String locale : germanLocales)
                event.getGenerator().addProvider(
                        event.includeClient(),
                        (DataProvider.Factory<GermanLanguageProvider>)
                                output -> new GermanLanguageProvider(output, locale)
                );
            for (String locale : portugueseLocales)
                event.getGenerator().addProvider(
                        event.includeClient(),
                        (DataProvider.Factory<PortugueseLanguageProvider>)
                                output -> new PortugueseLanguageProvider(output, locale)
                );
            event.getGenerator().addProvider(
                    event.includeClient(),
                    (DataProvider.Factory<SwedishLanguageProvider>)
                            output -> new SwedishLanguageProvider(output, "sv_se")
            );
        }

        @SubscribeEvent
        static void commonSetUp(FMLCommonSetupEvent event) {
            FungalOvergrowthMod.LOGGER.info("Common Set Up");
            PacketHandler.register();
        }

    }

}