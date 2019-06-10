package p455w0rd.sct.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

/**
 * @author p455w0rd
 *
 */
public class ModItemGroup extends ItemGroup {

	private static final ModItemGroup INSTANCE = new ModItemGroup();

	public ModItemGroup() {
		super(ModGlobals.MODID);
	}

	public static ModItemGroup getInstance() {
		return INSTANCE;
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ModItems.ITEM_BLOCK_STONE_WORKBENCH);
	}

}
