package p455w0rd.sct.init;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/**
 * @author p455w0rd
 *
 */
@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = ModGlobals.MODID, value = Dist.CLIENT)
public class ModEventsClient {

	@SubscribeEvent
	public static void onModelRegistryReady(ModelRegistryEvent event) {
		/*
		ItemModelMesher mesher = Minecraft.getInstance().getItemRenderer().getItemModelMesher();
		ModItems.ITEM_BLOCK_STONE_WORKBENCH.registerModel(mesher);
		ModItems.STONE_CRAFTING_PLATE.registerModel(mesher);
		ModItems.STONE_STICK.registerModel(mesher);
		*/
	}

}
