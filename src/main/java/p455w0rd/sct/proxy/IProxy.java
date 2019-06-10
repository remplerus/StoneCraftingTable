package p455w0rd.sct.proxy;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import p455w0rd.sct.init.ModGuiHandler.GUI;

/**
 * @author p455w0rd
 *
 */
public interface IProxy {

	default World getWorld() {
		return null;
	}

	default PlayerEntity getPlayer() {
		return null;
	}

	default boolean openGui(final GUI type, final PlayerEntity player, final BlockPos pos) {
		return false;
	}

}
