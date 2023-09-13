package keriefie.exnihiloabnormals.common.init;

import keriefie.exnihiloabnormals.ExNihiloAbnormals;
import keriefie.exnihiloabnormals.common.item.ENAResourceItem;
import keriefie.exnihiloabnormals.common.utility.ENAConstants;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import novamachina.exnihilosequentia.common.init.ExNihiloInitialization;
import novamachina.exnihilosequentia.common.item.ResourceItem;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(
        modid = ExNihiloAbnormals.MODID,
        bus = Mod.EventBusSubscriber.Bus.MOD
)
public class ENAItems {
    public static final List<RegistryObject<ResourceItem>> RESOURCE_ITEMS = new ArrayList<>();

    private static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExNihiloAbnormals.MODID);
    public static final RegistryObject<ResourceItem> ACAN_CORAL_LARVA =
            ITEMS.register(
                    ENAConstants.Items.ACAN_CORAL_LARVA,
                    () -> new ResourceItem(ENAConstants.Items.ACAN_CORAL_LARVA));
    public static final RegistryObject<ResourceItem> BRANCH_CORAL_LARVA =
            ITEMS.register(
                    ENAConstants.Items.BRANCH_CORAL_LARVA,
                    () -> new ResourceItem(ENAConstants.Items.BRANCH_CORAL_LARVA));
    public static final RegistryObject<ResourceItem> CHROME_CORAL_LARVA =
            ITEMS.register(
                    ENAConstants.Items.CHROME_CORAL_LARVA,
                    () -> new ResourceItem(ENAConstants.Items.CHROME_CORAL_LARVA));
    public static final RegistryObject<ResourceItem> ELDER_PRISMARINE_CORAL_LARVA =
            ITEMS.register(
                    ENAConstants.Items.ELDER_PRISMARINE_CORAL_LARVA,
                    () -> new ResourceItem(ENAConstants.Items.ELDER_PRISMARINE_CORAL_LARVA));
    public static final RegistryObject<ResourceItem> MOSS_CORAL_LARVA =
            ITEMS.register(
                    ENAConstants.Items.MOSS_CORAL_LARVA,
                    () -> new ResourceItem(ENAConstants.Items.MOSS_CORAL_LARVA));
    public static final RegistryObject<ResourceItem> PETAL_CORAL_LARVA =
            ITEMS.register(
                    ENAConstants.Items.PETAL_CORAL_LARVA,
                    () -> new ResourceItem(ENAConstants.Items.PETAL_CORAL_LARVA));
    public static final RegistryObject<ResourceItem> PILLOW_CORAL_LARVA =
            ITEMS.register(
                    ENAConstants.Items.PILLOW_CORAL_LARVA,
                    () -> new ResourceItem(ENAConstants.Items.PILLOW_CORAL_LARVA));
    public static final RegistryObject<ResourceItem> PRISMARINE_CORAL_LARVA =
            ITEMS.register(
                    ENAConstants.Items.PRISMARINE_CORAL_LARVA,
                    () -> new ResourceItem(ENAConstants.Items.PRISMARINE_CORAL_LARVA));
    public static final RegistryObject<ResourceItem> ROCK_CORAL_LARVA =
            ITEMS.register(
                    ENAConstants.Items.ROCK_CORAL_LARVA,
                    () -> new ResourceItem(ENAConstants.Items.ROCK_CORAL_LARVA));
    public static final RegistryObject<ResourceItem> SILK_CORAL_LARVA =
            ITEMS.register(
                    ENAConstants.Items.SILK_CORAL_LARVA,
                    () -> new ResourceItem(ENAConstants.Items.SILK_CORAL_LARVA));
    public static final RegistryObject<ResourceItem> STAR_CORAL_LARVA =
            ITEMS.register(
                    ENAConstants.Items.STAR_CORAL_LARVA,
                    () -> new ResourceItem(ENAConstants.Items.STAR_CORAL_LARVA));

    static boolean atmosphericPresent = ModList.get().isLoaded(ENAConstants.Mods.ATMOSPHERIC);
    static boolean endergeticPresent = ModList.get().isLoaded(ENAConstants.Mods.ENDERGETIC);
    static Block crustose = ForgeRegistries.BLOCKS.getValue(ENAConstants.ModBlocks.CRUSTOSE);
    static Block aspen_log = ForgeRegistries.BLOCKS.getValue(ENAConstants.ModBlocks.ASPEN_LOG);
    static Block crustose_log = ForgeRegistries.BLOCKS.getValue(ENAConstants.ModBlocks.CRUSTOSE_LOG);
    static Block aspen_wood = ForgeRegistries.BLOCKS.getValue(ENAConstants.ModBlocks.ASPEN_WOOD);
    static Block crustose_wood = ForgeRegistries.BLOCKS.getValue(ENAConstants.ModBlocks.CRUSTOSE_WOOD);
    static Block poismoss = ForgeRegistries.BLOCKS.getValue(ENAConstants.ModBlocks.POISMOSS);
    static Block eumus = ForgeRegistries.BLOCKS.getValue(ENAConstants.ModBlocks.EUMUS);
    static Block eumus_poismoss = ForgeRegistries.BLOCKS.getValue(ENAConstants.ModBlocks.EUMUS_POISMOSS);

    public static final RegistryObject<ResourceItem> CRUSTOSE_SPORE =
            ITEMS.register(
                    ENAConstants.Items.CRUSTOSE_SPORE,
                    () ->
                            new ENAResourceItem(

                                    ENAConstants.Items.CRUSTOSE_SPORE,
                                    Blocks.DIRT, atmosphericPresent ? crustose : null,
                                    atmosphericPresent ? aspen_log : null, atmosphericPresent ? crustose_log : null,
                                    atmosphericPresent ? aspen_wood : null, atmosphericPresent ? crustose_wood : null
                            )
            );
    public static final RegistryObject<ResourceItem> POISMOSS_SPORE =
            ITEMS.register(
                    ENAConstants.Items.POISMOSS_SPORE,
                    () ->
                            new ENAResourceItem(
                                    ENAConstants.Items.POISMOSS_SPORE,
                                    Blocks.END_STONE, endergeticPresent ? poismoss : null,
                                    endergeticPresent ? eumus : null, endergeticPresent ? eumus_poismoss : null
                            )
            );

    private static final Item.Properties tab =
            new Item.Properties().tab(ExNihiloInitialization.ITEM_GROUP);
    public static final RegistryObject<BlockItem> CRUSHED_IVORY_TRAVERTINE =
            ITEMS.register(
                    ENAConstants.Blocks.CRUSHED_IVORY_TRAVERTINE, () -> new BlockItem(ENABlocks.CRUSHED_IVORY_TRAVERTINE.get(), tab));
    public static final RegistryObject<BlockItem> CRUSHED_PEACH_TRAVERTINE =
            ITEMS.register(
                    ENAConstants.Blocks.CRUSHED_PEACH_TRAVERTINE, () -> new BlockItem(ENABlocks.CRUSHED_PEACH_TRAVERTINE.get(), tab));
    public static final RegistryObject<BlockItem> CRUSHED_PERSIMMON_TRAVERTINE =
            ITEMS.register(
                    ENAConstants.Blocks.CRUSHED_PERSIMMON_TRAVERTINE, () -> new BlockItem(ENABlocks.CRUSHED_PERSIMMON_TRAVERTINE.get(), tab));
    public static final RegistryObject<BlockItem> CRUSHED_SAFFRON_TRAVERTINE =
            ITEMS.register(
                    ENAConstants.Blocks.CRUSHED_SAFFRON_TRAVERTINE, () -> new BlockItem(ENABlocks.CRUSHED_SAFFRON_TRAVERTINE.get(), tab));
    // Barrels
    public static final RegistryObject<BlockItem> BARREL_ASPEN =
            ITEMS.register(
                    ENAConstants.Blocks.ASPEN_BARREL,
                    () -> createBurnableItem(ENABlocks.BARREL_ASPEN.get()));
    public static final RegistryObject<BlockItem> BARREL_AZALEA =
            ITEMS.register(
                    ENAConstants.Blocks.AZALEA_BARREL,
                    () -> createBurnableItem(ENABlocks.BARREL_AZALEA.get()));
    public static final RegistryObject<BlockItem> BARREL_CHERRY =
            ITEMS.register(
                    ENAConstants.Blocks.CHERRY_BARREL,
                    () -> createBurnableItem(ENABlocks.BARREL_CHERRY.get()));
    public static final RegistryObject<BlockItem> BARREL_DRIFTWOOD =
            ITEMS.register(
                    ENAConstants.Blocks.DRIFTWOOD_BARREL,
                    () -> createBurnableItem(ENABlocks.BARREL_DRIFTWOOD.get()));
    public static final RegistryObject<BlockItem> BARREL_GRIMWOOD =
            ITEMS.register(
                    ENAConstants.Blocks.GRIMWOOD_BARREL,
                    () -> createBurnableItem(ENABlocks.BARREL_GRIMWOOD.get()));
    public static final RegistryObject<BlockItem> BARREL_KOUSA =
            ITEMS.register(
                    ENAConstants.Blocks.KOUSA_BARREL,
                    () -> createBurnableItem(ENABlocks.BARREL_KOUSA.get()));
    public static final RegistryObject<BlockItem> BARREL_MAPLE =
            ITEMS.register(
                    ENAConstants.Blocks.MAPLE_BARREL,
                    () -> createBurnableItem(ENABlocks.BARREL_MAPLE.get()));
    public static final RegistryObject<BlockItem> BARREL_MORADO =
            ITEMS.register(
                    ENAConstants.Blocks.MORADO_BARREL,
                    () -> createBurnableItem(ENABlocks.BARREL_MORADO.get()));
    public static final RegistryObject<BlockItem> BARREL_POISE =
            ITEMS.register(
                    ENAConstants.Blocks.POISE_BARREL,
                    () -> createBurnableItem(ENABlocks.BARREL_POISE.get()));
    public static final RegistryObject<BlockItem> BARREL_RIVER =
            ITEMS.register(
                    ENAConstants.Blocks.RIVER_BARREL,
                    () -> createBurnableItem(ENABlocks.BARREL_RIVER.get()));
    public static final RegistryObject<BlockItem> BARREL_ROSEWOOD =
            ITEMS.register(
                    ENAConstants.Blocks.ROSEWOOD_BARREL,
                    () -> createBurnableItem(ENABlocks.BARREL_ROSEWOOD.get()));
    public static final RegistryObject<BlockItem> BARREL_WILLOW =
            ITEMS.register(
                    ENAConstants.Blocks.WILLOW_BARREL,
                    () -> createBurnableItem(ENABlocks.BARREL_WILLOW.get()));
    public static final RegistryObject<BlockItem> BARREL_WISTERIA =
            ITEMS.register(
                    ENAConstants.Blocks.WISTERIA_BARREL,
                    () -> createBurnableItem(ENABlocks.BARREL_WISTERIA.get()));
    public static final RegistryObject<BlockItem> BARREL_YUCCA =
            ITEMS.register(
                    ENAConstants.Blocks.YUCCA_BARREL,
                    () -> createBurnableItem(ENABlocks.BARREL_YUCCA.get()));
    // Crucibles
    public static final RegistryObject<BlockItem> CRUCIBLE_ASPEN =
            ITEMS.register(
                    ENAConstants.Blocks.ASPEN_CRUCIBLE,
                    () -> createBurnableItem(ENABlocks.CRUCIBLE_ASPEN.get()));
    public static final RegistryObject<BlockItem> CRUCIBLE_AZALEA =
            ITEMS.register(
                    ENAConstants.Blocks.AZALEA_CRUCIBLE,
                    () -> createBurnableItem(ENABlocks.CRUCIBLE_AZALEA.get()));
    public static final RegistryObject<BlockItem> CRUCIBLE_CHERRY =
            ITEMS.register(
                    ENAConstants.Blocks.CHERRY_CRUCIBLE,
                    () -> createBurnableItem(ENABlocks.CRUCIBLE_CHERRY.get()));
    public static final RegistryObject<BlockItem> CRUCIBLE_DRIFTWOOD =
            ITEMS.register(
                    ENAConstants.Blocks.DRIFTWOOD_CRUCIBLE,
                    () -> createBurnableItem(ENABlocks.CRUCIBLE_DRIFTWOOD.get()));
    public static final RegistryObject<BlockItem> CRUCIBLE_GRIMWOOD =
            ITEMS.register(
                    ENAConstants.Blocks.GRIMWOOD_CRUCIBLE,
                    () -> createBurnableItem(ENABlocks.CRUCIBLE_GRIMWOOD.get()));
    public static final RegistryObject<BlockItem> CRUCIBLE_KOUSA =
            ITEMS.register(
                    ENAConstants.Blocks.KOUSA_CRUCIBLE,
                    () -> createBurnableItem(ENABlocks.CRUCIBLE_KOUSA.get()));
    public static final RegistryObject<BlockItem> CRUCIBLE_MAPLE =
            ITEMS.register(
                    ENAConstants.Blocks.MAPLE_CRUCIBLE,
                    () -> createBurnableItem(ENABlocks.CRUCIBLE_MAPLE.get()));
    public static final RegistryObject<BlockItem> CRUCIBLE_MORADO =
            ITEMS.register(
                    ENAConstants.Blocks.MORADO_CRUCIBLE,
                    () -> createBurnableItem(ENABlocks.CRUCIBLE_MORADO.get()));
    public static final RegistryObject<BlockItem> CRUCIBLE_POISE =
            ITEMS.register(
                    ENAConstants.Blocks.POISE_CRUCIBLE,
                    () -> createBurnableItem(ENABlocks.CRUCIBLE_POISE.get()));
    public static final RegistryObject<BlockItem> CRUCIBLE_RIVER =
            ITEMS.register(
                    ENAConstants.Blocks.RIVER_CRUCIBLE,
                    () -> createBurnableItem(ENABlocks.CRUCIBLE_RIVER.get()));
    public static final RegistryObject<BlockItem> CRUCIBLE_ROSEWOOD =
            ITEMS.register(
                    ENAConstants.Blocks.ROSEWOOD_CRUCIBLE,
                    () -> createBurnableItem(ENABlocks.CRUCIBLE_ROSEWOOD.get()));
    public static final RegistryObject<BlockItem> CRUCIBLE_WILLOW =
            ITEMS.register(
                    ENAConstants.Blocks.WILLOW_CRUCIBLE,
                    () -> createBurnableItem(ENABlocks.CRUCIBLE_WILLOW.get()));
    public static final RegistryObject<BlockItem> CRUCIBLE_WISTERIA =
            ITEMS.register(
                    ENAConstants.Blocks.WISTERIA_CRUCIBLE,
                    () -> createBurnableItem(ENABlocks.CRUCIBLE_WISTERIA.get()));
    public static final RegistryObject<BlockItem> CRUCIBLE_YUCCA =
            ITEMS.register(
                    ENAConstants.Blocks.YUCCA_CRUCIBLE,
                    () -> createBurnableItem(ENABlocks.CRUCIBLE_YUCCA.get()));
    // Sieves
    public static final RegistryObject<BlockItem> SIEVE_ASPEN =
            ITEMS.register(
                    ENAConstants.Blocks.ASPEN_SIEVE,
                    () -> createBurnableItem(ENABlocks.SIEVE_ASPEN.get()));
    public static final RegistryObject<BlockItem> SIEVE_AZALEA =
            ITEMS.register(
                    ENAConstants.Blocks.AZALEA_SIEVE,
                    () -> createBurnableItem(ENABlocks.SIEVE_AZALEA.get()));
    public static final RegistryObject<BlockItem> SIEVE_CHERRY =
            ITEMS.register(
                    ENAConstants.Blocks.CHERRY_SIEVE,
                    () -> createBurnableItem(ENABlocks.SIEVE_CHERRY.get()));
    public static final RegistryObject<BlockItem> SIEVE_DRIFTWOOD =
            ITEMS.register(
                    ENAConstants.Blocks.DRIFTWOOD_SIEVE,
                    () -> createBurnableItem(ENABlocks.SIEVE_DRIFTWOOD.get()));
    public static final RegistryObject<BlockItem> SIEVE_GRIMWOOD =
            ITEMS.register(
                    ENAConstants.Blocks.GRIMWOOD_SIEVE,
                    () -> createBurnableItem(ENABlocks.SIEVE_GRIMWOOD.get()));
    public static final RegistryObject<BlockItem> SIEVE_KOUSA =
            ITEMS.register(
                    ENAConstants.Blocks.KOUSA_SIEVE,
                    () -> createBurnableItem(ENABlocks.SIEVE_KOUSA.get()));
    public static final RegistryObject<BlockItem> SIEVE_MAPLE =
            ITEMS.register(
                    ENAConstants.Blocks.MAPLE_SIEVE,
                    () -> createBurnableItem(ENABlocks.SIEVE_MAPLE.get()));
    public static final RegistryObject<BlockItem> SIEVE_MORADO =
            ITEMS.register(
                    ENAConstants.Blocks.MORADO_SIEVE,
                    () -> createBurnableItem(ENABlocks.SIEVE_MORADO.get()));
    public static final RegistryObject<BlockItem> SIEVE_POISE =
            ITEMS.register(
                    ENAConstants.Blocks.POISE_SIEVE,
                    () -> createBurnableItem(ENABlocks.SIEVE_POISE.get()));
    public static final RegistryObject<BlockItem> SIEVE_RIVER =
            ITEMS.register(
                    ENAConstants.Blocks.RIVER_SIEVE,
                    () -> createBurnableItem(ENABlocks.SIEVE_RIVER.get()));
    public static final RegistryObject<BlockItem> SIEVE_ROSEWOOD =
            ITEMS.register(
                    ENAConstants.Blocks.ROSEWOOD_SIEVE,
                    () -> createBurnableItem(ENABlocks.SIEVE_ROSEWOOD.get()));
    public static final RegistryObject<BlockItem> SIEVE_WILLOW =
            ITEMS.register(
                    ENAConstants.Blocks.WILLOW_SIEVE,
                    () -> createBurnableItem(ENABlocks.SIEVE_WILLOW.get()));
    public static final RegistryObject<BlockItem> SIEVE_WISTERIA =
            ITEMS.register(
                    ENAConstants.Blocks.WISTERIA_SIEVE,
                    () -> createBurnableItem(ENABlocks.SIEVE_WISTERIA.get()));
    public static final RegistryObject<BlockItem> SIEVE_YUCCA =
            ITEMS.register(
                    ENAConstants.Blocks.YUCCA_SIEVE,
                    () -> createBurnableItem(ENABlocks.SIEVE_YUCCA.get()));


    private static BlockItem createBurnableItem(@Nonnull final Block block) {
        return new BlockItem(block, tab) {
            @Override
            public int getBurnTime(
                    @Nonnull final ItemStack itemStack, @Nullable final RecipeType<?> recipeType) {
                return 400;
            }
        };
    }

    public static void init(@Nonnull final IEventBus bus) {
        ITEMS.register(bus);
    }
}
