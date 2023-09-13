package keriefie.exnihiloabnormals.datagen.common;


import com.teamabnormals.atmospheric.core.registry.AtmosphericBlocks;
import keriefie.exnihiloabnormals.ExNihiloAbnormals;
import keriefie.exnihiloabnormals.common.init.ENABlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import novamachina.exnihilosequentia.api.tag.ExNihiloTags;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ENABlockTagsGenerator extends BlockTagsProvider {

    public ENABlockTagsGenerator(
            DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, ExNihiloAbnormals.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ExNihiloTags.MINEABLE_WITH_HAMMER)
                .addTag(BlockTags.CORAL_PLANTS)
                .add(
                        AtmosphericBlocks.IVORY_TRAVERTINE.get(),
                        AtmosphericBlocks.PEACH_TRAVERTINE.get(),
                        AtmosphericBlocks.PERSIMMON_TRAVERTINE.get(),
                        AtmosphericBlocks.SAFFRON_TRAVERTINE.get()
                );
        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(
                        ENABlocks.CRUSHED_IVORY_TRAVERTINE.get(),
                        ENABlocks.CRUSHED_PEACH_TRAVERTINE.get(),
                        ENABlocks.CRUSHED_PERSIMMON_TRAVERTINE.get(),
                        ENABlocks.CRUSHED_SAFFRON_TRAVERTINE.get()
                );
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(
                        ENABlocks.BARREL_ASPEN.get(),
                        ENABlocks.BARREL_AZALEA.get(),
                        ENABlocks.BARREL_CHERRY.get(),
                        ENABlocks.BARREL_DRIFTWOOD.get(),
                        ENABlocks.BARREL_GRIMWOOD.get(),
                        ENABlocks.BARREL_KOUSA.get(),
                        ENABlocks.BARREL_MAPLE.get(),
                        ENABlocks.BARREL_MORADO.get(),
                        ENABlocks.BARREL_POISE.get(),
                        ENABlocks.BARREL_RIVER.get(),
                        ENABlocks.BARREL_ROSEWOOD.get(),
                        ENABlocks.BARREL_WILLOW.get(),
                        ENABlocks.BARREL_WISTERIA.get(),
                        ENABlocks.BARREL_YUCCA.get(),

                        ENABlocks.CRUCIBLE_ASPEN.get(),
                        ENABlocks.CRUCIBLE_AZALEA.get(),
                        ENABlocks.CRUCIBLE_CHERRY.get(),
                        ENABlocks.CRUCIBLE_DRIFTWOOD.get(),
                        ENABlocks.CRUCIBLE_GRIMWOOD.get(),
                        ENABlocks.CRUCIBLE_KOUSA.get(),
                        ENABlocks.CRUCIBLE_MAPLE.get(),
                        ENABlocks.CRUCIBLE_MORADO.get(),
                        ENABlocks.CRUCIBLE_POISE.get(),
                        ENABlocks.CRUCIBLE_RIVER.get(),
                        ENABlocks.CRUCIBLE_ROSEWOOD.get(),
                        ENABlocks.CRUCIBLE_WILLOW.get(),
                        ENABlocks.CRUCIBLE_WISTERIA.get(),
                        ENABlocks.CRUCIBLE_YUCCA.get(),

                        ENABlocks.SIEVE_ASPEN.get(),
                        ENABlocks.SIEVE_AZALEA.get(),
                        ENABlocks.SIEVE_CHERRY.get(),
                        ENABlocks.SIEVE_DRIFTWOOD.get(),
                        ENABlocks.SIEVE_GRIMWOOD.get(),
                        ENABlocks.SIEVE_KOUSA.get(),
                        ENABlocks.SIEVE_MAPLE.get(),
                        ENABlocks.SIEVE_MORADO.get(),
                        ENABlocks.SIEVE_POISE.get(),
                        ENABlocks.SIEVE_RIVER.get(),
                        ENABlocks.SIEVE_ROSEWOOD.get(),
                        ENABlocks.SIEVE_WILLOW.get(),
                        ENABlocks.SIEVE_WISTERIA.get(),
                        ENABlocks.SIEVE_YUCCA.get()
                );
    }

    @Nonnull
    @Override
    public String getName() {
        return "Block Tags: " + modId;
    }
}