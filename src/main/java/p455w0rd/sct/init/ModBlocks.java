package p455w0rd.sct.init;

import net.minecraft.block.BlockWorkbench;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import p455w0rd.sct.blocks.BlockSCT;
import p455w0rd.sct.blocks.tiles.TileSCT;

public class ModBlocks extends BlockWorkbench {

	public static final BlockSCT STONE_WORKBENCH = new BlockSCT();

	public static void registerTiles() {
		GameRegistry.registerTileEntity(TileSCT.class, new ResourceLocation(ModGlobals.MODID, STONE_WORKBENCH.getRegistryName().toString()));
	}

}
