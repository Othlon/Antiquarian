package othlon.antiquarian;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import othlon.antiquarian.blocks.AQBlocks;
import othlon.antiquarian.helpers.AQTab;
import othlon.antiquarian.items.AQItems;
import othlon.antiquarian.library.WorldGenerators;
import othlon.antiquarian.proxies.CommonProxy;
import othlon.antiquarian.world.LoadSchematicFromFileCommand;
import othlon.antiquarian.world.LoadSchematicFromResourceCommand;

/**
 * Created by jen on 19/07/2014.
 */

@Mod(modid = Antiquarian.MOD_ID, name = Antiquarian.MOD_NAME, version = Antiquarian.MOD_VERSION, useMetadata = true)
public class Antiquarian {

    public static final String MOD_ID = "antiquarian";
    public static final String MOD_NAME = "Antiquarian";
    public static final String MOD_VERSION = "@MOD_VERSION@";
    public static final String RESOURCE_PREFIX = MOD_ID.toLowerCase() + ':';

    @SidedProxy(clientSide ="othlon.antiquarian.proxies.ClientProxy", serverSide = "othlon.antiquarian.proxies.CommonProxy" )
    public static CommonProxy proxy;

    public static CreativeTabs tabAntiQ;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        tabAntiQ = new AQTab(CreativeTabs.getNextID(), "AntiquarianTab");
        AQItems.doTheItemThing();
        AQBlocks.doTheBlockThing();


    }//end pre init

    @Mod.EventHandler
    public void init (FMLInitializationEvent event) {
        proxy.loadSchematics();
        GameRegistry.registerWorldGenerator(WorldGenerators.CELTIC_SITE_GEN, 1);
    }

    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent event) {
       event.registerServerCommand(new LoadSchematicFromResourceCommand());
       event.registerServerCommand(new LoadSchematicFromFileCommand());
    }
}
