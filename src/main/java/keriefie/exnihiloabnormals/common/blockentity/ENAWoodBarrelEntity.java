package keriefie.exnihiloabnormals.common.blockentity;

import keriefie.exnihiloabnormals.common.init.ENABlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import novamachina.exnihilosequentia.common.blockentity.barrel.WoodBarrelEntity;

public class ENAWoodBarrelEntity extends WoodBarrelEntity {
    public ENAWoodBarrelEntity(BlockPos pos, BlockState state) {
        super(ENABlockEntities.WOODEN_BARREL_ENTITY.get(), pos, state);
    }
}
