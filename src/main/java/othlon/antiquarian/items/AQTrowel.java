package othlon.antiquarian.items;

import net.minecraft.item.ItemSpade;
import othlon.antiquarian.Antiquarian;

/**
 * Created by Jen on 14/02/2015.
 */
public class AQTrowel extends ItemSpade {

    public AQTrowel(){

        super(ToolMaterial.IRON);
        setUnlocalizedName(Antiquarian.RESOURCE_PREFIX + "trowel");
        setCreativeTab(Antiquarian.tabAntiQ);
        this.setTextureName(Antiquarian.RESOURCE_PREFIX +"trowel");
    }

}
