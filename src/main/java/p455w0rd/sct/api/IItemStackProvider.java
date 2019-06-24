package p455w0rd.sct.api;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;

/**
 * @author p455w0rd
 *
 */
public interface IItemStackProvider {

	@Nonnull
	ItemStack asStack();

}
