package p455w0rd.sct.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import p455w0rd.sct.init.ModGuiHandler;
import p455w0rd.sct.init.ModGuiHandler.GUI;

/**
 * @author p455w0rd
 *
 */
public class ClientProxy extends CommonProxy {

	@Override
	public boolean openGui(final GUI type, final PlayerEntity player, final BlockPos pos) {
		final boolean ret = super.openGui(type, player, pos);
		return ModGuiHandler.openGuiClient(type, player, pos) && ret;
	}

	@Override
	public PlayerEntity getPlayer() {
		return Minecraft.getInstance().field_71439_g;
	}

	@Override
	public World getWorld() {
		return Minecraft.getInstance().field_71441_e;
	}

}
