package p455w0rd.sct.init;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import p455w0rd.sct.blocks.tiles.TileSCT;

/**
 * @author p455w0rd
 *
 */
@EventBusSubscriber(bus = MOD, modid = ModGlobals.MODID)
public class ModEvents {

	@SubscribeEvent
	public static void onBlockRegistryReady(RegistryEvent.Register<Block> event) {
		event.getRegistry().register(ModBlocks.STONE_WORKBENCH);
		ForgeRegistries.ITEMS.register(ModItems.ITEM_BLOCK_STONE_WORKBENCH);
	}

	@SubscribeEvent
	public static void onItemRegistryReady(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(ModItems.STONE_CRAFTING_PLATE);
		event.getRegistry().register(ModItems.STONE_STICK);
	}

	@SubscribeEvent
	public static void onTileRegistryReady(RegistryEvent.Register<TileEntityType<?>> event) {
		event.getRegistry().register(TileSCT.TYPE);
	}

}
