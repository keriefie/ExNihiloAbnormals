package keriefie.exnihiloabnormals.datagen.common.recipes;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import novamachina.exnihilosequentia.common.crafting.ExNihiloFinishedRecipe;
import novamachina.exnihilosequentia.common.crafting.ItemStackWithChance;
import novamachina.exnihilosequentia.common.crafting.hammer.HammerRecipeBuilder;
import novamachina.exnihilosequentia.common.init.ExNihiloSerializers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class ENAHammerRecipeBuilder extends ExNihiloFinishedRecipe<ENAHammerRecipeBuilder> implements RecipeBuilder {
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    private Item result;

    @Nullable
    private String group;

    private ENAHammerRecipeBuilder() throws NullPointerException {
        super((RecipeSerializer) ExNihiloSerializers.HAMMER_RECIPE_SERIALIZER.get());
        this.setMultipleResults(Integer.MAX_VALUE);
    }

    @Nonnull
    public ENAHammerRecipeBuilder addDrop(@Nonnull ItemLike drop) {
        return this.addDrop(drop, 1, 1.0F);
    }

    @Nonnull
    public ENAHammerRecipeBuilder addDrop(@Nonnull ItemLike drop, int count) {
        return this.addDrop(drop, count, 1.0F);
    }

    @Nonnull
    public ENAHammerRecipeBuilder addDrop(@Nonnull ItemLike drop, float chance) {
        return this.addDrop(drop, 1, chance);
    }

    @Nonnull
    public ENAHammerRecipeBuilder addDrop(@Nonnull ItemLike drop, int count, float chance) {
        this.result = drop.asItem();
        return (ENAHammerRecipeBuilder)this.addResult(new ItemStackWithChance(new ItemStack(drop, count), chance));
    }

    @Nonnull
    public ENAHammerRecipeBuilder input(@Nonnull Ingredient input) {
        return (ENAHammerRecipeBuilder)this.addInput(input);
    }

    @Nonnull
    public ENAHammerRecipeBuilder input(@Nonnull ItemLike input) {
        return this.input(Ingredient.of(new ItemLike[]{input}));
    }

    @Nonnull
    public static ENAHammerRecipeBuilder builder() {
        return new ENAHammerRecipeBuilder();
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
