package keriefie.exnihiloabnormals.common.blockentity;

import keriefie.exnihiloabnormals.common.init.ENABlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import novamachina.exnihilosequentia.common.block.BlockSieve;
import novamachina.exnihilosequentia.common.blockentity.SieveEntity;

import javax.annotation.Nonnull;

public class ENASieveEntity extends SieveEntity {
    public ENASieveEntity(BlockPos pos, BlockState state) {
        super(ENABlockEntities.SIEVE_ENTITY.get(), pos, state);
    }
}
