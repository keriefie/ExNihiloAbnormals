package keriefie.exnihiloabnormals.datagen.common.recipes;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.material.Fluid;
import novamachina.exnihilosequentia.common.blockentity.crucible.CrucibleTypeEnum;
import novamachina.exnihilosequentia.common.crafting.ExNihiloFinishedRecipe;
import novamachina.exnihilosequentia.common.crafting.crucible.CrucibleRecipeBuilder;
import novamachina.exnihilosequentia.common.init.ExNihiloSerializers;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class ENACrucibleRecipeBuilder extends ExNihiloFinishedRecipe<ENACrucibleRecipeBuilder> implements RecipeBuilder {
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    private Fluid result;

    @Nullable
    private String group;

    private ENACrucibleRecipeBuilder() throws NullPointerException {
        super((RecipeSerializer) ExNihiloSerializers.CRUCIBLE_RECIPE_SERIALIZER.get());
    }

    @Nonnull
    public static ENACrucibleRecipeBuilder builder() {
        return new ENACrucibleRecipeBuilder();
    }

    @Nonnull
    public ENACrucibleRecipeBuilder amount(int amount) {
        return (ENACrucibleRecipeBuilder)this.addWriter((jsonObj) -> {
            jsonObj.addProperty("amount", amount);
        });
    }

    @Nonnull
    public ENACrucibleRecipeBuilder crucibleType(@Nonnull CrucibleTypeEnum type) {
        return (ENACrucibleRecipeBuilder)this.addWriter((jsonObj) -> {
            jsonObj.addProperty("crucibleType", type.getName());
        });
    }

    @Nonnull
    public ENACrucibleRecipeBuilder fluidResult(@Nonnull Fluid fluidResult) {
        this.result = fluidResult;
        return (ENACrucibleRecipeBuilder)this.addFluid("fluidResult", fluidResult);
    }

    @Nonnull
    public ENACrucibleRecipeBuilder input(@Nonnull Ingredient input) {
        return (ENACrucibleRecipeBuilder)this.addInput(input);
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
        return result.getBucket() != null ? result.getBucket() : Items.BUCKET;
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        this.build(pFinishedRecipeConsumer, pRecipeId);
    }
}
