package keriefie.exnihiloabnormals.datagen.common;


import keriefie.exnihiloabnormals.ExNihiloAbnormals;
import keriefie.exnihiloabnormals.common.init.ENABlocks;
import net.minecraft.data.DataGenerator;
import novamachina.exnihilosequentia.datagen.api.datagen.AbstractLootTableGenerator;

import javax.annotation.Nonnull;

public class ENALootTableGenerator extends AbstractLootTableGenerator {

    public ENALootTableGenerator(@Nonnull final DataGenerator generator) {
        super(generator, ExNihiloAbnormals.MODID);
    }

    @Override
    protected void createLootTables() {
        registerSelfDrops();
    }

    private void registerSelfDrops() {
        registerSelfDrop(ENABlocks.CRUSHED_IVORY_TRAVERTINE.get());
        registerSelfDrop(ENABlocks.CRUSHED_PEACH_TRAVERTINE.get());
        registerSelfDrop(ENABlocks.CRUSHED_PERSIMMON_TRAVERTINE.get());
        registerSelfDrop(ENABlocks.CRUSHED_SAFFRON_TRAVERTINE.get());

        registerSelfDrop(ENABlocks.BARREL_ASPEN.get());
        registerSelfDrop(ENABlocks.BARREL_AZALEA.get());
        registerSelfDrop(ENABlocks.BARREL_CHERRY.get());
        registerSelfDrop(ENABlocks.BARREL_DRIFTWOOD.get());
        registerSelfDrop(ENABlocks.BARREL_GRIMWOOD.get());
        registerSelfDrop(ENABlocks.BARREL_KOUSA.get());
        registerSelfDrop(ENABlocks.BARREL_MAPLE.get());
        registerSelfDrop(ENABlocks.BARREL_MORADO.get());
        registerSelfDrop(ENABlocks.BARREL_POISE.get());
        registerSelfDrop(ENABlocks.BARREL_RIVER.get());
        registerSelfDrop(ENABlocks.BARREL_ROSEWOOD.get());
        registerSelfDrop(ENABlocks.BARREL_WILLOW.get());
        registerSelfDrop(ENABlocks.BARREL_WISTERIA.get());
        registerSelfDrop(ENABlocks.BARREL_YUCCA.get());

        registerSelfDrop(ENABlocks.CRUCIBLE_ASPEN.get());
        registerSelfDrop(ENABlocks.CRUCIBLE_AZALEA.get());
        registerSelfDrop(ENABlocks.CRUCIBLE_CHERRY.get());
        registerSelfDrop(ENABlocks.CRUCIBLE_DRIFTWOOD.get());
        registerSelfDrop(ENABlocks.CRUCIBLE_GRIMWOOD.get());
        registerSelfDrop(ENABlocks.CRUCIBLE_KOUSA.get());
        registerSelfDrop(ENABlocks.CRUCIBLE_MAPLE.get());
        registerSelfDrop(ENABlocks.CRUCIBLE_MORADO.get());
        registerSelfDrop(ENABlocks.CRUCIBLE_POISE.get());
        registerSelfDrop(ENABlocks.CRUCIBLE_RIVER.get());
        registerSelfDrop(ENABlocks.CRUCIBLE_ROSEWOOD.get());
        registerSelfDrop(ENABlocks.CRUCIBLE_WILLOW.get());
        registerSelfDrop(ENABlocks.CRUCIBLE_WISTERIA.get());
        registerSelfDrop(ENABlocks.CRUCIBLE_YUCCA.get());

        registerSelfDrop(ENABlocks.SIEVE_ASPEN.get());
        registerSelfDrop(ENABlocks.SIEVE_AZALEA.get());
        registerSelfDrop(ENABlocks.SIEVE_CHERRY.get());
        registerSelfDrop(ENABlocks.SIEVE_DRIFTWOOD.get());
        registerSelfDrop(ENABlocks.SIEVE_GRIMWOOD.get());
        registerSelfDrop(ENABlocks.SIEVE_KOUSA.get());
        registerSelfDrop(ENABlocks.SIEVE_MAPLE.get());
        registerSelfDrop(ENABlocks.SIEVE_MORADO.get());
        registerSelfDrop(ENABlocks.SIEVE_POISE.get());
        registerSelfDrop(ENABlocks.SIEVE_RIVER.get());
        registerSelfDrop(ENABlocks.SIEVE_ROSEWOOD.get());
        registerSelfDrop(ENABlocks.SIEVE_WILLOW.get());
        registerSelfDrop(ENABlocks.SIEVE_WISTERIA.get());
        registerSelfDrop(ENABlocks.SIEVE_YUCCA.get());
    }
}