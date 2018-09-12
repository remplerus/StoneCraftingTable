package p455w0rd.sct.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.oredict.OreDictionary;
import p455w0rd.sct.StoneCraftingTable;
import p455w0rd.sct.init.ModBlocks;
import p455w0rd.sct.init.ModGuiHandler;
import p455w0rd.sct.init.ModItems;

/**
 * @author p455w0rd
 *
 */
public class CommonProxy {

	public void preInit(FMLPreInitializationEvent e) {
		ModBlocks.registerTiles();
	}

	public void init(FMLInitializationEvent e) {
		OreDictionary.registerOre("stickWood", ModItems.STONE_STICK);
	}

	public void postInit(FMLInitializationEvent e) {
		NetworkRegistry.INSTANCE.registerGuiHandler(StoneCraftingTable.instance, new ModGuiHandler());
	}

}
