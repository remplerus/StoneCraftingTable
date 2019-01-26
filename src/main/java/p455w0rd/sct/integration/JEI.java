package p455w0rd.sct.integration;

import mezz.jei.api.*;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import net.minecraft.item.ItemStack;
import p455w0rd.sct.client.gui.GuiSCT;
import p455w0rd.sct.containers.ContainerStoneWorkbench;
import p455w0rd.sct.init.ModBlocks;

/**
 * @author p455w0rd
 *
 */
@JEIPlugin
public class JEI implements IModPlugin {

	@Override
	public void register(IModRegistry registry) {
		registry.addRecipeClickArea(GuiSCT.class, 88, 32, 28, 23, VanillaRecipeCategoryUid.CRAFTING);
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerStoneWorkbench.class, VanillaRecipeCategoryUid.CRAFTING, 1, 9, 10, 36);
		registry.addRecipeCatalyst(new ItemStack(ModBlocks.STONE_WORKBENCH), VanillaRecipeCategoryUid.CRAFTING);
	}

}
