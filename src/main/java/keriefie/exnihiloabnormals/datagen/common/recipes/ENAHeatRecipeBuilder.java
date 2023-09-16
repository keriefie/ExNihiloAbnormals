package keriefie.exnihiloabnormals.datagen.common.recipes;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import novamachina.exnihilosequentia.common.crafting.ExNihiloFinishedRecipe;
import novamachina.exnihilosequentia.common.crafting.heat.HeatRecipeBuilder;
import novamachina.exnihilosequentia.common.init.ExNihiloSerializers;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class ENAHeatRecipeBuilder extends ExNihiloFinishedRecipe<ENAHeatRecipeBuilder> implements RecipeBuilder {
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    private Item result = Items.TORCH;

    @Nullable
    private String group;

    private ENAHeatRecipeBuilder() throws NullPointerException {
        super((RecipeSerializer) ExNihiloSerializers.HEAT_RECIPE_SERIALIZER.get());
    }

    public static ENAHeatRecipeBuilder builder() {
        return new ENAHeatRecipeBuilder();
    }

    @Nonnull
    public ENAHeatRecipeBuilder amount(int amount) {
        return (ENAHeatRecipeBuilder)this.addWriter((jsonObj) -> {
            jsonObj.addProperty("amount", amount);
        });
    }

    @Nonnull
    public ENAHeatRecipeBuilder input(@Nonnull Ingredient input) {
        return (ENAHeatRecipeBuilder)this.addInput(input);
    }

    @Nonnull
    public ENAHeatRecipeBuilder input(@Nonnull Block block) {
        return (ENAHeatRecipeBuilder)this.addBlock(block);
    }

    @Nonnull
    public ENAHeatRecipeBuilder properties(@Nonnull StatePropertiesPredicate properties) {
        return (ENAHeatRecipeBuilder)this.addWriter((jsonObj) -> {
            jsonObj.add("state", properties.serializeToJson());
        });
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
