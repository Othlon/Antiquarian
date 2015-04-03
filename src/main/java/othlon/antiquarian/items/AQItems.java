package othlon.antiquarian.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import othlon.antiquarian.Antiquarian;


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
        GameRegistry.registerItem(trowel, Antiquarian.RESOURCE_PREFIX + "trowel");

        celticFrag = new AQFragment("celtic");
        GameRegistry.registerItem(celticFrag, Antiquarian.RESOURCE_PREFIX + "celticFragment");

        romanFrag = new AQFragment("roman");
        GameRegistry.registerItem(romanFrag, Antiquarian.RESOURCE_PREFIX + "romanFragment");

        egyptianFrag = new AQFragment("egyptian");
        GameRegistry.registerItem(egyptianFrag, Antiquarian.RESOURCE_PREFIX + "egyptianFragment");

    }
}
