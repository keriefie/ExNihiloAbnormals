package keriefie.exnihiloabnormals.common.block;

import keriefie.exnihiloabnormals.common.blockentity.ENAWoodBarrelEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import novamachina.exnihilosequentia.common.block.barrels.WoodBarrelBlock;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ENAWoodBarrelBlock extends WoodBarrelBlock {
    public ENAWoodBarrelBlock() {
        super();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new ENAWoodBarrelEntity(pos, state);
    }
}
