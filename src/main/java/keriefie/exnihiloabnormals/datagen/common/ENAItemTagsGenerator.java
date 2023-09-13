package keriefie.exnihiloabnormals.datagen.common;

import com.teamabnormals.autumnity.core.registry.AutumnityItems;
import com.teamabnormals.environmental.core.registry.EnvironmentalItems;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import keriefie.exnihiloabnormals.ExNihiloAbnormals;
import keriefie.exnihiloabnormals.common.init.ENABlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import novamachina.exnihilosequentia.api.tag.ExNihiloTags;
import novamachina.exnihilosequentia.datagen.api.datagen.AbstractItemTagGenerator;

import javax.annotation.Nonnull;

public class ENAItemTagsGenerator extends AbstractItemTagGenerator {
    public ENAItemTagsGenerator(
            @Nonnull final DataGenerator generator,
            @Nonnull final BlockTagsProvider blockTagsProvider,
            @Nonnull final ExistingFileHelper existingFileHelper) {
        super(
                generator,
                blockTagsProvider,
                ExNihiloAbnormals.MODID,
                existingFileHelper);
    }

    @Override
    protected void addTags() {
        registerMeats();
        registerWoodenBarrel();
        registerWoodenCrucible();
        registerWoodenSieve();
    }

    private void registerMeats() {
        registerUncooked();
        registerCooked();
    }

    private void registerUncooked() {
        tag(ExNihiloTags.MEAT_UNCOOKED).add(AutumnityItems.TURKEY_PIECE.get());
        tag(ExNihiloTags.MEAT_UNCOOKED).add(EnvironmentalItems.DUCK.get());
        tag(ExNihiloTags.MEAT_UNCOOKED).add(NeapolitanItems.MINT_CHOPS.get());
    }

    private void registerCooked() {
        tag(ExNihiloTags.MEAT_COOKED).add(AutumnityItems.COOKED_TURKEY_PIECE.get());
        tag(ExNihiloTags.MEAT_COOKED).add(EnvironmentalItems.COOKED_DUCK.get());
        tag(ExNihiloTags.MEAT_COOKED).add(NeapolitanItems.COOKED_MINT_CHOPS.get());
    }

    private void registerWoodenBarrel() {
        tag(ExNihiloTags.BARREL).add(ENABlocks.BARREL_ASPEN.get().asItem());
        tag(ExNihiloTags.BARREL).add(ENABlocks.BARREL_AZALEA.get().asItem());
        tag(ExNihiloTags.BARREL).add(ENABlocks.BARREL_CHERRY.get().asItem());
        tag(ExNihiloTags.BARREL).add(ENABlocks.BARREL_DRIFTWOOD.get().asItem());
        tag(ExNihiloTags.BARREL).add(ENABlocks.BARREL_GRIMWOOD.get().asItem());
        tag(ExNihiloTags.BARREL).add(ENABlocks.BARREL_KOUSA.get().asItem());
        tag(ExNihiloTags.BARREL).add(ENABlocks.BARREL_MAPLE.get().asItem());
        tag(ExNihiloTags.BARREL).add(ENABlocks.BARREL_MORADO.get().asItem());
        tag(ExNihiloTags.BARREL).add(ENABlocks.BARREL_POISE.get().asItem());
        tag(ExNihiloTags.BARREL).add(ENABlocks.BARREL_RIVER.get().asItem());
        tag(ExNihiloTags.BARREL).add(ENABlocks.BARREL_ROSEWOOD.get().asItem());
        tag(ExNihiloTags.BARREL).add(ENABlocks.BARREL_WILLOW.get().asItem());
        tag(ExNihiloTags.BARREL).add(ENABlocks.BARREL_WISTERIA.get().asItem());
        tag(ExNihiloTags.BARREL).add(ENABlocks.BARREL_YUCCA.get().asItem());
    }

    private void registerWoodenCrucible() {
        tag(ExNihiloTags.CRUCIBLE).add(ENABlocks.CRUCIBLE_ASPEN.get().asItem());
        tag(ExNihiloTags.CRUCIBLE).add(ENABlocks.CRUCIBLE_AZALEA.get().asItem());
        tag(ExNihiloTags.CRUCIBLE).add(ENABlocks.CRUCIBLE_CHERRY.get().asItem());
        tag(ExNihiloTags.CRUCIBLE).add(ENABlocks.CRUCIBLE_DRIFTWOOD.get().asItem());
        tag(ExNihiloTags.CRUCIBLE).add(ENABlocks.CRUCIBLE_GRIMWOOD.get().asItem());
        tag(ExNihiloTags.CRUCIBLE).add(ENABlocks.CRUCIBLE_KOUSA.get().asItem());
        tag(ExNihiloTags.CRUCIBLE).add(ENABlocks.CRUCIBLE_MAPLE.get().asItem());
        tag(ExNihiloTags.CRUCIBLE).add(ENABlocks.CRUCIBLE_MORADO.get().asItem());
        tag(ExNihiloTags.CRUCIBLE).add(ENABlocks.CRUCIBLE_POISE.get().asItem());
        tag(ExNihiloTags.CRUCIBLE).add(ENABlocks.CRUCIBLE_RIVER.get().asItem());
        tag(ExNihiloTags.CRUCIBLE).add(ENABlocks.CRUCIBLE_ROSEWOOD.get().asItem());
        tag(ExNihiloTags.CRUCIBLE).add(ENABlocks.CRUCIBLE_WILLOW.get().asItem());
        tag(ExNihiloTags.CRUCIBLE).add(ENABlocks.CRUCIBLE_WISTERIA.get().asItem());
        tag(ExNihiloTags.CRUCIBLE).add(ENABlocks.CRUCIBLE_YUCCA.get().asItem());
    }

    private void registerWoodenSieve() {
        tag(ExNihiloTags.SIEVE).add(ENABlocks.SIEVE_ASPEN.get().asItem());
        tag(ExNihiloTags.SIEVE).add(ENABlocks.SIEVE_AZALEA.get().asItem());
        tag(ExNihiloTags.SIEVE).add(ENABlocks.SIEVE_CHERRY.get().asItem());
        tag(ExNihiloTags.SIEVE).add(ENABlocks.SIEVE_DRIFTWOOD.get().asItem());
        tag(ExNihiloTags.SIEVE).add(ENABlocks.SIEVE_GRIMWOOD.get().asItem());
        tag(ExNihiloTags.SIEVE).add(ENABlocks.SIEVE_KOUSA.get().asItem());
        tag(ExNihiloTags.SIEVE).add(ENABlocks.SIEVE_MAPLE.get().asItem());
        tag(ExNihiloTags.SIEVE).add(ENABlocks.SIEVE_MORADO.get().asItem());
        tag(ExNihiloTags.SIEVE).add(ENABlocks.SIEVE_POISE.get().asItem());
        tag(ExNihiloTags.SIEVE).add(ENABlocks.SIEVE_RIVER.get().asItem());
        tag(ExNihiloTags.SIEVE).add(ENABlocks.SIEVE_ROSEWOOD.get().asItem());
        tag(ExNihiloTags.SIEVE).add(ENABlocks.SIEVE_WILLOW.get().asItem());
        tag(ExNihiloTags.SIEVE).add(ENABlocks.SIEVE_WISTERIA.get().asItem());
        tag(ExNihiloTags.SIEVE).add(ENABlocks.SIEVE_YUCCA.get().asItem());
    }
}
