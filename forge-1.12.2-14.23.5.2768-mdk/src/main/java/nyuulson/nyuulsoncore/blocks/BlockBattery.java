package nyuulson.nyuulsoncore.blocks;

import nyuulson.nyuulsoncore.NyuulsonCore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBattery extends Block {
	
	public static final String NAME = "battery";
	
	public BlockBattery() {
		super(Material.IRON);
		this.setUnlocalizedName(NAME);
		this.setRegistryName(NyuulsonCore.MODID, NAME);
		this.setHardness(5.0f);
		this.setHarvestLevel("pickaxe", 5);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
}
