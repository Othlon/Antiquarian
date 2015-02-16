package othlon.antiquarian.items;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemTool;
import othlon.antiquarian.antiquarian;

import java.util.Set;

/**
 * Created by Jen on 14/02/2015.
 */
public class AQTrowel extends ItemSpade {

    public AQTrowel(){

        super(ToolMaterial.IRON);
        setUnlocalizedName("Trowel");
        setCreativeTab(antiquarian.tabAntiQ);
        this.setTextureName("antiquarian:trowel");
    }

}
