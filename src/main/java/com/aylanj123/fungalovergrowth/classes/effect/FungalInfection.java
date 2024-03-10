package com.aylanj123.fungalovergrowth.classes.effect;

import com.aylanj123.fungalovergrowth.FungalOvergrowthMod;
import com.aylanj123.fungalovergrowth.classes.entity.InfectedZombie;
import com.aylanj123.fungalovergrowth.helper.ColorHelper;
import com.aylanj123.fungalovergrowth.registry.EntityRegistry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;
import org.jetbrains.annotations.Nullable;

public class FungalInfection extends MobEffect {

    public FungalInfection(MobEffectCategory pCategory) {
        super(pCategory, ColorHelper.colorFromRGB(228,179,155));
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity instanceof Zombie oldZombie) {
            InfectedZombie zombie = oldZombie.convertTo(EntityRegistry.INFECTED_ZOMBIE.get(), true);
            if (zombie != null) zombie.convertBypass();
        }
        else
            pLivingEntity.hurt(
                pLivingEntity.damageSources().indirectMagic(pLivingEntity, pLivingEntity),
                Math.min(pLivingEntity.getHealth() - 1, pLivingEntity.getHealth() * ((1f / 3f) * (pAmplifier + 1)))
        );
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity pSource, @Nullable Entity pIndirectSource, LivingEntity pLivingEntity, int pAmplifier, double pHealth) {
        FungalOvergrowthMod.LOGGER.info("LOOOOL");
        super.applyInstantenousEffect(pSource, pIndirectSource, pLivingEntity, pAmplifier, pHealth);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return pDuration == 1;
    }

}
