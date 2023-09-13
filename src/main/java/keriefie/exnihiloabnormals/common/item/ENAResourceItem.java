package keriefie.exnihiloabnormals.common.item;

import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import novamachina.exnihilosequentia.common.item.ResourceItem;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

public class ENAResourceItem extends ResourceItem {
    @Nonnull
    private final String resourceName;
    private Block tiggerBlock1;
    private BlockState replaceBlock1;
    private Block tiggerBlock2;
    private BlockState replaceBlock2;
    private Block tiggerBlock3;
    private BlockState replaceBlock3;

    public ENAResourceItem(@NotNull String name, Block tiggerBlock1, Block replaceBlock1, Block tiggerBlock2, Block replaceBlock2) {
        super(name);
        this.resourceName = name;
        this.tiggerBlock1 = tiggerBlock1;
        this.replaceBlock1 = replaceBlock1 == null ? null : replaceBlock1.defaultBlockState();
        this.tiggerBlock2 = tiggerBlock2;
        this.replaceBlock2 = replaceBlock2 == null ? null : replaceBlock2.defaultBlockState();
    }

    public ENAResourceItem(@NotNull String name, Block tiggerBlock1, Block replaceBlock1, Block tiggerBlock2, Block replaceBlock2, Block tiggerBlock3, Block replaceBlock3) {
        super(name);
        this.resourceName = name;
        this.tiggerBlock1 = tiggerBlock1;
        this.replaceBlock1 = replaceBlock1 == null ? null : replaceBlock1.defaultBlockState();
        this.tiggerBlock2 = tiggerBlock2;
        this.replaceBlock2 = replaceBlock2 == null ? null : replaceBlock2.defaultBlockState();
        this.tiggerBlock3 = tiggerBlock3;
        this.replaceBlock3 = replaceBlock3 == null ? null : replaceBlock3.defaultBlockState();
    }

    @Override
    public @NotNull InteractionResult useOn(@Nonnull UseOnContext context) {


        if (this.getTriggerBlock1() != null && this.getReplaceBlock1() != null && this.getTriggerBlock2() != null && this.getReplaceBlock2() != null) {
            BlockState state = context.getLevel().getBlockState(context.getClickedPos());
            Block block = state.getBlock();

            if (block.equals(this.getTriggerBlock1())) {
                BlockState replaceBlock = this.getReplaceBlock1();
                if (!context.getPlayer().isCreative()) {
                    context.getItemInHand().shrink(1);
                }
                Block.updateOrDestroy(state, replaceBlock, context.getLevel(), context.getClickedPos(), 1);
                return InteractionResult.SUCCESS;
            } else if (state.getBlock().equals(this.getTriggerBlock2())) {
                BlockState replaceBlock;
                if (!context.getPlayer().isCreative()) {
                    context.getItemInHand().shrink(1);
                }
                if (this.getTriggerBlock3() != null && this.getReplaceBlock3() != null) {;
                    Direction.Axis axis = state.getValue(BlockStateProperties.AXIS);
                    replaceBlock = this.getReplaceBlock2().setValue(BlockStateProperties.AXIS, axis);
                } else {
                    replaceBlock = this.getReplaceBlock2();
                }

                Block.updateOrDestroy(state, replaceBlock, context.getLevel(), context.getClickedPos(), 1);
                return InteractionResult.SUCCESS;
            } else if (this.getTriggerBlock3() != null && this.getReplaceBlock3() != null && state.getBlock().equals(this.getTriggerBlock3())) {
                Direction.Axis axis = state.getValue(BlockStateProperties.AXIS);
                if (!context.getPlayer().isCreative()) {
                    context.getItemInHand().shrink(1);
                }
                BlockState replaceBlock = this.getReplaceBlock3().setValue(BlockStateProperties.AXIS, axis);

                Block.updateOrDestroy(state, replaceBlock, context.getLevel(), context.getClickedPos(), 1);
                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.FAIL;
            }
        } else {
            return InteractionResult.PASS;
        }
    }

    private Block getTriggerBlock1() {
        return this.tiggerBlock1;
    }

    private BlockState getReplaceBlock1() {
        return this.replaceBlock1;
    }

    private Block getTriggerBlock2() {
        return this.tiggerBlock2;
    }

    private BlockState getReplaceBlock2() {
        return this.replaceBlock2;
    }

    private Block getTriggerBlock3() {
        return this.tiggerBlock3;
    }

    private BlockState getReplaceBlock3() {
        return this.replaceBlock3;
    }
}
