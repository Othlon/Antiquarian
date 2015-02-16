package othlon.antiquarian.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;


/**
 * Created by Jen on 14/02/2015.
 */
public class AQItems {

    public static Item trowel;
    public static Item fragment;

    public static void doTheItemThing(){
        trowel = new AQTrowel();
        GameRegistry.registerItem(trowel, "trowel");

        fragment = new AQFragment();
        GameRegistry.registerItem(fragment, "Fragment");

    }
}
