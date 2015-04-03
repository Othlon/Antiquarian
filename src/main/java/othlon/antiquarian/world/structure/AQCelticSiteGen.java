package othlon.antiquarian.world.structure;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderFlat;
import net.minecraftforge.common.util.ForgeDirection;
import othlon.antiquarian.blocks.AQBlocks;
import othlon.antiquarian.world.SchematicLoader;

import java.util.Random;

/**
 * Created by Jen on 19/02/2015.
 */
public class AQCelticSiteGen implements IWorldGenerator {

    private final SchematicLoader schematicLoader;
    Block topSoil = AQBlocks.celticTopsoil;


    public AQCelticSiteGen()
    {
        this.schematicLoader = new SchematicLoader();
    }

    private static ResourceLocation test01Schematic = new ResourceLocation("Antiquarian:schematics/test01.schematic");

    public void loadSchematics() {
        schematicLoader.loadSchematic(test01Schematic);
    }

    @Override
    public void generate (Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        if ((chunkGenerator instanceof ChunkProviderFlat || world.provider.terrainType == WorldType.FLAT))
        {
            return;
        }
        if (world.provider.dimensionId == 0){
            if (chunkX % 4 == 0 && chunkZ % 4 == 0) {
                schematicLoader.renderSchematicInOneShot(test01Schematic, world, chunkX * 16, 96, chunkZ * 16, ForgeDirection.NORTH, false);
            }
        }
    }
}
