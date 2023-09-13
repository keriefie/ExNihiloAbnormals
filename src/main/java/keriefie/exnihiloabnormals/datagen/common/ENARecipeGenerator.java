package keriefie.exnihiloabnormals.datagen.common;

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
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import novamachina.exnihilosequentia.common.block.BaseBlock;
import novamachina.exnihilosequentia.common.crafting.sieve.MeshWithChance;
import novamachina.exnihilosequentia.common.crafting.sieve.SieveRecipeBuilder;
import novamachina.exnihilosequentia.common.init.ExNihiloBlocks;
import novamachina.exnihilosequentia.common.init.ExNihiloFluids;
import novamachina.exnihilosequentia.common.init.ExNihiloItems;
import novamachina.exnihilosequentia.datagen.api.datagen.AbstractRecipeGenerator;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static com.teamabnormals.clayworks.core.data.server.ClayworksRecipeProvider.KILN_CONFIG;
import static com.teamabnormals.clayworks.core.data.server.ClayworksRecipeProvider.conditionalRecipe;

public class ENARecipeGenerator extends AbstractRecipeGenerator {

    @Nonnull
    private static final Fluid seawater = ExNihiloFluids.SEA_WATER.get();

    public ENARecipeGenerator(@Nonnull DataGenerator generator) {
        super(generator, ExNihiloAbnormals.MODID);
    }

    @Override
    protected void buildCraftingRecipes(@Nonnull final Consumer<FinishedRecipe> consumer) {
        registerBarrels(consumer);
        registerCrucibles(consumer);
        registerSieves(consumer);
        registerBeehives(consumer);
        registerKilnRecipes(consumer);
        registerCustomRecipes(consumer);
    }

    private void registerCustomRecipes(@Nonnull final Consumer<FinishedRecipe> consumer) {
        registerFluidItemRecipes(consumer);
        registerSieveRecipes(consumer);
        registerHammerRecipes(consumer);
        registerCompostRecipes(consumer);
        registerCrucibleRecipes(consumer);
        registerHeatRecipes(consumer);
    }

    void createBarrel(@Nonnull Consumer<FinishedRecipe> consumer, @Nonnull RegistryObject<BaseBlock> barrel, @Nonnull Block block, @Nonnull Block slab) {
        createBarrel(consumer, barrel, block.asItem(), slab.asItem());
    }

    void createCrucible(@Nonnull Consumer<FinishedRecipe> consumer, @Nonnull RegistryObject<BaseBlock> barrel, @Nonnull Block block, @Nonnull Block slab) {
        createCrucible(consumer, barrel, block.asItem(), slab.asItem());
    }

