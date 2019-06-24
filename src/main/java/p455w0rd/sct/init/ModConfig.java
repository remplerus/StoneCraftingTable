package p455w0rd.sct.init;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class ModConfig {

	public static final ForgeConfigSpec CONFIG_SPEC;
	//private static final ModConfig CONFIG;

	public static BooleanValue INFINITE_USE;

	static {
		final Pair<ModConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ModConfig::new);
		CONFIG_SPEC = specPair.getRight();
		//CONFIG = specPair.getLeft();
	}

	ModConfig(final ForgeConfigSpec.Builder builder) {
		builder.push("general");
		INFINITE_USE = builder.define("infiniteUse", true);
		builder.pop();
	}

}
