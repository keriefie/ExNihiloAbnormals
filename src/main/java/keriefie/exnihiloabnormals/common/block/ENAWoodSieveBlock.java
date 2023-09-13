package keriefie.exnihiloabnormals.common.block;

import keriefie.exnihiloabnormals.common.blockentity.ENASieveEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import novamachina.exnihilosequentia.common.block.BlockSieve;
import novamachina.exnihilosequentia.common.block.sieves.WoodSieveBlock;
import novamachina.exnihilosequentia.common.blockentity.SieveEntity;
import novamachina.exnihilosequentia.common.builder.BlockBuilder;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ENAWoodSieveBlock extends WoodSieveBlock {
    public ENAWoodSieveBlock() {
        super();
    }

    @Override
    @Nullable
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new ENASieveEntity(pos, state);
    }
}
