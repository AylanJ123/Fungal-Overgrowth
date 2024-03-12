package com.aylanj123.fungalovergrowth.registry;

import com.aylanj123.fungalovergrowth.FungalOvergrowthMod;
import com.aylanj123.fungalovergrowth.classes.effect.FungalInfection;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EffectRegistry {

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, FungalOvergrowthMod.MODID);

    public static final RegistryObject<MobEffect> FUNGAL_INFECTION = EFFECTS.register(
            FungalInfection.ID, () -> new FungalInfection(MobEffectCategory.HARMFUL)
    );

}
