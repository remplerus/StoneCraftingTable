package com.rempler.sct.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.registration.*;
import net.minecraft.util.ResourceLocation;
import com.rempler.sct.table.SCTScreen;
import com.rempler.sct.table.SCTContainer;
import com.rempler.sct.init.Constants;
import com.rempler.sct.init.ModObjects;

/**
 * @author p455w0rd, updated by Rempler
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
