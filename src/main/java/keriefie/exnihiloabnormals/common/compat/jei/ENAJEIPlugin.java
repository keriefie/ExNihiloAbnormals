package keriefie.exnihiloabnormals.common.compat.jei;

import keriefie.exnihiloabnormals.ExNihiloAbnormals;
import keriefie.exnihiloabnormals.common.init.ENABlocks;
import keriefie.exnihiloabnormals.common.init.ENAItems;
import keriefie.exnihiloabnormals.common.utility.ENAConstants;
import keriefie.exnihiloabnormals.common.utility.ENAConstants.Mods;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.RegistryObject;
import novamachina.exnihilosequentia.common.block.BaseBlock;
import novamachina.exnihilosequentia.common.compat.jei.RecipeTypes;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

@JeiPlugin
@SuppressWarnings("unused")
public class ENAJEIPlugin implements IModPlugin {
    static String MODID = ExNihiloAbnormals.MODID;

    @Nonnull
    private static final ResourceLocation CRUCIBLES =
            new ResourceLocation(
                    MODID, ENAConstants.Blocks.CRUCIBLES);

    @Nonnull
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(
                Mods.JEI, MODID);
    }

    protected void addItemAsItemStack(List<ItemStack> list, ItemLike item) {
        list.add(new ItemStack(item));
    }

    @Override
    public void registerRecipes(@Nonnull final IRecipeRegistration registration) {
        IIngredientManager manager = registration.getIngredientManager();

        List<ItemStack> ingredientsToRemove = new ArrayList<>();

        ModList modList = ModList.get();

        if (!modList.isLoaded(Mods.ATMOSPHERIC)) {
            addItemAsItemStack(ingredientsToRemove, ENABlocks.BARREL_ASPEN.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.BARREL_GRIMWOOD.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.BARREL_KOUSA.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.BARREL_MORADO.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.BARREL_ROSEWOOD.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.BARREL_YUCCA.get().asItem());

            addItemAsItemStack(ingredientsToRemove, ENABlocks.CRUCIBLE_ASPEN.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.CRUCIBLE_GRIMWOOD.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.CRUCIBLE_KOUSA.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.CRUCIBLE_MORADO.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.CRUCIBLE_ROSEWOOD.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.CRUCIBLE_YUCCA.get().asItem());

            addItemAsItemStack(ingredientsToRemove, ENABlocks.SIEVE_ASPEN.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.SIEVE_GRIMWOOD.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.SIEVE_KOUSA.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.SIEVE_MORADO.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.SIEVE_ROSEWOOD.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.SIEVE_YUCCA.get().asItem());

            addItemAsItemStack(ingredientsToRemove, ENAItems.CRUSTOSE_SPORE.get().asItem());
        }
        if (!modList.isLoaded(Mods.AUTUMNITY)) {
            addItemAsItemStack(ingredientsToRemove, ENABlocks.BARREL_MAPLE.get().asItem());

            addItemAsItemStack(ingredientsToRemove, ENABlocks.CRUCIBLE_MAPLE.get().asItem());

            addItemAsItemStack(ingredientsToRemove, ENABlocks.SIEVE_MAPLE.get().asItem());
        }
        if (!modList.isLoaded(Mods.CAVERNS_AND_CHASMS)) {
            addItemAsItemStack(ingredientsToRemove, ENABlocks.BARREL_AZALEA.get().asItem());

            addItemAsItemStack(ingredientsToRemove, ENABlocks.CRUCIBLE_AZALEA.get().asItem());

            addItemAsItemStack(ingredientsToRemove, ENABlocks.SIEVE_AZALEA.get().asItem());
        }
        if (!modList.isLoaded(Mods.ENDERGETIC)) {
            addItemAsItemStack(ingredientsToRemove, ENABlocks.BARREL_POISE.get().asItem());

            addItemAsItemStack(ingredientsToRemove, ENABlocks.CRUCIBLE_POISE.get().asItem());

            addItemAsItemStack(ingredientsToRemove, ENABlocks.SIEVE_POISE.get().asItem());

            addItemAsItemStack(ingredientsToRemove, ENAItems.POISMOSS_SPORE.get().asItem());
        }
        if (!modList.isLoaded(Mods.ENVIRONMENTAL)) {
            addItemAsItemStack(ingredientsToRemove, ENABlocks.BARREL_CHERRY.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.BARREL_WILLOW.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.BARREL_WISTERIA.get().asItem());

            addItemAsItemStack(ingredientsToRemove, ENABlocks.CRUCIBLE_CHERRY.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.CRUCIBLE_WILLOW.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.CRUCIBLE_WISTERIA.get().asItem());

            addItemAsItemStack(ingredientsToRemove, ENABlocks.SIEVE_CHERRY.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.SIEVE_WILLOW.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.SIEVE_WISTERIA.get().asItem());
        }
        if (!modList.isLoaded(Mods.UPGRADE_AQUATIC)) {
            addItemAsItemStack(ingredientsToRemove, ENABlocks.BARREL_DRIFTWOOD.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.BARREL_RIVER.get().asItem());

            addItemAsItemStack(ingredientsToRemove, ENABlocks.CRUCIBLE_DRIFTWOOD.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.CRUCIBLE_RIVER.get().asItem());

            addItemAsItemStack(ingredientsToRemove, ENABlocks.SIEVE_DRIFTWOOD.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENABlocks.SIEVE_RIVER.get().asItem());

            addItemAsItemStack(ingredientsToRemove, ENAItems.ACAN_CORAL_LARVA.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENAItems.BRANCH_CORAL_LARVA.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENAItems.CHROME_CORAL_LARVA.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENAItems.ELDER_PRISMARINE_CORAL_LARVA.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENAItems.MOSS_CORAL_LARVA.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENAItems.PETAL_CORAL_LARVA.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENAItems.PILLOW_CORAL_LARVA.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENAItems.PRISMARINE_CORAL_LARVA.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENAItems.ROCK_CORAL_LARVA.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENAItems.SILK_CORAL_LARVA.get().asItem());
            addItemAsItemStack(ingredientsToRemove, ENAItems.STAR_CORAL_LARVA.get().asItem());
        }

        manager.removeIngredientsAtRuntime(VanillaTypes.ITEM_STACK, ingredientsToRemove);
    }

    @Override
    public void registerRecipeCatalysts(@Nonnull final IRecipeCatalystRegistration registration) {
        registerBarrels(registration);
        registerCrucibles(registration);
        registerSieves(registration);
    }

    protected void addBarrel(@Nonnull final IRecipeCatalystRegistration registration, RegistryObject<BaseBlock> barrel) {
        registration.addRecipeCatalyst(
                new ItemStack(barrel.get()),
                RecipeTypes.FLUID_ON_TOP,
                RecipeTypes.FLUID_TRANSFORM,
                RecipeTypes.FLUID_ITEM,
                RecipeTypes.COMPOST);
    }

    protected void addCrucible(@Nonnull final IRecipeCatalystRegistration registration, RegistryObject<BaseBlock> crucible) {
        registration.addRecipeCatalyst(
                new ItemStack(crucible.get()),
                RecipeTypes.CRUCIBLE,
                RecipeTypes.HEAT);
    }

    protected void addSieve(@Nonnull final IRecipeCatalystRegistration registration, RegistryObject<BaseBlock> sieve) {
        registration.addRecipeCatalyst(
                new ItemStack(sieve.get()),
                RecipeTypes.DRY_SIEVE,
                RecipeTypes.WET_SIEVE);
    }

    private void registerBarrels(@Nonnull final IRecipeCatalystRegistration registration) {
        addBarrel(registration, ENABlocks.BARREL_ASPEN);
        addBarrel(registration, ENABlocks.BARREL_AZALEA);
        addBarrel(registration, ENABlocks.BARREL_CHERRY);
        addBarrel(registration, ENABlocks.BARREL_DRIFTWOOD);
        addBarrel(registration, ENABlocks.BARREL_GRIMWOOD);
        addBarrel(registration, ENABlocks.BARREL_KOUSA);
        addBarrel(registration, ENABlocks.BARREL_MAPLE);
        addBarrel(registration, ENABlocks.BARREL_MORADO);
        addBarrel(registration, ENABlocks.BARREL_POISE);
        addBarrel(registration, ENABlocks.BARREL_RIVER);
        addBarrel(registration, ENABlocks.BARREL_ROSEWOOD);
        addBarrel(registration, ENABlocks.BARREL_WILLOW);
        addBarrel(registration, ENABlocks.BARREL_WISTERIA);
        addBarrel(registration, ENABlocks.BARREL_YUCCA);
    }

    private void registerCrucibles(@Nonnull final IRecipeCatalystRegistration registration) {
        addCrucible(registration, ENABlocks.CRUCIBLE_ASPEN);
        addCrucible(registration, ENABlocks.CRUCIBLE_AZALEA);
        addCrucible(registration, ENABlocks.CRUCIBLE_CHERRY);
        addCrucible(registration, ENABlocks.CRUCIBLE_DRIFTWOOD);
        addCrucible(registration, ENABlocks.CRUCIBLE_GRIMWOOD);
        addCrucible(registration, ENABlocks.CRUCIBLE_KOUSA);
        addCrucible(registration, ENABlocks.CRUCIBLE_MAPLE);
        addCrucible(registration, ENABlocks.CRUCIBLE_MORADO);
        addCrucible(registration, ENABlocks.CRUCIBLE_POISE);
        addCrucible(registration, ENABlocks.CRUCIBLE_RIVER);
        addCrucible(registration, ENABlocks.CRUCIBLE_ROSEWOOD);
        addCrucible(registration, ENABlocks.CRUCIBLE_WILLOW);
        addCrucible(registration, ENABlocks.CRUCIBLE_WISTERIA);
        addCrucible(registration, ENABlocks.CRUCIBLE_YUCCA);
    }

    private void registerSieves(@Nonnull final IRecipeCatalystRegistration registration) {
        addSieve(registration, ENABlocks.SIEVE_ASPEN);
        addSieve(registration, ENABlocks.SIEVE_AZALEA);
        addSieve(registration, ENABlocks.SIEVE_CHERRY);
        addSieve(registration, ENABlocks.SIEVE_DRIFTWOOD);
        addSieve(registration, ENABlocks.SIEVE_GRIMWOOD);
        addSieve(registration, ENABlocks.SIEVE_KOUSA);
        addSieve(registration, ENABlocks.SIEVE_MAPLE);
        addSieve(registration, ENABlocks.SIEVE_MORADO);
        addSieve(registration, ENABlocks.SIEVE_POISE);
        addSieve(registration, ENABlocks.SIEVE_RIVER);
        addSieve(registration, ENABlocks.SIEVE_ROSEWOOD);
        addSieve(registration, ENABlocks.SIEVE_WILLOW);
        addSieve(registration, ENABlocks.SIEVE_WISTERIA);
        addSieve(registration, ENABlocks.SIEVE_YUCCA);
    }
}
