package othlon.antiquarian;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import othlon.antiquarian.blocks.AQBlocks;
import othlon.antiquarian.helpers.AQTab;
import othlon.antiquarian.items.AQItems;
import othlon.antiquarian.proxies.CommonProxy;

/**
 * Created by jen on 19/07/2014.
 */

@Mod (modid="Antiquarian")
public class antiquarian {

    @SidedProxy(clientSide ="othlon.antiquarian.proxies.ClientProxy", serverSide = "othlon.antiquarian.proxie.CommonProxy" )
    public static CommonProxy proxy;

    public static CreativeTabs tabAntiQ;



    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        tabAntiQ = new AQTab(CreativeTabs.getNextID(), "CherryPigTab");
        AQItems.doTheItemThing();
        AQBlocks.doTheBlockThing();


    }//end pre init


}
