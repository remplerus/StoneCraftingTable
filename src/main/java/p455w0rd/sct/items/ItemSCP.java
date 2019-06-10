package p455w0rd.sct.items;

import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import p455w0rd.sct.init.ModGlobals;
import p455w0rd.sct.init.ModItemGroup;

/**
 * @author p455w0rd
 *
 */
public class ItemSCP extends Item {

	private static final String NAME = "stone_crafting_plate";
	private static final Properties PROPS = new Properties().group(ModItemGroup.getInstance()).maxStackSize(64);

	public ItemSCP() {
		//setCreativeTab(CreativeTabs.DECORATIONS);
		//setUnlocalizedName(NAME);
		super(PROPS);
		setRegistryName(ModGlobals.MODID + ":" + NAME);
	}

	@OnlyIn(Dist.CLIENT)
	public void registerModel(ItemModelMesher mesher) {
		mesher.register(this, new ModelResourceLocation(getRegistryName(), "inventory"));
		//ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}
