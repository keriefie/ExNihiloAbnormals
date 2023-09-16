package keriefie.exnihiloabnormals.datagen.common.recipes;

import com.google.gson.JsonArray;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import novamachina.exnihilosequentia.common.crafting.ExNihiloFinishedRecipe;
import novamachina.exnihilosequentia.common.crafting.sieve.MeshWithChance;
import novamachina.exnihilosequentia.common.crafting.sieve.SieveRecipeBuilder;
import novamachina.exnihilosequentia.common.init.ExNihiloSerializers;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class ENASieveRecipeBuilder extends ExNihiloFinishedRecipe<ENASieveRecipeBuilder> implements RecipeBuilder {
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    private Item result;

    @Nullable
    private String group;

    @Nonnull
    private final JsonArray meshArray = new JsonArray();

    private ENASieveRecipeBuilder() throws NullPointerException {
        super((RecipeSerializer) ExNihiloSerializers.SIEVE_RECIPE_SERIALIZER.get());
        this.addWriter((jsonObject) -> {
            jsonObject.add("rolls", this.meshArray);
        });
    }

    @Nonnull
    public static ENASieveRecipeBuilder builder() {
        return new ENASieveRecipeBuilder();
    }

    @Nonnull
    public ENASieveRecipeBuilder addRoll(@Nonnull MeshWithChance mesh) {
        this.meshArray.add(mesh.serialize());
        return this;
    }

    @Nonnull
    public ENASieveRecipeBuilder drop(@Nonnull ItemLike drop) {
        this.result = drop.asItem();
        return (ENASieveRecipeBuilder)this.addResult(drop);
    }

    @Nonnull
    public ENASieveRecipeBuilder input(@Nonnull Ingredient input) {
        return (ENASieveRecipeBuilder)this.addInput(input);
    }

    @Nonnull
    public ENASieveRecipeBuilder isWaterlogged() {
        return (ENASieveRecipeBuilder)this.addBoolean("waterlogged", true);
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
