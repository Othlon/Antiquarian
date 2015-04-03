package othlon.antiquarian.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import othlon.antiquarian.Antiquarian;
import othlon.antiquarian.items.AQItems;

import java.util.List;
import java.util.Random;

/**
 * Created by Jen on 16/02/2015.
 */
public class AQDigBlock extends AQBlockGrass {
    @SideOnly(Side.CLIENT)
    IIcon icons[];

    private IIcon overlay;

    Item fragmentDrop;

    public AQDigBlock(Item frag)
    {
        setHardness(2.0F);
        setHarvestLevel("shovel", 0);
        setResistance(5.0F);
        setStepSound(soundTypeGravel);
        setBlockName("TopSoil");
        setCreativeTab(Antiquarian.tabAntiQ);
        fragmentDrop = frag;
        //what biome am i in?
        //Steven: You can't possibly know this now.
        //set fragment category according to biome ID returned

    }

  //  @SideOnly(Side.CLIENT)
  //  public int getMyBiome(World world)
  //  {

 //   }


    public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z, boolean willHarvest)
    {

        return removedByPlayer(world, player, x, y, z);
    }


    @Override
    public void getSubBlocks(Item item, CreativeTabs cTab, List list) {
        //noinspection unchecked
        list.add(new ItemStack(item, 1, 0));
    }

    public Item getItemDropped(int intA, Random rand, int intB) {

        EntityPlayer player = harvesters.get();
        ItemStack heldItem  = player.getCurrentEquippedItem();
        if((heldItem != null)&&(heldItem.getItem() == AQItems.trowel))
        {
           return fragmentDrop;
        }
            return Blocks.dirt.getItemDropped(0, rand, intB);

    }

    @Override
    public void registerBlockIcons(IIconRegister thisdude) {
        icons = new IIcon[4];
        icons[0] = thisdude.registerIcon("antiquarian:topsoil_top");
        icons[1] = thisdude.registerIcon("antiquarian:topsoil_side");
        icons[2] = thisdude.registerIcon("antiquarian:topsoil_btm");
        icons[3] = thisdude.registerIcon("antiquarian:topsoil_side_overlay");
    }


    //@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side == 0){
            return icons[2];
        }
        else if (side == 1) {
            return icons[0];
        } else {
            return icons[1];
        }

    }

    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int blockSide){
        if (blockSide == 0){
            return icons[2];
        }
        else if (blockSide == 1) {
            return icons[0];
        } else {
            return icons[1];
        }
    }

    @SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
      double d0 = 0.5D;
      double d1 = 1.0D;
      return ColorizerGrass.getGrassColor(d0, d1);
   }

    @SideOnly(Side.CLIENT)
    public int getRenderColor(int p_149741_1_) {
        return this.getBlockColor();
    }

    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess blockAcess, int x, int y, int z) {
        int l = 0;
        int i1 = 0;
        int j1 = 0;

        for(int k1 = -1; k1 <= 1; ++k1) {
            for(int l1 = -1; l1 <= 1; ++l1) {
                int i2 = blockAcess.getBiomeGenForCoords(x + l1, z + k1).getBiomeGrassColor(x + l1, y, z + k1);
                l += (i2 & 16711680) >> 16;
                i1 += (i2 & '\uff00') >> 8;
                j1 += i2 & 255;
            }
        }

        return (l / 9 & 255) << 16 | (i1 / 9 & 255) << 8 | j1 / 9 & 255;
    }

    @SideOnly(Side.CLIENT)
    public static IIcon getIconSideOverlay() {
        return AQBlocks.celticTopsoil.overlay;
    }

    public void func_149853_b(World world, Random rand, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
        int iCount = 0;

        while(iCount < 128)
        {
            int i1 = p_149853_3_;
            int j1 = p_149853_4_ + 1;
            int k1 = p_149853_5_;
            int l1 = 0;

            while(true)
            {
                if (l1 < iCount / 16) {
                    i1 += rand.nextInt(3) - 1;
                    j1 += (rand.nextInt(3) - 1) * rand.nextInt(3) / 2;
                    k1 += rand.nextInt(3) - 1;
                    if (world.getBlock(i1, j1 - 1, k1) == Blocks.grass && !world.getBlock(i1, j1, k1).isNormalCube()) {
                        ++l1;
                        continue;
                    }
                } else if (world.getBlock(i1, j1, k1).getMaterial() == Material.air) {
                    if (rand.nextInt(8) != 0) {
                        if (Blocks.tallgrass.canBlockStay(world, i1, j1, k1)) {
                            world.setBlock(i1, j1, k1, Blocks.tallgrass, 1, 3);
                        }
                    } else {
                        world.getBiomeGenForCoords(i1, k1).plantFlower(world, rand, i1, j1, k1);
                    }
                }

                ++iCount;
                break;
            }
        }
    }

}//end class bracket

