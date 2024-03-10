package com.aylanj123.fungalovergrowth.classes.entity;

import com.aylanj123.fungalovergrowth.registry.EffectRegistry;
import com.aylanj123.fungalovergrowth.registry.EntityRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class InfectedZombie extends Zombie {

    public static final String ID = "infected_zombie";

    public InfectedZombie(EntityType<InfectedZombie> entityEntityType, Level level) {
        super(entityEntityType, level);
    }

    @Override
    public boolean isBaby() {
        return false;
    }

    @Override
    public void setBaby(boolean pChildZombie) {}

    @Override
    protected void doUnderWaterConversion() {
        if (this.hasEffect(EffectRegistry.FUNGAL_INFECTION.get())) return;
        List<LivingEntity> nearby = this.level().getNearbyEntities(
                LivingEntity.class,
                TargetingConditions
                        .forNonCombat()
                        .range(10)
                        .ignoreLineOfSight()
                        .ignoreInvisibilityTesting()
                        .selector(Entity::isInWater),
                this,
                new AABB(
                        getX() + 5,
                        getY() + 5,
                        getZ() + 5,
                        getX() - 5,
                        getY() - 5,
                        getZ() - 5
                )
        );
        for (LivingEntity entity : nearby)
            applyEffect(entity);
        this.kill();
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        boolean flag = super.doHurtTarget(pEntity);
        if (flag) {
            applyEffect((LivingEntity) pEntity);
        }
        return flag;
    }

    public void applyEffect(LivingEntity entity) {
        boolean isZombie = entity instanceof Zombie;
        int duration = Integer.MAX_VALUE;
        int amplifier = -1;
        MobEffectInstance effectToRemove = null;
        for (MobEffectInstance effect : entity.getActiveEffects()) {
            if (effect.getEffect() != EffectRegistry.FUNGAL_INFECTION.get()) continue;
            duration = effect.getDuration();
            amplifier = effect.getAmplifier();
            effectToRemove = effect;
            break;
        }
        if (effectToRemove != null) entity.getActiveEffects().remove(effectToRemove);
        amplifier = Math.min(2, amplifier + 1);
        duration = Math.min(duration, 20 * (45 * 3 - 45 * amplifier));
        if (isZombie) duration /= 10;
        entity.addEffect(new MobEffectInstance(EffectRegistry.FUNGAL_INFECTION.get(), duration, amplifier));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ZOMBIE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.ZOMBIE_HURT;
    }
    @Override

    protected SoundEvent getDeathSound() {
        return SoundEvents.ZOMBIE_DEATH;
    }

    @Override
    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    public void convertBypass() {
        convertToZombieType(EntityRegistry.INFECTED_ZOMBIE.get());
    }
}
