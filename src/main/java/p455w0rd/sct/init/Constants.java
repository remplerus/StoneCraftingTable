package p455w0rd.sct.init;

import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Constants {

	public static final String MODID = "sct";
	public static final String NAME = "StoneCraftingTable";
	public static final String VERSION = "1.0.3";
	public static final String SERVER_PROXY = "p455w0rd.sct.proxy.CommonProxy";
	public static final String CLIENT_PROXY = "p455w0rd.sct.proxy.ClientProxy";
	public static final String DEPENDENCIES = "";
	public static final String CONFIG_FILE = "config/StoneCraftingTable.toml";
	public static final ItemGroup ITEM_GROUP = new ItemGroup(MODID) {
		@Override
		public ItemStack createIcon() {
			return ModObjects.ITEM_BLOCK_STONE_WORKBENCH.asStack();
		}
	};
	public static final Properties BASE_PROPS = new Properties().group(ITEM_GROUP).maxStackSize(64);

}
