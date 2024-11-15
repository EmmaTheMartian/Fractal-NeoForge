package de.dafuqs.fractal;

import net.fabricmc.api.*;

public class Fractal implements ModInitializer {
	
	/*
	// Texture (put into \resources\assets\fractal\textures\gui\container\creative_inventory)
	public static final Identifier BACKGROUND_TEXTURE = Identifier.of("fractal", "textures/gui/container/creative_inventory/custom_background.png");
	
	// Sprites (put into \resources\assets\fractal\textures\gui\sprites\container\creative_inventory)
	public static final Identifier SCROLLBAR_ENABLED_TEXTURE = Identifier.of("fractal", "container/creative_inventory/custom_scrollbar_enabled");
	public static final Identifier SCROLLBAR_DISABLED_TEXTURE = Identifier.of("fractal", "container/creative_inventory/custom_scrollbar_disabled");
	
	public static final Identifier SUBTAB_SELECTED_TEXTURE_LEFT = Identifier.of("fractal", "container/creative_inventory/custom_subtab_selected_left");
	public static final Identifier SUBTAB_UNSELECTED_TEXTURE_LEFT = Identifier.of("fractal", "container/creative_inventory/custom_subtab_unselected_left");
	public static final Identifier SUBTAB_SELECTED_TEXTURE_RIGHT = Identifier.of("fractal", "container/creative_inventory/custom_subtab_selected_right");
	public static final Identifier SUBTAB_UNSELECTED_TEXTURE_RIGHT = Identifier.of("fractal", "container/creative_inventory/custom_subtab_unselected_right");
	
	public static final Identifier TAB_TOP_FIRST_SELECTED_TEXTURE = Identifier.of("fractal", "container/creative_inventory/custom_tab_top_first_selected");
	public static final Identifier TAB_TOP_SELECTED_TEXTURE = Identifier.of("fractal", "container/creative_inventory/custom_tab_top_selected");
	public static final Identifier TAB_TOP_LAST_SELECTED_TEXTURE = Identifier.of("fractal", "container/creative_inventory/custom_tab_top_last_selected");
	public static final Identifier TAB_TOP_FIRST_UNSELECTED_TEXTURE = Identifier.of("fractal", "container/creative_inventory/custom_tab_top_first_unselected");
	public static final Identifier TAB_TOP_UNSELECTED_TEXTURE = Identifier.of("fractal", "container/creative_inventory/custom_tab_top_unselected");
	public static final Identifier TAB_TOP_LAST_UNSELECTED_TEXTURE = Identifier.of("fractal", "container/creative_inventory/custom_tab_top_last_unselected");
	public static final Identifier TAB_BOTTOM_FIRST_SELECTED_TEXTURE = Identifier.of("fractal", "container/creative_inventory/custom_tab_bottom_first_selected");
	public static final Identifier TAB_BOTTOM_SELECTED_TEXTURE = Identifier.of("fractal", "container/creative_inventory/custom_tab_bottom_selected");
	public static final Identifier TAB_BOTTOM_LAST_SELECTED_TEXTURE = Identifier.of("fractal", "container/creative_inventory/custom_tab_bottom_last_selected");
	public static final Identifier TAB_BOTTOM_FIRST_UNSELECTED_TEXTURE = Identifier.of("fractal", "container/creative_inventory/custom_tab_bottom_first_unselected");
	public static final Identifier TAB_BOTTOM_UNSELECTED_TEXTURE = Identifier.of("fractal", "container/creative_inventory/custom_tab_bottom_unselected");
	public static final Identifier TAB_BOTTOM_LAST_UNSELECTED_TEXTURE = Identifier.of("fractal", "container/creative_inventory/custom_tab_bottom_last_unselected");
	
	public static final ItemSubGroupStyle STYLE = new ItemSubGroupStyle.Builder()
			.background(BACKGROUND_TEXTURE)
			.scrollbar(SCROLLBAR_ENABLED_TEXTURE, SCROLLBAR_DISABLED_TEXTURE)
			.subtab(SUBTAB_SELECTED_TEXTURE_LEFT, SUBTAB_UNSELECTED_TEXTURE_LEFT, SUBTAB_SELECTED_TEXTURE_RIGHT, SUBTAB_UNSELECTED_TEXTURE_RIGHT)
			.tab(TAB_TOP_FIRST_SELECTED_TEXTURE, TAB_TOP_SELECTED_TEXTURE, TAB_TOP_LAST_SELECTED_TEXTURE, TAB_TOP_FIRST_UNSELECTED_TEXTURE, TAB_TOP_UNSELECTED_TEXTURE, TAB_TOP_LAST_UNSELECTED_TEXTURE,
					TAB_BOTTOM_FIRST_SELECTED_TEXTURE, TAB_BOTTOM_SELECTED_TEXTURE, TAB_BOTTOM_LAST_SELECTED_TEXTURE, TAB_BOTTOM_FIRST_UNSELECTED_TEXTURE, TAB_BOTTOM_UNSELECTED_TEXTURE, TAB_BOTTOM_LAST_UNSELECTED_TEXTURE)
			.build();
	
	public static final Identifier GROUP_ID = Identifier.of("mymod", "main");
	
	public static final ItemGroup MAIN = FabricItemGroup.builder()
			.icon(() -> new ItemStack(Blocks.REDSTONE_BLOCK))
			.entries((displayContext, entries) -> {
				for (ItemSubGroup subGroup : Fractal.MAIN.fractal$getChildren()) {
					entries.addAll(subGroup.getSearchTabStacks(), ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
				}
			})
			.displayName(Text.translatable("mymod.1"))
			.noRenderedName()
			.build();
	
	public static final ItemGroup EQUIPMENT = new ItemSubGroup.Builder(MAIN, Identifier.of("mymod", "equipment"), Text.translatable("itemGroup.mymod.equipment")).styled(STYLE).entries((displayContext, entries) -> entries.add(Items.APPLE)).build();
	public static final ItemGroup FUNCTIONAL = new ItemSubGroup.Builder(MAIN, Identifier.of("mymod", "functional"), Text.translatable("itemGroup.mymod.functional")).styled(STYLE).entries((displayContext, entries) -> entries.add(Items.BAKED_POTATO)).build();
	public static final ItemGroup CUISINE = new ItemSubGroup.Builder(MAIN, Identifier.of("mymod", "cuisine"), Text.translatable("itemGroup.mymod.cuisine")).entries((displayContext, entries) -> entries.add(Items.CACTUS)).build();
	public static final ItemGroup RESOURCES = new ItemSubGroup.Builder(MAIN, Identifier.of("mymod", "resources"), Text.translatable("itemGroup.mymod.resources")).entries((displayContext, entries) -> entries.add(Items.DANDELION)).build();
	*/
	
	@Override
	public void onInitialize() {
		//Registry.register(Registries.ITEM_GROUP, GROUP_ID, MAIN);
	}
	
}