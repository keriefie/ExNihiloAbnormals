package keriefie.exnihiloabnormals.common.init;

import keriefie.exnihiloabnormals.ExNihiloAbnormals;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(
        modid = ExNihiloAbnormals.MODID,
        bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ENAMCCompost {
    // MinecraftForge.EVENT_BUS
    @SubscribeEvent
    public static void setupNonTagBasedRegistries(@Nonnull final FMLCommonSetupEvent event) {
        registerVanillaCompost();
    }

    private static void registerVanillaCompost() {
        createMCCompost(ENAItems.CRUSTOSE_SPORE.get().asItem(), 0.3f);
        createMCCompost(ENAItems.POISMOSS_SPORE.get().asItem(), 0.3f);
    }

    private static void createMCCompost(Item item, float chance) {
        ComposterBlock.COMPOSTABLES.put(item, chance);
    }
}
