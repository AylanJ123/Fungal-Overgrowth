package com.aylanj123.fungalovergrowth.registry;

import net.minecraftforge.eventbus.api.IEventBus;

public class Registry {

    public static void register(IEventBus bus) {
        EntityRegistry.ENTITIES.register(bus);
        EffectRegistry.EFFECTS.register(bus);
        SoundRegistry.SOUNDS.register(bus);
    }

}
