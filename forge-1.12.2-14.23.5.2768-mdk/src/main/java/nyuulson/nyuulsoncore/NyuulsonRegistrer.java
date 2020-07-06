package nyuulson.nyuulsoncore;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@EventBusSubscriber(modid = NyuulsonCore.MODID)
@ObjectHolder(NyuulsonCore.MODID)
public class NyuulsonRegistrer {
	
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {
		event.getRegistry().register(NyuulsonCore.BLOCK_BATTERY);
	}
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
		Item blockBatteryItem = new ItemBlock(NyuulsonCore.BLOCK_BATTERY).setRegistryName(NyuulsonCore.BLOCK_BATTERY.getRegistryName());
		
		event.getRegistry().register(blockBatteryItem);
		ModelLoader.setCustomModelResourceLocation(blockBatteryItem, 0,
				new ModelResourceLocation(blockBatteryItem.getRegistryName(), "normal"));
	}
}
