package p455w0rd.sct.containers;

import java.util.Optional;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.play.server.SSetSlotPacket;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import p455w0rd.sct.blocks.tiles.TileSCT;
import p455w0rd.sct.inventory.InventoryWorkbench;

/**
 * @author p455w0rd
 *
 */
public class ContainerStoneWorkbench extends RecipeBookContainer<InventoryWorkbench> {

	private final TileSCT tile;
	private final InventoryWorkbench craftMatrix;
	private final CraftResultInventory craftResult;
	private final World world;
	private final PlayerEntity player;

	public ContainerStoneWorkbench(final TileSCT tile, final PlayerEntity player, final int id) {
		super(ContainerType.field_221518_l, id);
		this.tile = tile;
		world = player.world;
		this.player = player;
		craftResult = new CraftResultInventory() {
			@Override
			public void markDirty() {
				tile.markDirty();
				final BlockState state = tile.getWorld().getBlockState(tile.getPos());
				tile.getWorld().notifyBlockUpdate(tile.getPos(), state, state, 3);
			}
		};
		craftMatrix = new InventoryWorkbench(this, tile);
		craftMatrix.openInventory(player);
		addSlot(new CraftingResultSlot(player, craftMatrix, craftResult, 0, 124, 35));
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				addSlot(new Slot(craftMatrix, j + i * 3, 30 + j * 18, 17 + i * 18));
			}
		}
		for (int k = 0; k < 3; ++k) {
			for (int i1 = 0; i1 < 9; ++i1) {
				addSlot(new Slot(player.field_71071_by, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
			}
		}

		for (int l = 0; l < 9; ++l) {
			addSlot(new Slot(player.field_71071_by, l, 8 + l * 18, 142));
		}
		onCraftMatrixChanged(craftMatrix);
		tile.updateInvs();
	}

	@Override
	public void onCraftMatrixChanged(final IInventory inventory) {
		IWorldPosCallable.of(world, player.getPosition()).consume((world, pos) -> {
			if (!world.isRemote) {
				final ServerPlayerEntity playerMp = (ServerPlayerEntity) player;
				ItemStack stack = ItemStack.EMPTY;
				final Optional<ICraftingRecipe> optional = world.getServer().getRecipeManager().func_215371_a(IRecipeType.field_222149_a, craftMatrix, world);
				if (optional.isPresent()) {
					final ICraftingRecipe icraftingrecipe = optional.get();
					if (craftResult.canUseRecipe(world, playerMp, icraftingrecipe)) {
						stack = icraftingrecipe.getCraftingResult(craftMatrix);
					}
				}

				craftResult.setInventorySlotContents(0, stack);
				playerMp.connection.sendPacket(new SSetSlotPacket(windowId, 0, stack));
			}
		});
	}

	@Override
	public void func_201771_a(final RecipeItemHelper rih) {
		craftMatrix.fillStackedContents(rih);
	}

	@Override
	public void clear() {
		craftMatrix.clear();
		craftResult.clear();
	}

	@Override
	public boolean matches(final IRecipe<? super InventoryWorkbench> recipe) {
		return recipe.matches(craftMatrix, player.world);
	}

	@Override
	public int getOutputSlot() {
		return 0;
	}

	@Override
	public int getWidth() {
		return craftMatrix.getWidth();
	}

	@Override
	public int getHeight() {
		return craftMatrix.getHeight();
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public int getSize() {
		return 10;
	}

	@Override
	public boolean canInteractWith(final PlayerEntity player) {
		return tile.isUsableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(final PlayerEntity player, final int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		final Slot slot = inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			final ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (index == 0) {
				itemstack1.getItem().onCreated(itemstack1, world, player);
				if (!mergeItemStack(itemstack1, 10, 46, true)) {
					return ItemStack.EMPTY;
				}
				slot.onSlotChange(itemstack1, itemstack);
			}
			else if (index >= 10 && index < 37) {
				if (!mergeItemStack(itemstack1, 37, 46, false)) {
					return ItemStack.EMPTY;
				}
			}
			else if (index >= 37 && index < 46) {
				if (!mergeItemStack(itemstack1, 10, 37, false)) {
					return ItemStack.EMPTY;
				}
			}
			else if (!mergeItemStack(itemstack1, 10, 46, false)) {
				return ItemStack.EMPTY;
			}
			if (itemstack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			}
			else {
				slot.onSlotChanged();
			}
			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}
			final ItemStack itemstack2 = slot.onTake(player, itemstack1);
			if (index == 0) {
				player.dropItem(itemstack2, false);
			}
		}
		return itemstack;
	}

	@Override
	public boolean canMergeSlot(final ItemStack stack, final Slot slotIn) {
		return slotIn.inventory != craftResult && super.canMergeSlot(stack, slotIn);
	}

}