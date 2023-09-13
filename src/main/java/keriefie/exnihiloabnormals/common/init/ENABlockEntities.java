package keriefie.exnihiloabnormals.common.init;

import keriefie.exnihiloabnormals.ExNihiloAbnormals;
import keriefie.exnihiloabnormals.common.blockentity.ENASieveEntity;
import keriefie.exnihiloabnormals.common.blockentity.ENAWoodBarrelEntity;
import keriefie.exnihiloabnormals.common.blockentity.ENAWoodCrucibleEntity;
import keriefie.exnihiloabnormals.common.utility.ENAConstants;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import novamachina.exnihilosequentia.common.blockentity.SieveEntity;
import novamachina.exnihilosequentia.common.blockentity.barrel.WoodBarrelEntity;
import novamachina.exnihilosequentia.common.blockentity.crucible.WoodCrucibleEntity;

import javax.annotation.Nonnull;

public class ENABlockEntities {
    @Nonnull
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES;
    @Nonnull
    public static final RegistryObject<BlockEntityType<? extends WoodBarrelEntity>> WOODEN_BARREL_ENTITY;
    @Nonnull
    public static final RegistryObject<BlockEntityType<? extends WoodCrucibleEntity>> WOODEN_CRUCIBLE_ENTITY;
    @Nonnull
    public static final RegistryObject<BlockEntityType<? extends SieveEntity>> SIEVE_ENTITY;

    static {}
    private ENABlockEntities() {}

    static {
        BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ExNihiloAbnormals.MODID);
        WOODEN_BARREL_ENTITY =
                BLOCK_ENTITIES.register(
                        ENAConstants.Blocks.BARRELS,
                        () -> BlockEntityType.Builder.of(
                                        ENAWoodBarrelEntity::new,
                                        new Block[]{
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
                                                ENABlocks.BARREL_YUCCA.get()
                                        }
                                ).build(null));
        WOODEN_CRUCIBLE_ENTITY =
                BLOCK_ENTITIES.register(
                        ENAConstants.Blocks.CRUCIBLES,
                        () ->
                                BlockEntityType.Builder.of(
                                        ENAWoodCrucibleEntity::new,
                                        new Block[]{
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
                                            ENABlocks.CRUCIBLE_YUCCA.get()
                                        }
                                ).build(null));
        SIEVE_ENTITY =
                BLOCK_ENTITIES.register(
                        ENAConstants.Blocks.SIEVES,
                        () ->
                                BlockEntityType.Builder.of(
                                        ENASieveEntity::new,
                                        new Block[]{
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
                                        }
                                ).build(null));
    }

    public static void init(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }
}
