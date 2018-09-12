package p455w0rd.sct.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import p455w0rd.sct.containers.ContainerStoneWorkbench;

/**
 * @author p455w0rd
 *
 */
@SideOnly(Side.CLIENT)
public class GuiSCT extends GuiContainer {

	private static final ResourceLocation CRAFTING_TABLE_GUI_TEXTURES = new ResourceLocation("textures/gui/container/crafting_table.png");

	public GuiSCT(ContainerStoneWorkbench container) {
		super(container);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		fontRenderer.drawString(I18n.format("tile.stone_crafting_table.name"), 28, 6, 4210752);
		fontRenderer.drawString(I18n.format("container.inventory"), 8, ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(CRAFTING_TABLE_GUI_TEXTURES);
		int i = guiLeft;
		int j = (height - ySize) / 2;
		this.drawTexturedModalRect(i, j, 0, 0, xSize, ySize);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		renderHoveredToolTip(mouseX, mouseY);
	}

}