package top.girlkisser.fractal.api;

import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.Event;

public class CreativeSubTabEvent extends Event
{
	private final CreativeModeTab tab;
	private final CreativeSubTab subGroup;
	private final CreativeModeTab.Output itemDisplayBuilder;

	public CreativeSubTabEvent(CreativeModeTab tab, CreativeSubTab subGroup, CreativeModeTab.Output itemDisplayBuilder)
	{
		this.tab = tab;
		this.subGroup = subGroup;
		this.itemDisplayBuilder = itemDisplayBuilder;
	}

	public CreativeModeTab getTab()
	{
		return tab;
	}

	public CreativeSubTab subGroup()
	{
		return subGroup;
	}

	public CreativeModeTab.Output getItemDisplayBuilder()
	{
		return itemDisplayBuilder;
	}
}
