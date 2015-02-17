package othlon.antiquarian.items;

import net.minecraft.item.Item;
import othlon.antiquarian.antiquarian;

/**
 * Created by Jen on 16/02/2015.
 */
public class AQFragment extends Item {

    public AQFragment(String sCiv){

        String textureName = "antiquarian:"+sCiv+"_frag";

        setUnlocalizedName(sCiv+" Fragment");
        setCreativeTab(antiquarian.tabAntiQ);
        this.setTextureName(textureName.toLowerCase());
    }
}
