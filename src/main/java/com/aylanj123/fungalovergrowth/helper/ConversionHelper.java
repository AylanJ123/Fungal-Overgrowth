package com.aylanj123.fungalovergrowth.helper;

import com.aylanj123.fungalovergrowth.classes.entity.InfectedZombie;
import com.aylanj123.fungalovergrowth.registry.EntityRegistry;
import com.aylanj123.fungalovergrowth.registry.SoundRegistry;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;

public class ConversionHelper {

	public static void convert(LivingEntity entity) {
		Zombie oldZombie = (Zombie) entity;
		InfectedZombie zombie = oldZombie.convertTo(EntityRegistry.INFECTED_ZOMBIE.get(), true);
		entity.level().playSound(
			null,
			oldZombie.blockPosition(),
			SoundRegistry.INFECTED_CONVERT.get(),
			SoundSource.HOSTILE,
			1f,
			1f
		);
		if (zombie != null) {
			zombie.convertBypass();
		}
	}

}
