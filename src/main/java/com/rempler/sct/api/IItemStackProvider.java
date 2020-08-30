package com.rempler.sct.api;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;

/**
 * @author p455w0rd, updated by Rempler
 *
 */
public interface IItemStackProvider {

	@Nonnull
	ItemStack asStack();

}
