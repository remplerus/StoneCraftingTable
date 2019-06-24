package p455w0rd.sct.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.registration.*;
import net.minecraft.util.ResourceLocation;
import p455w0rd.sct.client.SCTScreen;
import p455w0rd.sct.container.SCTContainer;
import p455w0rd.sct.init.Constants;
import p455w0rd.sct.init.ModObjects;

/**
 * @author p455w0rd
 *
 */
@JeiPlugin
public class JEI implements IModPlugin {

	private static final ResourceLocation ID = new ResourceLocation(Constants.MODID, Constants.MODID);

	@Override
	public void registerRecipeTransferHandlers(final IRecipeTransferRegistration r) {
		r.addRecipeTransferHandler(SCTContainer.class, VanillaRecipeCategoryUid.CRAFTING, 1, 9, 10, 36);
	}

	@Override
	public void registerGuiHandlers(final IGuiHandlerRegistration r) {
		r.addRecipeClickArea(SCTScreen.class, 88, 32, 28, 23, VanillaRecipeCategoryUid.CRAFTING);
	}

	@Override
	public void registerRecipeCatalysts(final IRecipeCatalystRegistration r) {
		r.addRecipeCatalyst(ModObjects.ITEM_BLOCK_STONE_WORKBENCH.asStack(), VanillaRecipeCategoryUid.CRAFTING);
	}

	@Override
	public ResourceLocation getPluginUid() {
		return ID;
	}

}
