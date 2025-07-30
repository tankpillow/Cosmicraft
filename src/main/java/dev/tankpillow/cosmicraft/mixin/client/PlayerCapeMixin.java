package dev.tankpillow.cosmicraft.mixin.client;

import java.util.UUID;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import dev.tankpillow.cosmicraft.misc.cape.CapeManager;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.util.Identifier;

@Mixin(AbstractClientPlayerEntity.class)
public abstract class PlayerCapeMixin {

	@Inject(method = "getCapeTexture", at = @At("RETURN"), cancellable = true)
	private void injectCapeSkinTextures(CallbackInfoReturnable<Identifier> cir) {
		AbstractClientPlayerEntity self = (AbstractClientPlayerEntity) (Object) this;
		Identifier original = cir.getReturnValue();
		
		UUID uuid = self.getUuid();
		Identifier customCape = CapeManager.getCapeForUUID(uuid);
		if(customCape != null) {
			cir.setReturnValue(customCape);
		}
		cir.setReturnValue(original);
	}
	
}
