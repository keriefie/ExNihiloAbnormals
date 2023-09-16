package keriefie.exnihiloabnormals.datagen.common;

import com.mojang.logging.LogUtils;
import com.teamabnormals.atmospheric.core.registry.AtmosphericBlocks;
import com.teamabnormals.atmospheric.core.registry.AtmosphericItems;
import com.teamabnormals.autumnity.core.registry.AutumnityBlocks;
import com.teamabnormals.autumnity.core.registry.AutumnityItems;
import com.teamabnormals.berry_good.core.registry.BGItems;
import com.teamabnormals.caverns_and_chasms.core.registry.CCBlocks;
import com.teamabnormals.caverns_and_chasms.core.registry.CCItems;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes;
import com.teamabnormals.endergetic.core.registry.EEBlocks;
import com.teamabnormals.environmental.core.registry.EnvironmentalBlocks;
import com.teamabnormals.environmental.core.registry.EnvironmentalItems;
import com.teamabnormals.neapolitan.core.registry.NeapolitanBlocks;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import com.teamabnormals.upgrade_aquatic.core.registry.UABlocks;
import com.teamabnormals.upgrade_aquatic.core.registry.UAItems;
import com.teamabnormals.woodworks.core.registry.WoodworksBlocks;
import keriefie.exnihiloabnormals.ExNihiloAbnormals;
import keriefie.exnihiloabnormals.common.init.ENABlocks;
import keriefie.exnihiloabnormals.common.init.ENAItems;
import keriefie.exnihiloabnormals.common.utility.ENAConstants;
import keriefie.exnihiloabnormals.datagen.common.recipes.*;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.UpgradeRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.AndCondition;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import novamachina.exnihilosequentia.common.block.BaseBlock;
import novamachina.exnihilosequentia.common.block.BlockSieve;
import novamachina.exnihilosequentia.common.blockentity.crucible.CrucibleTypeEnum;
import novamachina.exnihilosequentia.common.crafting.compost.CompostRecipeBuilder;
import novamachina.exnihilosequentia.common.crafting.crucible.CrucibleRecipeBuilder;
import novamachina.exnihilosequentia.common.crafting.fluiditem.FluidItemRecipeBuilder;
import novamachina.exnihilosequentia.common.crafting.hammer.HammerRecipeBuilder;
import novamachina.exnihilosequentia.common.crafting.heat.HeatRecipeBuilder;
import novamachina.exnihilosequentia.common.crafting.sieve.MeshWithChance;
import novamachina.exnihilosequentia.common.crafting.sieve.SieveRecipeBuilder;
import novamachina.exnihilosequentia.common.init.ExNihiloBlocks;
import novamachina.exnihilosequentia.common.init.ExNihiloFluids;
import novamachina.exnihilosequentia.common.init.ExNihiloItems;
import novamachina.exnihilosequentia.common.item.mesh.MeshType;
import novamachina.exnihilosequentia.common.utility.ExNihiloLogger;
import novamachina.exnihilosequentia.datagen.api.datagen.AbstractRecipeGenerator;
import org.checkerframework.checker.units.qual.A;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static com.teamabnormals.clayworks.core.data.server.ClayworksRecipeProvider.KILN_CONFIG;
import static com.teamabnormals.clayworks.core.data.server.ClayworksRecipeProvider.conditionalRecipe;

public class ENARecipeGenerator extends AbstractRecipeGenerator {

    @Nonnull
    private static final ExNihiloLogger logger = new ExNihiloLogger(LogUtils.getLogger());

    @Nonnull
    private static final Fluid seawater = ExNihiloFluids.SEA_WATER.get();
    @Nonnull
    private static final ModLoadedCondition ATMOSPHERIC_LOADED = new ModLoadedCondition(ENAConstants.Mods.ATMOSPHERIC);
    @Nonnull
    private static final ModLoadedCondition AUTUMNITY_LOADED = new ModLoadedCondition(ENAConstants.Mods.AUTUMNITY);
    @Nonnull
    private static final ModLoadedCondition BERRY_GOOD_LOADED = new ModLoadedCondition(ENAConstants.Mods.BERRY_GOOD);
    @Nonnull
    private static final ModLoadedCondition CAVERNS_AND_CHASMS_LOADED = new ModLoadedCondition(ENAConstants.Mods.CAVERNS_AND_CHASMS);
    @Nonnull
    private static final ModLoadedCondition ENDERGETIC_LOADED = new ModLoadedCondition(ENAConstants.Mods.ENDERGETIC);
    @Nonnull
    private static final ModLoadedCondition ENVIRONMENTAL_LOADED = new ModLoadedCondition(ENAConstants.Mods.ENVIRONMENTAL);
    @Nonnull
    private static final ModLoadedCondition NEAPOLITAN_LOADED = new ModLoadedCondition(ENAConstants.Mods.NEAPOLITAN);
    @Nonnull
    private static final ModLoadedCondition UPGRADE_AQUATIC_LOADED = new ModLoadedCondition(ENAConstants.Mods.UPGRADE_AQUATIC);
    @Nonnull
    private static final ModLoadedCondition WOODWORKS_LOADED = new ModLoadedCondition(ENAConstants.Mods.WOODWORKS);
    @Nonnull
    private static final ModLoadedCondition CLAYWORKS_LOADED = new ModLoadedCondition(ENAConstants.Mods.CLAYWORKS);

    public ENARecipeGenerator(@Nonnull DataGenerator generator) {
        super(generator, ExNihiloAbnormals.MODID);
    }

    @Override
    protected void buildCraftingRecipes(@Nonnull final Consumer<FinishedRecipe> consumer) {
        logger.debug("buildCraftingRecipes");
        registerBarrels(consumer);
        registerCrucibles(consumer);
        registerSieves(consumer);
        registerBeehives(consumer);
        registerKilnRecipes(consumer);
        registerCustomRecipes(consumer);
    }

    private void registerCustomRecipes(@Nonnull final Consumer<FinishedRecipe> consumer) {
        logger.debug("registerCustomRecipes");
        registerFluidItemRecipes(consumer);
        registerSieveRecipes(consumer);
        registerHammerRecipes(consumer);
        registerCompostRecipes(consumer);
        registerCrucibleRecipes(consumer);
        registerHeatRecipes(consumer);
    }

    public static void conditionalRecipe(Consumer<FinishedRecipe> consumer, List<ICondition> conditions, RecipeBuilder recipe, ResourceLocation id) {
        ConditionalRecipe.Builder builder = ConditionalRecipe.builder();
        for (ICondition condition : conditions) {
            builder.addCondition(condition);
        }
        builder.addRecipe(consumer1 -> recipe.save(consumer1, id)).generateAdvancement(new ResourceLocation(id.getNamespace(), "recipes/" + recipe.getResult().getItemCategory().getRecipeFolderName() + "/" + id.getPath())).build(consumer, id);
    }

    public static void conditionalRecipe(Consumer<FinishedRecipe> consumer, ICondition condition, RecipeBuilder recipe, ResourceLocation id) {
        ConditionalRecipe.Builder builder = ConditionalRecipe.builder();
        builder.addCondition(condition);
        builder.addRecipe(consumer1 -> recipe.save(consumer1, id)).generateAdvancement(new ResourceLocation(id.getNamespace(), "recipes/" + recipe.getResult().getItemCategory().getRecipeFolderName() + "/" + id.getPath())).build(consumer, id);
    }

    void createBarrel(@Nonnull Consumer<FinishedRecipe> consumer, @Nonnull RegistryObject<BaseBlock> barrel, @Nonnull Block block, @Nonnull Block slab) {
        createBarrel(consumer, barrel, block.asItem(), slab.asItem());
    }

    void createConditionalBarrel(@Nonnull Consumer<FinishedRecipe> consumer, ICondition condition, @Nonnull RegistryObject<BaseBlock> barrel, @Nonnull Block block, @Nonnull Block slab) {
        conditionalRecipe(consumer, condition,
                ShapedRecipeBuilder.shaped((ItemLike)barrel.get())
                        .pattern("x x")
                        .pattern("x x")
                        .pattern("x-x")
                        .define('x', block)
                        .define('-', slab)
                        .group("exnihilosequentia")
                        .unlockedBy("has_walls", has(block))
                        .unlockedBy("has_base", has(slab)),
                createSaveLocation(barrel.getId()));
    }

    void createCrucible(@Nonnull Consumer<FinishedRecipe> consumer, @Nonnull RegistryObject<BaseBlock> crucible, @Nonnull Block block, @Nonnull Block slab) {
        createCrucible(consumer, crucible, block.asItem(), slab.asItem());
    }

    void createConditionalCrucible(@Nonnull Consumer<FinishedRecipe> consumer, ICondition condition, @Nonnull RegistryObject<BaseBlock> crucible, @Nonnull Block block, @Nonnull Block slab) {
        conditionalRecipe(consumer, condition,
                ShapedRecipeBuilder.shaped((ItemLike)crucible.get())
                        .pattern("c c")
                        .pattern("clc")
                        .pattern("s s")
                        .define('c', block)
                        .define('l', slab)
                        .define('s', Tags.Items.RODS_WOODEN)
                        .group("exnihilosequentia")
                        .unlockedBy("has_logs", has(block)),
                createSaveLocation(crucible.getId()));
    }

    void createSieve(@Nonnull Consumer<FinishedRecipe> consumer, @Nonnull RegistryObject<BaseBlock> sieve, @Nonnull Block block, @Nonnull Block slab) {
        createSieve(consumer, sieve, block.asItem(), slab.asItem());
    }

