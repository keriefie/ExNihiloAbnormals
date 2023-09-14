package keriefie.exnihiloabnormals.datagen.common.recipes;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import novamachina.exnihilosequentia.common.crafting.ExNihiloFinishedRecipe;
import novamachina.exnihilosequentia.common.crafting.compost.CompostRecipeBuilder;
import novamachina.exnihilosequentia.common.init.ExNihiloSerializers;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class ENACompostRecipeBuilder extends ExNihiloFinishedRecipe<ENACompostRecipeBuilder> implements RecipeBuilder {
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    private Item result;

    @Nullable
    private String group;

    private ENACompostRecipeBuilder() {
        super((RecipeSerializer) ExNihiloSerializers.COMPOST_RECIPE_SERIALIZER.get());
    }

    @Nonnull
    public static ENACompostRecipeBuilder builder() {
        return new ENACompostRecipeBuilder();
    }

    @Nonnull
    public ENACompostRecipeBuilder amount(int amount) {
        return (ENACompostRecipeBuilder)this.addWriter((jsonObj) -> {
            jsonObj.addProperty("amount", amount);
        });
    }

    @Nonnull
    public ENACompostRecipeBuilder input(@Nonnull TagKey<Item> tag) {
        return (ENACompostRecipeBuilder)this.addInput(tag);
    }

    @Nonnull
    public ENACompostRecipeBuilder input(@Nonnull ItemLike input) {
        return (ENACompostRecipeBuilder)this.addInput(input);
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
        return Items.DIRT;
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        this.build(pFinishedRecipeConsumer, pRecipeId);
    }
}
