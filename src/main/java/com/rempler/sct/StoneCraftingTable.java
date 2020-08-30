package com.rempler.sct;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import com.rempler.sct.init.Constants;
import com.rempler.sct.proxy.ClientProxy;
import com.rempler.sct.proxy.CommonProxy;

@Mod(Constants.MODID)
public class StoneCraftingTable {

	private static StoneCraftingTable instance;
	private static CommonProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new CommonProxy());

	public StoneCraftingTable() {
		if (instance == null) {
			instance = this;
		}
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
		//ModLoadingContext.get().registerConfig(Type.COMMON, ModConfig.CONFIG_SPEC);
	}

	public static StoneCraftingTable getInstance() {
		return instance;
	}

	public static CommonProxy getProxy() {
		return proxy;
	}

	private void init(final FMLCommonSetupEvent e) {
		proxy.init();
	}

}