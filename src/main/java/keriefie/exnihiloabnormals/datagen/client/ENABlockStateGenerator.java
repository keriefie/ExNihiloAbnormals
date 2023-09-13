package keriefie.exnihiloabnormals.datagen.client;


import keriefie.exnihiloabnormals.ExNihiloAbnormals;
import keriefie.exnihiloabnormals.common.init.ENABlocks;
import keriefie.exnihiloabnormals.common.utility.ENAConstants.Mods;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import novamachina.exnihilosequentia.datagen.api.datagen.AbstractBlockStateGenerator;

import javax.annotation.Nonnull;

public class ENABlockStateGenerator extends AbstractBlockStateGenerator {

    public ENABlockStateGenerator(
            @Nonnull final DataGenerator gen, @Nonnull final ExistingFileHelper exFileHelper) {
        super(gen, ExNihiloAbnormals.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerSimpleBlocks();
        registerBarrels();
        registerCrucibles();
        registerSieves();
    }

    private void registerBarrels() {
        createBarrel(
                ENABlocks.BARREL_ASPEN.get(),
                enaLoc("block/aspen_barrel"),
                modLoc(Mods.ATMOSPHERIC, "block/aspen_planks"));
        createBarrel(
                ENABlocks.BARREL_GRIMWOOD.get(),
                enaLoc("block/grimwood_barrel"),
                modLoc(Mods.ATMOSPHERIC, "block/grimwood_planks"));
        createBarrel(
                ENABlocks.BARREL_KOUSA.get(),
                enaLoc("block/kousa_barrel"),
                modLoc(Mods.ATMOSPHERIC, "block/kousa_planks"));
        createBarrel(
                ENABlocks.BARREL_MORADO.get(),
                enaLoc("block/morado_barrel"),
                modLoc(Mods.ATMOSPHERIC, "block/morado_planks"));
        createBarrel(
                ENABlocks.BARREL_ROSEWOOD.get(),
                enaLoc("block/rosewood_barrel"),
                modLoc(Mods.ATMOSPHERIC, "block/rosewood_planks"));
        createBarrel(
                ENABlocks.BARREL_YUCCA.get(),
                enaLoc("block/yucca_barrel"),
                modLoc(Mods.ATMOSPHERIC, "block/yucca_planks"));
        createBarrel(
                ENABlocks.BARREL_MAPLE.get(),
                enaLoc("block/maple_barrel"),
                modLoc(Mods.AUTUMNITY, "block/maple_planks"));
        createBarrel(
                ENABlocks.BARREL_AZALEA.get(),
                enaLoc("block/azalea_barrel"),
                modLoc(Mods.CAVERNS_AND_CHASMS, "block/azalea_planks"));
        createBarrel(
                ENABlocks.BARREL_POISE.get(),
                enaLoc("block/poise_barrel"),
                modLoc(Mods.ENDERGETIC, "block/poise_planks"));
        createBarrel(
                ENABlocks.BARREL_CHERRY.get(),
                enaLoc("block/cherry_barrel"),
                modLoc(Mods.ENVIRONMENTAL, "block/cherry_planks"));
        createBarrel(
                ENABlocks.BARREL_WILLOW.get(),
                enaLoc("block/willow_barrel"),
                modLoc(Mods.ENVIRONMENTAL, "block/willow_planks"));
        createBarrel(
                ENABlocks.BARREL_WISTERIA.get(),
                enaLoc("block/wisteria_barrel"),
                modLoc(Mods.ENVIRONMENTAL, "block/wisteria_planks"));
        createBarrel(
                ENABlocks.BARREL_DRIFTWOOD.get(),
                enaLoc("block/driftwood_barrel"),
                modLoc(Mods.UPGRADE_AQUATIC, "block/driftwood_planks"));
        createBarrel(
                ENABlocks.BARREL_RIVER.get(),
                enaLoc("block/river_barrel"),
                modLoc(Mods.UPGRADE_AQUATIC, "block/river_planks"));
    }

    private void registerCrucibles() {
        createCrucible(
                ENABlocks.CRUCIBLE_ASPEN.get(),
                enaLoc("block/aspen_crucible"),
                modLoc(Mods.ATMOSPHERIC, "block/aspen_planks"));
        createCrucible(
                ENABlocks.CRUCIBLE_GRIMWOOD.get(),
                enaLoc("block/grimwood_crucible"),
                modLoc(Mods.ATMOSPHERIC, "block/grimwood_planks"));
        createCrucible(
                ENABlocks.CRUCIBLE_KOUSA.get(),
                enaLoc("block/kousa_crucible"),
                modLoc(Mods.ATMOSPHERIC, "block/kousa_planks"));
        createCrucible(
                ENABlocks.CRUCIBLE_MORADO.get(),
                enaLoc("block/morado_crucible"),
                modLoc(Mods.ATMOSPHERIC, "block/morado_planks"));
        createCrucible(
                ENABlocks.CRUCIBLE_ROSEWOOD.get(),
                enaLoc("block/rosewood_crucible"),
                modLoc(Mods.ATMOSPHERIC, "block/rosewood_planks"));
        createCrucible(
                ENABlocks.CRUCIBLE_YUCCA.get(),
                enaLoc("block/yucca_crucible"),
                modLoc(Mods.ATMOSPHERIC, "block/yucca_planks"));
        createCrucible(
                ENABlocks.CRUCIBLE_MAPLE.get(),
                enaLoc("block/maple_crucible"),
                modLoc(Mods.AUTUMNITY, "block/maple_planks"));
        createCrucible(
                ENABlocks.CRUCIBLE_AZALEA.get(),
                enaLoc("block/azalea_crucible"),
                modLoc(Mods.CAVERNS_AND_CHASMS, "block/azalea_planks"));
        createCrucible(
                ENABlocks.CRUCIBLE_POISE.get(),
                enaLoc("block/poise_crucible"),
                modLoc(Mods.ENDERGETIC, "block/poise_planks"));
        createCrucible(
                ENABlocks.CRUCIBLE_CHERRY.get(),
                enaLoc("block/cherry_crucible"),
                modLoc(Mods.ENVIRONMENTAL, "block/cherry_planks"));
        createCrucible(
                ENABlocks.CRUCIBLE_WILLOW.get(),
                enaLoc("block/willow_crucible"),
                modLoc(Mods.ENVIRONMENTAL, "block/willow_planks"));
        createCrucible(
                ENABlocks.CRUCIBLE_WISTERIA.get(),
                enaLoc("block/wisteria_crucible"),
                modLoc(Mods.ENVIRONMENTAL, "block/wisteria_planks"));
        createCrucible(
                ENABlocks.CRUCIBLE_DRIFTWOOD.get(),
                enaLoc("block/driftwood_crucible"),
                modLoc(Mods.UPGRADE_AQUATIC, "block/driftwood_planks"));
        createCrucible(
                ENABlocks.CRUCIBLE_RIVER.get(),
                enaLoc("block/river_crucible"),
                modLoc(Mods.UPGRADE_AQUATIC, "block/river_planks"));
    }

    private void registerSieves() {
        createSieve(
                ENABlocks.SIEVE_ASPEN.get(),
                enaLoc("block/aspen_sieve"),
                modLoc(Mods.ATMOSPHERIC, "block/aspen_planks"));
        createSieve(
                ENABlocks.SIEVE_GRIMWOOD.get(),
                enaLoc("block/grimwood_sieve"),
                modLoc(Mods.ATMOSPHERIC, "block/grimwood_planks"));
        createSieve(
                ENABlocks.SIEVE_KOUSA.get(),
                enaLoc("block/kousa_sieve"),
                modLoc(Mods.ATMOSPHERIC, "block/kousa_planks"));
        createSieve(
                ENABlocks.SIEVE_MORADO.get(),
                enaLoc("block/morado_sieve"),
                modLoc(Mods.ATMOSPHERIC, "block/morado_planks"));
        createSieve(
                ENABlocks.SIEVE_ROSEWOOD.get(),
                enaLoc("block/rosewood_sieve"),
                modLoc(Mods.ATMOSPHERIC, "block/rosewood_planks"));
        createSieve(
                ENABlocks.SIEVE_YUCCA.get(),
                enaLoc("block/yucca_sieve"),
                modLoc(Mods.ATMOSPHERIC, "block/yucca_planks"));
        createSieve(
                ENABlocks.SIEVE_MAPLE.get(),
                enaLoc("block/maple_sieve"),
                modLoc(Mods.AUTUMNITY, "block/maple_planks"));
        createSieve(
                ENABlocks.SIEVE_AZALEA.get(),
                enaLoc("block/azalea_sieve"),
                modLoc(Mods.CAVERNS_AND_CHASMS, "block/azalea_planks"));
        createSieve(
                ENABlocks.SIEVE_POISE.get(),
                enaLoc("block/poise_sieve"),
                modLoc(Mods.ENDERGETIC, "block/poise_planks"));
        createSieve(
                ENABlocks.SIEVE_CHERRY.get(),
                enaLoc("block/cherry_sieve"),
                modLoc(Mods.ENVIRONMENTAL, "block/cherry_planks"));
        createSieve(
                ENABlocks.SIEVE_WILLOW.get(),
                enaLoc("block/willow_sieve"),
                modLoc(Mods.ENVIRONMENTAL, "block/willow_planks"));
        createSieve(
                ENABlocks.SIEVE_WISTERIA.get(),
                enaLoc("block/wisteria_sieve"),
                modLoc(Mods.ENVIRONMENTAL, "block/wisteria_planks"));
        createSieve(
                ENABlocks.SIEVE_DRIFTWOOD.get(),
                enaLoc("block/driftwood_sieve"),
                modLoc(Mods.UPGRADE_AQUATIC, "block/driftwood_planks"));
        createSieve(
                ENABlocks.SIEVE_RIVER.get(),
                enaLoc("block/river_sieve"),
                modLoc(Mods.UPGRADE_AQUATIC, "block/river_planks"));
    }

    private void registerSimpleBlocks() {
        basicBlock(ENABlocks.CRUSHED_IVORY_TRAVERTINE.get());
        basicBlock(ENABlocks.CRUSHED_PEACH_TRAVERTINE.get());
        basicBlock(ENABlocks.CRUSHED_PERSIMMON_TRAVERTINE.get());
        basicBlock(ENABlocks.CRUSHED_SAFFRON_TRAVERTINE.get());
    }

    protected ResourceLocation enaLoc(String string) {
        return new ResourceLocation(ExNihiloAbnormals.MODID, string);
    }

    protected ResourceLocation modLoc(String mod, String string) {
        return new ResourceLocation(mod, string);
//        return vanillaLoc("block/oak_planks");
    }
}
