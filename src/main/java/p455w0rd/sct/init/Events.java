package p455w0rd.sct.init;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import p455w0rd.sct.block.SCTTileEntity;
import p455w0rd.sct.container.SCTContainer;

/**
 * @author p455w0rd
 *
 */
@EventBusSubscriber(bus = MOD, modid = Constants.MODID)
public class Events {

	@SubscribeEvent
	public static void onBlockRegistryReady(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(ModObjects.STONE_WORKBENCH);
	}

	@SubscribeEvent
	public static void onItemRegistryReady(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ModObjects.getItems());
	}

	@SubscribeEvent
	public static void onTileRegistryReady(final RegistryEvent.Register<TileEntityType<?>> event) {
		event.getRegistry().register(SCTTileEntity.TYPE);
	}

	@SubscribeEvent
	public static void onContainerRegistryReady(final RegistryEvent.Register<ContainerType<?>> event) {
		event.getRegistry().register(SCTContainer.TYPE);
	}

}
