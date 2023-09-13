package keriefie.exnihiloabnormals.common.compat.jei;

import mezz.jei.api.ingredients.IIngredientType;
import net.minecraft.world.item.Item;
import novamachina.exnihilosequentia.common.block.BaseBlock;

public final class ENATypes {
    /**
     * @since 9.7.0
     */
    public static final IIngredientType<BaseBlock> BASE_BLOCK = new IIngredientType() {
        @Override
        public Class<? extends BaseBlock> getIngredientClass() {
            return BaseBlock.class;
        }

        public Item getItem(BaseBlock block) {
            return block.asItem();
        }
    };

    private ENATypes() {

    }
}
