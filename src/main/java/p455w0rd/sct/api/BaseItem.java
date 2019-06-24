package p455w0rd.sct.api;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import p455w0rd.sct.init.Constants;

/**
 * @author p455w0rd
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
