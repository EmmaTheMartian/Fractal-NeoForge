package top.girlkisser.fractal.mixin;

import top.girlkisser.fractal.api.CreativeSubTab;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreativeModeTabs.class)
public abstract class CreativeModeTabsMixin
{
	@Inject(at = @At("HEAD"), method = "buildAllTabContents")
	private static void buildAllTabContents(CreativeModeTab.ItemDisplayParameters parameters, CallbackInfo ci)
	{
		CreativeSubTab.SUBTABS.forEach(it -> it.buildContents(parameters));
	}
}
