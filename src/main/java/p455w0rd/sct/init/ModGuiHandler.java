package p455w0rd.sct.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.network.IGuiHandler;
import p455w0rd.sct.blocks.tiles.TileSCT;
import p455w0rd.sct.client.gui.GuiSCT;
import p455w0rd.sct.containers.ContainerStoneWorkbench;

/**
 * @author p455w0rd
 *
 */
public class ModGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(final int ID, final PlayerEntity player, final World world, final int x, final int y, final int z) {
		final BlockPos pos = new BlockPos(x, y, z);
		final TileEntity tile = world.getTileEntity(pos);
		if (tile != null && tile instanceof TileSCT) {
			return new ContainerStoneWorkbench((TileSCT) tile, player, 0);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(final int ID, final PlayerEntity player, final World world, final int x, final int y, final int z) {
		return getClientGuiElement(ID, player, world, new BlockPos(x, y, z));
	}

	public Object getClientGuiElement(final int ID, final PlayerEntity player, final World world, final BlockPos pos) {
		final TileEntity tile = world.getTileEntity(pos);
		if (tile != null && tile instanceof TileSCT) {
			return new GuiSCT(new ContainerStoneWorkbench((TileSCT) tile, player, 0), player.field_71071_by, new StringTextComponent("Stone Crafting Table"));
		}
		return null;
	}

	@OnlyIn(Dist.CLIENT)
	public static boolean openGuiClient(final GUI type, final PlayerEntity player, final BlockPos pos) {
		if (type != null) {
			final Screen gui = getGui(type, player, pos);
			if (gui != null) {
				Minecraft.getInstance().displayGuiScreen(gui);
				return true;
			}
		}
		return false;
	}

	public static boolean openGuiServer(final GUI type, final PlayerEntity player, final BlockPos pos) {
		final TileEntity tile = player.getEntityWorld().getTileEntity(pos);
		switch (type) {
		case STONE_CRAFTING_TABLE:
			if (tile != null && tile instanceof TileSCT) {
				final ContainerStoneWorkbench c = getContainer(type, player, pos);
				if (c != null) {
					player.field_71070_bA = c;
					return true;
				}
			}
		default:
			return false;
		}
	}

	private static ContainerStoneWorkbench getContainer(final GUI type, final PlayerEntity player, final BlockPos pos) {
		final TileEntity tile = player.getEntityWorld().getTileEntity(pos);
		switch (type) {
		case STONE_CRAFTING_TABLE:
			if (tile != null && tile instanceof TileSCT) {
				return new ContainerStoneWorkbench((TileSCT) tile, player, 0);
			}
		default:
			return null;
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static Screen getGui(final GUI type, final PlayerEntity player, final BlockPos pos) {
		final TileEntity tile = player.getEntityWorld().getTileEntity(pos);
		switch (type) {
		case STONE_CRAFTING_TABLE:
			if (tile != null && tile instanceof TileSCT) {
				final ContainerStoneWorkbench c = getContainer(type, player, pos);
				if (c != null) {
					player.field_71070_bA = c;
					return new GuiSCT(c, player.field_71071_by, new StringTextComponent("Stone Crafting Table"));
				}
			}
		default:
			return null;
		}
	}

	public static enum GUI {

			STONE_CRAFTING_TABLE

	}

}
