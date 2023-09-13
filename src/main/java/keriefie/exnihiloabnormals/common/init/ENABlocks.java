package keriefie.exnihiloabnormals.common.init;

import keriefie.exnihiloabnormals.ExNihiloAbnormals;
import keriefie.exnihiloabnormals.common.block.ENAWoodBarrelBlock;
import keriefie.exnihiloabnormals.common.block.ENAWoodCrucibleBlock;
import keriefie.exnihiloabnormals.common.block.ENAWoodSieveBlock;
import keriefie.exnihiloabnormals.common.utility.ENAConstants;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import novamachina.exnihilosequentia.common.block.BaseBlock;
import novamachina.exnihilosequentia.common.block.BaseFallingBlock;
import novamachina.exnihilosequentia.common.builder.BlockBuilder;

import javax.annotation.Nonnull;

public class ENABlocks {
    @Nonnull
    private static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExNihiloAbnormals.MODID);

    @Nonnull
    public static final RegistryObject<BaseFallingBlock> CRUSHED_IVORY_TRAVERTINE =
            BLOCKS.register(
                    ENAConstants.Blocks.CRUSHED_IVORY_TRAVERTINE,
                    () ->
                            new BaseFallingBlock(
                                    new BlockBuilder()
                                            .properties(
                                                    BlockBehaviour.Properties.of(Material.SAND)
                                                            .strength(0.7F)
                                                            .sound(SoundType.GRAVEL))));
    @Nonnull
    public static final RegistryObject<BaseFallingBlock> CRUSHED_PEACH_TRAVERTINE =
            BLOCKS.register(
                    ENAConstants.Blocks.CRUSHED_PEACH_TRAVERTINE,
                    () ->
                            new BaseFallingBlock(
                                    new BlockBuilder()
                                            .properties(
                                                    BlockBehaviour.Properties.of(Material.SAND)
                                                            .strength(0.7F)
                                                            .sound(SoundType.GRAVEL))));
    @Nonnull
    public static final RegistryObject<BaseFallingBlock> CRUSHED_PERSIMMON_TRAVERTINE =
            BLOCKS.register(
                    ENAConstants.Blocks.CRUSHED_PERSIMMON_TRAVERTINE,
                    () ->
                            new BaseFallingBlock(
                                    new BlockBuilder()
                                            .properties(
                                                    BlockBehaviour.Properties.of(Material.SAND)
                                                            .strength(0.7F)
                                                            .sound(SoundType.GRAVEL))));
    @Nonnull
    public static final RegistryObject<BaseFallingBlock> CRUSHED_SAFFRON_TRAVERTINE =
            BLOCKS.register(
                    ENAConstants.Blocks.CRUSHED_SAFFRON_TRAVERTINE,
                    () ->
                            new BaseFallingBlock(
                                    new BlockBuilder()
                                            .properties(
                                                    BlockBehaviour.Properties.of(Material.SAND)
                                                            .strength(0.7F)
                                                            .sound(SoundType.GRAVEL))));
    // Barrels
    @Nonnull
    public static final RegistryObject<BaseBlock> BARREL_ASPEN =
            BLOCKS.register(ENAConstants.Blocks.ASPEN_BARREL, ENAWoodBarrelBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> BARREL_AZALEA =
            BLOCKS.register(ENAConstants.Blocks.AZALEA_BARREL, ENAWoodBarrelBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> BARREL_CHERRY =
            BLOCKS.register(ENAConstants.Blocks.CHERRY_BARREL, ENAWoodBarrelBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> BARREL_DRIFTWOOD =
            BLOCKS.register(ENAConstants.Blocks.DRIFTWOOD_BARREL, ENAWoodBarrelBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> BARREL_GRIMWOOD =
            BLOCKS.register(ENAConstants.Blocks.GRIMWOOD_BARREL, ENAWoodBarrelBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> BARREL_KOUSA =
            BLOCKS.register(ENAConstants.Blocks.KOUSA_BARREL, ENAWoodBarrelBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> BARREL_MAPLE =
            BLOCKS.register(ENAConstants.Blocks.MAPLE_BARREL, ENAWoodBarrelBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> BARREL_MORADO =
            BLOCKS.register(ENAConstants.Blocks.MORADO_BARREL, ENAWoodBarrelBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> BARREL_POISE =
            BLOCKS.register(ENAConstants.Blocks.POISE_BARREL, ENAWoodBarrelBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> BARREL_RIVER =
            BLOCKS.register(ENAConstants.Blocks.RIVER_BARREL, ENAWoodBarrelBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> BARREL_ROSEWOOD =
            BLOCKS.register(ENAConstants.Blocks.ROSEWOOD_BARREL, ENAWoodBarrelBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> BARREL_WILLOW =
            BLOCKS.register(ENAConstants.Blocks.WILLOW_BARREL, ENAWoodBarrelBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> BARREL_WISTERIA =
            BLOCKS.register(ENAConstants.Blocks.WISTERIA_BARREL, ENAWoodBarrelBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> BARREL_YUCCA =
            BLOCKS.register(ENAConstants.Blocks.YUCCA_BARREL, ENAWoodBarrelBlock::new);
    // Crucibles
    @Nonnull
    public static final RegistryObject<BaseBlock> CRUCIBLE_ASPEN =
            BLOCKS.register(ENAConstants.Blocks.ASPEN_CRUCIBLE, ENAWoodCrucibleBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> CRUCIBLE_AZALEA =
            BLOCKS.register(ENAConstants.Blocks.AZALEA_CRUCIBLE, ENAWoodCrucibleBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> CRUCIBLE_CHERRY =
            BLOCKS.register(ENAConstants.Blocks.CHERRY_CRUCIBLE, ENAWoodCrucibleBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> CRUCIBLE_DRIFTWOOD =
            BLOCKS.register(ENAConstants.Blocks.DRIFTWOOD_CRUCIBLE, ENAWoodCrucibleBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> CRUCIBLE_GRIMWOOD =
            BLOCKS.register(ENAConstants.Blocks.GRIMWOOD_CRUCIBLE, ENAWoodCrucibleBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> CRUCIBLE_KOUSA =
            BLOCKS.register(ENAConstants.Blocks.KOUSA_CRUCIBLE, ENAWoodCrucibleBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> CRUCIBLE_MAPLE =
            BLOCKS.register(ENAConstants.Blocks.MAPLE_CRUCIBLE, ENAWoodCrucibleBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> CRUCIBLE_MORADO =
            BLOCKS.register(ENAConstants.Blocks.MORADO_CRUCIBLE, ENAWoodCrucibleBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> CRUCIBLE_POISE =
            BLOCKS.register(ENAConstants.Blocks.POISE_CRUCIBLE, ENAWoodCrucibleBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> CRUCIBLE_RIVER =
            BLOCKS.register(ENAConstants.Blocks.RIVER_CRUCIBLE, ENAWoodCrucibleBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> CRUCIBLE_ROSEWOOD =
            BLOCKS.register(ENAConstants.Blocks.ROSEWOOD_CRUCIBLE, ENAWoodCrucibleBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> CRUCIBLE_WILLOW =
            BLOCKS.register(ENAConstants.Blocks.WILLOW_CRUCIBLE, ENAWoodCrucibleBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> CRUCIBLE_WISTERIA =
            BLOCKS.register(ENAConstants.Blocks.WISTERIA_CRUCIBLE, ENAWoodCrucibleBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> CRUCIBLE_YUCCA =
            BLOCKS.register(ENAConstants.Blocks.YUCCA_CRUCIBLE, ENAWoodCrucibleBlock::new);
    // Sieves
    @Nonnull
    public static final RegistryObject<BaseBlock> SIEVE_ASPEN =
            BLOCKS.register(ENAConstants.Blocks.ASPEN_SIEVE, ENAWoodSieveBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> SIEVE_AZALEA =
            BLOCKS.register(ENAConstants.Blocks.AZALEA_SIEVE, ENAWoodSieveBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> SIEVE_CHERRY =
            BLOCKS.register(ENAConstants.Blocks.CHERRY_SIEVE, ENAWoodSieveBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> SIEVE_DRIFTWOOD =
            BLOCKS.register(ENAConstants.Blocks.DRIFTWOOD_SIEVE, ENAWoodSieveBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> SIEVE_GRIMWOOD =
            BLOCKS.register(ENAConstants.Blocks.GRIMWOOD_SIEVE, ENAWoodSieveBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> SIEVE_KOUSA =
            BLOCKS.register(ENAConstants.Blocks.KOUSA_SIEVE, ENAWoodSieveBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> SIEVE_MAPLE =
            BLOCKS.register(ENAConstants.Blocks.MAPLE_SIEVE, ENAWoodSieveBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> SIEVE_MORADO =
            BLOCKS.register(ENAConstants.Blocks.MORADO_SIEVE, ENAWoodSieveBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> SIEVE_POISE =
            BLOCKS.register(ENAConstants.Blocks.POISE_SIEVE, ENAWoodSieveBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> SIEVE_RIVER =
            BLOCKS.register(ENAConstants.Blocks.RIVER_SIEVE, ENAWoodSieveBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> SIEVE_ROSEWOOD =
            BLOCKS.register(ENAConstants.Blocks.ROSEWOOD_SIEVE, ENAWoodSieveBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> SIEVE_WILLOW =
            BLOCKS.register(ENAConstants.Blocks.WILLOW_SIEVE, ENAWoodSieveBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> SIEVE_WISTERIA =
            BLOCKS.register(ENAConstants.Blocks.WISTERIA_SIEVE, ENAWoodSieveBlock::new);
    @Nonnull
    public static final RegistryObject<BaseBlock> SIEVE_YUCCA =
            BLOCKS.register(ENAConstants.Blocks.YUCCA_SIEVE, ENAWoodSieveBlock::new);

    private ENABlocks() {}

    public static void init(@Nonnull final IEventBus bus) {
        BLOCKS.register(bus);
    }
}
