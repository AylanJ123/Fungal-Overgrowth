package com.aylanj123.fungalovergrowth.event;
import com.aylanj123.fungalovergrowth.FungalOvergrowthMod;
import com.aylanj123.fungalovergrowth.classes.entity.InfectedZombie;
import com.aylanj123.fungalovergrowth.datagen.ItemModels;
import com.aylanj123.fungalovergrowth.datagen.Recipes;
import com.aylanj123.fungalovergrowth.datagen.SoundsDefinitions;
import com.aylanj123.fungalovergrowth.datagen.language.*;
import com.aylanj123.fungalovergrowth.networking.PacketHandler;
import com.aylanj123.fungalovergrowth.registry.EntityRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

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
            DataGenerator gen = event.getGenerator();
            PackOutput output = gen.getPackOutput();
            ExistingFileHelper helper = event.getExistingFileHelper();
            CompletableFuture<HolderLookup.Provider> lookUp = event.getLookupProvider();

            for (String locale : englishLocales) gen.addProvider(event.includeClient(),
                    new EnglishLanguageProvider(output, locale)
                );
            for (String locale : spanishLocales) gen.addProvider(event.includeClient(),
                    new SpanishLanguageProvider(output, locale)
                );
            for (String locale : germanLocales) gen.addProvider(event.includeClient(),
                    new GermanLanguageProvider(output, locale)
                );
            for (String locale : portugueseLocales) gen.addProvider(event.includeClient(),
                    new PortugueseLanguageProvider(output, locale)
                );
            gen.addProvider(event.includeClient(),
                    new SwedishLanguageProvider(output, "sv_se")
            );

            gen.addProvider(event.includeServer(), new Recipes(output));
            gen.addProvider(event.includeServer(), new SoundsDefinitions(output, helper));
            gen.addProvider(event.includeClient(), new ItemModels(output, helper));
        }

        @SubscribeEvent
        static void commonSetUp(FMLCommonSetupEvent event) {
            FungalOvergrowthMod.LOGGER.info("Common Set Up");
            PacketHandler.register();
        }

        @SubscribeEvent
        static void registerAttributes(EntityAttributeCreationEvent event) {
            event.put(EntityRegistry.INFECTED_ZOMBIE.get(), InfectedZombie.createAttributes().build());
        }

    }

}