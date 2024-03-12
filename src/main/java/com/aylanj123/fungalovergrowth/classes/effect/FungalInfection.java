package com.aylanj123.fungalovergrowth.classes.effect;

import com.aylanj123.fungalovergrowth.helper.ColorHelper;
import com.aylanj123.fungalovergrowth.helper.ConversionHelper;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;

public class FungalInfection extends MobEffect {

    public static final String ID = "fungal_infection";

    public FungalInfection(MobEffectCategory pCategory) {
        super(pCategory, ColorHelper.colorFromRGB(228,179,155));
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity instanceof Zombie) {
            ConversionHelper.convert(pLivingEntity);
        }
        else
            pLivingEntity.hurt(
                pLivingEntity.damageSources().indirectMagic(pLivingEntity, pLivingEntity),
                Math.min(pLivingEntity.getHealth() - 1, pLivingEntity.getHealth() * ((1f / 3f) * (pAmplifier + 1)))
        );
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return pDuration == 1;
    }

}
