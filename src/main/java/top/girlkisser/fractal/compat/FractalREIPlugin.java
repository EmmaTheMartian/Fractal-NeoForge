package top.girlkisser.fractal.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.screen.ExclusionZones;
import me.shedaniel.rei.forge.REIPluginClient;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.world.item.CreativeModeTab;
import top.girlkisser.fractal.interfaces.ICreativeTabParent;
import top.girlkisser.fractal.interfaces.ISubTabLocation;
import top.girlkisser.fractal.mixin.client.CreativeModeInventoryScreenAccessor;

import java.util.List;

@SuppressWarnings("unused")
@REIPluginClient
public class FractalREIPlugin implements REIClientPlugin
{
	@Override
	public void registerExclusionZones(ExclusionZones zones)
	{
		zones.register(CreativeModeInventoryScreen.class, (screen) ->
		{
			CreativeModeTab selected = CreativeModeInventoryScreenAccessor.fractal$getSelectedTab();
			if (selected instanceof ICreativeTabParent parent && screen instanceof ISubTabLocation stl && parent.fractal$getChildren() != null && !parent.fractal$getChildren().isEmpty())
			{
				return List.of(
					new Rectangle(stl.fractal$getX(), stl.fractal$getY(), 72, stl.fractal$getH()),
					new Rectangle(stl.fractal$getX2(), stl.fractal$getY(), 72, stl.fractal$getH2())
				);
			}
			return List.of();
		});
	}
}
