package com.aylanj123.fungalovergrowth.eventhandler;
import com.aylanj123.fungalovergrowth.FungalOvergrowthMod;
import com.aylanj123.fungalovergrowth.Config;
import net.minecraftforge.api.distmarker.Dist;
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

    }

}
