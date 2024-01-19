package dynamic_fps.impl.util;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;

import static dynamic_fps.impl.util.Localization.localized;

import com.mojang.blaze3d.vertex.PoseStack;

import dynamic_fps.impl.DynamicFPSMod;

public final class HudInfoRenderer implements HudRenderCallback {
	@Override
	public void onHudRender(PoseStack poseStack, float tickDelta) {
		if (DynamicFPSMod.isDisabled()) {
			drawCenteredText(poseStack, localized("gui", "hud.disabled"), 32);
		} else if (DynamicFPSMod.isForcingLowFPS()) {
			drawCenteredText(poseStack, localized("gui", "hud.reducing"), 32);
		}
	}

	private void drawCenteredText(PoseStack poseStack, Component component, float y) {
		Minecraft client = Minecraft.getInstance();
		Font fontRenderer = client.gui.getFont();

		int windowWidth = client.getWindow().getGuiScaledWidth();
		int stringWidth = fontRenderer.width(component);

		fontRenderer.drawShadow(
			poseStack,
			component,
			(windowWidth - stringWidth) / 2f,
			y,
			0xFFFFFFFF
		);
	}
}
