package p455w0rd.sct.init;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModConfig {

	public static Configuration config;

	public static void init() {
		config = new Configuration(new File(ModGlobals.CONFIG_FILE));
		MinecraftForge.EVENT_BUS.register(new ModConfig());

		if (config.hasChanged()) {
			config.save();
		}
	}

	@SubscribeEvent
	public void onConfigChange(ConfigChangedEvent.OnConfigChangedEvent e) {
		if (e.getModID().equals(ModGlobals.MODID)) {
			init();
		}
	}

	public static class Options {

		public static boolean INFINITE_USE = false;

	}
}
