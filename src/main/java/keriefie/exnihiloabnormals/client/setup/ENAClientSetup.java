package keriefie.exnihiloabnormals.client.setup;

import keriefie.exnihiloabnormals.ExNihiloAbnormals;
import keriefie.exnihiloabnormals.common.init.ENABlockEntities;
import keriefie.exnihiloabnormals.common.init.ENABlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import novamachina.exnihilosequentia.client.render.BarrelRender;
import novamachina.exnihilosequentia.client.render.CrucibleRender;
import novamachina.exnihilosequentia.client.render.SieveRender;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(
        modid = ExNihiloAbnormals.MODID,
        value = Dist.CLIENT,
        bus = Mod.EventBusSubscriber.Bus.MOD)
public class ENAClientSetup {
    private ENAClientSetup() {}

    public static void init(@Nonnull final FMLClientSetupEvent event) {
        registerBarrelRenderLayer();
        registerCrucibleRenderLayer();
        registerSieveRenderLayer();

        BarrelRender.register(ENABlockEntities.WOODEN_BARREL_ENTITY.get());
        CrucibleRender.register(ENABlockEntities.WOODEN_CRUCIBLE_ENTITY.get());
        SieveRender.register(ENABlockEntities.SIEVE_ENTITY.get());
    }

    private static void registerBarrelRenderLayer() {
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.BARREL_ASPEN.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.BARREL_AZALEA.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.BARREL_CHERRY.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.BARREL_DRIFTWOOD.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.BARREL_GRIMWOOD.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.BARREL_KOUSA.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.BARREL_MAPLE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.BARREL_MORADO.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.BARREL_POISE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.BARREL_RIVER.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.BARREL_ROSEWOOD.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.BARREL_WILLOW.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.BARREL_WISTERIA.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.BARREL_YUCCA.get(), RenderType.cutoutMipped());
    }

    private static void registerCrucibleRenderLayer() {
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.CRUCIBLE_ASPEN.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.CRUCIBLE_AZALEA.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.CRUCIBLE_CHERRY.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.CRUCIBLE_DRIFTWOOD.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.CRUCIBLE_GRIMWOOD.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.CRUCIBLE_KOUSA.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.CRUCIBLE_MAPLE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.CRUCIBLE_MORADO.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.CRUCIBLE_POISE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.CRUCIBLE_RIVER.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.CRUCIBLE_ROSEWOOD.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.CRUCIBLE_WILLOW.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.CRUCIBLE_WISTERIA.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.CRUCIBLE_YUCCA.get(), RenderType.cutoutMipped());
    }

    private static void registerSieveRenderLayer() {
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.SIEVE_ASPEN.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.SIEVE_AZALEA.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.SIEVE_CHERRY.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.SIEVE_DRIFTWOOD.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.SIEVE_GRIMWOOD.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.SIEVE_KOUSA.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.SIEVE_MAPLE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.SIEVE_MORADO.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.SIEVE_POISE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.SIEVE_RIVER.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.SIEVE_ROSEWOOD.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.SIEVE_WILLOW.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.SIEVE_WISTERIA.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(
                ENABlocks.SIEVE_YUCCA.get(), RenderType.cutoutMipped());
    }
}

