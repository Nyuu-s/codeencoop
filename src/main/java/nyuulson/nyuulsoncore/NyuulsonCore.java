package nyuulson.nyuulsoncore;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import nyuulson.nyuulsoncore.blocks.BlockBattery;

@Mod(modid = NyuulsonCore.MODID, name = NyuulsonCore.NAME, version = NyuulsonCore.VERSION)
public class NyuulsonCore
{
    public static final String MODID = "nyuulsoncore";
    public static final String NAME = "Nyuulson Core";
    public static final String VERSION = "1.0";
    
    public static final Block BLOCK_BATTERY = new BlockBattery();

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("Nyuulson Core initialized");
    }
}
