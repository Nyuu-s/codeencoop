package nyuulson.nyuulsoncore.blocks.tileentity;

import cofh.redstoneflux.api.IEnergyProvider;
import cofh.redstoneflux.api.IEnergyReceiver;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import cofh.core.util.helpers.EnergyHelper;
import nyuulson.nyuulsoncore.NyuulsonCore;
import scala.Int;

public class TileEntityBattery extends TileEntity implements ITickable, IEnergyProvider, IEnergyReceiver {
	
	private int energyStored = 0;
	final static int maxEnergyStore = 1000;
	final static int maxFlux = Int.MaxValue();
	 
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.energyStored = compound.getInteger("Energy");
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setInteger("Energy", this.energyStored);
		return super.writeToNBT(compound);
	}

	@Override
	public int getEnergyStored(EnumFacing arg0) {
		// TODO Auto-generated method stub
		return energyStored;
	}

	@Override
	public int getMaxEnergyStored(EnumFacing arg0) {
		// TODO Auto-generated method stub
		return TileEntityBattery.maxEnergyStore;
	}

	@Override
	public boolean canConnectEnergy(EnumFacing arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int receiveEnergy(EnumFacing arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub
		int received = Math.min(arg1, Math.min(TileEntityBattery.maxEnergyStore - this.energyStored, TileEntityBattery.maxFlux));
		
		NyuulsonCore.logger.info(received);
		
		this.energyStored += received;
		return received;
	}

	@Override
	public int extractEnergy(EnumFacing arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub
		int extracted = Math.min(arg1, Math.min(this.energyStored, TileEntityBattery.maxFlux));
		
		NyuulsonCore.logger.info(extracted);
		
		this.energyStored -= extracted;
		return extracted;
	}

	@Override
	public void update() {
		/*for (int x = 0; x < 2 ; x++) {
			for (int y = 0; y < 2 ; y++) {
				for (int z = 0 ; z < 2 ; z++) {
					if (!(x==1 && y==1 && z==1)) {
						TileEntity potentialOutput = world.getTileEntity(this.getPos().add(x-1, y-1, z-1));
						if (potentialOutput != null && EnergyHelper.canAdjacentEnergyHandlerExtract(potentialOutput, EnumFacing.))
					}
				}
			}
		}*/
		
		/*for (int i = 0 ; i < 3 ; i++) {
			for (int offset = 0 ; offset < 2 ; offset++) {
				Vec3i vec;
				switch (i) {
					case 0:
						vec = new BlockPos(2*offset-1, 0, 0);
						break;
					case 1:
						vec = new BlockPos(0, 2*offset-1, 0);
						break;
					case 2:
						vec = new BlockPos(0, 0, 2*offset-1);
						break;
				}
				
				TileEntity potentialOutput = world.getTileEntity(this.getPos().add(vec));
				if (potentialOutput != null && EnergyHelper.canAdjacentEnergyHandlerReceive(potentialOutput, EnumFacing.getFacingFromVector(vec.getX(), vec.getY(), vec.getZ()))) {
					int sent = EnergyHelper.
				}
			}
		}*/
		
		for (int i = 0 ; i < 6 ; i++) {
			EnumFacing currentFace = EnumFacing.VALUES[i];
			if (EnergyHelper.canAdjacentEnergyHandlerReceive(this, currentFace)) {
				EnergyHelper.insertEnergyIntoAdjacentEnergyReceiver(this, currentFace, this.extractEnergy(currentFace, TileEntityBattery.maxEnergyStore, false), false);
			}
		}
	}
}
