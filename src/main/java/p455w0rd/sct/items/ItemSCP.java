package p455w0rd.sct.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import p455w0rd.sct.init.ModGlobals;

/**
 * @author p455w0rd
 *
 */
public class ItemSCP extends Item {

	private static final String NAME = "stone_crafting_plate";

	public ItemSCP() {
		setCreativeTab(CreativeTabs.DECORATIONS);
		setUnlocalizedName(NAME);
		setRegistryName(ModGlobals.MODID + ":" + NAME);
	}

	@SideOnly(Side.CLIENT)
	public void registerModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}
