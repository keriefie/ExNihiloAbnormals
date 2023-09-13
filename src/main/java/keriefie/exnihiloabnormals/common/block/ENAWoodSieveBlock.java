package keriefie.exnihiloabnormals.common.block;

import keriefie.exnihiloabnormals.common.blockentity.ENASieveEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import novamachina.exnihilosequentia.common.block.sieves.WoodSieveBlock;

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
