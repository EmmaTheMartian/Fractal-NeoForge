package top.girlkisser.fractal.compat;

import me.shedaniel.math.Rectangle;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.gui.handlers.IGuiContainerHandler;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import top.girlkisser.fractal.interfaces.ICreativeTabParent;
import top.girlkisser.fractal.interfaces.ISubTabLocation;
import top.girlkisser.fractal.mixin.client.CreativeModeInventoryScreenAccessor;

import java.util.List;

@SuppressWarnings("unused")
@JeiPlugin
public class FractalJEIPlugin implements IModPlugin
{
	public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("fractal", "jei_plugin");

	@Override
	public ResourceLocation getPluginUid()
	{
		return ID;
	}

	@Override
	public void registerGuiHandlers(IGuiHandlerRegistration registration)
	{
		registration.addGenericGuiContainerHandler(CreativeModeInventoryScreen.class, new IGuiContainerHandler<CreativeModeInventoryScreen>()
		{
			@Override
			public List<Rect2i> getGuiExtraAreas(CreativeModeInventoryScreen screen)
			{
				CreativeModeTab selected = CreativeModeInventoryScreenAccessor.fractal$getSelectedTab();
				if (selected instanceof ICreativeTabParent parent && screen instanceof ISubTabLocation stl && parent.fractal$getChildren() != null && !parent.fractal$getChildren().isEmpty())
				{
					return List.of(
						new Rect2i(stl.fractal$getX(), stl.fractal$getY(), 72, stl.fractal$getH()),
						new Rect2i(stl.fractal$getX2(), stl.fractal$getY(), 72, stl.fractal$getH2())
					);
				}
				return List.of();
			}
		});
	}
}
