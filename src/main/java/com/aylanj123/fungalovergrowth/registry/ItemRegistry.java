package com.aylanj123.fungalovergrowth.registry;

import com.aylanj123.fungalovergrowth.FungalOvergrowthMod;
import com.aylanj123.fungalovergrowth.classes.effect.FungalInfection;
import com.aylanj123.fungalovergrowth.classes.entity.InfectedZombie;
import com.aylanj123.fungalovergrowth.helper.ColorHelper;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {

    public static final String EGG_FORMAT = "%s_spawn_egg";

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FungalOvergrowthMod.MODID);

    public static final RegistryObject<ForgeSpawnEggItem> INFECTED_ZOMBIE_EGG = ITEMS.register(
        String.format(EGG_FORMAT, InfectedZombie.ID),
        () -> new ForgeSpawnEggItem(EntityRegistry.INFECTED_ZOMBIE,
            ColorHelper.colorFromRGB(13, 69, 30),  ColorHelper.colorFromRGB(173, 114, 82),
            new Item.Properties().stacksTo(64)
        )
    );

}
