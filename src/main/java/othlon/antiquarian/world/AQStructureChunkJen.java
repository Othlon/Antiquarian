package othlon.antiquarian.world;

import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.util.Rectangle;

/**
 * Created by Jen on 23/02/2015.
 */
public class AQStructureChunkJen {

    private final World world;
    private final int chunkX;
    private final int chunkZ;
    private final AQCelticSiteGen dig;
    private final Rectangle intersection;

    public AQStructureChunkJen(World world, int chunkX, int chunkZ, AQCelticSiteGen dig, Rectangle intersection)
    {
        this.world = world;

        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
        this.dig = dig;
        this.intersection = intersection;
    }

    public void generate()
    {
        AQWorldJen.schematicLoader.renderSchematicToSingleChunk(
                dig.schematic.resource,
                world,
                intersection.getX(), dig.height, intersection.getY(),
                chunkX, chunkZ,
                ForgeDirection.NORTH,
                false);
    }

}
