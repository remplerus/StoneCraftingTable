package p455w0rd.sct;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import p455w0rd.sct.init.ModGlobals;
import p455w0rd.sct.proxy.*;

@Mod(ModGlobals.MODID)
public class StoneCraftingTable {

	private static StoneCraftingTable instance;
	private static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new CommonProxy());

	public StoneCraftingTable() {
		if (instance == null) {
			instance = this;
		}
		//ModLoadingContext.get().registerConfig(Type.COMMON, ModConfig.CONFIG_SPEC);
	}

	public static StoneCraftingTable getInstance() {
		return instance;
	}

	public static IProxy getProxy() {
		return proxy;
	}

	/*
	@SidedProxy(clientSide = ModGlobals.CLIENT_PROXY, serverSide = ModGlobals.SERVER_PROXY)
	public static CommonProxy proxy;
	
	@Mod.Instance(ModGlobals.MODID)

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
	*/

}