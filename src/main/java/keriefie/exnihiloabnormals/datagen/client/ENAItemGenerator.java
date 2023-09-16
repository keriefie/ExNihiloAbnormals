package keriefie.exnihiloabnormals.datagen.client;

import keriefie.exnihiloabnormals.ExNihiloAbnormals;
import keriefie.exnihiloabnormals.common.init.ENAItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import novamachina.exnihilosequentia.common.item.ResourceItem;
import novamachina.exnihilosequentia.datagen.api.datagen.AbstractItemGenerator;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ENAItemGenerator extends AbstractItemGenerator {

    private static final String ITEMS_TAG = "item/";
    private static final String ITEM_HANDHELD_TAG = "item/handheld";
    private static final String ITEM_GENERATED_TAG = "item/generated";
    private static final String LAYER_0_TAG = "layer0";

    public ENAItemGenerator(
            @Nonnull final DataGenerator generator,
            @Nonnull final ExistingFileHelper existingFileHelper) {
        super(generator, ExNihiloAbnormals.MODID, existingFileHelper);
    }

    private void registerResource(ItemLike item) {
        @Nullable final ResourceLocation resourceLocation = ForgeRegistries.ITEMS.getKey(item.asItem());
        if (resourceLocation == null) {
            return;
        }

        singleTexture(
                resourceLocation.getPath(),
                new ResourceLocation(ITEM_GENERATED_TAG),
                LAYER_0_TAG,
                new ResourceLocation(modid, ITEMS_TAG + resourceLocation.getPath()));
    }

    private void registerResources() {
        registerResource(ENAItems.ACAN_CORAL_LARVA.get());
        registerResource(ENAItems.BRANCH_CORAL_LARVA.get());
        registerResource(ENAItems.CHROME_CORAL_LARVA.get());
        registerResource(ENAItems.ELDER_PRISMARINE_CORAL_LARVA.get());
        registerResource(ENAItems.FINGER_CORAL_LARVA.get());
        registerResource(ENAItems.MOSS_CORAL_LARVA.get());
        registerResource(ENAItems.PETAL_CORAL_LARVA.get());
        registerResource(ENAItems.PILLOW_CORAL_LARVA.get());
        registerResource(ENAItems.PRISMARINE_CORAL_LARVA.get());
        registerResource(ENAItems.ROCK_CORAL_LARVA.get());
        registerResource(ENAItems.SILK_CORAL_LARVA.get());
        registerResource(ENAItems.STAR_CORAL_LARVA.get());

        registerResource(ENAItems.CRUSTOSE_SPORE.get());
        registerResource(ENAItems.POISMOSS_SPORE.get());
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<ResourceItem> resourceItem : ENAItems.RESOURCE_ITEMS) {
            registerResource(resourceItem.get());
        }

        registerResources();
    }
}
