package p455w0rd.sct.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import p455w0rd.sct.client.gui.GuiSCT;
import p455w0rd.sct.containers.ContainerStoneWorkbench;

/**
 * @author p455w0rd
 *
 */
public class ClientProxy extends CommonProxy {

	@Override
	public void init() {
		ScreenManager.registerFactory(ContainerStoneWorkbench.TYPE, GuiSCT::new);
	}

	@Override
	public PlayerEntity getPlayer() {
		return Minecraft.getInstance().player;
	}

	@Override
	public World getWorld() {
		return Minecraft.getInstance().world;
	}

}
