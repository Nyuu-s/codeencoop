package nyuulson.nyuulsoncore.blocks;

import nyuulson.nyuulsoncore.NyuulsonCore;
import nyuulson.nyuulsoncore.blocks.tileentity.TileEntityBattery;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

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
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityBattery();
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
}
