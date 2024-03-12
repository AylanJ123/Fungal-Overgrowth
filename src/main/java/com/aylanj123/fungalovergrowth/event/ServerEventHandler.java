package com.aylanj123.fungalovergrowth.event;

import com.aylanj123.fungalovergrowth.FungalOvergrowthMod;
import com.aylanj123.fungalovergrowth.Config;
import com.aylanj123.fungalovergrowth.classes.entity.InfectedZombie;
import com.aylanj123.fungalovergrowth.helper.ConversionHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;

public class ServerEventHandler {

    public static class ServerForgeEvents {

        @SubscribeEvent
        static void serverSetUp(ServerStartingEvent event) {
            FungalOvergrowthMod.LOGGER.info("Setting up the server");
            Config.serverSidedLoad();
        }

        @SubscribeEvent
        static void mobSpawned(EntityJoinLevelEvent event) {
            Entity entity = event.getEntity();
            if (entity instanceof Zombie && !(entity instanceof InfectedZombie))
                if ((new Random()).nextFloat() < Config.infectedReplaceChance)
                    ConversionHelper.convert((LivingEntity) entity);
        }

    }


}