package keriefie.exnihiloabnormals.common.blockentity;

import keriefie.exnihiloabnormals.common.init.ENABlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import novamachina.exnihilosequentia.common.blockentity.crucible.WoodCrucibleEntity;

public class ENAWoodCrucibleEntity extends WoodCrucibleEntity {
    public ENAWoodCrucibleEntity(BlockPos pos, BlockState state) {
        super(ENABlockEntities.WOODEN_CRUCIBLE_ENTITY.get(), pos, state);
    }
}
