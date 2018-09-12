package p455w0rd.sct.init;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
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
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity tile = world.getTileEntity(pos);
		if (tile != null && tile instanceof TileSCT) {
			return new ContainerStoneWorkbench((TileSCT) tile, player);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity tile = world.getTileEntity(pos);
		if (tile != null && tile instanceof TileSCT) {
			return new GuiSCT(new ContainerStoneWorkbench((TileSCT) tile, player));
		}
		return null;
	}

}