    void createConditionalSieve(@Nonnull Consumer<FinishedRecipe> consumer, ICondition condition, @Nonnull RegistryObject<BaseBlock> sieve, @Nonnull Block block, @Nonnull Block slab) {
        conditionalRecipe(consumer, condition,
                ShapedRecipeBuilder.shaped((BlockSieve)sieve.get())
                        .pattern("p p")
                        .pattern("plp")
                        .pattern("s s")
                        .define('p', block)
                        .define('l', slab)
                        .define('s', Tags.Items.RODS_WOODEN)
                        .unlockedBy("has_plank", has(block)),
                createSaveLocation(sieve.getId()));
    }

    void createBeehive(@Nonnull Consumer<FinishedRecipe> consumer, @Nonnull Block beehive_block, @Nonnull Block plank) {
        @Nullable final ResourceLocation beehive = ForgeRegistries.BLOCKS.getKey(beehive_block);
        ShapedRecipeBuilder.shaped(beehive_block.asItem())
                .pattern("xxx")
                .pattern("fff")
                .pattern("xxx")
                .define('x', plank.asItem())
                .define('f', ExNihiloItems.BEEHIVE_FRAME.get())
                .unlockedBy(
                        "has_frame",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ExNihiloItems.BEEHIVE_FRAME.get()))
                .save(consumer, replaceNamespace(createSaveLocation(beehive), ExNihiloAbnormals.MODID));
    }

    void createConditionalBeehive(@Nonnull Consumer<FinishedRecipe> consumer, ICondition condition, @Nonnull Block beehive_block, @Nonnull Block plank) {
        @Nullable final ResourceLocation beehive = ForgeRegistries.BLOCKS.getKey(beehive_block);
        conditionalRecipe(consumer, condition,
                ShapedRecipeBuilder.shaped(beehive_block.asItem())
                .pattern("xxx")
                .pattern("fff")
                .pattern("xxx")
                .define('x', plank.asItem())
                .define('f', ExNihiloItems.BEEHIVE_FRAME.get())
                .unlockedBy(
                        "has_frame",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ExNihiloItems.BEEHIVE_FRAME.get())),
                replaceNamespace(createSaveLocation(beehive), ExNihiloAbnormals.MODID)
        );
    }

    ResourceLocation replaceNamespace(ResourceLocation location, String namespace) {
        return new ResourceLocation(namespace, location.getPath());
    }

    private void registerBarrels(@Nonnull final Consumer<FinishedRecipe> consumer) {
        logger.debug("registerBarrels");
        createConditionalBarrel(consumer, ATMOSPHERIC_LOADED, ENABlocks.BARREL_ASPEN, AtmosphericBlocks.ASPEN_PLANKS.get(), AtmosphericBlocks.ASPEN_SLAB.get());
        createConditionalBarrel(consumer, ATMOSPHERIC_LOADED, ENABlocks.BARREL_GRIMWOOD, AtmosphericBlocks.GRIMWOOD_PLANKS.get(), AtmosphericBlocks.GRIMWOOD_SLAB.get());
        createConditionalBarrel(consumer, ATMOSPHERIC_LOADED, ENABlocks.BARREL_KOUSA, AtmosphericBlocks.KOUSA_PLANKS.get(), AtmosphericBlocks.KOUSA_SLAB.get());
        createConditionalBarrel(consumer, ATMOSPHERIC_LOADED, ENABlocks.BARREL_MORADO, AtmosphericBlocks.MORADO_PLANKS.get(), AtmosphericBlocks.MORADO_SLAB.get());
        createConditionalBarrel(consumer, ATMOSPHERIC_LOADED, ENABlocks.BARREL_ROSEWOOD, AtmosphericBlocks.ROSEWOOD_PLANKS.get(), AtmosphericBlocks.ROSEWOOD_SLAB.get());
        createConditionalBarrel(consumer, ATMOSPHERIC_LOADED, ENABlocks.BARREL_YUCCA, AtmosphericBlocks.YUCCA_PLANKS.get(), AtmosphericBlocks.YUCCA_SLAB.get());
        createConditionalBarrel(consumer, AUTUMNITY_LOADED, ENABlocks.BARREL_MAPLE, AutumnityBlocks.MAPLE_PLANKS.get(), AutumnityBlocks.MAPLE_SLAB.get());
        createConditionalBarrel(consumer, CAVERNS_AND_CHASMS_LOADED, ENABlocks.BARREL_AZALEA, CCBlocks.AZALEA_PLANKS.get(), CCBlocks.AZALEA_SLAB.get());
        createConditionalBarrel(consumer, ENDERGETIC_LOADED, ENABlocks.BARREL_POISE, EEBlocks.POISE_PLANKS.get(), EEBlocks.POISE_SLAB.get());
        createConditionalBarrel(consumer, ENVIRONMENTAL_LOADED, ENABlocks.BARREL_CHERRY, EnvironmentalBlocks.CHERRY_PLANKS.get(), EnvironmentalBlocks.CHERRY_SLAB.get());
        createConditionalBarrel(consumer, ENVIRONMENTAL_LOADED, ENABlocks.BARREL_WILLOW, EnvironmentalBlocks.WILLOW_PLANKS.get(), EnvironmentalBlocks.WILLOW_SLAB.get());
        createConditionalBarrel(consumer, ENVIRONMENTAL_LOADED, ENABlocks.BARREL_WISTERIA, EnvironmentalBlocks.WISTERIA_PLANKS.get(), EnvironmentalBlocks.WISTERIA_SLAB.get());
        createConditionalBarrel(consumer, UPGRADE_AQUATIC_LOADED, ENABlocks.BARREL_DRIFTWOOD, UABlocks.DRIFTWOOD_PLANKS.get(), UABlocks.DRIFTWOOD_SLAB.get());
        createConditionalBarrel(consumer, UPGRADE_AQUATIC_LOADED, ENABlocks.BARREL_RIVER, UABlocks.RIVER_PLANKS.get(), UABlocks.RIVER_SLAB.get());
    }

    private void registerCrucibles(@Nonnull final Consumer<FinishedRecipe> consumer) {
        logger.debug("registerCrucibles");
        createConditionalCrucible(consumer, ATMOSPHERIC_LOADED, ENABlocks.CRUCIBLE_ASPEN, AtmosphericBlocks.ASPEN_PLANKS.get(), AtmosphericBlocks.ASPEN_SLAB.get());
        createConditionalCrucible(consumer, ATMOSPHERIC_LOADED, ENABlocks.CRUCIBLE_GRIMWOOD, AtmosphericBlocks.GRIMWOOD_PLANKS.get(), AtmosphericBlocks.GRIMWOOD_SLAB.get());
        createConditionalCrucible(consumer, ATMOSPHERIC_LOADED, ENABlocks.CRUCIBLE_KOUSA, AtmosphericBlocks.KOUSA_PLANKS.get(), AtmosphericBlocks.KOUSA_SLAB.get());
        createConditionalCrucible(consumer, ATMOSPHERIC_LOADED, ENABlocks.CRUCIBLE_MORADO, AtmosphericBlocks.MORADO_PLANKS.get(), AtmosphericBlocks.MORADO_SLAB.get());
        createConditionalCrucible(consumer, ATMOSPHERIC_LOADED, ENABlocks.CRUCIBLE_ROSEWOOD, AtmosphericBlocks.ROSEWOOD_PLANKS.get(), AtmosphericBlocks.ROSEWOOD_SLAB.get());
        createConditionalCrucible(consumer, ATMOSPHERIC_LOADED, ENABlocks.CRUCIBLE_YUCCA, AtmosphericBlocks.YUCCA_PLANKS.get(), AtmosphericBlocks.YUCCA_SLAB.get());
        createConditionalCrucible(consumer, AUTUMNITY_LOADED, ENABlocks.CRUCIBLE_MAPLE, AutumnityBlocks.MAPLE_PLANKS.get(), AutumnityBlocks.MAPLE_SLAB.get());
        createConditionalCrucible(consumer, CAVERNS_AND_CHASMS_LOADED, ENABlocks.CRUCIBLE_AZALEA, CCBlocks.AZALEA_PLANKS.get(), CCBlocks.AZALEA_SLAB.get());
        createConditionalCrucible(consumer, ENDERGETIC_LOADED, ENABlocks.CRUCIBLE_POISE, EEBlocks.POISE_PLANKS.get(), EEBlocks.POISE_SLAB.get());
        createConditionalCrucible(consumer, ENVIRONMENTAL_LOADED, ENABlocks.CRUCIBLE_CHERRY, EnvironmentalBlocks.CHERRY_PLANKS.get(), EnvironmentalBlocks.CHERRY_SLAB.get());
        createConditionalCrucible(consumer, ENVIRONMENTAL_LOADED, ENABlocks.CRUCIBLE_WILLOW, EnvironmentalBlocks.WILLOW_PLANKS.get(), EnvironmentalBlocks.WILLOW_SLAB.get());
        createConditionalCrucible(consumer, ENVIRONMENTAL_LOADED, ENABlocks.CRUCIBLE_WISTERIA, EnvironmentalBlocks.WISTERIA_PLANKS.get(), EnvironmentalBlocks.WISTERIA_SLAB.get());
        createConditionalCrucible(consumer, UPGRADE_AQUATIC_LOADED, ENABlocks.CRUCIBLE_DRIFTWOOD, UABlocks.DRIFTWOOD_PLANKS.get(), UABlocks.DRIFTWOOD_SLAB.get());
        createConditionalCrucible(consumer, UPGRADE_AQUATIC_LOADED, ENABlocks.CRUCIBLE_RIVER, UABlocks.RIVER_PLANKS.get(), UABlocks.RIVER_SLAB.get());
    }

    private void registerSieves(@Nonnull final Consumer<FinishedRecipe> consumer) {
        logger.debug("registerSieves");
        createConditionalSieve(consumer, ATMOSPHERIC_LOADED, ENABlocks.SIEVE_ASPEN, AtmosphericBlocks.ASPEN_PLANKS.get(), AtmosphericBlocks.ASPEN_SLAB.get());
        createConditionalSieve(consumer, ATMOSPHERIC_LOADED, ENABlocks.SIEVE_GRIMWOOD, AtmosphericBlocks.GRIMWOOD_PLANKS.get(), AtmosphericBlocks.GRIMWOOD_SLAB.get());
        createConditionalSieve(consumer, ATMOSPHERIC_LOADED, ENABlocks.SIEVE_KOUSA, AtmosphericBlocks.KOUSA_PLANKS.get(), AtmosphericBlocks.KOUSA_SLAB.get());
        createConditionalSieve(consumer, ATMOSPHERIC_LOADED, ENABlocks.SIEVE_MORADO, AtmosphericBlocks.MORADO_PLANKS.get(), AtmosphericBlocks.MORADO_SLAB.get());
        createConditionalSieve(consumer, ATMOSPHERIC_LOADED, ENABlocks.SIEVE_ROSEWOOD, AtmosphericBlocks.ROSEWOOD_PLANKS.get(), AtmosphericBlocks.ROSEWOOD_SLAB.get());
        createConditionalSieve(consumer, ATMOSPHERIC_LOADED, ENABlocks.SIEVE_YUCCA, AtmosphericBlocks.YUCCA_PLANKS.get(), AtmosphericBlocks.YUCCA_SLAB.get());
        createConditionalSieve(consumer, ATMOSPHERIC_LOADED, ENABlocks.SIEVE_MAPLE, AutumnityBlocks.MAPLE_PLANKS.get(), AutumnityBlocks.MAPLE_SLAB.get());
        createConditionalSieve(consumer, CAVERNS_AND_CHASMS_LOADED, ENABlocks.SIEVE_AZALEA, CCBlocks.AZALEA_PLANKS.get(), CCBlocks.AZALEA_SLAB.get());
        createConditionalSieve(consumer, ENDERGETIC_LOADED, ENABlocks.SIEVE_POISE, EEBlocks.POISE_PLANKS.get(), EEBlocks.POISE_SLAB.get());
        createConditionalSieve(consumer, ENVIRONMENTAL_LOADED, ENABlocks.SIEVE_CHERRY, EnvironmentalBlocks.CHERRY_PLANKS.get(), EnvironmentalBlocks.CHERRY_SLAB.get());
        createConditionalSieve(consumer, ENVIRONMENTAL_LOADED, ENABlocks.SIEVE_WILLOW, EnvironmentalBlocks.WILLOW_PLANKS.get(), EnvironmentalBlocks.WILLOW_SLAB.get());
        createConditionalSieve(consumer, ENVIRONMENTAL_LOADED, ENABlocks.SIEVE_WISTERIA, EnvironmentalBlocks.WISTERIA_PLANKS.get(), EnvironmentalBlocks.WISTERIA_SLAB.get());
        createConditionalSieve(consumer, UPGRADE_AQUATIC_LOADED, ENABlocks.SIEVE_DRIFTWOOD, UABlocks.DRIFTWOOD_PLANKS.get(), UABlocks.DRIFTWOOD_SLAB.get());
        createConditionalSieve(consumer, UPGRADE_AQUATIC_LOADED, ENABlocks.SIEVE_RIVER, UABlocks.RIVER_PLANKS.get(), UABlocks.RIVER_SLAB.get());
    }

    private static AndCondition and(ICondition a, ICondition b) {
        return new AndCondition(a, b);
    }

    private void registerBeehives(@Nonnull final Consumer<FinishedRecipe> consumer) {
        logger.debug("registerBeehives");
        createConditionalBeehive(consumer, WOODWORKS_LOADED, WoodworksBlocks.SPRUCE_BEEHIVE.get(), Blocks.SPRUCE_PLANKS);
        createConditionalBeehive(consumer, WOODWORKS_LOADED, WoodworksBlocks.BIRCH_BEEHIVE.get(), Blocks.BIRCH_PLANKS);
        createConditionalBeehive(consumer, WOODWORKS_LOADED, WoodworksBlocks.ACACIA_BEEHIVE.get(), Blocks.ACACIA_PLANKS);
        createConditionalBeehive(consumer, WOODWORKS_LOADED, WoodworksBlocks.JUNGLE_BEEHIVE.get(), Blocks.JUNGLE_PLANKS);
        createConditionalBeehive(consumer, WOODWORKS_LOADED, WoodworksBlocks.DARK_OAK_BEEHIVE.get(), Blocks.DARK_OAK_PLANKS);
        createConditionalBeehive(consumer, WOODWORKS_LOADED, WoodworksBlocks.MANGROVE_BEEHIVE.get(), Blocks.MANGROVE_PLANKS);
        createConditionalBeehive(consumer, WOODWORKS_LOADED, WoodworksBlocks.CRIMSON_BEEHIVE.get(), Blocks.CRIMSON_PLANKS);
        createConditionalBeehive(consumer, WOODWORKS_LOADED, WoodworksBlocks.WARPED_BEEHIVE.get(), Blocks.WARPED_PLANKS);

        createConditionalBeehive(consumer, and(ATMOSPHERIC_LOADED, WOODWORKS_LOADED), AtmosphericBlocks.ASPEN_BEEHIVE.get(), AtmosphericBlocks.ASPEN_PLANKS.get());
        createConditionalBeehive(consumer, and(ATMOSPHERIC_LOADED, WOODWORKS_LOADED), AtmosphericBlocks.GRIMWOOD_BEEHIVE.get(), AtmosphericBlocks.GRIMWOOD_PLANKS.get());
        createConditionalBeehive(consumer, and(ATMOSPHERIC_LOADED, WOODWORKS_LOADED), AtmosphericBlocks.KOUSA_BEEHIVE.get(), AtmosphericBlocks.KOUSA_PLANKS.get());
        createConditionalBeehive(consumer, and(ATMOSPHERIC_LOADED, WOODWORKS_LOADED), AtmosphericBlocks.MORADO_BEEHIVE.get(), AtmosphericBlocks.MORADO_PLANKS.get());
        createConditionalBeehive(consumer, and(ATMOSPHERIC_LOADED, WOODWORKS_LOADED), AtmosphericBlocks.ROSEWOOD_BEEHIVE.get(), AtmosphericBlocks.ROSEWOOD_PLANKS.get());
        createConditionalBeehive(consumer, and(ATMOSPHERIC_LOADED, WOODWORKS_LOADED), AtmosphericBlocks.YUCCA_BEEHIVE.get(), AtmosphericBlocks.YUCCA_PLANKS.get());
        createConditionalBeehive(consumer, and(AUTUMNITY_LOADED, WOODWORKS_LOADED), AutumnityBlocks.MAPLE_BEEHIVE.get(), AutumnityBlocks.MAPLE_PLANKS.get());
        createConditionalBeehive(consumer, and(CAVERNS_AND_CHASMS_LOADED, WOODWORKS_LOADED), CCBlocks.AZALEA_BEEHIVE.get(), CCBlocks.AZALEA_PLANKS.get());
        createConditionalBeehive(consumer, and(ENDERGETIC_LOADED, WOODWORKS_LOADED), EEBlocks.POISE_BEEHIVE.get(), EEBlocks.POISE_PLANKS.get());
        createConditionalBeehive(consumer, and(ENVIRONMENTAL_LOADED, WOODWORKS_LOADED), EnvironmentalBlocks.CHERRY_BEEHIVE.get(), EnvironmentalBlocks.CHERRY_PLANKS.get());
        createConditionalBeehive(consumer, and(ENVIRONMENTAL_LOADED, WOODWORKS_LOADED), EnvironmentalBlocks.WILLOW_BEEHIVE.get(), EnvironmentalBlocks.WILLOW_PLANKS.get());
        createConditionalBeehive(consumer, and(ENVIRONMENTAL_LOADED, WOODWORKS_LOADED), EnvironmentalBlocks.WISTERIA_BEEHIVE.get(), EnvironmentalBlocks.WISTERIA_PLANKS.get());
        createConditionalBeehive(consumer, and(UPGRADE_AQUATIC_LOADED, WOODWORKS_LOADED), UABlocks.DRIFTWOOD_BEEHIVE.get(), UABlocks.DRIFTWOOD_PLANKS.get());
        createConditionalBeehive(consumer, and(UPGRADE_AQUATIC_LOADED, WOODWORKS_LOADED), UABlocks.RIVER_BEEHIVE.get(), UABlocks.RIVER_PLANKS.get());
    }

    protected static void baking(Consumer<FinishedRecipe> consumer, ItemLike ingredient, ItemLike result, float experience, int cookingTime) {
        conditionalRecipe(consumer, and(CLAYWORKS_LOADED, KILN_CONFIG), SimpleCookingRecipeBuilder.cooking(Ingredient.of(ingredient), result, experience, cookingTime, ClayworksRecipes.ClayworksRecipeSerializers.BAKING.get()).unlockedBy(getHasName(ingredient), has(ingredient)), new ResourceLocation(ExNihiloAbnormals.MODID, getItemName(result) + "_from_baking"));
    }

    private void registerKilnRecipes(@Nonnull final Consumer<FinishedRecipe> consumer) {
        logger.debug("registerKilnRecipes");
        baking(consumer, ExNihiloBlocks.CRUCIBLE_UNFIRED.get(), ExNihiloBlocks.CRUCIBLE_FIRED.get(), 0.7F, 100);
    }

    protected void createFluidItemRecipes(@Nonnull Consumer<FinishedRecipe> consumer, @Nonnull Fluid fluidInput, @Nonnull Item itemInput, @Nonnull Block blockOutput, @Nonnull String id) {
        FluidItemRecipeBuilder.builder().fluidInBarrel(fluidInput).input(itemInput).result(blockOutput).build(consumer, this.fluidItemLoc(id));
    }

    protected void createConditionalFluidItemRecipe(@Nonnull Consumer<FinishedRecipe> consumer, ICondition condition, @Nonnull Fluid fluidInput, @Nonnull Item itemInput, @Nonnull Block blockOutput, @Nonnull String id) {
        conditionalRecipe(consumer, condition, ENAFluidItemRecipeBuilder.builder().fluidInBarrel(fluidInput).input(itemInput).result(blockOutput), this.fluidItemLoc(id));
    }

    private void registerFluidItemRecipes(@Nonnull final Consumer<FinishedRecipe> consumer) {
        logger.debug("registerFluidItemRecipes");
        createConditionalFluidItemRecipe(
                consumer,
                UPGRADE_AQUATIC_LOADED,
                seawater,
                ENAItems.ACAN_CORAL_LARVA.get(),
                UABlocks.ACAN_CORAL_BLOCK.get(),
                "acan_coral");
        createConditionalFluidItemRecipe(
                consumer,
                UPGRADE_AQUATIC_LOADED,
                seawater,
                ENAItems.BRANCH_CORAL_LARVA.get(),
                UABlocks.BRANCH_CORAL_BLOCK.get(),
                "branch_coral");
        createConditionalFluidItemRecipe(
                consumer,
                UPGRADE_AQUATIC_LOADED,
                seawater,
                ENAItems.CHROME_CORAL_LARVA.get(),
                UABlocks.CHROME_CORAL_BLOCK.get(),
                "chrome_coral");
        createConditionalFluidItemRecipe(
                consumer,
                UPGRADE_AQUATIC_LOADED,
                seawater,
                ENAItems.ELDER_PRISMARINE_CORAL_LARVA.get(),
                UABlocks.ELDER_PRISMARINE_CORAL_BLOCK.get(),
                "elder_prismarine_coral");
        createConditionalFluidItemRecipe(
                consumer,
                UPGRADE_AQUATIC_LOADED,
                seawater,
                ENAItems.FINGER_CORAL_LARVA.get(),
                UABlocks.FINGER_CORAL_BLOCK.get(),
                "finger_coral");
        createConditionalFluidItemRecipe(
                consumer,
                UPGRADE_AQUATIC_LOADED,
                seawater,
                ENAItems.MOSS_CORAL_LARVA.get(),
                UABlocks.MOSS_CORAL_BLOCK.get(),
                "moss_coral");
        createConditionalFluidItemRecipe(
                consumer,
                UPGRADE_AQUATIC_LOADED,
                seawater,
                ENAItems.PETAL_CORAL_LARVA.get(),
                UABlocks.PETAL_CORAL_BLOCK.get(),
                "petal_coral");
        createConditionalFluidItemRecipe(
                consumer,
                UPGRADE_AQUATIC_LOADED,
                seawater,
                ENAItems.PILLOW_CORAL_LARVA.get(),
                UABlocks.PILLOW_CORAL_BLOCK.get(),
                "pillow_coral");
        createConditionalFluidItemRecipe(
                consumer,
                UPGRADE_AQUATIC_LOADED,
                seawater,
                ENAItems.PRISMARINE_CORAL_LARVA.get(),
                UABlocks.PRISMARINE_CORAL_BLOCK.get(),
                "prismarine_coral");
        createConditionalFluidItemRecipe(
                consumer,
                UPGRADE_AQUATIC_LOADED,
                seawater,
                ENAItems.ROCK_CORAL_LARVA.get(),
                UABlocks.ROCK_CORAL_BLOCK.get(),
                "rock_coral");
        createConditionalFluidItemRecipe(
                consumer,
                UPGRADE_AQUATIC_LOADED,
                seawater,
                ENAItems.SILK_CORAL_LARVA.get(),
                UABlocks.SILK_CORAL_BLOCK.get(),
                "silk_coral");
        createConditionalFluidItemRecipe(
                consumer,
                UPGRADE_AQUATIC_LOADED,
                seawater,
                ENAItems.STAR_CORAL_LARVA.get(),
                UABlocks.STAR_CORAL_BLOCK.get(),
                "star_coral");

        createConditionalFluidItemRecipe(
                consumer, ATMOSPHERIC_LOADED, seawater, Blocks.SAND.asItem(), AtmosphericBlocks.ARID_SAND.get(), "arid_sand");
        createConditionalFluidItemRecipe(
                consumer, ATMOSPHERIC_LOADED, seawater, Blocks.RED_SAND.asItem(), AtmosphericBlocks.RED_ARID_SAND.get(), "red_arid_sand");
    }

    private Map<Block, Item> getAbnormalsLeavesSaplings() {
        @Nonnull final Map<Block, Item> saplingMap = new HashMap<>();
        saplingMap.put(AtmosphericBlocks.ROSEWOOD_LEAVES.get(), AtmosphericBlocks.ROSEWOOD_SAPLING.get().asItem());
        saplingMap.put(AtmosphericBlocks.MORADO_LEAVES.get(), AtmosphericBlocks.MORADO_SAPLING.get().asItem());
        saplingMap.put(AtmosphericBlocks.YUCCA_LEAVES.get(), AtmosphericBlocks.YUCCA_SAPLING.get().asItem());
        saplingMap.put(AtmosphericBlocks.ASPEN_LEAVES.get(), AtmosphericBlocks.ASPEN_SAPLING.get().asItem());
        saplingMap.put(AtmosphericBlocks.KOUSA_LEAVES.get(), AtmosphericBlocks.KOUSA_SAPLING.get().asItem());
        saplingMap.put(AtmosphericBlocks.GRIMWOOD_LEAVES.get(), AtmosphericBlocks.GRIMWOOD_SAPLING.get().asItem());
        saplingMap.put(EnvironmentalBlocks.WILLOW_LEAVES.get(), EnvironmentalBlocks.WILLOW_SAPLING.get().asItem());
        saplingMap.put(EnvironmentalBlocks.CHERRY_LEAVES.get(), EnvironmentalBlocks.CHERRY_SAPLING.get().asItem());
        saplingMap.put(EnvironmentalBlocks.PINK_WISTERIA_LEAVES.get(), EnvironmentalBlocks.PINK_WISTERIA_SAPLING.get().asItem());
        saplingMap.put(EnvironmentalBlocks.BLUE_WISTERIA_LEAVES.get(), EnvironmentalBlocks.BLUE_WISTERIA_SAPLING.get().asItem());
        saplingMap.put(EnvironmentalBlocks.PURPLE_WISTERIA_LEAVES.get(), EnvironmentalBlocks.PURPLE_WISTERIA_SAPLING.get().asItem());
        saplingMap.put(EnvironmentalBlocks.WHITE_WISTERIA_LEAVES.get(), EnvironmentalBlocks.WHITE_WISTERIA_SAPLING.get().asItem());
        saplingMap.put(UABlocks.RIVER_LEAVES.get(), UABlocks.RIVER_SAPLING.get().asItem());
        saplingMap.put(AutumnityBlocks.MAPLE_LEAVES.get(), AutumnityBlocks.MAPLE_SAPLING.get().asItem());
        saplingMap.put(AutumnityBlocks.YELLOW_MAPLE_LEAVES.get(), AutumnityBlocks.YELLOW_MAPLE_SAPLING.get().asItem());
        saplingMap.put(AutumnityBlocks.ORANGE_MAPLE_LEAVES.get(), AutumnityBlocks.ORANGE_MAPLE_SAPLING.get().asItem());
        saplingMap.put(AutumnityBlocks.RED_MAPLE_LEAVES.get(), AutumnityBlocks.RED_MAPLE_SAPLING.get().asItem());

        return saplingMap;
    }

    protected void createConditionalCompostRecipe(@Nonnull Consumer<FinishedRecipe> consumer, ICondition condition, @Nonnull ItemLike input, int amount, @Nonnull String string) {
        conditionalRecipe(consumer, condition, ENACompostRecipeBuilder.builder().input(input.asItem()).amount(amount), this.compostLoc(string));
    }

    private void registerCompostRecipes(@Nonnull final Consumer<FinishedRecipe> consumer) {
        logger.debug("registerCompostRecipes");
        createConditionalCompostRecipe(consumer, ATMOSPHERIC_LOADED, AtmosphericBlocks.PASSION_VINE.get(), 100, "passion_vine");
        createConditionalCompostRecipe(consumer, ATMOSPHERIC_LOADED, AtmosphericItems.PASSION_VINE_COIL.get(), 800, "passion_vine_coil");
        createConditionalCompostRecipe(consumer, ATMOSPHERIC_LOADED, AtmosphericBlocks.BARREL_CACTUS.get(), 100, "barrel_cactus");
        createConditionalCompostRecipe(consumer, ATMOSPHERIC_LOADED, AtmosphericBlocks.YUCCA_BRANCH.get(), 100, "yucca_branch");
        createConditionalCompostRecipe(consumer, ATMOSPHERIC_LOADED, AtmosphericBlocks.ARID_SPROUTS.get(), 100, "arid_sprouts");
        createConditionalCompostRecipe(consumer, ATMOSPHERIC_LOADED, AtmosphericBlocks.PASSION_VINE_BUNDLE.get(), 900, "passion_vine_bundle");
        createConditionalCompostRecipe(consumer, ATMOSPHERIC_LOADED, AtmosphericBlocks.YUCCA_BUNDLE.get(), 900, "yucca_bundle");
        createConditionalCompostRecipe(consumer, ATMOSPHERIC_LOADED, AtmosphericBlocks.ROASTED_YUCCA_BUNDLE.get(), 900, "roasted_yucca_bundle");
        createConditionalCompostRecipe(consumer, ATMOSPHERIC_LOADED, AtmosphericBlocks.ALOE_BUNDLE.get(), 900, "aloe_bundle");
        createConditionalCompostRecipe(consumer, ATMOSPHERIC_LOADED, AtmosphericBlocks.ALOE_GEL_BLOCK.get(), 400, "aloe_gel_block");
        createConditionalCompostRecipe(consumer, ATMOSPHERIC_LOADED, AtmosphericItems.YUCCA_FRUIT.get(), 100, "yucca_fruit");
        createConditionalCompostRecipe(consumer, ATMOSPHERIC_LOADED, AtmosphericItems.ROASTED_YUCCA_FRUIT.get(), 100, "roasted_yucca_fruit");
        createConditionalCompostRecipe(consumer, ATMOSPHERIC_LOADED, AtmosphericItems.PASSIONFRUIT.get(), 100, "passionfruit");
        createConditionalCompostRecipe(consumer, ATMOSPHERIC_LOADED, AtmosphericItems.ALOE_KERNELS.get(), 100, "aloe_kernels");

        createConditionalCompostRecipe(consumer, AUTUMNITY_LOADED, AutumnityBlocks.REDSTONE_JACK_O_LANTERN.get(), 1000 / 6, "redstone_jack_o_lantern");
        createConditionalCompostRecipe(consumer, AUTUMNITY_LOADED, AutumnityBlocks.SOUL_JACK_O_LANTERN.get(), 1000 / 6, "soul_jack_o_lantern");
        createConditionalCompostRecipe(consumer, AUTUMNITY_LOADED, AutumnityBlocks.CUPRIC_JACK_O_LANTERN.get(), 1000 / 6, "cupric_jack_o_lantern");
        createConditionalCompostRecipe(consumer, AUTUMNITY_LOADED, AutumnityBlocks.ENDER_JACK_O_LANTERN.get(), 1000 / 6, "ender_jack_o_lantern");
        createConditionalCompostRecipe(consumer, AUTUMNITY_LOADED, AutumnityBlocks.LARGE_PUMPKIN_SLICE.get(), 1000 / 6, "large_pumpkin_slice");
        createConditionalCompostRecipe(consumer, AUTUMNITY_LOADED, AutumnityBlocks.CARVED_LARGE_PUMPKIN_SLICE.get(), 1000 / 6, "carved_large_pumpkin_slice");
        createConditionalCompostRecipe(consumer, AUTUMNITY_LOADED, AutumnityBlocks.LARGE_JACK_O_LANTERN_SLICE.get(), 1000 / 6, "large_jack_o_lantern_slice");
        createConditionalCompostRecipe(consumer, AUTUMNITY_LOADED, AutumnityBlocks.LARGE_REDSTONE_JACK_O_LANTERN_SLICE.get(), 1000 / 6, "large_redstone_jack_o_lantern_slice");
        createConditionalCompostRecipe(consumer, AUTUMNITY_LOADED, AutumnityBlocks.LARGE_SOUL_JACK_O_LANTERN_SLICE.get(), 1000 / 6, "large_soul_jack_o_lantern_slice");
        createConditionalCompostRecipe(consumer, AUTUMNITY_LOADED, AutumnityBlocks.LARGE_CUPRIC_JACK_O_LANTERN_SLICE.get(), 1000 / 6, "large_cupric_jack_o_lantern_slice");
        createConditionalCompostRecipe(consumer, AUTUMNITY_LOADED, AutumnityBlocks.LARGE_ENDER_JACK_O_LANTERN_SLICE.get(), 1000 / 6, "large_ender_jack_o_lantern_slice");
        createConditionalCompostRecipe(consumer, AUTUMNITY_LOADED, AutumnityBlocks.TURKEY.get(), 1000, "turkey");
        createConditionalCompostRecipe(consumer, AUTUMNITY_LOADED, AutumnityBlocks.COOKED_TURKEY.get(), 1000, "cooked_turkey");
        createConditionalCompostRecipe(consumer, AUTUMNITY_LOADED, AutumnityItems.PUMPKIN_BREAD.get(), 160, "pumpkin_bread");

        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.GRASS_THATCH.get(), 100, "grass_thatch");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.GRASS_THATCH_SLAB.get(), 50, "grass_thatch_slab");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.GRASS_THATCH_STAIRS.get(), 75, "grass_thatch_stairs");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.GRASS_THATCH_VERTICAL_SLAB.get(), 50, "grass_thatch_vertical_stairs"); //
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.CATTAIL_THATCH.get(), 100, "cattail_thatch");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.CATTAIL_THATCH_SLAB.get(), 50, "cattail_thatch_slab");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.CATTAIL_THATCH_SLAB.get(), 75, "cattail_thatch_stairs");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.CATTAIL_THATCH_VERTICAL_SLAB.get(), 50, "cattail_thatch_vertical_stairs"); //
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.DUCKWEED_THATCH.get(), 100, "duckweed_thatch");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.DUCKWEED_THATCH_SLAB.get(), 50, "duckweed_thatch_slab");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.DUCKWEED_THATCH_SLAB.get(), 75, "duckweed_thatch_stairs");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.DUCKWEED_THATCH_VERTICAL_SLAB.get(), 50, "duckweed_thatch_vertical_stairs"); //
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.YAK_HAIR_BLOCK.get(), 360, "yak_hair_block");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.YAK_HAIR_RUG.get(), 120, "yak_hair_rug");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.CATTAIL.get(), 100, "cattail");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.TALL_CATTAIL.get(), 100, "tall_cattail");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.PINK_HANGING_WISTERIA_LEAVES.get(), 100, "pink_hanging_wisteria_leaves");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.BLUE_HANGING_WISTERIA_LEAVES.get(), 100, "blue_hanging_wisteria_leaves");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.PURPLE_HANGING_WISTERIA_LEAVES.get(), 100, "purple_hanging_wisteria_leaves");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.WHITE_HANGING_WISTERIA_LEAVES.get(), 100, "white_hanging_wisteria_leaves");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.HANGING_WILLOW_LEAVES.get(), 100, "hanging_willow_leaves");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.LARGE_LILY_PAD.get(), 100, "large_lily_pad");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.GIANT_LILY_PAD.get(), 100, "giant_lily_pad");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.DUCKWEED.get(), 100, "duckweed");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.TALL_DEAD_BUSH.get(), 100, "tall_dead_bush");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.GIANT_TALL_GRASS.get(), 100, "giant_tall_grass");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalBlocks.MYCELIUM_SPROUTS.get(), 100, "mycelium_sprouts");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalItems.TRUFFLE.get(), 100, "truffle");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalItems.CATTAIL_SEEDS.get(), 100, "cattail_seeds");
        createConditionalCompostRecipe(consumer, ENVIRONMENTAL_LOADED, EnvironmentalItems.YAK_HAIR.get(), 40, "yak_hair");

        createConditionalCompostRecipe(consumer, ATMOSPHERIC_LOADED, ENAItems.CRUSTOSE_SPORE.get(), 100, "crustose_spore");
        createConditionalCompostRecipe(consumer, ENDERGETIC_LOADED, ENAItems.POISMOSS_SPORE.get(), 100, "poismoss_spore");

        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.FROND_THATCH.get(), 100, "frond_thatch");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.FROND_THATCH_SLAB.get(), 50, "frond_thatch_slab");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.FROND_THATCH_SLAB.get(), 75, "frond_thatch_stairs");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.FROND_THATCH_VERTICAL_SLAB.get(), 50, "frond_thatch_vertical_stairs"); //
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.SMALL_BANANA_FROND.get(), 50, "small_banana_frond");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.BANANA_FROND.get(), 100, "banana_frond");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.LARGE_BANANA_FROND.get(), 150, "large_banana_frond");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.BANANA_STALK.get(), 150, "banana_stalk");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.BEANSTALK.get(), 150, "beanstalk");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.BEANSTALK_THORNS.get(), 100, "beanstalk_thorns");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanItems.CHOCOLATE_BAR.get(), 160, "chocolate_bar");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.CHOCOLATE_BLOCK.get(), 1000, "chocolate_block");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.CHOCOLATE_BRICKS.get(), 640, "chocolate_bricks");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.CHOCOLATE_BRICK_SLAB.get(), 320, "chocolate_brick_slab");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.CHOCOLATE_BRICK_VERTICAL_SLAB.get(), 320, "chocolate_brick_vertical_slab");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.CHOCOLATE_BRICK_STAIRS.get(), 480, "chocolate_brick_stairs");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.CHOCOLATE_BRICK_WALL.get(), 640, "chocolate_brick_wall");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.CHISELED_CHOCOLATE_BRICKS.get(), 640, "chiseled_chocolate_bricks");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.CHOCOLATE_TILES.get(), 640, "chocolate_tiles");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.CHOCOLATE_TILE_SLAB.get(), 320, "chocolate_tile_slab");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.CHOCOLATE_TILE_VERTICAL_SLAB.get(), 320, "chocolate_tile_vertical_slab");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.CHOCOLATE_TILE_STAIRS.get(), 480, "chocolate_tile_stairs");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanBlocks.CHOCOLATE_TILE_WALL.get(), 640, "chocolate_tile_wall");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanItems.STRAWBERRIES.get(), 100, "strawberries");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanItems.WHITE_STRAWBERRIES.get(), 100, "white_strawberries");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanItems.STRAWBERRY_SCONES.get(), 160, "strawberry_scones");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanItems.VANILLA_PODS.get(), 100, "vanilla_pods");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanItems.DRIED_VANILLA_PODS.get(), 100, "dried_vanilla_pods");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanItems.CHOCOLATE_STRAWBERRIES.get(), 160, "chocolate_strawberries");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanItems.CHOCOLATE_SPIDER_EYE.get(), 160, "chocolate_spider_eye");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanItems.VANILLA_CHOCOLATE_FINGERS.get(), 160, "vanilla_chocolate_fingers");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanItems.BANANA.get(), 100, "banana");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanItems.BANANA_BUNCH.get(), 100, "banana_bunch");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanItems.MINT_SPROUT.get(), 100, "mint_sprout");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanItems.MINT_LEAVES.get(), 100, "mint_leaves");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanItems.ADZUKI_BEANS.get(), 100, "adzuki_beans");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanItems.ROASTED_ADZUKI_BEANS.get(), 100, "roasted_adzuki_beans");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanItems.ADZUKI_BUN.get(), 160, "adzuki_bun");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanItems.BANANA_BREAD.get(), 160, "banana_bread");
        createConditionalCompostRecipe(consumer, NEAPOLITAN_LOADED, NeapolitanItems.MINT_CHOCOLATE.get(), 160, "mint_chocolate");

        createConditionalCompostRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.BEACHGRASS.get(), 100, "beachgrass");
        createConditionalCompostRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.TALL_BEACHGRASS.get(), 100, "tall_beachgrass");
        createConditionalCompostRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.BEACHGRASS_THATCH.get(), 100, "beachgrass_thatch");
        createConditionalCompostRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.BEACHGRASS_THATCH_SLAB.get(), 50, "beachgrass_thatch_slab");
        createConditionalCompostRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.BEACHGRASS_THATCH_SLAB.get(), 75, "beachgrass_thatch_stairs");
        createConditionalCompostRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.BEACHGRASS_THATCH_VERTICAL_SLAB.get(), 50, "beachgrass_thatch_vertical_stairs"); //
        createConditionalCompostRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.TONGUE_KELP.get(), 100, "tongue_kelp");
        createConditionalCompostRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.THORNY_KELP.get(), 100, "thorny_kelp");
        createConditionalCompostRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.OCHRE_KELP.get(), 100, "ochre_kelp");
        createConditionalCompostRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.POLAR_KELP.get(), 100, "polar_kelp");
        createConditionalCompostRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.MULBERRY_JAM_BLOCK.get(), 400, "mulberry_jam_block");
        createConditionalCompostRecipe(consumer, UPGRADE_AQUATIC_LOADED, UAItems.MULBERRY_BREAD.get(), 160, "mulberry_bread");
        createConditionalCompostRecipe(consumer, UPGRADE_AQUATIC_LOADED, UAItems.MULBERRY_PIE.get(), 160, "mulberry_pie");
        createConditionalCompostRecipe(consumer, UPGRADE_AQUATIC_LOADED, UAItems.MULBERRY.get(), 100, "mulberry");

        createConditionalCompostRecipe(consumer, CAVERNS_AND_CHASMS_LOADED, CCBlocks.ROTTEN_FLESH_BLOCK.get(), 900, "rotten_flesh_block");
    }

    protected void createConditionalHammerRecipe(@Nonnull Consumer<FinishedRecipe> consumer, ICondition condition, @Nonnull Block blockInput, @Nonnull Block blockOutput, @Nonnull String id) {
        conditionalRecipe(consumer, condition, ENAHammerRecipeBuilder.builder().input(blockInput).addDrop(blockOutput), this.hammerLoc(id));
    }

    private void registerHammerRecipes(@Nonnull final Consumer<FinishedRecipe> consumer) {
        logger.debug("registerHammerRecipes");
        createConditionalHammerRecipe(
                consumer, ATMOSPHERIC_LOADED, AtmosphericBlocks.IVORY_TRAVERTINE.get(), ENABlocks.CRUSHED_IVORY_TRAVERTINE.get(), "ivory_travertine");
        createConditionalHammerRecipe(
                consumer, ATMOSPHERIC_LOADED, AtmosphericBlocks.PEACH_TRAVERTINE.get(), ENABlocks.CRUSHED_PEACH_TRAVERTINE.get(), "peach_travertine");
        createConditionalHammerRecipe(
                consumer, ATMOSPHERIC_LOADED, AtmosphericBlocks.PERSIMMON_TRAVERTINE.get(), ENABlocks.CRUSHED_PERSIMMON_TRAVERTINE.get(), "persimmon_travertine");
        createConditionalHammerRecipe(
                consumer, ATMOSPHERIC_LOADED, AtmosphericBlocks.SAFFRON_TRAVERTINE.get(), ENABlocks.CRUSHED_SAFFRON_TRAVERTINE.get(), "saffron_travertine");

        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.ACAN_CORAL_BLOCK.get(), UABlocks.ACAN_CORAL.get(), "acan_coral");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.BRANCH_CORAL_BLOCK.get(), UABlocks.BRANCH_CORAL.get(), "branch_coral");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.CHROME_CORAL_BLOCK.get(), UABlocks.CHROME_CORAL.get(), "chrome_coral");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.ELDER_PRISMARINE_CORAL_BLOCK.get(), UABlocks.ELDER_PRISMARINE_CORAL.get(), "elder_prismarine_coral");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.FINGER_CORAL_BLOCK.get(), UABlocks.FINGER_CORAL.get(), "finger_coral");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.MOSS_CORAL_BLOCK.get(), UABlocks.MOSS_CORAL.get(), "moss_coral");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.PETAL_CORAL_BLOCK.get(), UABlocks.PETAL_CORAL.get(), "petal_coral");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.PILLOW_CORAL_BLOCK.get(), UABlocks.PILLOW_CORAL.get(), "pillow_coral");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.PRISMARINE_CORAL_BLOCK.get(), UABlocks.PRISMARINE_CORAL.get(), "prismarine_coral");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.ROCK_CORAL_BLOCK.get(), UABlocks.ROCK_CORAL.get(), "rock_coral");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.SILK_CORAL_BLOCK.get(), UABlocks.SILK_CORAL.get(), "silk_coral");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.STAR_CORAL_BLOCK.get(), UABlocks.STAR_CORAL.get(), "star_coral");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.ACAN_CORAL.get(), UABlocks.ACAN_CORAL_FAN.get(), "acan_coral_fan");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.BRANCH_CORAL.get(), UABlocks.BRANCH_CORAL_FAN.get(), "branch_coral_fan");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.CHROME_CORAL.get(), UABlocks.CHROME_CORAL_FAN.get(), "chrome_coral_fan");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.ELDER_PRISMARINE_CORAL.get(), UABlocks.ELDER_PRISMARINE_CORAL_FAN.get(), "elder_prismarine_coral_fan");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.FINGER_CORAL.get(), UABlocks.FINGER_CORAL_FAN.get(), "finger_coral_fan");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.MOSS_CORAL.get(), UABlocks.MOSS_CORAL_FAN.get(), "moss_coral_fan");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.PETAL_CORAL.get(), UABlocks.PETAL_CORAL_FAN.get(), "petal_coral_fan");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.PILLOW_CORAL.get(), UABlocks.PILLOW_CORAL_FAN.get(), "pillow_coral_fan");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.PRISMARINE_CORAL.get(), UABlocks.PRISMARINE_CORAL_FAN.get(), "prismarine_coral_fan");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.ROCK_CORAL.get(), UABlocks.ROCK_CORAL_FAN.get(), "rock_coral_fan");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.SILK_CORAL.get(), UABlocks.SILK_CORAL_FAN.get(), "silk_coral_fan");
        createConditionalHammerRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.STAR_CORAL.get(), UABlocks.STAR_CORAL_FAN.get(), "star_coral_fan");
    }

    protected void createConditionalHeatRecipe(@Nonnull Consumer<FinishedRecipe> consumer, ICondition condition, @Nonnull Block block, int amount, @Nonnull String id) {
        conditionalRecipe(consumer, condition, ENAHeatRecipeBuilder.builder().input(block).amount(amount), this.heatLoc(id));
    }

    protected void createConditionalHeatRecipe(@Nonnull Consumer<FinishedRecipe> consumer, ICondition condition, @Nonnull Block block, int amount, @Nonnull StatePropertiesPredicate properties, @Nonnull String id) {
        conditionalRecipe(consumer, condition, ENAHeatRecipeBuilder.builder().input(block).amount(amount).properties(properties), this.heatLoc(id));
    }

    private void registerHeatRecipes(@Nonnull final Consumer<FinishedRecipe> consumer) {
        logger.debug("registerHeatRecipes");
        createConditionalHeatRecipe(consumer, CAVERNS_AND_CHASMS_LOADED, CCBlocks.CUPRIC_TORCH.get(), 1, "cuptic_torch");
        createConditionalHeatRecipe(consumer, ENDERGETIC_LOADED, EEBlocks.ENDER_TORCH.get(), 1, "ender_torch");
        createConditionalHeatRecipe(consumer, CAVERNS_AND_CHASMS_LOADED, CCBlocks.CUPRIC_FIRE.get(), 4, "cupric_fire");
        createConditionalHeatRecipe(consumer, ENDERGETIC_LOADED, EEBlocks.ENDER_FIRE.get(), 4, "ender_fire");
//        createConditionalHeatRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.PINK_JELLY_TORCH.get(), 2, "pink_jelly_torch");
//        createConditionalHeatRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.PURPLE_JELLY_TORCH.get(), 2, "purple_jelly_torch");
//        createConditionalHeatRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.BLUE_JELLY_TORCH.get(), 2, "blue_jelly_torch");
//        createConditionalHeatRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.GREEN_JELLY_TORCH.get(), 2, "green_jelly_torch");
//        createConditionalHeatRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.YELLOW_JELLY_TORCH.get(), 2, "yellow_jelly_torch");
//        createConditionalHeatRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.ORANGE_JELLY_TORCH.get(), 2, "orange_jelly_torch");
//        createConditionalHeatRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.RED_JELLY_TORCH.get(), 2, "red_jelly_torch");
//        createConditionalHeatRecipe(consumer, UPGRADE_AQUATIC_LOADED, UABlocks.WHITE_JELLY_TORCH.get(), 2, "white_jelly_torch");
        createConditionalHeatRecipe(consumer, CAVERNS_AND_CHASMS_LOADED, CCBlocks.LAVA_LAMP.get(), 3, "lava_lamp");
        StatePropertiesPredicate lit =
                StatePropertiesPredicate.Builder.properties()
                        .hasProperty(BlockStateProperties.LIT, true)
                        .build();
        createConditionalHeatRecipe(consumer, CAVERNS_AND_CHASMS_LOADED, CCBlocks.CUPRIC_CAMPFIRE.get(), 4, lit, "cupric_campfire");
        createConditionalHeatRecipe(consumer, ENDERGETIC_LOADED, EEBlocks.ENDER_CAMPFIRE.get(), 4, lit, "ender_campfire");
        createConditionalHeatRecipe(consumer, CAVERNS_AND_CHASMS_LOADED, CCBlocks.BRAZIER.get(), 5, lit, "brazier");
        createConditionalHeatRecipe(consumer, CAVERNS_AND_CHASMS_LOADED, CCBlocks.SOUL_BRAZIER.get(), 5, lit, "soul_brazier");
        createConditionalHeatRecipe(consumer, CAVERNS_AND_CHASMS_LOADED, CCBlocks.CUPRIC_BRAZIER.get(), 5, lit, "cupric_brazier");
        createConditionalHeatRecipe(consumer, CAVERNS_AND_CHASMS_LOADED, CCBlocks.ENDER_BRAZIER.get(), 5, lit, "ender_brazier");
    }

    protected void createConditionalFiredCrucibleRecipe(@Nonnull Consumer<FinishedRecipe> consumer, ICondition condition, @Nonnull Block block, int amount, @Nonnull String id) {
        conditionalRecipe(consumer, condition, ENACrucibleRecipeBuilder.builder().input(Ingredient.of(new ItemLike[]{block})).amount(amount).fluidResult(Fluids.LAVA).crucibleType(CrucibleTypeEnum.FIRED), this.crucibleLoc(id));
    }

    private void registerCrucibleRecipes(@Nonnull final Consumer<FinishedRecipe> consumer) {
        logger.debug("registerCrucibleRecipes");
        createConditionalFiredCrucibleRecipe(consumer, ATMOSPHERIC_LOADED, AtmosphericBlocks.IVORY_TRAVERTINE.get(), 250, "ivory_travertine");
        createConditionalFiredCrucibleRecipe(consumer, ATMOSPHERIC_LOADED, AtmosphericBlocks.PEACH_TRAVERTINE.get(), 250, "peach_travertine");
        createConditionalFiredCrucibleRecipe(consumer, ATMOSPHERIC_LOADED, AtmosphericBlocks.PERSIMMON_TRAVERTINE.get(), 250, "persimmon_travertine");
        createConditionalFiredCrucibleRecipe(consumer, ATMOSPHERIC_LOADED, AtmosphericBlocks.SAFFRON_TRAVERTINE.get(), 250, "saffron_travertine");

        createConditionalFiredCrucibleRecipe(consumer, ATMOSPHERIC_LOADED, ENABlocks.CRUSHED_IVORY_TRAVERTINE.get(), 200, "crushed_ivory_travertine");
        createConditionalFiredCrucibleRecipe(consumer, ATMOSPHERIC_LOADED, ENABlocks.CRUSHED_PEACH_TRAVERTINE.get(), 200, "crushed_peach_travertine");
        createConditionalFiredCrucibleRecipe(consumer, ATMOSPHERIC_LOADED, ENABlocks.CRUSHED_PERSIMMON_TRAVERTINE.get(), 200, "crushed_persimmon_travertine");
        createConditionalFiredCrucibleRecipe(consumer, ATMOSPHERIC_LOADED, ENABlocks.CRUSHED_SAFFRON_TRAVERTINE.get(), 200, "crushed_saffron_travertine");
    }

    protected void createConditionalSieveRecipe(@Nonnull Consumer<FinishedRecipe> consumer, ICondition condition, @Nonnull Ingredient input, @Nonnull ItemLike result, @Nonnull MeshType mesh, @Nonnull float chance, @Nonnull boolean isWaterLogged, @Nonnull String id) {
        ENASieveRecipeBuilder builder = ENASieveRecipeBuilder.builder()
                .input(input)
                .drop(result)
                .addRoll(new MeshWithChance(mesh, chance));

        conditionalRecipe(consumer, condition, isWaterLogged ? builder.isWaterlogged() : builder, this.sieveLoc(id));
    }

    private void registerSieveRecipes(@Nonnull final Consumer<FinishedRecipe> consumer) {
        logger.debug("registerSieveRecipes");
        final MeshType STRING = ExNihiloItems.MESH_STRING.get().getType();
        final MeshType FLINT = ExNihiloItems.MESH_FLINT.get().getType();
        final MeshType IRON = ExNihiloItems.MESH_IRON.get().getType();
        final MeshType DIAMOND = ExNihiloItems.MESH_DIAMOND.get().getType();
        final MeshType EMERALD = ExNihiloItems.MESH_EMERALD.get().getType();
        final MeshType NETHERITE = ExNihiloItems.MESH_NETHERITE.get().getType();


        createConditionalSieveRecipe(consumer, UPGRADE_AQUATIC_LOADED,
                Ingredient.of(Blocks.SAND),
                UABlocks.BEACHGRASS.get(),
                STRING, 0.05F,
                false,
                "beachgrass");

        logger.debug("registerSieveRecipes (Corals)");
        createConditionalSieveRecipe(consumer, UPGRADE_AQUATIC_LOADED,
                Ingredient.of(Blocks.SAND),
                ENAItems.ACAN_CORAL_LARVA.get(),
                IRON, 0.05F,
                true,
                "seed_cyan_coral");
        createConditionalSieveRecipe(consumer, UPGRADE_AQUATIC_LOADED,
                Ingredient.of(Blocks.SAND),
                ENAItems.BRANCH_CORAL_LARVA.get(),
                IRON, 0.05F,
                true,
                "seed_black_coral");
        createConditionalSieveRecipe(consumer, UPGRADE_AQUATIC_LOADED,
                Ingredient.of(Blocks.SAND),
                ENAItems.ELDER_PRISMARINE_CORAL_LARVA.get(),
                IRON, 0.05F,
                true,
                "seed_elder_prismarine_coral");
        createConditionalSieveRecipe(consumer, UPGRADE_AQUATIC_LOADED,
                Ingredient.of(Blocks.SAND),
                ENAItems.FINGER_CORAL_LARVA.get(),
                IRON, 0.05F,
                true,
                "seed_orange_coral");
        createConditionalSieveRecipe(consumer, UPGRADE_AQUATIC_LOADED,
                Ingredient.of(Blocks.SAND),
                ENAItems.MOSS_CORAL_LARVA.get(),
                IRON, 0.05F,
                true,
                "seed_green_coral");
        createConditionalSieveRecipe(consumer, UPGRADE_AQUATIC_LOADED,
                Ingredient.of(Blocks.SAND),
                ENAItems.PETAL_CORAL_LARVA.get(),
                IRON, 0.05F,
                true,
                "seed_light_blue_coral");
        createConditionalSieveRecipe(consumer, UPGRADE_AQUATIC_LOADED,
                Ingredient.of(Blocks.SAND),
                ENAItems.PILLOW_CORAL_LARVA.get(),
                IRON, 0.05F,
                true,
                "seed_white_coral");
        createConditionalSieveRecipe(consumer, UPGRADE_AQUATIC_LOADED,
                Ingredient.of(Blocks.SAND),
                ENAItems.PRISMARINE_CORAL_LARVA.get(),
                IRON, 0.05F,
                true,
                "seed_prismarine_coral");
        createConditionalSieveRecipe(consumer, UPGRADE_AQUATIC_LOADED,
                Ingredient.of(Blocks.SAND),
                ENAItems.ROCK_CORAL_LARVA.get(),
                IRON, 0.05F,
                true,
                "seed_brown_coral");
        createConditionalSieveRecipe(consumer, UPGRADE_AQUATIC_LOADED,
                Ingredient.of(Blocks.SAND),
                ENAItems.SILK_CORAL_LARVA.get(),
                IRON, 0.05F,
                true,
                "seed_purple_coral");
        createConditionalSieveRecipe(consumer, UPGRADE_AQUATIC_LOADED,
                Ingredient.of(Blocks.SAND),
                ENAItems.STAR_CORAL_LARVA.get(),
                IRON, 0.05F,
                true,
                "seed_lime_coral");


        createConditionalSieveRecipe(consumer, UPGRADE_AQUATIC_LOADED,
                Ingredient.of(Blocks.SAND),
                UABlocks.TONGUE_KELP.get(),
                IRON, 0.025F,
                true,
                "tongue_kelp");
        createConditionalSieveRecipe(consumer, UPGRADE_AQUATIC_LOADED,
                Ingredient.of(Blocks.SAND),
                UABlocks.THORNY_KELP.get(),
                IRON, 0.025F,
                true,
                "thorny_kelp");
        createConditionalSieveRecipe(consumer, UPGRADE_AQUATIC_LOADED,
                Ingredient.of(Blocks.SAND),
                UABlocks.OCHRE_KELP.get(),
                IRON, 0.025F,
                true,
                "ochre_kelp");
        createConditionalSieveRecipe(consumer, UPGRADE_AQUATIC_LOADED,
                Ingredient.of(Blocks.SAND),
                UABlocks.POLAR_KELP.get(),
                IRON, 0.025F,
                true,
                "polar_kelp");

        createConditionalSieveRecipe(consumer, UPGRADE_AQUATIC_LOADED,
                Ingredient.of(Blocks.SAND),
                UABlocks.DRIFTWOOD_LOG.get(),
                STRING, 0.025F,
                true,
                "driftwood");

        createConditionalSieveRecipe(consumer, AUTUMNITY_LOADED,
                Ingredient.of(Blocks.DIRT),
                AutumnityItems.FOUL_BERRY_PIPS.get(),
                STRING, 0.05F,
                false,
                "foul_berry_pips");

        createConditionalSieveRecipe(consumer, NEAPOLITAN_LOADED,
                Ingredient.of(Blocks.DIRT),
                NeapolitanItems.STRAWBERRY_PIPS.get(),
                STRING, 0.05F,
                false,
                "strawberry_pips");

        createConditionalSieveRecipe(consumer, NEAPOLITAN_LOADED,
                Ingredient.of(Blocks.DIRT),
                NeapolitanItems.ADZUKI_BEANS.get(),
                STRING, 0.05F,
                false,
                "adzuki_beans");

        createConditionalSieveRecipe(consumer, ENVIRONMENTAL_LOADED,
                Ingredient.of(Blocks.DIRT),
                EnvironmentalItems.CATTAIL_SEEDS.get(),
                STRING, 0.05F,
                true,
                "cattail_seeds");

        createConditionalSieveRecipe(consumer, UPGRADE_AQUATIC_LOADED,
                Ingredient.of(Blocks.DIRT),
                UABlocks.PURPLE_PICKERELWEED.get(),
                STRING, 0.05F,
                true,
                "purple_pickerelweed");

        createConditionalSieveRecipe(consumer, UPGRADE_AQUATIC_LOADED,
                Ingredient.of(Blocks.DIRT),
                UABlocks.BLUE_PICKERELWEED.get(),
                STRING, 0.05F,
                true,
                "blue_pickerelweed");

        createConditionalSieveRecipe(consumer, NEAPOLITAN_LOADED,
                Ingredient.of(Blocks.SAND),
                NeapolitanBlocks.SMALL_BANANA_FROND.get(),
                STRING, 0.05F,
                false,
                "small_banana_frond");

        createConditionalSieveRecipe(consumer, NEAPOLITAN_LOADED,
                Ingredient.of(Blocks.SAND),
                NeapolitanItems.VANILLA_PODS.get(),
                STRING, 0.03F,
                false,
                "vanilla_pods");

        createConditionalSieveRecipe(consumer, NEAPOLITAN_LOADED,
                Ingredient.of(Blocks.SAND),
                NeapolitanItems.MINT_SPROUT.get(),
                STRING, 0.03F,
                false,
                "mint_sprout");

        createConditionalSieveRecipe(consumer, ATMOSPHERIC_LOADED,
                Ingredient.of(Blocks.SAND),
                AtmosphericBlocks.PASSION_VINE.get(),
                STRING, 0.03F,
                false,
                "passion_vine");

        createConditionalSieveRecipe(consumer, ATMOSPHERIC_LOADED,
                Ingredient.of(AtmosphericBlocks.ARID_SAND.get()),
                AtmosphericItems.ALOE_KERNELS.get(),
                STRING, 0.05F,
                false,
                "aloe_kernels");

        createConditionalSieveRecipe(consumer, ATMOSPHERIC_LOADED,
                Ingredient.of(AtmosphericBlocks.RED_ARID_SAND.get()),
                AtmosphericItems.ALOE_KERNELS.get(),
                STRING, 0.05F,
                false,
                "aloe_kernels_red");

        createConditionalSieveRecipe(consumer, ATMOSPHERIC_LOADED,
                Ingredient.of(AtmosphericBlocks.ARID_SAND.get()),
                AtmosphericBlocks.YUCCA_SAPLING.get(),
                STRING, 0.05F,
                false,
                "yucca_sapling_arid");

        createConditionalSieveRecipe(consumer, ATMOSPHERIC_LOADED,
                Ingredient.of(AtmosphericBlocks.RED_ARID_SAND.get()),
                AtmosphericBlocks.YUCCA_SAPLING.get(),
                STRING, 0.05F,
                false,
                "yucca_sapling_arid_red");

        createConditionalSieveRecipe(consumer, ATMOSPHERIC_LOADED,
                Ingredient.of(AtmosphericBlocks.ARID_SAND.get()),
                AtmosphericBlocks.BARREL_CACTUS.get(),
                STRING, 0.05F,
                false,
                "barrel_cactus");

        createConditionalSieveRecipe(consumer, ATMOSPHERIC_LOADED,
                Ingredient.of(AtmosphericBlocks.RED_ARID_SAND.get()),
                AtmosphericBlocks.BARREL_CACTUS.get(),
                STRING, 0.05F,
                false,
                "barrel_cactus_red");

        createConditionalSieveRecipe(consumer, BERRY_GOOD_LOADED,
                Ingredient.of(Blocks.DIRT),
                BGItems.SWEET_BERRY_PIPS.get(),
                STRING, 0.05F,
                false,
                "sweet_berry_pips");

        createConditionalSieveRecipe(consumer, BERRY_GOOD_LOADED,
                Ingredient.of(Blocks.DIRT),
                BGItems.GLOW_BERRY_PIPS.get(),
                STRING, 0.05F,
                false,
                "glow_berry_pips");

        createConditionalSieveRecipe(consumer, ATMOSPHERIC_LOADED,
                Ingredient.of(Blocks.DIRT),
                ENAItems.CRUSTOSE_SPORE.get(),
                FLINT, 0.05F,
                false,
                "crustose_spores");

        createConditionalSieveRecipe(consumer, CAVERNS_AND_CHASMS_LOADED,
                Ingredient.of(Blocks.GRAVEL),
                CCItems.SPINEL.get(),
                FLINT, 0.05F,
                false,
                "spinel");

        createConditionalSieveRecipe(consumer, CAVERNS_AND_CHASMS_LOADED,
                Ingredient.of(CCBlocks.ROCKY_DIRT.get()),
                Blocks.DIRT,
                STRING, 0.4F,
                false,
                "dirt_rd");

        createConditionalSieveRecipe(consumer, CAVERNS_AND_CHASMS_LOADED,
                Ingredient.of(CCBlocks.ROCKY_DIRT.get()),
                Blocks.COBBLESTONE,
                STRING, 0.4F,
                false,
                "cobblestone_rd");

        createConditionalSieveRecipe(consumer, CAVERNS_AND_CHASMS_LOADED,
                Ingredient.of(EEBlocks.EUMUS.get()),
                EEBlocks.CORROCK_CROWN_END_STANDING.get(),
                STRING, 0.05F,
                false,
                "corrock_crown");

        createConditionalSieveRecipe(consumer, CAVERNS_AND_CHASMS_LOADED,
                Ingredient.of(EEBlocks.EUMUS.get()),
                EEBlocks.CORROCK_END.get(),
                STRING, 0.05F,
                false,
                "corrock");

        createConditionalSieveRecipe(consumer, CAVERNS_AND_CHASMS_LOADED,
                Ingredient.of(EEBlocks.EUMUS.get()),
                EEBlocks.POISE_BUSH.get(),
                STRING, 0.05F,
                false,
                "poise_bush");

        createConditionalSieveRecipe(consumer, CAVERNS_AND_CHASMS_LOADED,
                Ingredient.of(EEBlocks.EUMUS.get()),
                ENAItems.POISMOSS_SPORE.get(),
                FLINT, 0.05F,
                false,
                "poismoss_spore_eumus");

        createConditionalSieveRecipe(consumer, CAVERNS_AND_CHASMS_LOADED,
                Ingredient.of(ExNihiloBlocks.CRUSHED_END_STONE.get()),
                ENAItems.POISMOSS_SPORE.get(),
                FLINT, 0.05F,
                false,
                "poismoss_spore_endstone");

        createConditionalSieveRecipe(consumer, ATMOSPHERIC_LOADED,
                Ingredient.of(AtmosphericBlocks.FLOWERING_MORADO_LEAVES.get()),
                AtmosphericBlocks.MORADO_SAPLING.get(),
                STRING, 0.05F,
                false,
                "flowering_morado_leaves");

        createConditionalSieveRecipe(consumer, ATMOSPHERIC_LOADED,
                Ingredient.of(AtmosphericBlocks.FLOWERING_MORADO_LEAVES.get()),
                AtmosphericItems.YELLOW_BLOSSOMS.get(),
                STRING, 0.05F,
                false,
                "flowering_morado_leaves_blossoms");

        logger.debug("registerSieveRecipes (Saplings)");
        getAbnormalsLeavesSaplings()
                .forEach(
                        (input, drop) -> {
                            @Nullable final ResourceLocation resourceLocation = ForgeRegistries.BLOCKS.getKey(input);
                            @Nullable final ResourceLocation resourceLocation2 = ForgeRegistries.ITEMS.getKey(drop);

                            logger.debug(resourceLocation.toString());
                            if (resourceLocation != null) {
                                logger.debug(resourceLocation.toString());
                                conditionalRecipe(consumer, new ModLoadedCondition(resourceLocation.getNamespace()),
                                        ENASieveRecipeBuilder.builder()
                                            .input(Ingredient.of(input))
                                            .drop(drop)
                                            .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.05F))
                                            .addRoll(new MeshWithChance(ExNihiloItems.MESH_FLINT.get().getType(), 0.1F))
                                            .addRoll(new MeshWithChance(ExNihiloItems.MESH_IRON.get().getType(), 0.15F))
                                            .addRoll(new MeshWithChance(ExNihiloItems.MESH_DIAMOND.get().getType(), 0.2F)),
                                        sieveLoc(resourceLocation.getPath()));
                            }
                            if (resourceLocation != null) {
                                logger.debug(resourceLocation.toString());
                                conditionalRecipe(consumer, new ModLoadedCondition(resourceLocation.getNamespace()),
                                        ENASieveRecipeBuilder.builder()
                                                .input(Ingredient.of(Blocks.DIRT))
                                                .drop(drop)
                                                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.05F)),
                                        sieveLoc(resourceLocation2.getPath()));
                            }
                        });
    }
}
