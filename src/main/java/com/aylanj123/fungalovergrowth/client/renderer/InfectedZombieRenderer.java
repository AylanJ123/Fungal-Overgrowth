package com.aylanj123.fungalovergrowth.client.renderer;

import com.aylanj123.fungalovergrowth.FungalOvergrowthMod;
import com.aylanj123.fungalovergrowth.classes.entity.InfectedZombie;
import com.aylanj123.fungalovergrowth.client.model.InfectedZombieModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.SoundType;

public class InfectedZombieRenderer extends AbstractZombieRenderer<InfectedZombie, InfectedZombieModel<InfectedZombie>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(
            FungalOvergrowthMod.MODID, String.format("textures/entity/%s.png", InfectedZombie.ID)
    );

    public InfectedZombieRenderer(EntityRendererProvider.Context cx) {
        super(
                cx,
                new InfectedZombieModel<>(cx.bakeLayer(InfectedZombieModel.LAYER_LOCATION)),
                new InfectedZombieModel<>(cx.bakeLayer(ModelLayers.ZOMBIE_INNER_ARMOR)),
                new InfectedZombieModel<>(cx.bakeLayer(ModelLayers.ZOMBIE_OUTER_ARMOR))
        );
    }

    @Override
    public ResourceLocation getTextureLocation(InfectedZombie pEntity) {
        return TEXTURE;
    }
}
