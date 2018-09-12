package p455w0rd.sct.inventory;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

/**
 * @author Lothrazar via https://github.com/PrinceOfAmber/Cyclic/blob/develop/src/main/java/com/lothrazar/cyclicmagic/block/workbench/InventoryWorkbench.java
 *
 */
public class InventoryWorkbench extends InventoryCrafting {

	private IInventory tileEntity;
	private Container container;

	public InventoryWorkbench(Container eventHandlerIn, IInventory tileEntity) {
		super(eventHandlerIn, 3, 3);
		this.tileEntity = tileEntity;
		container = eventHandlerIn;
	}

	@Override
	public int getSizeInventory() {
		return 9;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return tileEntity.getStackInSlot(index);
	}

	/**
	 * just like vanilla
	 */
	@Override
	public ItemStack decrStackSize(int index, int count) {
		if (getStackInSlot(index).isEmpty()) {
			return ItemStack.EMPTY;
		}
		ItemStack stack;
		if (getStackInSlot(index).getCount() <= count) {
			stack = getStackInSlot(index);
			setInventorySlotContents(index, ItemStack.EMPTY);
			container.onCraftMatrixChanged(this);
			return stack;
		}
		else {
			stack = getStackInSlot(index).splitStack(count);
			if (getStackInSlot(index).getCount() == 0) {
				setInventorySlotContents(index, ItemStack.EMPTY);
			}
			container.onCraftMatrixChanged(this);
			return stack;
		}
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		tileEntity.setInventorySlotContents(index, stack);
		container.onCraftMatrixChanged(this);
	}
}