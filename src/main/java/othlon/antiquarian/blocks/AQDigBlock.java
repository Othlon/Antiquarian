package othlon.antiquarian.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
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
import othlon.antiquarian.antiquarian;
import othlon.antiquarian.items.AQItems;
import othlon.antiquarian.items.AQTrowel;

import java.util.List;
import java.util.Random;

/**
 * Created by Jen on 16/02/2015.
 */
public class AQDigBlock extends BlockGrass {
    @SideOnly(Side.CLIENT)
    IIcon icons[];

    private IIcon overlay;


    public AQDigBlock()
    {
        this.setHardness(2.0F);
        this.setHarvestLevel("shovel", 0);
        this.setResistance(5.0F);
        this.setStepSound(soundTypeGravel);
        this.setBlockName("TopSoil");
        setCreativeTab(antiquarian.tabAntiQ);

    }
    public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z, boolean willHarvest)
    {
        ItemStack heldItem = player.getCurrentEquippedItem();
        ItemStack frags = new ItemStack(AQItems.fragment, 1, 0);

        if((heldItem.getItem() == AQItems.trowel) && (heldItem.getItem() != null))
        {
           this.dropBlockAsItem(world, x, y, z, frags);
        }

        return removedByPlayer(world, player, x, y, z);
    }


    @Override
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
        //noinspection unchecked
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
    }

    public Item getItemDropped(int p_149650_1_, Random rand, int p_149650_3_) {

            return Blocks.dirt.getItemDropped(0, rand, p_149650_3_);

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
    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
        int l = 0;
        int i1 = 0;
        int j1 = 0;

        for(int k1 = -1; k1 <= 1; ++k1) {
            for(int l1 = -1; l1 <= 1; ++l1) {
                int i2 = p_149720_1_.getBiomeGenForCoords(p_149720_2_ + l1, p_149720_4_ + k1).getBiomeGrassColor(p_149720_2_ + l1, p_149720_3_, p_149720_4_ + k1);
                l += (i2 & 16711680) >> 16;
                i1 += (i2 & '\uff00') >> 8;
                j1 += i2 & 255;
            }
        }

        return (l / 9 & 255) << 16 | (i1 / 9 & 255) << 8 | j1 / 9 & 255;
    }

    @SideOnly(Side.CLIENT)
    public static IIcon getIconSideOverlay() {
        return AQBlocks.digBlock.overlay;
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

