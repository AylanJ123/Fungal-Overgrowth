package com.aylanj123.fungalovergrowth.registry;

import com.aylanj123.fungalovergrowth.FungalOvergrowthMod;
import com.aylanj123.fungalovergrowth.classes.entity.InfectedZombie;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityRegistry {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FungalOvergrowthMod.MODID);

    public static final RegistryObject<EntityType<InfectedZombie>> INFECTED_ZOMBIE = ENTITIES.register(
            InfectedZombie.ID, () -> EntityType.Builder.of(InfectedZombie::new, MobCategory.CREATURE)
                    .sized(0.6F, 1.95F)
                    .clientTrackingRange(12)
                    .build(new ResourceLocation(FungalOvergrowthMod.MODID, InfectedZombie.ID).toString())
    );

}
