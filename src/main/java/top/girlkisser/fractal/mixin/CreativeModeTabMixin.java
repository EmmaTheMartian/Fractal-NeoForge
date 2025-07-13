package top.girlkisser.fractal.mixin;

import com.google.common.collect.Lists;
import top.girlkisser.fractal.api.CreativeSubTab;
import top.girlkisser.fractal.interfaces.ICreativeTabParent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;
import java.util.List;

@Mixin(CreativeModeTab.class)
public abstract class CreativeModeTabMixin implements ICreativeTabParent
{
	@Unique
	private final List<CreativeSubTab> fractal$children = Lists.newArrayList();
	@Unique
	private CreativeSubTab fractal$selectedChild = null;

	@Inject(at = @At("HEAD"), method = "getDisplayItems", cancellable = true)
	public void getDisplayItems(CallbackInfoReturnable<Collection<ItemStack>> cir)
	{
		if (fractal$selectedChild != null)
		{
			cir.setReturnValue(fractal$selectedChild.getDisplayItems());
		}
	}

	@Override
	public List<CreativeSubTab> fractal$getChildren()
	{
		return fractal$children;
	}

	@Override
	public CreativeSubTab fractal$getSelectedChild()
	{
		return fractal$selectedChild;
	}

	@Override
	public void fractal$setSelectedChild(CreativeSubTab group)
	{
		fractal$selectedChild = group;
	}
}
