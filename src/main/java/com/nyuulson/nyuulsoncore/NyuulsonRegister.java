package com.nyuulson.nyuulsoncore;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@EventBusSubscriber(modid = NyuulsonCore.MODID)
@ObjectHolder(NyuulsonCore.MODID)
public class NyuulsonRegister {
	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
		Item amethyst = new Item().setRegistryName(NyuulsonCore.MODID, "amethyst").setUnlocalizedName("amethyst").setCreativeTab(CreativeTabs.MISC);
		event.getRegistry().register(amethyst);
		ModelResourceLocation loc = new ModelResourceLocation(amethyst.getRegistryName(), "inventory");
		ModelLoader.setCustomModelResourceLocation(amethyst, 0, loc);
	}
}
