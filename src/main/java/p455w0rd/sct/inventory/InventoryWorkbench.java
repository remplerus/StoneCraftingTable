package p455w0rd.sct.inventory;

import p455w0rd.sct.blocks.tiles.TileSCT;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

/**
 * @author Lothrazar via https://github.com/PrinceOfAmber/Cyclic/blob/develop/src/main/java/com/lothrazar/cyclicmagic/block/workbench/InventoryWorkbench.java
 *
 */
public class InventoryWorkbench extends InventoryCrafting {

	private TileSCT tileEntity;
	private Container container;

	public InventoryWorkbench(Container eventHandlerIn, TileSCT tileEntity) {
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

	@Override
	public void markDirty() {
			tileEntity.markDirty();
			IBlockState state = tileEntity.getWorld().getBlockState(tileEntity.getPos());
			tileEntity.getWorld().notifyBlockUpdate(tileEntity.getPos(), state, state, 3);
	}

	@Override
	public void openInventory(EntityPlayer player) {
			super.openInventory(player);
			tileEntity.onOpen(this);
	}

	@Override
	public void closeInventory(EntityPlayer player) {
			super.closeInventory(player);
			tileEntity.onClose(this);
	}

	public void changed() {
			container.onCraftMatrixChanged(this);
	}

	/**
	 * just like vanilla
	 */
	@Override
	public ItemStack decrStackSize(int index, int count) {
		ItemStack is = tileEntity.decrStackSize(index, count);
		if (is != ItemStack.EMPTY)
			tileEntity.updateInvs();
		return is;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		tileEntity.setInventorySlotContents(index, stack);
		tileEntity.updateInvs();
	}
}
