package com.aylanj123.fungalovergrowth.registry;

import com.aylanj123.fungalovergrowth.FungalOvergrowthMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundRegistry {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, FungalOvergrowthMod.MODID);

    public static final String INFECTED_CONVERT_NAME = "infected_convert";
    public static final String DEATH_NAME = "death";
    public static final String HURT_NAME = "hurt";
    public static final String SAY_NAME = "say";

    public static final RegistryObject<SoundEvent> INFECTED_CONVERT = registerEntry(INFECTED_CONVERT_NAME);
    public static final RegistryObject<SoundEvent> DEATH = registerEntry(DEATH_NAME);
    public static final RegistryObject<SoundEvent> HURT = registerEntry(HURT_NAME);
    public static final RegistryObject<SoundEvent> SAY = registerEntry(SAY_NAME);

    private static RegistryObject<SoundEvent> registerEntry(String name) {
        return SOUNDS.register(
                name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(
                        FungalOvergrowthMod.MODID, name
                ))
        );
    }

}
