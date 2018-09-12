package p455w0rd.sct.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

/**
 * @author p455w0rd
 *
 */
@EventBusSubscriber(modid = ModGlobals.MODID)
public class ModEvents {

	@SubscribeEvent
	public static void onBlockRegistryReady(RegistryEvent.Register<Block> event) {
		event.getRegistry().register(ModBlocks.STONE_WORKBENCH);
		ForgeRegistries.ITEMS.register(ModItems.ITEM_BLOCK_STONE_WORKBENCH.setRegistryName(ModBlocks.STONE_WORKBENCH.getRegistryName()));
	}

	@SubscribeEvent
	public static void onItemRegistryReady(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(ModItems.STONE_CRAFTING_PLATE);
		event.getRegistry().register(ModItems.STONE_STICK);
	}

	@SubscribeEvent
	public static void onModelRegistryReady(ModelRegistryEvent event) {
		ModBlocks.STONE_WORKBENCH.registerModel();
		ModItems.STONE_CRAFTING_PLATE.registerModel();
		ModItems.STONE_STICK.registerModel();
	}

}
