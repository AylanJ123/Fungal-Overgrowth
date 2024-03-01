package com.aylanj123.fungalovergrowth.networking;

import com.aylanj123.fungalovergrowth.FungalOvergrowthMod;
import com.aylanj123.fungalovergrowth.networking.packets.NameHereS2CPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry.ChannelBuilder;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class PacketHandler {

    private static final SimpleChannel INSTANCE = ChannelBuilder.named(
            new ResourceLocation(FungalOvergrowthMod.MODID, "main")
        ).serverAcceptedVersions((status) -> true)
        .clientAcceptedVersions((status) -> true)
        .networkProtocolVersion(() -> "1")
        .simpleChannel();

    public static void register() {
//        INSTANCE.messageBuilder(
//            MovedC2SPacket.class, 1, NetworkDirection.PLAY_TO_SERVER
//                ).encoder(MovedC2SPacket::encode)
//                .decoder(MovedC2SPacket::new)
//                .consumerMainThread(MovedC2SPacket::handle)
//                .add();
    }

    public static void sendServer(Object msg) {
        INSTANCE.send(PacketDistributor.SERVER.noArg(), msg);
    }

    public static void sendPlayer(Object msg, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), msg);
    }

}
