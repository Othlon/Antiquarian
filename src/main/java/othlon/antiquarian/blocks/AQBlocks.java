package othlon.antiquarian.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import othlon.antiquarian.items.AQItems;

/**
 * Created by Jen on 16/02/2015.
 */
public class AQBlocks {

    private static final String CELTIC_TOPSOIL_NAME = "celticTopSoil";
    private static final String ROMAN_TOPSOIL_NAME = "romanTopSoil";

    public static AQDigBlock celticTopsoil = (AQDigBlock)new AQDigBlock(AQItems.celticFrag).setBlockName(CELTIC_TOPSOIL_NAME);
    public static AQDigBlock romanTopsoil  = (AQDigBlock)new AQDigBlock(AQItems.romanFrag).setBlockName(ROMAN_TOPSOIL_NAME);

    public static void doTheBlockThing(){
        GameRegistry.registerBlock(celticTopsoil, CELTIC_TOPSOIL_NAME);
        OreDictionary.registerOre("blockDirt", celticTopsoil);

        GameRegistry.registerBlock(romanTopsoil, ROMAN_TOPSOIL_NAME);
        OreDictionary.registerOre("blockDirt", romanTopsoil);
    }
}
