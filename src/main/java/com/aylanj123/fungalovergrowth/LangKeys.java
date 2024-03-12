package com.aylanj123.fungalovergrowth;

import com.aylanj123.fungalovergrowth.classes.effect.FungalInfection;
import com.aylanj123.fungalovergrowth.classes.entity.InfectedZombie;
import com.aylanj123.fungalovergrowth.registry.SoundRegistry;

import static com.aylanj123.fungalovergrowth.registry.ItemRegistry.EGG_FORMAT;

public enum LangKeys {

    INFECTED_ZOMBIE(Prefix.ENTITY, InfectedZombie.ID),

    INFECTED_ZOMBIE_EGG(Prefix.ITEM, String.format(EGG_FORMAT, InfectedZombie.ID)),

    FUNGAL_INFECTION(Prefix.EFFECT, FungalInfection.ID),

    INFECTED_CONVERT(Prefix.SOUNDS, SoundRegistry.INFECTED_CONVERT_NAME),
    DEATH(Prefix.SOUNDS, SoundRegistry.DEATH_NAME),
    HURT(Prefix.SOUNDS, SoundRegistry.HURT_NAME),
    SAY(Prefix.SOUNDS, SoundRegistry.SAY_NAME);

    private final String key;

    LangKeys(String key) {
        this.key = String.format("%s.%s", FungalOvergrowthMod.MODID, key);
    }

    LangKeys(Prefix prefix, String key) {
        this.key = String.format("%s.%s.%s", prefix, FungalOvergrowthMod.MODID, key);
    }

    public String key() {
        return key;
    }

    @Override
    public String toString() {
        return key;
    }

    private enum Prefix {
        ENTITY("entity"),
        ITEM("item"),
        EFFECT("effect"),
        SOUNDS("sounds");

        private final String key;

        Prefix(String key) {
            this.key = key;
        }

        public String key() {
            return key;
        }

        @Override
        public String toString() {
            return key;
        }
    }

}