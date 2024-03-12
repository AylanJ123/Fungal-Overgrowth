package com.aylanj123.fungalovergrowth.event;
import com.aylanj123.fungalovergrowth.FungalOvergrowthMod;
import com.aylanj123.fungalovergrowth.Config;
import com.aylanj123.fungalovergrowth.classes.entity.InfectedZombie;
import com.aylanj123.fungalovergrowth.client.model.InfectedZombieModel;
import com.aylanj123.fungalovergrowth.client.renderer.InfectedZombieRenderer;
import com.aylanj123.fungalovergrowth.registry.EntityRegistry;
import com.aylanj123.fungalovergrowth.registry.ItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientEventHandler {

    @Mod.EventBusSubscriber(modid = FungalOvergrowthMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        static void clientSetUp(FMLClientSetupEvent event) {
            FungalOvergrowthMod.LOGGER.info("Setting up the client");
            Config.clientSidedLoad();
        }

        @SubscribeEvent
        static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(EntityRegistry.INFECTED_ZOMBIE.get(), InfectedZombieRenderer::new);
        }

        @SubscribeEvent
        static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(InfectedZombieModel.LAYER_LOCATION, InfectedZombieModel::createBodyLayer);
        }

        @SubscribeEvent
        public static void addCreative(BuildCreativeModeTabContentsEvent event)
        {
            if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
                event.accept(ItemRegistry.INFECTED_ZOMBIE_EGG, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }

    }

}
