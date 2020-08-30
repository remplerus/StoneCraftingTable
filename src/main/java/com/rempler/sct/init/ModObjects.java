package com.rempler.sct.init;

import com.rempler.sct.table.SCTBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import com.rempler.sct.api.BaseBlockItem;
import com.rempler.sct.api.BaseItem;

/**
 * @author p455w0rd, updated by Rempler
 *
 */
public class ModObjects {

	public static final SCTBlock STONE_WORKBENCH = new SCTBlock();
	public static final BaseItem STONE_CRAFTING_PLATE = new BaseItem("stone_crafting_plate");
	public static final BaseItem STONE_STICK = new BaseItem("stone_stick");
	public static final BaseBlockItem ITEM_BLOCK_STONE_WORKBENCH = new BaseBlockItem(STONE_WORKBENCH) {
		@Override
		public int getBurnTime(final ItemStack itemStack) {
			return 200;
		}
	};

	private static final Item[] ITEMS = new Item[] { //@formatter:off
			STONE_CRAFTING_PLATE,
			STONE_STICK,
			ITEM_BLOCK_STONE_WORKBENCH//@formatter:on
	};

	public static Item[] getItems() {
		return ITEMS;
	}

}
