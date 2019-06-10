package p455w0rd.sct.proxy;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import p455w0rd.sct.init.ModGuiHandler;
import p455w0rd.sct.init.ModGuiHandler.GUI;

/**
 * @author p455w0rd
 *
 */
public class CommonProxy implements IProxy {

	@Override
	public boolean openGui(final GUI type, final PlayerEntity player, final BlockPos pos) {
		return ModGuiHandler.openGuiServer(type, player, pos);
	}
	/*
	public void preInit(FMLPreInitializationEvent e) {
		ModBlocks.registerTiles();
	}

	public void init(FMLInitializationEvent e) {
		OreDictionary.registerOre("stickWood", ModItems.STONE_STICK);
	}

	public void postInit(FMLInitializationEvent e) {
		NetworkRegistry.INSTANCE.registerGuiHandler(StoneCraftingTable.instance, new ModGuiHandler());
	}
	*/
}
