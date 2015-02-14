package othlon.antiquarian.helpers;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Jen on 13/02/2015.
 */
public class AQTab extends CreativeTabs{

    public AQTab(int position, String tabID) {
        super(position, tabID);
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(Items.clay_ball);
    }

    @Override
    public Item getTabIconItem() {
        return null;
    }

}
