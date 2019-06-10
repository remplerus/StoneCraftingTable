package p455w0rd.sct.items;

import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.BlockItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import p455w0rd.sct.init.ModBlocks;
import p455w0rd.sct.init.ModItemGroup;

/**
 * @author p455w0rd
 *
 */
public class ItemBlockSCT extends BlockItem {

	private static final Properties PROPS = new Properties().group(ModItemGroup.getInstance()).maxStackSize(64);

	public ItemBlockSCT() {
		super(ModBlocks.STONE_WORKBENCH, PROPS);
		setRegistryName(ModBlocks.STONE_WORKBENCH.getRegistryName());
	}

	@OnlyIn(Dist.CLIENT)
	public void registerModel(final ItemModelMesher mesher) {
		//ModelBakery.registerItemVariants(this, new ModelResourceLocation(getRegistryName(), "inventory"));
		mesher.register(this, new ModelResourceLocation(getRegistryName(), "inventory"));
		//ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}
