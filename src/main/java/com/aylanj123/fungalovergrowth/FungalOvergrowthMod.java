package com.aylanj123.fungalovergrowth;

import com.aylanj123.fungalovergrowth.eventhandler.*;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;

@Mod(FungalOvergrowthMod.MODID)
public class FungalOvergrowthMod
{
    public static final String MODID = "fungal_overgrowth";
    public static final Logger LOGGER = LogUtils.getLogger();

    public FungalOvergrowthMod()
    {
        MinecraftForge.EVENT_BUS.register(ServerEventHandler.ServerForgeEvents.class);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_SPEC, MODID + "-server.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_SPEC, MODID + "-client.toml");
    }

}
