package keriefie.exnihiloabnormals.common.utility;

import cpw.mods.modlauncher.api.ITransformationService;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class ENAConstants {
    private ENAConstants() {}

    public static class Mods {
        public static final String JEI = "jei";

        public static final String ATMOSPHERIC = "atmospheric";
        public static final String AUTUMNITY = "autumnity";
        public static final String BUZZIER_BEES = "buzzier_bees";
        public static final String ENDERGETIC = "endergetic";
        public static final String ENVIRONMENTAL = "environmental";
        public static final String CAVERNS_AND_CHASMS = "caverns_and_chasms";
        public static final String CLAYWORKS = "clayworks";
        public static final String INCUBATION = "incubation";
        public static final String NEAPOLITAN = "neapolitan";
        public static final String NETHER_EXTENSION = "nether_extension";
        public static final String PET_CEMETERY = "pet_cemetery";
        public static final String UPGRADE_AQUATIC = "upgrade_aquatic";
        public static final String WOODWORKS = "woodworks";
    }

    public static class ModBlocks {
        public static final ResourceLocation CRUSTOSE = new ResourceLocation(Mods.ATMOSPHERIC, "crustose");
        public static final ResourceLocation ASPEN_LOG = new ResourceLocation(Mods.ATMOSPHERIC, "aspen_log");
        public static final ResourceLocation CRUSTOSE_LOG = new ResourceLocation(Mods.ATMOSPHERIC, "crustose_log");
        public static final ResourceLocation ASPEN_WOOD = new ResourceLocation(Mods.ATMOSPHERIC, "aspen_wood");
        public static final ResourceLocation CRUSTOSE_WOOD = new ResourceLocation(Mods.ATMOSPHERIC, "crustose_wood");
        public static final ResourceLocation POISMOSS = new ResourceLocation(Mods.ENDERGETIC, "poismoss");
        public static final ResourceLocation EUMUS = new ResourceLocation(Mods.ENDERGETIC, "eumus");
        public static final ResourceLocation EUMUS_POISMOSS = new ResourceLocation(Mods.ENDERGETIC, "eumus_poismoss");
    }

    public static class Items {
        public static final List<String> resourceList = new ArrayList<>();
        public static final String ACAN_CORAL_LARVA = createResourceName("acan_coral_larva");
        public static final String BRANCH_CORAL_LARVA = createResourceName("branch_coral_larva");
        public static final String CHROME_CORAL_LARVA = createResourceName("chrome_coral_larva");
        public static final String ELDER_PRISMARINE_CORAL_LARVA = createResourceName("elder_prismarine_coral_larva");
        public static final String MOSS_CORAL_LARVA = createResourceName("moss_coral_larva");
        public static final String PETAL_CORAL_LARVA = createResourceName("petal_coral_larva");
        public static final String PILLOW_CORAL_LARVA = createResourceName("pillow_coral_larva");
        public static final String PRISMARINE_CORAL_LARVA = createResourceName("prismarine_coral_larva");
        public static final String ROCK_CORAL_LARVA = createResourceName("rock_coral_larva");
        public static final String SILK_CORAL_LARVA = createResourceName("silk_coral_larva");
        public static final String STAR_CORAL_LARVA = createResourceName("star_coral_larva");

        public static final String CRUSTOSE_SPORE = createResourceName("crustose_spores");
        public static final String POISMOSS_SPORE = createResourceName("poismoss_spores");



        private static String createResourceName(final String name) {
            resourceList.add(name);
            return name;
        }
    }

    public static class Blocks {
        public static List<String> blocksList = new ArrayList<>();
        public static final String BARRELS = "barrels";
        public static final String CRUCIBLES = "crucibles";
        public static final String SIEVES = "sieves";
        // Stones
        public static final String CRUSHED_IVORY_TRAVERTINE = addBlockToList("crushed_ivory_travertine");
        public static final String CRUSHED_PEACH_TRAVERTINE = addBlockToList("crushed_peach_travertine");
        public static final String CRUSHED_PERSIMMON_TRAVERTINE = addBlockToList("crushed_persimmon_travertine");
        public static final String CRUSHED_SAFFRON_TRAVERTINE = addBlockToList("crushed_saffron_travertine");
        // Barrels
        public static final String ASPEN_BARREL = addBlockToList("aspen_barrel");
        public static final String AZALEA_BARREL = addBlockToList("azalea_barrel");
        public static final String CHERRY_BARREL = addBlockToList("cherry_barrel");
        public static final String DRIFTWOOD_BARREL = addBlockToList("driftwood_barrel");
        public static final String GRIMWOOD_BARREL = addBlockToList("grimwood_barrel");
        public static final String KOUSA_BARREL = addBlockToList("kousa_barrel");
        public static final String MAPLE_BARREL = addBlockToList("maple_barrel");
        public static final String MORADO_BARREL = addBlockToList("morado_barrel");
        public static final String POISE_BARREL = addBlockToList("poise_barrel");
        public static final String RIVER_BARREL = addBlockToList("river_barrel");
        public static final String ROSEWOOD_BARREL = addBlockToList("rosewood_barrel");
        public static final String WILLOW_BARREL = addBlockToList("willow_barrel");
        public static final String WISTERIA_BARREL = addBlockToList("wisteria_barrel");
        public static final String YUCCA_BARREL = addBlockToList("yucca_barrel");
        // Crucibles
        public static final String ASPEN_CRUCIBLE = addBlockToList("aspen_crucible");
        public static final String AZALEA_CRUCIBLE = addBlockToList("azalea_crucible");
        public static final String CHERRY_CRUCIBLE = addBlockToList("cherry_crucible");
        public static final String DRIFTWOOD_CRUCIBLE = addBlockToList("driftwood_crucible");
        public static final String GRIMWOOD_CRUCIBLE = addBlockToList("grimwood_crucible");
        public static final String KOUSA_CRUCIBLE = addBlockToList("kousa_crucible");
        public static final String MAPLE_CRUCIBLE = addBlockToList("maple_crucible");
        public static final String MORADO_CRUCIBLE = addBlockToList("morado_crucible");
        public static final String POISE_CRUCIBLE = addBlockToList("poise_crucible");
        public static final String RIVER_CRUCIBLE = addBlockToList("river_crucible");
        public static final String ROSEWOOD_CRUCIBLE = addBlockToList("rosewood_crucible");
        public static final String WILLOW_CRUCIBLE = addBlockToList("willow_crucible");
        public static final String WISTERIA_CRUCIBLE = addBlockToList("wisteria_crucible");
        public static final String YUCCA_CRUCIBLE = addBlockToList("yucca_crucible");
        // Sieves
        public static final String ASPEN_SIEVE = addBlockToList("aspen_sieve");
        public static final String AZALEA_SIEVE = addBlockToList("azalea_sieve");
        public static final String CHERRY_SIEVE = addBlockToList("cherry_sieve");
        public static final String DRIFTWOOD_SIEVE = addBlockToList("driftwood_sieve");
        public static final String GRIMWOOD_SIEVE = addBlockToList("grimwood_sieve");
        public static final String KOUSA_SIEVE = addBlockToList("kousa_sieve");
        public static final String MAPLE_SIEVE = addBlockToList("maple_sieve");
        public static final String MORADO_SIEVE = addBlockToList("morado_sieve");
        public static final String POISE_SIEVE = addBlockToList("poise_sieve");
        public static final String RIVER_SIEVE = addBlockToList("river_sieve");
        public static final String ROSEWOOD_SIEVE = addBlockToList("rosewood_sieve");
        public static final String WILLOW_SIEVE = addBlockToList("willow_sieve");
        public static final String WISTERIA_SIEVE = addBlockToList("wisteria_sieve");
        public static final String YUCCA_SIEVE = addBlockToList("yucca_sieve");


        private Blocks() {}

        private static String addBlockToList(final String name) {
            blocksList.add(name);
            return name;
        }
    }

}
