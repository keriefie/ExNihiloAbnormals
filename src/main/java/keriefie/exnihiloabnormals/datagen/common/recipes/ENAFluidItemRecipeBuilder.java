package keriefie.exnihiloabnormals.datagen.common.recipes;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import novamachina.exnihilosequentia.common.crafting.ExNihiloFinishedRecipe;
import novamachina.exnihilosequentia.common.init.ExNihiloSerializers;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class ENAFluidItemRecipeBuilder extends ExNihiloFinishedRecipe<ENAFluidItemRecipeBuilder> implements RecipeBuilder {
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    private Item result;

    @Nullable
    private String group;

    private ENAFluidItemRecipeBuilder() throws NullPointerException {
        super((RecipeSerializer) ExNihiloSerializers.FLUID_ITEM_RECIPE_SERIALIZER.get());
    }

    @Nonnull
    public static ENAFluidItemRecipeBuilder builder() {
        return new ENAFluidItemRecipeBuilder();
    }

    @Nonnull
    public ENAFluidItemRecipeBuilder fluidInBarrel(@Nonnull Fluid fluid) {
        return (ENAFluidItemRecipeBuilder)this.addFluid(fluid);
    }

    @Nonnull
    public ENAFluidItemRecipeBuilder input(@Nonnull ItemLike input) {
        return (ENAFluidItemRecipeBuilder)this.addInput(input);
    }

    @Nonnull
    public ENAFluidItemRecipeBuilder input(@Nonnull Ingredient input) {
        return (ENAFluidItemRecipeBuilder)this.addInput(input);
    }

    @Nonnull
    public ENAFluidItemRecipeBuilder input(@Nonnull TagKey<Item> tag) {
        return (ENAFluidItemRecipeBuilder)this.addInput(tag);
    }

    @Nonnull
    public ENAFluidItemRecipeBuilder result(@Nonnull ItemLike output) {
        this.result = output.asItem();
        return (ENAFluidItemRecipeBuilder)this.addResult(output);
    }

    @Override
    public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    @Override
    public Item getResult() {
        return this.result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        this.build(pFinishedRecipeConsumer, pRecipeId);
    }
}
