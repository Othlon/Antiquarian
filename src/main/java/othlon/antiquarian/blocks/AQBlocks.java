package othlon.antiquarian.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import othlon.antiquarian.items.AQItems;

/**
 * Created by Jen on 16/02/2015.
 */
public class AQBlocks {

    public static AQDigBlock celticTopsoil = new AQDigBlock(AQItems.celticFrag);
    public static AQDigBlock romanTopsoil  = new AQDigBlock(AQItems.romanFrag);

    public static void doTheBlockThing(){
        GameRegistry.registerBlock(celticTopsoil, "celticTopsoil");
        OreDictionary.registerOre("blockDirt", celticTopsoil);

        GameRegistry.registerBlock(romanTopsoil, "romanTopsoil");
        OreDictionary.registerOre("blockDirt", romanTopsoil);
    }
}
