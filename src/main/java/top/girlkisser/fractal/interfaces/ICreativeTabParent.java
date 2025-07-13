package top.girlkisser.fractal.interfaces;

import top.girlkisser.fractal.api.CreativeSubTab;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

@ApiStatus.Internal
public interface ICreativeTabParent
{
	default List<CreativeSubTab> fractal$getChildren()
	{
		return null;
	}

	default CreativeSubTab fractal$getSelectedChild()
	{
		return null;
	}

	default void fractal$setSelectedChild(CreativeSubTab group)
	{
	}
}
