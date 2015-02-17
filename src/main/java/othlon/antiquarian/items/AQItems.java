package othlon.antiquarian.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;


/**
 * Created by Jen on 14/02/2015.
 */
public class AQItems {

    public static Item trowel;
    public static Item celticFrag;
    public static Item romanFrag;
    public static Item egyptianFrag;
   // public static Item celticFrag;

    public static void doTheItemThing(){
        trowel = new AQTrowel();
        GameRegistry.registerItem(trowel, "trowel");

        celticFrag = new AQFragment("Celtic");
        GameRegistry.registerItem(celticFrag, "celticFragment");

        romanFrag = new AQFragment("Roman");
        GameRegistry.registerItem(romanFrag, "romanFragment");

        egyptianFrag = new AQFragment("Egyptian");
        GameRegistry.registerItem(egyptianFrag, "egyptianFragment");

    }
}
