package com.rempler.sct.api;

import com.rempler.sct.init.Constants;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @author p455w0rd, updated by Rempler
 *
 */
public class BaseItem extends Item implements IItemStackProvider {

	ItemStack stack;

	public BaseItem(final String name) {
		super(Constants.BASE_PROPS);
		setRegistryName(Constants.MODID + ":" + name);
		stack = new ItemStack(this);
	}

	@Override
	public ItemStack asStack() {
		return stack;
	}

}
