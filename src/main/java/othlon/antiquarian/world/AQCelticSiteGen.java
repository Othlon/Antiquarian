package othlon.antiquarian.world;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.*;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderFlat;
import net.minecraft.world.gen.feature.WorldGenerator;
import othlon.antiquarian.blocks.AQBlocks;

import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * Created by Jen on 19/02/2015.
 */
public class AQCelticSiteGen extends WorldGenerator implements IWorldGenerator {

    Block topSoil = AQBlocks.celticTopsoil;

    public AQCelticSiteGen()
    {

    }

    @Override
    //IWorldGen version
    public void generate (Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        if ((chunkGenerator instanceof ChunkProviderFlat || world.provider.terrainType == WorldType.FLAT))
        {
            return;
        }
        else{
                generateIsland(world, rand, chunkX * 16, chunkZ * 16);
        }
    }

    // Island is biased towards one direction. Quadrants would be more useful
    public void generateIsland (World world, Random rand, int xChunk, int zChunk) {
        int xRange = rand.nextInt(13) + 20;
        int yCenter = 50 + world.getHeightValue(xChunk, zChunk) + rand.nextInt(50);
        int zRange = rand.nextInt(13) + 20;
        int height = 12;
        int initialHeight = height;
        Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, xRange, zRange);

        // Basic shape
        for (int x = 0; x <= xRange; x++)
        {
            for (int z = 0; z <= zRange; z++)
            {
                for (int y = 0; y <= height; y++)
                {
                    if (ellipse.contains(x, z))
                        world.setBlock(x + xChunk, y + yCenter, z + zChunk, topSoil, 5, 0);
                }
            }
        }
    }

    @Override
    //WorldGenerator version
    public boolean generate (World world, Random rand, int x, int y, int z)
    {
        return true;
    }
}
