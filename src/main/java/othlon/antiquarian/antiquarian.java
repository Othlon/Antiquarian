package othlon.antiquarian;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import othlon.antiquarian.testing.AQBlock;

/**
 * Created by jen on 19/07/2014.
 */

@Mod (modid="Antiquarian")
public class antiquarian {

    public AQBlock topsoil;
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

       topsoil  = new AQBlock();


        GameRegistry.registerBlock(topsoil, "Topsoil");

    }//end pre init


}
