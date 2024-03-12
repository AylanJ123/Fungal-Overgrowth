package com.aylanj123.fungalovergrowth.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> writer) {
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registry.ROPED_LADDER.get(), 8)
//            .pattern("LLL")
//            .pattern("LSL")
//            .pattern("LLL")
//            .define('L', Items.LADDER)
//            .define('S', Items.STRING)
//            .group("roped_big")
//            .unlockedBy(getHasName(Items.LADDER), has(Items.LADDER))
//            .showNotification(true)
//            .save(writer, "roped_big");
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registry.ROPED_LADDER.get(), 3)
//            .requires(Items.LADDER, 3)
//            .requires(Items.STRING, 1)
//            .group("roped_small")
//            .unlockedBy(getHasName(Items.LADDER), has(Items.LADDER))
//            .save(writer, "roped_small");
    }

}
