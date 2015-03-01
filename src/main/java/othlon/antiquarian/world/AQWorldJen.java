package othlon.antiquarian.world;

import com.google.common.collect.Lists;
import othlon.antiquarian.world.
/**
 * Created by Jen on 23/02/2015.
 */
public enum AQWorldJen {
    INSTANCE;
    private static final List<StructureGenerator> structureGens = Lists.newArrayList();

    public static final SchematicLoader schematicLoader = new SchematicLoader();

}
