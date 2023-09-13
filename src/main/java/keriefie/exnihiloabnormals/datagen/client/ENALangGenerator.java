package keriefie.exnihiloabnormals.datagen.client;


import keriefie.exnihiloabnormals.ExNihiloAbnormals;
import keriefie.exnihiloabnormals.common.utility.ENAConstants;
import net.minecraft.data.DataGenerator;
import novamachina.exnihilosequentia.datagen.api.datagen.AbstractLangGenerator;

public class ENALangGenerator extends AbstractLangGenerator {

    public ENALangGenerator(DataGenerator gen, String locale) {
        super(gen, ExNihiloAbnormals.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        // CreativeTab
        // add("itemGroup." + ExNihiloAbnormals.MODID, "Ex Nihilo: Sequentia");
        // Blocks
        addBlock();
        // Items
        addItem();
    }

    @Override
    protected void addBlockAutoName(String block) {
        String BLOCK_LANG = "block."+ExNihiloAbnormals.MODID+".";
        this.add(BLOCK_LANG + block, this.properNaming(block));
    }

    private void addBlock() {
        for (int i = 0; i < ENAConstants.Blocks.blocksList.size(); i++) {
            addBlockAutoName(ENAConstants.Blocks.blocksList.get(i));
        }
    }

    private void addItem() {
        // Resources
        for (String name : ENAConstants.Items.resourceList) {
            addItemAutoName(name);
        }
    }
}
