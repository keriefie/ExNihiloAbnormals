package keriefie.exnihiloabnormals.datagen;

import keriefie.exnihiloabnormals.datagen.client.ENABlockStateGenerator;
import keriefie.exnihiloabnormals.datagen.client.ENAItemGenerator;
import keriefie.exnihiloabnormals.datagen.client.ENALangGenerator;
import keriefie.exnihiloabnormals.datagen.common.ENABlockTagsGenerator;
import keriefie.exnihiloabnormals.datagen.common.ENAItemTagsGenerator;
import keriefie.exnihiloabnormals.datagen.common.ENARecipeGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ENADataGenerators {

    private ENADataGenerators() {
    }

    @SubscribeEvent
    public static void gatherData(@Nonnull final GatherDataEvent event) {
        @Nonnull final DataGenerator generator = event.getGenerator();

        if (event.includeServer()) {
            // Recipes
            generator.addProvider(true, new ENARecipeGenerator(generator));
            // LootTable
            // generator.addProvider(true, new ExNihiloLootTableGenerator(generator));
            // Tags
            generator.addProvider(
                    true,
                    new ENAItemTagsGenerator(
                            generator,
                            new ENABlockTagsGenerator(
                                    generator,
                                    event.getExistingFileHelper()),
                            event.getExistingFileHelper()));
//            generator.addProvider(
//                    true, new ExNihiloFluidTagsGenerator(generator, event.getExistingFileHelper()));
            generator.addProvider(
                    true, new ENABlockTagsGenerator(generator, event.getExistingFileHelper()));
        }
        if (event.includeClient()) {
            // BlockStates
            generator.addProvider(
                    true, new ENABlockStateGenerator(generator, event.getExistingFileHelper()));
            // Items
            generator.addProvider(
                    true, new ENAItemGenerator(generator, event.getExistingFileHelper()));
            // Ores
//            generator.addProvider(
//                    true, new ExNihiloOreItemGenerator(generator, event.getExistingFileHelper()));
            // Lang
            generator.addProvider(true, new ENALangGenerator(generator, "en_us"));
        }
    }
}
