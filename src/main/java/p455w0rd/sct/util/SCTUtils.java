package p455w0rd.sct.util;

import java.util.Set;

import org.apache.logging.log4j.LogManager;

import com.mojang.datafixers.DataFixUtils;
import com.mojang.datafixers.types.Type;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.datafix.DataFixesManager;
import net.minecraft.util.datafix.TypeReferences;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import p455w0rd.sct.init.ModGlobals;

/**
 * @author p455w0rd
 *
 */
public class SCTUtils {

	public static <T extends TileEntity> TileEntityType<T> registerTileEntityType(final String id, final TileEntityType.Builder<T> builder) {
		Type<?> type = null;

		try {
			type = DataFixesManager.getDataFixer().getSchema(DataFixUtils.makeKey(SharedConstants.getVersion().getWorldVersion())).getChoiceType(TypeReferences.BLOCK_ENTITY, id);
		}
		catch (final IllegalArgumentException illegalstateexception) {
			if (SharedConstants.developmentMode) {
				throw illegalstateexception;
			}

			LogManager.getLogger(ModGlobals.MODID).warn("No data fixer registered for block entity {}", id);
		}

		if (getBlocksFromBuilder(builder).isEmpty()) {
			LogManager.getLogger(ModGlobals.MODID).warn("Block entity type {} requires at least one valid block to be defined!", id);
		}

		return Registry.register(Registry.field_212626_o, id, builder.build(type));
	}

	private static <T extends TileEntity> Set<Block> getBlocksFromBuilder(final TileEntityType.Builder<T> builder) {
		return ObfuscationReflectionHelper.getPrivateValue(TileEntityType.Builder.class, builder, "field_223044_b");
	}

}
