package com.aylanj123.fungalovergrowth;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config
{
    private static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SERVER_SPEC;
    public static final ForgeConfigSpec CLIENT_SPEC;

//    private static final ForgeConfigSpec.ConfigValue<Boolean> INVINCIBLE_PLAYERS;

//    private static final ForgeConfigSpec.ConfigValue<Boolean> CHAT_CONFIRMATION;

    static {
        SERVER_BUILDER.push("Configs for Fungal Overgrowth mod - Server Sided -");
        CLIENT_BUILDER.push("Configs for Fungal Overgrowth mod - Client Sided -");

//        INVINCIBLE_PLAYERS = SERVER_BUILDER
//                .comment("Players should be invincible and untargetable while AFK. If true, players can't go AFK during combat or if monsters are nearby.")
//                .define("invinciblePlayers", false);

//        CHAT_CONFIRMATION = CLIENT_BUILDER
//                .comment("Set to true if you want to receive a chat confirmation of your AFK state when self applied.")
//                .define("chatConfirmation", false);

        SERVER_BUILDER.pop();
        CLIENT_BUILDER.pop();
        SERVER_SPEC = SERVER_BUILDER.build();
        CLIENT_SPEC = CLIENT_BUILDER.build();

    }

    public static boolean invinciblePlayers;

    public static void serverSidedLoad()
    {
//        invinciblePlayers = INVINCIBLE_PLAYERS.get();
    }

    public static void clientSidedLoad() {
//        chatConfirmation = CHAT_CONFIRMATION.get();
    }

}
