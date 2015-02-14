package othlon.antiquarian.items;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSpade;
import othlon.antiquarian.antiquarian;

import java.util.Set;

/**
 * Created by Jen on 14/02/2015.
 */
public class AQTrowel extends ItemSpade{


    private static final Set superEffective;

    public AQTrowel(){

        super(1.0F, ToolMaterial.IRON, superEffective);
        setUnlocalizedName("Trowel");
        setCreativeTab(antiquarian.tabAntiQ);
        setTextureName("antiquarian:trowel");
    }
    static {
        superEffective = Sets.newHashSet(new Block[]{Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium});
    }

}