    void createSieve(@Nonnull Consumer<FinishedRecipe> consumer, @Nonnull RegistryObject<BaseBlock> barrel, @Nonnull Block block, @Nonnull Block slab) {
        createSieve(consumer, barrel, block.asItem(), slab.asItem());
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

    ResourceLocation replaceNamespace(ResourceLocation location, String namespace) {
        return new ResourceLocation(namespace, location.getPath());
    }

    private void registerBarrels(@Nonnull final Consumer<FinishedRecipe> consumer) {
        createBarrel(consumer, ENABlocks.BARREL_ASPEN, AtmosphericBlocks.ASPEN_PLANKS.get(), AtmosphericBlocks.ASPEN_SLAB.get());
        createBarrel(consumer, ENABlocks.BARREL_GRIMWOOD, AtmosphericBlocks.GRIMWOOD_PLANKS.get(), AtmosphericBlocks.GRIMWOOD_SLAB.get());
        createBarrel(consumer, ENABlocks.BARREL_KOUSA, AtmosphericBlocks.KOUSA_PLANKS.get(), AtmosphericBlocks.KOUSA_SLAB.get());
        createBarrel(consumer, ENABlocks.BARREL_MORADO, AtmosphericBlocks.MORADO_PLANKS.get(), AtmosphericBlocks.MORADO_SLAB.get());
        createBarrel(consumer, ENABlocks.BARREL_ROSEWOOD, AtmosphericBlocks.ROSEWOOD_PLANKS.get(), AtmosphericBlocks.ROSEWOOD_SLAB.get());
        createBarrel(consumer, ENABlocks.BARREL_YUCCA, AtmosphericBlocks.YUCCA_PLANKS.get(), AtmosphericBlocks.YUCCA_SLAB.get());
        createBarrel(consumer, ENABlocks.BARREL_MAPLE, AutumnityBlocks.MAPLE_PLANKS.get(), AutumnityBlocks.MAPLE_SLAB.get());
        createBarrel(consumer, ENABlocks.BARREL_AZALEA, CCBlocks.AZALEA_PLANKS.get(), CCBlocks.AZALEA_SLAB.get());
        createBarrel(consumer, ENABlocks.BARREL_POISE, EEBlocks.POISE_PLANKS.get(), EEBlocks.POISE_SLAB.get());
        createBarrel(consumer, ENABlocks.BARREL_CHERRY, EnvironmentalBlocks.CHERRY_PLANKS.get(), EnvironmentalBlocks.CHERRY_SLAB.get());
        createBarrel(consumer, ENABlocks.BARREL_WILLOW, EnvironmentalBlocks.WILLOW_PLANKS.get(), EnvironmentalBlocks.WILLOW_SLAB.get());
        createBarrel(consumer, ENABlocks.BARREL_WISTERIA, EnvironmentalBlocks.WISTERIA_PLANKS.get(), EnvironmentalBlocks.WISTERIA_SLAB.get());
        createBarrel(consumer, ENABlocks.BARREL_DRIFTWOOD, UABlocks.DRIFTWOOD_PLANKS.get(), UABlocks.DRIFTWOOD_SLAB.get());
        createBarrel(consumer, ENABlocks.BARREL_RIVER, UABlocks.RIVER_PLANKS.get(), UABlocks.RIVER_SLAB.get());
    }

    private void registerCrucibles(@Nonnull final Consumer<FinishedRecipe> consumer) {
        createCrucible(consumer, ENABlocks.CRUCIBLE_ASPEN, AtmosphericBlocks.ASPEN_PLANKS.get(), AtmosphericBlocks.ASPEN_SLAB.get());
        createCrucible(consumer, ENABlocks.CRUCIBLE_GRIMWOOD, AtmosphericBlocks.GRIMWOOD_PLANKS.get(), AtmosphericBlocks.GRIMWOOD_SLAB.get());
        createCrucible(consumer, ENABlocks.CRUCIBLE_KOUSA, AtmosphericBlocks.KOUSA_PLANKS.get(), AtmosphericBlocks.KOUSA_SLAB.get());
        createCrucible(consumer, ENABlocks.CRUCIBLE_MORADO, AtmosphericBlocks.MORADO_PLANKS.get(), AtmosphericBlocks.MORADO_SLAB.get());
        createCrucible(consumer, ENABlocks.CRUCIBLE_ROSEWOOD, AtmosphericBlocks.ROSEWOOD_PLANKS.get(), AtmosphericBlocks.ROSEWOOD_SLAB.get());
        createCrucible(consumer, ENABlocks.CRUCIBLE_YUCCA, AtmosphericBlocks.YUCCA_PLANKS.get(), AtmosphericBlocks.YUCCA_SLAB.get());
        createCrucible(consumer, ENABlocks.CRUCIBLE_MAPLE, AutumnityBlocks.MAPLE_PLANKS.get(), AutumnityBlocks.MAPLE_SLAB.get());
        createCrucible(consumer, ENABlocks.CRUCIBLE_AZALEA, CCBlocks.AZALEA_PLANKS.get(), CCBlocks.AZALEA_SLAB.get());
        createCrucible(consumer, ENABlocks.CRUCIBLE_POISE, EEBlocks.POISE_PLANKS.get(), EEBlocks.POISE_SLAB.get());
        createCrucible(consumer, ENABlocks.CRUCIBLE_CHERRY, EnvironmentalBlocks.CHERRY_PLANKS.get(), EnvironmentalBlocks.CHERRY_SLAB.get());
        createCrucible(consumer, ENABlocks.CRUCIBLE_WILLOW, EnvironmentalBlocks.WILLOW_PLANKS.get(), EnvironmentalBlocks.WILLOW_SLAB.get());
        createCrucible(consumer, ENABlocks.CRUCIBLE_WISTERIA, EnvironmentalBlocks.WISTERIA_PLANKS.get(), EnvironmentalBlocks.WISTERIA_SLAB.get());
        createCrucible(consumer, ENABlocks.CRUCIBLE_DRIFTWOOD, UABlocks.DRIFTWOOD_PLANKS.get(), UABlocks.DRIFTWOOD_SLAB.get());
        createCrucible(consumer, ENABlocks.CRUCIBLE_RIVER, UABlocks.RIVER_PLANKS.get(), UABlocks.RIVER_SLAB.get());
    }

    private void registerSieves(@Nonnull final Consumer<FinishedRecipe> consumer) {
        createSieve(consumer, ENABlocks.SIEVE_ASPEN, AtmosphericBlocks.ASPEN_PLANKS.get(), AtmosphericBlocks.ASPEN_SLAB.get());
        createSieve(consumer, ENABlocks.SIEVE_GRIMWOOD, AtmosphericBlocks.GRIMWOOD_PLANKS.get(), AtmosphericBlocks.GRIMWOOD_SLAB.get());
        createSieve(consumer, ENABlocks.SIEVE_KOUSA, AtmosphericBlocks.KOUSA_PLANKS.get(), AtmosphericBlocks.KOUSA_SLAB.get());
        createSieve(consumer, ENABlocks.SIEVE_MORADO, AtmosphericBlocks.MORADO_PLANKS.get(), AtmosphericBlocks.MORADO_SLAB.get());
        createSieve(consumer, ENABlocks.SIEVE_ROSEWOOD, AtmosphericBlocks.ROSEWOOD_PLANKS.get(), AtmosphericBlocks.ROSEWOOD_SLAB.get());
        createSieve(consumer, ENABlocks.SIEVE_YUCCA, AtmosphericBlocks.YUCCA_PLANKS.get(), AtmosphericBlocks.YUCCA_SLAB.get());
        createSieve(consumer, ENABlocks.SIEVE_MAPLE, AutumnityBlocks.MAPLE_PLANKS.get(), AutumnityBlocks.MAPLE_SLAB.get());
        createSieve(consumer, ENABlocks.SIEVE_AZALEA, CCBlocks.AZALEA_PLANKS.get(), CCBlocks.AZALEA_SLAB.get());
        createSieve(consumer, ENABlocks.SIEVE_POISE, EEBlocks.POISE_PLANKS.get(), EEBlocks.POISE_SLAB.get());
        createSieve(consumer, ENABlocks.SIEVE_CHERRY, EnvironmentalBlocks.CHERRY_PLANKS.get(), EnvironmentalBlocks.CHERRY_SLAB.get());
        createSieve(consumer, ENABlocks.SIEVE_WILLOW, EnvironmentalBlocks.WILLOW_PLANKS.get(), EnvironmentalBlocks.WILLOW_SLAB.get());
        createSieve(consumer, ENABlocks.SIEVE_WISTERIA, EnvironmentalBlocks.WISTERIA_PLANKS.get(), EnvironmentalBlocks.WISTERIA_SLAB.get());
        createSieve(consumer, ENABlocks.SIEVE_DRIFTWOOD, UABlocks.DRIFTWOOD_PLANKS.get(), UABlocks.DRIFTWOOD_SLAB.get());
        createSieve(consumer, ENABlocks.SIEVE_RIVER, UABlocks.RIVER_PLANKS.get(), UABlocks.RIVER_SLAB.get());
    }

    private void registerBeehives(@Nonnull final Consumer<FinishedRecipe> consumer) {
        createBeehive(consumer, WoodworksBlocks.SPRUCE_BEEHIVE.get(), Blocks.SPRUCE_PLANKS);
        createBeehive(consumer, WoodworksBlocks.BIRCH_BEEHIVE.get(), Blocks.BIRCH_PLANKS);
        createBeehive(consumer, WoodworksBlocks.ACACIA_BEEHIVE.get(), Blocks.ACACIA_PLANKS);
        createBeehive(consumer, WoodworksBlocks.JUNGLE_BEEHIVE.get(), Blocks.JUNGLE_PLANKS);
        createBeehive(consumer, WoodworksBlocks.DARK_OAK_BEEHIVE.get(), Blocks.DARK_OAK_PLANKS);
        createBeehive(consumer, WoodworksBlocks.MANGROVE_BEEHIVE.get(), Blocks.MANGROVE_PLANKS);
        createBeehive(consumer, WoodworksBlocks.CRIMSON_BEEHIVE.get(), Blocks.CRIMSON_PLANKS);
        createBeehive(consumer, WoodworksBlocks.WARPED_BEEHIVE.get(), Blocks.WARPED_PLANKS);

        createBeehive(consumer, AtmosphericBlocks.ASPEN_BEEHIVE.get(), AtmosphericBlocks.ASPEN_PLANKS.get());
        createBeehive(consumer, AtmosphericBlocks.GRIMWOOD_BEEHIVE.get(), AtmosphericBlocks.GRIMWOOD_PLANKS.get());
        createBeehive(consumer, AtmosphericBlocks.KOUSA_BEEHIVE.get(), AtmosphericBlocks.KOUSA_PLANKS.get());
        createBeehive(consumer, AtmosphericBlocks.MORADO_BEEHIVE.get(), AtmosphericBlocks.MORADO_PLANKS.get());
        createBeehive(consumer, AtmosphericBlocks.ROSEWOOD_BEEHIVE.get(), AtmosphericBlocks.ROSEWOOD_PLANKS.get());
        createBeehive(consumer, AtmosphericBlocks.YUCCA_BEEHIVE.get(), AtmosphericBlocks.YUCCA_PLANKS.get());
        createBeehive(consumer, AutumnityBlocks.MAPLE_BEEHIVE.get(), AutumnityBlocks.MAPLE_PLANKS.get());
        createBeehive(consumer, CCBlocks.AZALEA_BEEHIVE.get(), CCBlocks.AZALEA_PLANKS.get());
        createBeehive(consumer, EEBlocks.POISE_BEEHIVE.get(), EEBlocks.POISE_PLANKS.get());
        createBeehive(consumer, EnvironmentalBlocks.CHERRY_BEEHIVE.get(), EnvironmentalBlocks.CHERRY_PLANKS.get());
        createBeehive(consumer, EnvironmentalBlocks.WILLOW_BEEHIVE.get(), EnvironmentalBlocks.WILLOW_PLANKS.get());
        createBeehive(consumer, EnvironmentalBlocks.WISTERIA_BEEHIVE.get(), EnvironmentalBlocks.WISTERIA_PLANKS.get());
        createBeehive(consumer, UABlocks.DRIFTWOOD_BEEHIVE.get(), UABlocks.DRIFTWOOD_PLANKS.get());
        createBeehive(consumer, UABlocks.RIVER_BEEHIVE.get(), UABlocks.RIVER_PLANKS.get());
    }

    protected static void baking(Consumer<FinishedRecipe> consumer, ItemLike ingredient, ItemLike result, float experience, int cookingTime) {
        conditionalRecipe(consumer, KILN_CONFIG, SimpleCookingRecipeBuilder.cooking(Ingredient.of(ingredient), result, experience, cookingTime, ClayworksRecipes.ClayworksRecipeSerializers.BAKING.get()).unlockedBy(getHasName(ingredient), has(ingredient)), new ResourceLocation(ExNihiloAbnormals.MODID, getItemName(result) + "_from_baking"));
    }

    private void registerKilnRecipes(@Nonnull final Consumer<FinishedRecipe> consumer) {
        baking(consumer, ExNihiloBlocks.CRUCIBLE_UNFIRED.get(), ExNihiloBlocks.CRUCIBLE_FIRED.get(), 0.7F, 100);
    }

    private void registerFluidItemRecipes(@Nonnull final Consumer<FinishedRecipe> consumer) {
        createFluidItemRecipes(
                consumer,
                seawater,
                ENAItems.ACAN_CORAL_LARVA.get(),
                UABlocks.ACAN_CORAL_BLOCK.get(),
                "acan_coral");
        createFluidItemRecipes(
                consumer,
                seawater,
                ENAItems.BRANCH_CORAL_LARVA.get(),
                UABlocks.BRANCH_CORAL_BLOCK.get(),
                "branch_coral");
        createFluidItemRecipes(
                consumer,
                seawater,
                ENAItems.CHROME_CORAL_LARVA.get(),
                UABlocks.CHROME_CORAL_BLOCK.get(),
                "chrome_coral");
        createFluidItemRecipes(
                consumer,
                seawater,
                ENAItems.ELDER_PRISMARINE_CORAL_LARVA.get(),
                UABlocks.ELDER_PRISMARINE_CORAL_BLOCK.get(),
                "elder_prismarine_coral");
        createFluidItemRecipes(
                consumer,
                seawater,
                ENAItems.MOSS_CORAL_LARVA.get(),
                UABlocks.MOSS_CORAL_BLOCK.get(),
                "moss_coral");
        createFluidItemRecipes(
                consumer,
                seawater,
                ENAItems.PETAL_CORAL_LARVA.get(),
                UABlocks.PETAL_CORAL_BLOCK.get(),
                "petal_coral");
        createFluidItemRecipes(
                consumer,
                seawater,
                ENAItems.PILLOW_CORAL_LARVA.get(),
                UABlocks.PILLOW_CORAL_BLOCK.get(),
                "pillow_coral");
        createFluidItemRecipes(
                consumer,
                seawater,
                ENAItems.PRISMARINE_CORAL_LARVA.get(),
                UABlocks.PRISMARINE_CORAL_BLOCK.get(),
                "prismarine_coral");
        createFluidItemRecipes(
                consumer,
                seawater,
                ENAItems.ROCK_CORAL_LARVA.get(),
                UABlocks.ROCK_CORAL_BLOCK.get(),
                "rock_coral");
        createFluidItemRecipes(
                consumer,
                seawater,
                ENAItems.SILK_CORAL_LARVA.get(),
                UABlocks.SILK_CORAL_BLOCK.get(),
                "silk_coral");
        createFluidItemRecipes(
                consumer,
                seawater,
                ENAItems.STAR_CORAL_LARVA.get(),
                UABlocks.STAR_CORAL_BLOCK.get(),
                "star_coral");

        createFluidItemRecipes(
                consumer, seawater, Blocks.SAND.asItem(), AtmosphericBlocks.ARID_SAND.get(), "arid_sand");
        createFluidItemRecipes(
                consumer, seawater, Blocks.RED_SAND.asItem(), AtmosphericBlocks.RED_ARID_SAND.get(), "red_arid_sand");
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

    private void registerCompostRecipes(@Nonnull final Consumer<FinishedRecipe> consumer) {
        createCompostRecipe(consumer, AtmosphericBlocks.PASSION_VINE.get(), 100, "passion_vine");
        createCompostRecipe(consumer, AtmosphericItems.PASSION_VINE_COIL.get(), 800, "passion_vine_coil");
        createCompostRecipe(consumer, AtmosphericBlocks.BARREL_CACTUS.get(), 100, "barrel_cactus");
        createCompostRecipe(consumer, AtmosphericBlocks.YUCCA_BRANCH.get(), 100, "yucca_branch");
        createCompostRecipe(consumer, AtmosphericBlocks.ARID_SPROUTS.get(), 100, "arid_sprouts");
        createCompostRecipe(consumer, AtmosphericBlocks.PASSION_VINE_BUNDLE.get(), 900, "passion_vine_bundle");
        createCompostRecipe(consumer, AtmosphericBlocks.YUCCA_BUNDLE.get(), 900, "yucca_bundle");
        createCompostRecipe(consumer, AtmosphericBlocks.ROASTED_YUCCA_BUNDLE.get(), 900, "roasted_yucca_bundle");
        createCompostRecipe(consumer, AtmosphericBlocks.ALOE_BUNDLE.get(), 900, "aloe_bundle");
        createCompostRecipe(consumer, AtmosphericBlocks.ALOE_GEL_BLOCK.get(), 400, "aloe_gel_block");
        createCompostRecipe(consumer, AtmosphericItems.YUCCA_FRUIT.get(), 100, "yucca_fruit");
        createCompostRecipe(consumer, AtmosphericItems.ROASTED_YUCCA_FRUIT.get(), 100, "roasted_yucca_fruit");
        createCompostRecipe(consumer, AtmosphericItems.PASSIONFRUIT.get(), 100, "passionfruit");
        createCompostRecipe(consumer, AtmosphericItems.ALOE_KERNELS.get(), 100, "aloe_kernels");

        createCompostRecipe(consumer, AutumnityBlocks.REDSTONE_JACK_O_LANTERN.get(), 1000 / 6, "redstone_jack_o_lantern");
        createCompostRecipe(consumer, AutumnityBlocks.SOUL_JACK_O_LANTERN.get(), 1000 / 6, "soul_jack_o_lantern");
        createCompostRecipe(consumer, AutumnityBlocks.CUPRIC_JACK_O_LANTERN.get(), 1000 / 6, "cupric_jack_o_lantern");
        createCompostRecipe(consumer, AutumnityBlocks.ENDER_JACK_O_LANTERN.get(), 1000 / 6, "ender_jack_o_lantern");
        createCompostRecipe(consumer, AutumnityBlocks.LARGE_PUMPKIN_SLICE.get(), 1000 / 6, "large_pumpkin_slice");
        createCompostRecipe(consumer, AutumnityBlocks.LARGE_JACK_O_LANTERN_SLICE.get(), 1000 / 6, "large_jack_o_lantern_slice");
        createCompostRecipe(consumer, AutumnityBlocks.LARGE_REDSTONE_JACK_O_LANTERN_SLICE.get(), 1000 / 6, "large_redstone_jack_o_lantern_slice");
        createCompostRecipe(consumer, AutumnityBlocks.LARGE_SOUL_JACK_O_LANTERN_SLICE.get(), 1000 / 6, "large_soul_jack_o_lantern_slice");
        createCompostRecipe(consumer, AutumnityBlocks.LARGE_CUPRIC_JACK_O_LANTERN_SLICE.get(), 1000 / 6, "large_cupric_jack_o_lantern_slice");
        createCompostRecipe(consumer, AutumnityBlocks.LARGE_ENDER_JACK_O_LANTERN_SLICE.get(), 1000 / 6, "large_ender_jack_o_lantern_slice");
        createCompostRecipe(consumer, AutumnityBlocks.TURKEY.get(), 1000, "turkey");
        createCompostRecipe(consumer, AutumnityBlocks.COOKED_TURKEY.get(), 1000, "cooked_turkey");

        createCompostRecipe(consumer, EnvironmentalBlocks.GRASS_THATCH.get(), 100, "grass_thatch");
        createCompostRecipe(consumer, EnvironmentalBlocks.GRASS_THATCH_SLAB.get(), 50, "grass_thatch_slab");
        createCompostRecipe(consumer, EnvironmentalBlocks.GRASS_THATCH_STAIRS.get(), 75, "grass_thatch_stairs");
        createCompostRecipe(consumer, EnvironmentalBlocks.GRASS_THATCH_VERTICAL_SLAB.get(), 50, "grass_thatch_vertical_stairs"); //
        createCompostRecipe(consumer, EnvironmentalBlocks.CATTAIL_THATCH.get(), 100, "cattail_thatch");
        createCompostRecipe(consumer, EnvironmentalBlocks.CATTAIL_THATCH_SLAB.get(), 50, "cattail_thatch_slab");
        createCompostRecipe(consumer, EnvironmentalBlocks.CATTAIL_THATCH_SLAB.get(), 75, "cattail_thatch_stairs");
        createCompostRecipe(consumer, EnvironmentalBlocks.CATTAIL_THATCH_VERTICAL_SLAB.get(), 50, "cattail_thatch_vertical_stairs"); //
        createCompostRecipe(consumer, EnvironmentalBlocks.DUCKWEED_THATCH.get(), 100, "duckweed_thatch");
        createCompostRecipe(consumer, EnvironmentalBlocks.DUCKWEED_THATCH_SLAB.get(), 50, "duckweed_thatch_slab");
        createCompostRecipe(consumer, EnvironmentalBlocks.DUCKWEED_THATCH_SLAB.get(), 75, "duckweed_thatch_stairs");
        createCompostRecipe(consumer, EnvironmentalBlocks.DUCKWEED_THATCH_VERTICAL_SLAB.get(), 50, "duckweed_thatch_vertical_stairs"); //
        createCompostRecipe(consumer, EnvironmentalBlocks.YAK_HAIR_BLOCK.get(), 360, "yak_hair_block");
        createCompostRecipe(consumer, EnvironmentalBlocks.YAK_HAIR_RUG.get(), 120, "yak_hair_rug");
        createCompostRecipe(consumer, EnvironmentalBlocks.CATTAIL.get(), 100, "cattail");
        createCompostRecipe(consumer, EnvironmentalBlocks.TALL_CATTAIL.get(), 100, "tall_cattail");
        createCompostRecipe(consumer, EnvironmentalBlocks.PINK_HANGING_WISTERIA_LEAVES.get(), 100, "pink_hanging_wisteria_leaves");
        createCompostRecipe(consumer, EnvironmentalBlocks.BLUE_HANGING_WISTERIA_LEAVES.get(), 100, "blue_hanging_wisteria_leaves");
        createCompostRecipe(consumer, EnvironmentalBlocks.PURPLE_HANGING_WISTERIA_LEAVES.get(), 100, "purple_hanging_wisteria_leaves");
        createCompostRecipe(consumer, EnvironmentalBlocks.WHITE_HANGING_WISTERIA_LEAVES.get(), 100, "white_hanging_wisteria_leaves");
        createCompostRecipe(consumer, EnvironmentalBlocks.HANGING_WILLOW_LEAVES.get(), 100, "hanging_willow_leaves");
        createCompostRecipe(consumer, EnvironmentalBlocks.LARGE_LILY_PAD.get(), 100, "large_lily_pad");
        createCompostRecipe(consumer, EnvironmentalBlocks.GIANT_LILY_PAD.get(), 100, "giant_lily_pad");
        createCompostRecipe(consumer, EnvironmentalBlocks.DUCKWEED.get(), 100, "duckweed");
        createCompostRecipe(consumer, EnvironmentalBlocks.TALL_DEAD_BUSH.get(), 100, "tall_dead_bush");
        createCompostRecipe(consumer, EnvironmentalBlocks.GIANT_TALL_GRASS.get(), 100, "giant_tall_grass");
        createCompostRecipe(consumer, EnvironmentalBlocks.MYCELIUM_SPROUTS.get(), 100, "mycelium_sprouts");
        createCompostRecipe(consumer, EnvironmentalItems.TRUFFLE.get(), 100, "truffle");
        createCompostRecipe(consumer, EnvironmentalItems.CATTAIL_SEEDS.get(), 100, "cattail_seeds");
        createCompostRecipe(consumer, EnvironmentalItems.YAK_HAIR.get(), 40, "yak_hair");

        createCompostRecipe(consumer, ENAItems.CRUSTOSE_SPORE.get(), 100, "crustose_spore");
        createCompostRecipe(consumer, ENAItems.POISMOSS_SPORE.get(), 100, "poismoss_spore");

        createCompostRecipe(consumer, NeapolitanBlocks.FROND_THATCH.get(), 100, "frond_thatch");
        createCompostRecipe(consumer, NeapolitanBlocks.FROND_THATCH_SLAB.get(), 50, "frond_thatch_slab");
        createCompostRecipe(consumer, NeapolitanBlocks.FROND_THATCH_SLAB.get(), 75, "frond_thatch_stairs");
        createCompostRecipe(consumer, NeapolitanBlocks.FROND_THATCH_VERTICAL_SLAB.get(), 50, "frond_thatch_vertical_stairs"); //
        createCompostRecipe(consumer, NeapolitanBlocks.SMALL_BANANA_FROND.get(), 50, "small_banana_frond");
        createCompostRecipe(consumer, NeapolitanBlocks.BANANA_FROND.get(), 100, "banana_frond");
        createCompostRecipe(consumer, NeapolitanBlocks.LARGE_BANANA_FROND.get(), 150, "large_banana_frond");
        createCompostRecipe(consumer, NeapolitanBlocks.BANANA_STALK.get(), 150, "banana_stalk");
        createCompostRecipe(consumer, NeapolitanBlocks.BEANSTALK.get(), 150, "beanstalk");
        createCompostRecipe(consumer, NeapolitanBlocks.BEANSTALK_THORNS.get(), 100, "beanstalk_thorns");
        createCompostRecipe(consumer, NeapolitanItems.CHOCOLATE_BAR.get(), 160, "chocolate_bar");
        createCompostRecipe(consumer, NeapolitanBlocks.CHOCOLATE_BLOCK.get(), 1000, "chocolate_block");
        createCompostRecipe(consumer, NeapolitanBlocks.CHOCOLATE_BRICKS.get(), 640, "chocolate_bricks");
        createCompostRecipe(consumer, NeapolitanBlocks.CHOCOLATE_BRICK_SLAB.get(), 320, "chocolate_brick_slab");
        createCompostRecipe(consumer, NeapolitanBlocks.CHOCOLATE_BRICK_VERTICAL_SLAB.get(), 320, "chocolate_brick_vertical_slab");
        createCompostRecipe(consumer, NeapolitanBlocks.CHOCOLATE_BRICK_STAIRS.get(), 480, "chocolate_brick_stairs");
        createCompostRecipe(consumer, NeapolitanBlocks.CHOCOLATE_BRICK_WALL.get(), 640, "chocolate_brick_wall");
        createCompostRecipe(consumer, NeapolitanBlocks.CHISELED_CHOCOLATE_BRICKS.get(), 640, "chiseled_chocolate_bricks");
        createCompostRecipe(consumer, NeapolitanBlocks.CHOCOLATE_TILES.get(), 640, "chocolate_tiles");
        createCompostRecipe(consumer, NeapolitanBlocks.CHOCOLATE_TILE_SLAB.get(), 320, "chocolate_tile_slab");
        createCompostRecipe(consumer, NeapolitanBlocks.CHOCOLATE_TILE_VERTICAL_SLAB.get(), 320, "chocolate_tile_vertical_slab");
        createCompostRecipe(consumer, NeapolitanBlocks.CHOCOLATE_TILE_STAIRS.get(), 480, "chocolate_tile_stairs");
        createCompostRecipe(consumer, NeapolitanBlocks.CHOCOLATE_TILE_WALL.get(), 640, "chocolate_tile_wall");
        createCompostRecipe(consumer, NeapolitanItems.STRAWBERRIES.get(), 100, "strawberries");
        createCompostRecipe(consumer, NeapolitanItems.WHITE_STRAWBERRIES.get(), 100, "white_strawberries");
        createCompostRecipe(consumer, NeapolitanItems.STRAWBERRY_SCONES.get(), 160, "strawberry_scones");
        createCompostRecipe(consumer, NeapolitanItems.VANILLA_PODS.get(), 100, "vanilla_pods");
        createCompostRecipe(consumer, NeapolitanItems.DRIED_VANILLA_PODS.get(), 100, "dried_vanilla_pods");
        createCompostRecipe(consumer, NeapolitanItems.CHOCOLATE_STRAWBERRIES.get(), 160, "chocolate_strawberries");
        createCompostRecipe(consumer, NeapolitanItems.CHOCOLATE_SPIDER_EYE.get(), 160, "chocolate_spider_eye");
        createCompostRecipe(consumer, NeapolitanItems.VANILLA_CHOCOLATE_FINGERS.get(), 160, "vanilla_chocolate_fingers");
        createCompostRecipe(consumer, NeapolitanItems.BANANA.get(), 100, "banana");
        createCompostRecipe(consumer, NeapolitanItems.BANANA_BUNCH.get(), 100, "banana_bunch");
        createCompostRecipe(consumer, NeapolitanItems.MINT_SPROUT.get(), 100, "mint_sprout");
        createCompostRecipe(consumer, NeapolitanItems.MINT_LEAVES.get(), 100, "mint_leaves");
        createCompostRecipe(consumer, NeapolitanItems.ADZUKI_BEANS.get(), 100, "adzuki_beans");
        createCompostRecipe(consumer, NeapolitanItems.ROASTED_ADZUKI_BEANS.get(), 100, "roasted_adzuki_beans");
        createCompostRecipe(consumer, NeapolitanItems.ADZUKI_BUN.get(), 160, "adzuki_bun");
        createCompostRecipe(consumer, NeapolitanItems.BANANA_BREAD.get(), 160, "banana_bread");
        createCompostRecipe(consumer, NeapolitanItems.MINT_CHOCOLATE.get(), 160, "mint_chocolate");

        createCompostRecipe(consumer, UABlocks.BEACHGRASS.get(), 100, "beachgrass");
        createCompostRecipe(consumer, UABlocks.TALL_BEACHGRASS.get(), 100, "tall_beachgrass");
        createCompostRecipe(consumer, UABlocks.BEACHGRASS_THATCH.get(), 100, "beachgrass_thatch");
        createCompostRecipe(consumer, UABlocks.BEACHGRASS_THATCH_SLAB.get(), 50, "beachgrass_thatch_slab");
        createCompostRecipe(consumer, UABlocks.BEACHGRASS_THATCH_SLAB.get(), 75, "beachgrass_thatch_stairs");
        createCompostRecipe(consumer, UABlocks.BEACHGRASS_THATCH_VERTICAL_SLAB.get(), 50, "beachgrass_thatch_vertical_stairs"); //
        createCompostRecipe(consumer, UABlocks.TONGUE_KELP.get(), 100, "tongue_kelp");
        createCompostRecipe(consumer, UABlocks.THORNY_KELP.get(), 100, "thorny_kelp");
        createCompostRecipe(consumer, UABlocks.OCHRE_KELP.get(), 100, "ochre_kelp");
        createCompostRecipe(consumer, UABlocks.POLAR_KELP.get(), 100, "polar_kelp");
        createCompostRecipe(consumer, UABlocks.MULBERRY_JAM_BLOCK.get(), 400, "mulberry_jam_block");
        createCompostRecipe(consumer, UAItems.MULBERRY_BREAD.get(), 160, "mulberry_bread");
        createCompostRecipe(consumer, UAItems.MULBERRY_PIE.get(), 160, "mulberry_pie");
        createCompostRecipe(consumer, UAItems.MULBERRY.get(), 100, "mulberry");

        createCompostRecipe(consumer, CCBlocks.ROTTEN_FLESH_BLOCK.get(), 900, "rotten_flesh_block");
    }

    private void registerHammerRecipes(@Nonnull final Consumer<FinishedRecipe> consumer) {
        createHammerRecipes(
                consumer, AtmosphericBlocks.IVORY_TRAVERTINE.get(), ENABlocks.CRUSHED_IVORY_TRAVERTINE.get(), "ivory_travertine");
        createHammerRecipes(
                consumer, AtmosphericBlocks.PEACH_TRAVERTINE.get(), ENABlocks.CRUSHED_PEACH_TRAVERTINE.get(), "peach_travertine");
        createHammerRecipes(
                consumer, AtmosphericBlocks.PERSIMMON_TRAVERTINE.get(), ENABlocks.CRUSHED_PERSIMMON_TRAVERTINE.get(), "persimmon_travertine");
        createHammerRecipes(
                consumer, AtmosphericBlocks.SAFFRON_TRAVERTINE.get(), ENABlocks.CRUSHED_SAFFRON_TRAVERTINE.get(), "saffron_travertine");

        createHammerRecipes(consumer, UABlocks.ACAN_CORAL_BLOCK.get(), UABlocks.ACAN_CORAL.get(), "acan_coral");
        createHammerRecipes(consumer, UABlocks.BRANCH_CORAL_BLOCK.get(), UABlocks.BRANCH_CORAL.get(), "branch_coral");
        createHammerRecipes(consumer, UABlocks.CHROME_CORAL_BLOCK.get(), UABlocks.CHROME_CORAL.get(), "chrome_coral");
        createHammerRecipes(consumer, UABlocks.ELDER_PRISMARINE_CORAL_BLOCK.get(), UABlocks.ELDER_PRISMARINE_CORAL.get(), "elder_prismarine_coral");
        createHammerRecipes(consumer, UABlocks.MOSS_CORAL_BLOCK.get(), UABlocks.MOSS_CORAL.get(), "moss_coral");
        createHammerRecipes(consumer, UABlocks.PETAL_CORAL_BLOCK.get(), UABlocks.PETAL_CORAL.get(), "petal_coral");
        createHammerRecipes(consumer, UABlocks.PILLOW_CORAL_BLOCK.get(), UABlocks.PILLOW_CORAL.get(), "pillow_coral");
        createHammerRecipes(consumer, UABlocks.PRISMARINE_CORAL_BLOCK.get(), UABlocks.PRISMARINE_CORAL.get(), "prismarine_coral");
        createHammerRecipes(consumer, UABlocks.ROCK_CORAL_BLOCK.get(), UABlocks.ROCK_CORAL.get(), "rock_coral");
        createHammerRecipes(consumer, UABlocks.SILK_CORAL_BLOCK.get(), UABlocks.SILK_CORAL.get(), "silk_coral");
        createHammerRecipes(consumer, UABlocks.STAR_CORAL_BLOCK.get(), UABlocks.STAR_CORAL.get(), "star_coral");
        createHammerRecipes(consumer, UABlocks.ACAN_CORAL.get(), UABlocks.ACAN_CORAL_FAN.get(), "acan_coral_fan");
        createHammerRecipes(consumer, UABlocks.BRANCH_CORAL.get(), UABlocks.BRANCH_CORAL_FAN.get(), "branch_coral_fan");
        createHammerRecipes(consumer, UABlocks.CHROME_CORAL.get(), UABlocks.CHROME_CORAL_FAN.get(), "chrome_coral_fan");
        createHammerRecipes(consumer, UABlocks.ELDER_PRISMARINE_CORAL.get(), UABlocks.ELDER_PRISMARINE_CORAL_FAN.get(), "elder_prismarine_coral_fan");
        createHammerRecipes(consumer, UABlocks.MOSS_CORAL.get(), UABlocks.MOSS_CORAL_FAN.get(), "moss_coral_fan");
        createHammerRecipes(consumer, UABlocks.PETAL_CORAL.get(), UABlocks.PETAL_CORAL_FAN.get(), "petal_coral_fan");
        createHammerRecipes(consumer, UABlocks.PILLOW_CORAL.get(), UABlocks.PILLOW_CORAL_FAN.get(), "pillow_coral_fan");
        createHammerRecipes(consumer, UABlocks.PRISMARINE_CORAL.get(), UABlocks.PRISMARINE_CORAL_FAN.get(), "prismarine_coral_fan");
        createHammerRecipes(consumer, UABlocks.ROCK_CORAL.get(), UABlocks.ROCK_CORAL_FAN.get(), "rock_coral_fan");
        createHammerRecipes(consumer, UABlocks.SILK_CORAL.get(), UABlocks.SILK_CORAL_FAN.get(), "silk_coral_fan");
        createHammerRecipes(consumer, UABlocks.STAR_CORAL.get(), UABlocks.STAR_CORAL_FAN.get(), "star_coral_fan");
    }

    private void registerHeatRecipes(@Nonnull final Consumer<FinishedRecipe> consumer) {
        createHeatRecipes(consumer, CCBlocks.CUPRIC_TORCH.get(), 1, "cuptic_torch");
        createHeatRecipes(consumer, EEBlocks.ENDER_TORCH.get(), 1, "ender_torch");
        createHeatRecipes(consumer, CCBlocks.CUPRIC_FIRE.get(), 4, "cupric_fire");
        createHeatRecipes(consumer, EEBlocks.ENDER_FIRE.get(), 4, "ender_fire");
//        createHeatRecipes(consumer, UABlocks.PINK_JELLY_TORCH.get(), 2, "pink_jelly_torch");
//        createHeatRecipes(consumer, UABlocks.PURPLE_JELLY_TORCH.get(), 2, "purple_jelly_torch");
//        createHeatRecipes(consumer, UABlocks.BLUE_JELLY_TORCH.get(), 2, "blue_jelly_torch");
//        createHeatRecipes(consumer, UABlocks.GREEN_JELLY_TORCH.get(), 2, "green_jelly_torch");
//        createHeatRecipes(consumer, UABlocks.YELLOW_JELLY_TORCH.get(), 2, "yellow_jelly_torch");
//        createHeatRecipes(consumer, UABlocks.ORANGE_JELLY_TORCH.get(), 2, "orange_jelly_torch");
//        createHeatRecipes(consumer, UABlocks.RED_JELLY_TORCH.get(), 2, "red_jelly_torch");
//        createHeatRecipes(consumer, UABlocks.WHITE_JELLY_TORCH.get(), 2, "white_jelly_torch");
        createHeatRecipes(consumer, CCBlocks.LAVA_LAMP.get(), 3, "lava_lamp");
        StatePropertiesPredicate lit =
                StatePropertiesPredicate.Builder.properties()
                        .hasProperty(BlockStateProperties.LIT, true)
                        .build();
        createHeatRecipes(consumer, CCBlocks.CUPRIC_CAMPFIRE.get(), 4, lit, "cupric_campfire");
        createHeatRecipes(consumer, EEBlocks.ENDER_CAMPFIRE.get(), 4, lit, "ender_campfire");
        createHeatRecipes(consumer, CCBlocks.BRAZIER.get(), 5, lit, "brazier");
        createHeatRecipes(consumer, CCBlocks.SOUL_BRAZIER.get(), 5, lit, "soul_brazier");
        createHeatRecipes(consumer, CCBlocks.CUPRIC_BRAZIER.get(), 5, lit, "cupric_brazier");
        createHeatRecipes(consumer, CCBlocks.ENDER_BRAZIER.get(), 5, lit, "ender_brazier");
    }

    private void registerCrucibleRecipes(@Nonnull final Consumer<FinishedRecipe> consumer) {
        createFiredCrucibleRecipes(consumer, AtmosphericBlocks.IVORY_TRAVERTINE.get(), 250, "ivory_travertine");
        createFiredCrucibleRecipes(consumer, AtmosphericBlocks.PEACH_TRAVERTINE.get(), 250, "peach_travertine");
        createFiredCrucibleRecipes(consumer, AtmosphericBlocks.PERSIMMON_TRAVERTINE.get(), 250, "persimmon_travertine");
        createFiredCrucibleRecipes(consumer, AtmosphericBlocks.SAFFRON_TRAVERTINE.get(), 250, "saffron_travertine");

        createFiredCrucibleRecipes(consumer, AtmosphericBlocks.IVORY_TRAVERTINE.get(), 200, "ivory_travertine_tuff");
        createFiredCrucibleRecipes(consumer, AtmosphericBlocks.PEACH_TRAVERTINE.get(), 200, "peach_travertine_tuff");
        createFiredCrucibleRecipes(consumer, AtmosphericBlocks.PERSIMMON_TRAVERTINE.get(), 200, "persimmon_travertine_tuff");
        createFiredCrucibleRecipes(consumer, AtmosphericBlocks.SAFFRON_TRAVERTINE.get(), 200, "saffron_travertine_tuff");
    }

    private void registerSieveRecipes(@Nonnull final Consumer<FinishedRecipe> consumer) {
        SieveRecipeBuilder.builder()
                .input(Ingredient.of(Blocks.SAND))
                .addResult(UABlocks.BEACHGRASS.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.03F))
                .build(consumer, sieveLoc("beachgrass"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(ItemTags.SAND))
                .addResult(ENAItems.ACAN_CORAL_LARVA.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_IRON.get().getType(), 0.05F))
                .isWaterlogged()
                .build(consumer, sieveLoc("seed_cyan_coral"));
        SieveRecipeBuilder.builder()
                .input(Ingredient.of(ItemTags.SAND))
                .addResult(ENAItems.BRANCH_CORAL_LARVA.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_IRON.get().getType(), 0.05F))
                .isWaterlogged()
                .build(consumer, sieveLoc("seed_black_coral"));
        SieveRecipeBuilder.builder()
                .input(Ingredient.of(ItemTags.SAND))
                .addResult(ENAItems.CHROME_CORAL_LARVA.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_IRON.get().getType(), 0.05F))
                .isWaterlogged()
                .build(consumer, sieveLoc("seed_gray_coral"));
        SieveRecipeBuilder.builder()
                .input(Ingredient.of(ItemTags.SAND))
                .addResult(ENAItems.ELDER_PRISMARINE_CORAL_LARVA.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_IRON.get().getType(), 0.025F))
                .isWaterlogged()
                .build(consumer, sieveLoc("seed_elder_prismarine_coral"));
        SieveRecipeBuilder.builder()
                .input(Ingredient.of(ItemTags.SAND))
                .addResult(ENAItems.MOSS_CORAL_LARVA.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_IRON.get().getType(), 0.05F))
                .isWaterlogged()
                .build(consumer, sieveLoc("seed_green_coral"));
        SieveRecipeBuilder.builder()
                .input(Ingredient.of(ItemTags.SAND))
                .addResult(ENAItems.PETAL_CORAL_LARVA.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_IRON.get().getType(), 0.05F))
                .isWaterlogged()
                .build(consumer, sieveLoc("seed_light_blue_coral"));
        SieveRecipeBuilder.builder()
                .input(Ingredient.of(ItemTags.SAND))
                .addResult(ENAItems.PILLOW_CORAL_LARVA.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_IRON.get().getType(), 0.05F))
                .isWaterlogged()
                .build(consumer, sieveLoc("seed_white_coral"));
        SieveRecipeBuilder.builder()
                .input(Ingredient.of(ItemTags.SAND))
                .addResult(ENAItems.PRISMARINE_CORAL_LARVA.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_IRON.get().getType(), 0.025F))
                .isWaterlogged()
                .build(consumer, sieveLoc("seed_prismarine_coral"));
        SieveRecipeBuilder.builder()
                .input(Ingredient.of(ItemTags.SAND))
                .addResult(ENAItems.ROCK_CORAL_LARVA.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_IRON.get().getType(), 0.05F))
                .isWaterlogged()
                .build(consumer, sieveLoc("seed_brown_coral"));
        SieveRecipeBuilder.builder()
                .input(Ingredient.of(ItemTags.SAND))
                .addResult(ENAItems.SILK_CORAL_LARVA.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_IRON.get().getType(), 0.05F))
                .isWaterlogged()
                .build(consumer, sieveLoc("seed_purple_coral"));
        SieveRecipeBuilder.builder()
                .input(Ingredient.of(ItemTags.SAND))
                .addResult(ENAItems.STAR_CORAL_LARVA.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_IRON.get().getType(), 0.05F))
                .isWaterlogged()
                .build(consumer, sieveLoc("seed_lime_coral"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(ItemTags.SAND))
                .addResult(UABlocks.TONGUE_KELP.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_IRON.get().getType(), 0.025F))
                .isWaterlogged()
                .build(consumer, sieveLoc("tongue_kelp"));
        SieveRecipeBuilder.builder()
                .input(Ingredient.of(ItemTags.SAND))
                .addResult(UABlocks.THORNY_KELP.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_IRON.get().getType(), 0.025F))
                .isWaterlogged()
                .build(consumer, sieveLoc("thorny_kelp"));
        SieveRecipeBuilder.builder()
                .input(Ingredient.of(ItemTags.SAND))
                .addResult(UABlocks.OCHRE_KELP.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_IRON.get().getType(), 0.025F))
                .isWaterlogged()
                .build(consumer, sieveLoc("ochre_kelp"));
        SieveRecipeBuilder.builder()
                .input(Ingredient.of(ItemTags.SAND))
                .addResult(UABlocks.POLAR_KELP.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_IRON.get().getType(), 0.025F))
                .isWaterlogged()
                .build(consumer, sieveLoc("polar_kelp"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(ItemTags.SAND))
                .addResult(UABlocks.DRIFTWOOD_LOG.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.05F))
                .isWaterlogged()
                .build(consumer, sieveLoc("driftwood"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(Blocks.DIRT))
                .addResult(AutumnityItems.FOUL_BERRY_PIPS.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.05F))
                .build(consumer, sieveLoc("foul_berry_pips"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(Blocks.DIRT))
                .addResult(NeapolitanItems.STRAWBERRY_PIPS.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.05F))
                .build(consumer, sieveLoc("strawberry_pips"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(Blocks.DIRT))
                .addResult(NeapolitanItems.ADZUKI_BEANS.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.05F))
                .build(consumer, sieveLoc("adzuki_beans"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(Blocks.DIRT))
                .addResult(EnvironmentalItems.CATTAIL_SEEDS.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.03F))
                .isWaterlogged()
                .build(consumer, sieveLoc("cattail_seeds"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(Blocks.DIRT))
                .addResult(UABlocks.PURPLE_PICKERELWEED.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.03F))
                .isWaterlogged()
                .build(consumer, sieveLoc("purple_pickerelweed"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(Blocks.DIRT))
                .addResult(UABlocks.BLUE_PICKERELWEED.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.03F))
                .isWaterlogged()
                .build(consumer, sieveLoc("blue_pickerelweed"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(Blocks.SAND))
                .addResult(NeapolitanBlocks.SMALL_BANANA_FROND.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.05F))
                .build(consumer, sieveLoc("banana_frond"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(Blocks.SAND))
                .addResult(NeapolitanItems.VANILLA_PODS.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.03F))
                .build(consumer, sieveLoc("vanilla_pods"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(Blocks.SAND))
                .addResult(NeapolitanItems.MINT_SPROUT.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.03F))
                .build(consumer, sieveLoc("mint_sprout"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(Blocks.SAND))
                .addResult(AtmosphericBlocks.PASSION_VINE.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.03F))
                .build(consumer, sieveLoc("passion_vine"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(AtmosphericBlocks.ARID_SAND.get()))
                .addResult(AtmosphericItems.ALOE_KERNELS.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.05F))
                .build(consumer, sieveLoc("aloe_kernels"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(AtmosphericBlocks.RED_ARID_SAND.get()))
                .addResult(AtmosphericItems.ALOE_KERNELS.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.05F))
                .build(consumer, sieveLoc("aloe_kernels_red"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(AtmosphericBlocks.ARID_SAND.get()))
                .addResult(AtmosphericBlocks.YUCCA_SAPLING.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.05F))
                .build(consumer, sieveLoc("yucca_sapling_arid"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(AtmosphericBlocks.RED_ARID_SAND.get()))
                .addResult(AtmosphericBlocks.YUCCA_SAPLING.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.05F))
                .build(consumer, sieveLoc("yucca_sapling_arid_red"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(Blocks.SAND))
                .addResult(AtmosphericBlocks.BARREL_CACTUS.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.03F))
                .build(consumer, sieveLoc("barrel_cactus"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(ItemTags.DIRT))
                .addResult(BGItems.SWEET_BERRY_PIPS.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.05F))
                .build(consumer, sieveLoc("sweet_berry_pips"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(ItemTags.DIRT))
                .addResult(BGItems.GLOW_BERRY_PIPS.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.05F))
                .build(consumer, sieveLoc("glow_berry_pips"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(ItemTags.DIRT))
                .addResult(ENAItems.CRUSTOSE_SPORE.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.05F))
                .build(consumer, sieveLoc("crustose_spores"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(Blocks.GRAVEL))
                .addResult(CCItems.SPINEL.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_FLINT.get().getType(), 0.05F))
                .build(consumer, sieveLoc("spinel"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(CCBlocks.ROCKY_DIRT.get()))
                .addResult(Blocks.DIRT)
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.4F))
                .build(consumer, sieveLoc("dirt_rd"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(CCBlocks.ROCKY_DIRT.get()))
                .addResult(Blocks.COBBLESTONE)
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.4F))
                .build(consumer, sieveLoc("cobblestone_rd"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(EEBlocks.EUMUS.get()))
                .addResult(EEBlocks.CORROCK_CROWN_END_STANDING.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.05F))
                .build(consumer, sieveLoc("corrock_crown"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(EEBlocks.EUMUS.get()))
                .addResult(EEBlocks.CORROCK_END.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.05F))
                .build(consumer, sieveLoc("corrock"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(EEBlocks.EUMUS.get()))
                .addResult(EEBlocks.POISE_BUSH.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.05F))
                .build(consumer, sieveLoc("poise_bush"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(EEBlocks.EUMUS.get()))
                .addResult(ENAItems.POISMOSS_SPORE.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.05F))
                .build(consumer, sieveLoc("poismoss_spore_eumus"));

        SieveRecipeBuilder.builder()
                .input(Ingredient.of(ExNihiloBlocks.CRUSHED_END_STONE.get()))
                .addResult(ENAItems.POISMOSS_SPORE.get())
                .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.05F))
                .build(consumer, sieveLoc("poismoss_spore_endstone"));

        getAbnormalsLeavesSaplings()
                .forEach(
                        (input, drop) -> {
                            @Nullable final ResourceLocation resourceLocation = ForgeRegistries.BLOCKS.getKey(input);
                            if (resourceLocation != null) {
                                SieveRecipeBuilder.builder()
                                        .input(Ingredient.of(input))
                                        .addResult(drop)
                                        .addRoll(new MeshWithChance(ExNihiloItems.MESH_STRING.get().getType(), 0.05F))
                                        .addRoll(new MeshWithChance(ExNihiloItems.MESH_FLINT.get().getType(), 0.1F))
                                        .addRoll(new MeshWithChance(ExNihiloItems.MESH_IRON.get().getType(), 0.15F))
                                        .addRoll(new MeshWithChance(ExNihiloItems.MESH_DIAMOND.get().getType(), 0.2F))
                                        .build(consumer, sieveLoc(resourceLocation.getPath()));
                            }
                        });
    }
}
