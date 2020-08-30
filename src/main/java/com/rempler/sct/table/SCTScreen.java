package com.rempler.sct.table;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import com.rempler.sct.table.SCTContainer;

/**
 * @author p455w0rd, updated by Rempler
 *
 */
@OnlyIn(Dist.CLIENT)
public class SCTScreen extends ContainerScreen<SCTContainer> {

	private static final ResourceLocation CRAFTING_TABLE_GUI_TEXTURES = new ResourceLocation("textures/gui/container/crafting_table.png");

	public SCTScreen(final SCTContainer container, final PlayerInventory inventory, final ITextComponent text) {
		super(container, inventory, text);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(final int mouseX, final int mouseY) {
		font.drawString(I18n.format("block.sct.stone_crafting_table"), 28, 6, 4210752);
		font.drawString(I18n.format("container.inventory"), 8, ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(final float partialTicks, final int mouseX, final int mouseY) {
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		minecraft.getTextureManager().bindTexture(CRAFTING_TABLE_GUI_TEXTURES);
		final int i = guiLeft;
		final int j = (height - ySize) / 2;
		this.blit(i, j, 0, 0, xSize, ySize);
	}

	@Override
	public void render(final int mouseX, final int mouseY, final float partialTicks) {
		if (minecraft != null) {
			renderBackground();
			super.render(mouseX, mouseY, partialTicks);
			renderHoveredToolTip(mouseX, mouseY);
		}
	}

}