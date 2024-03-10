package com.aylanj123.fungalovergrowth.event;

import com.aylanj123.fungalovergrowth.FungalOvergrowthMod;
import com.aylanj123.fungalovergrowth.Config;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ServerEventHandler {

    public static class ServerForgeEvents {

        @SubscribeEvent
        static void serverSetUp(ServerStartingEvent event) {
            FungalOvergrowthMod.LOGGER.info("Setting up the server");
            Config.serverSidedLoad();
        }

    }


}