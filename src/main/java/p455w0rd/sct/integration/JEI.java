package p455w0rd.sct.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.registration.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import p455w0rd.sct.client.gui.GuiSCT;
import p455w0rd.sct.containers.ContainerStoneWorkbench;
import p455w0rd.sct.init.ModBlocks;
import p455w0rd.sct.init.ModGlobals;

/**
 * @author p455w0rd
 *
 */
@JeiPlugin
public class JEI implements IModPlugin {

	private static final ResourceLocation ID = new ResourceLocation(ModGlobals.MODID, "");

	@Override
	public void registerRecipeTransferHandlers(final IRecipeTransferRegistration r) {
		r.addRecipeTransferHandler(ContainerStoneWorkbench.class, VanillaRecipeCategoryUid.CRAFTING, 1, 9, 10, 36);
	}

	@Override
	public void registerGuiHandlers(final IGuiHandlerRegistration r) {
		r.addRecipeClickArea(GuiSCT.class, 88, 32, 28, 23, VanillaRecipeCategoryUid.CRAFTING);
	}

	@Override
	public void registerRecipeCatalysts(final IRecipeCatalystRegistration r) {
		r.addRecipeCatalyst(new ItemStack(ModBlocks.STONE_WORKBENCH), VanillaRecipeCategoryUid.CRAFTING);
	}

	@Override
	public ResourceLocation getPluginUid() {
		return ID;
	}

}
