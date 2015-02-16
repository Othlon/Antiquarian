package othlon.antiquarian.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by Jen on 16/02/2015.
 */
public class AQBlocks {

    public static AQDigBlock digBlock = new AQDigBlock();

    public static void doTheBlockThing(){
        GameRegistry.registerBlock(digBlock, "ditsiteBlock");
        OreDictionary.registerOre("blockDirt", digBlock);
    }
}
