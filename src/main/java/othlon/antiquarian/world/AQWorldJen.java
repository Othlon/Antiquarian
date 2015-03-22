package othlon.antiquarian.world;

import com.google.common.collect.Lists;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.WorldEvent;
import othlon.antiquarian.world.SchematicLoader;
/**
 * Created by Jen on 23/02/2015.
 */
public enum AQWorldJen {
    INSTANCE;
    //private static final List<StructureGenerator> structureGens = Lists.newArrayList();

    public static final SchematicLoader schematicLoader = new SchematicLoader();

    @SubscribeEvent
    public void OnWorldStarted(WorldEvent.Load worldLoadEvent) {
        structureGens.clear();
        final RemnantRuinsGenerator ruinsGenerator = new RemnantRuinsGenerator();
        structureGens.add(ruinsGenerator);
    }
}
