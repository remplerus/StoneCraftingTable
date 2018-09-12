package p455w0rd.sct;

import java.io.File;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import p455w0rd.sct.init.ModGlobals;
import p455w0rd.sct.proxy.CommonProxy;

@Mod(modid = ModGlobals.MODID, name = ModGlobals.MOD_NAME, version = ModGlobals.VERSION, dependencies = ModGlobals.DEPENDENCIES)
public class StoneCraftingTable {

	@SidedProxy(clientSide = ModGlobals.CLIENT_PROXY, serverSide = ModGlobals.SERVER_PROXY)
	public static CommonProxy proxy;

	@Mod.Instance(ModGlobals.MODID)
	public static StoneCraftingTable instance;
	public File configFile;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}

	@Mod.EventHandler
	public void postInit(FMLInitializationEvent e) {
		proxy.postInit(e);
	}

}