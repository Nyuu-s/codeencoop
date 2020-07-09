package nyuulson.nyuulsoncore.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import nyuulson.nyuulsoncore.NyuulsonCore;
import nyuulson.nyuulsoncore.init.ModItems;
import nyuulson.nyuulsoncore.util.IHasModel;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);

        ModItems.ITEMS.add(this);
    }
    @Override
    public void registerModels() {
        NyuulsonCore.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
