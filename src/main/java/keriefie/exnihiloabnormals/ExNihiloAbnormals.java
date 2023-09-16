package keriefie.exnihiloabnormals;


import com.mojang.logging.LogUtils;
import keriefie.exnihiloabnormals.client.setup.ENAClientSetup;
import keriefie.exnihiloabnormals.common.init.ENABlockEntities;
import keriefie.exnihiloabnormals.common.init.ENABlocks;
import keriefie.exnihiloabnormals.common.init.ENAItems;
import keriefie.exnihiloabnormals.common.init.ENAMCCompost;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import novamachina.exnihilosequentia.common.utility.ExNihiloLogger;

import javax.annotation.Nonnull;

@Mod(ExNihiloAbnormals.MODID)
public class ExNihiloAbnormals {
    public static final String MODID = "exnihiloabnormals";

    public ExNihiloAbnormals() {
        FMLJavaModLoadingContext context = FMLJavaModLoadingContext.get();
        IEventBus bus = context.getModEventBus();
        ENAItems.init(bus);
        ENABlocks.init(bus);
        ENABlockEntities.init(bus);

        bus.addListener(ENAMCCompost::setupNonTagBasedRegistries);
        bus.addListener(ENAClientSetup::init);
    }
}
