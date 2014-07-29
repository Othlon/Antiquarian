package othlon.antiquarian.testing;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockGrass;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.List;

/**
 * Created by jen on 27/07/2014.
 */
public class AQBlock extends BlockGrass {
    @SideOnly(Side.CLIENT)
    IIcon icons[];


    public AQBlock(){
        this.setHardness(2.0F);
        this.setHarvestLevel("shovel", 0);
        this.setResistance(5.0F);
        this.setStepSound(soundTypeGravel);
        this.setBlockName("TopSoil");
        this.setCreativeTab(CreativeTabs.tabFood);

    }

    @Override
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
        //noinspection unchecked
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
    } //nope

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
    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_)
      {
        return 16777215;
        }
}
