package othlon.antiquarian;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import othlon.antiquarian.helpers.AQTab;
import othlon.antiquarian.proxies.CommonProxy;
import othlon.antiquarian.testing.AQBlock;

/**
 * Created by jen on 19/07/2014.
 */

@Mod (modid="Antiquarian")
public class antiquarian {

    @SidedProxy(clientSide ="othlon.antiquarian.proxie.ClientProxy", serverSide = "othlon.antiquarian.proxies.CommonProxy" )
    public static CommonProxy proxy;

    public static CreativeTabs tabAntiQ;

    public AQBlock topsoil;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

       topsoil  = new AQBlock();
       tabAntiQ = new AQTab(CreativeTabs.getNextID(), "CherryPigTab");


        GameRegistry.registerBlock(topsoil, "Topsoil");

    }//end pre init


}
