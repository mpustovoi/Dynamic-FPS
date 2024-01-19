package dynamic_fps.impl.mixin;

import net.minecraft.client.gui.components.toasts.Toast;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import dynamic_fps.impl.DynamicFPSMod;
import net.minecraft.client.gui.components.toasts.ToastComponent;

import java.util.Deque;

@Mixin(ToastComponent.class)
public class ToastComponentMixin {
	@Redirect(method = "render", at = @At(value = "INVOKE", target = "Ljava/util/Deque;isEmpty()Z"))
	private boolean onQueueIsEmpty(Deque<Toast> queued) {
		if (!DynamicFPSMod.shouldShowToasts()) {
			return true;
		} else {
			return queued.isEmpty();
		}
	}
}
