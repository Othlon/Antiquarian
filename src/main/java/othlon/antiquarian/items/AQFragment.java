package othlon.antiquarian.items;

import net.minecraft.item.Item;
import othlon.antiquarian.antiquarian;

/**
 * Created by Jen on 16/02/2015.
 */
public class AQFragment extends Item {

    public AQFragment(){

        setUnlocalizedName("Fragment");
        setCreativeTab(antiquarian.tabAntiQ);
        this.setTextureName("antiquarian:fragment");
    }
}
