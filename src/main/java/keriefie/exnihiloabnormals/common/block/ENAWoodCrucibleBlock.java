package keriefie.exnihiloabnormals.common.block;

import keriefie.exnihiloabnormals.common.blockentity.ENAWoodCrucibleEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import novamachina.exnihilosequentia.common.block.crucibles.WoodCrucibleBlock;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ENAWoodCrucibleBlock extends WoodCrucibleBlock {
    public ENAWoodCrucibleBlock() {
        super();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new ENAWoodCrucibleEntity(pos, state);
    }
}
