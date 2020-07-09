package nyuulson.nyuulsoncore;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import nyuulson.nyuulsoncore.proxy.CommonProxy;
import nyuulson.nyuulsoncore.util.Reference;
import org.apache.logging.log4j.Logger;

import java.sql.Ref;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class NyuulsonCore
{

    @Instance
    public static NyuulsonCore instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
    public static CommonProxy proxy;

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
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}
