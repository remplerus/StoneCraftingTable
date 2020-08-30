package com.rempler.sct.init;

import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Constants {

	public static final String MODID = "sct";
	public static final ItemGroup ITEM_GROUP = new ItemGroup(MODID) {
		@Override
		public ItemStack createIcon() {
			return ModObjects.ITEM_BLOCK_STONE_WORKBENCH.asStack();
		}
	};
	public static final Properties BASE_PROPS = new Properties().group(ITEM_GROUP).maxStackSize(64);

}
