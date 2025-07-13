package top.girlkisser.fractal.interfaces;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public interface ISubTabLocation
{
	// tab start y
	int fractal$getY();

	// left
	int fractal$getX();
	int fractal$getH();

	// right
	int fractal$getX2();
	int fractal$getH2();
}
