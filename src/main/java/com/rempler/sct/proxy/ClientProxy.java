package com.rempler.sct.proxy;

import com.rempler.sct.table.SCTScreen;
import com.rempler.sct.table.SCTContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

/**
 * @author p455w0rd, updated by Rempler
 *
 */
public class ClientProxy extends CommonProxy {

	@Override
	public void init() {
		ScreenManager.registerFactory(SCTContainer.TYPE, SCTScreen::new);
	}

	@Override
	public PlayerEntity getClientPlayer() {
		return Minecraft.getInstance().player;
	}

	@Override
	public World getClientWorld() {
		return Minecraft.getInstance().world;
	}

}
