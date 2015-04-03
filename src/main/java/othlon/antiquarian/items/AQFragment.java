package othlon.antiquarian.items;

import net.minecraft.item.Item;
import othlon.antiquarian.Antiquarian;

/**
 * Created by Jen on 16/02/2015.
 */
public class AQFragment extends Item {

    public AQFragment(String sCiv){

        String unlocalizedName = Antiquarian.RESOURCE_PREFIX +sCiv+"Fragment";

        setUnlocalizedName(unlocalizedName);
        setCreativeTab(Antiquarian.tabAntiQ);
        this.setTextureName((Antiquarian.RESOURCE_PREFIX +sCiv + "_frag").toLowerCase());
    }
}
