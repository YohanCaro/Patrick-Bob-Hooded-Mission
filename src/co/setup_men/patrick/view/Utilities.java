package co.setup_men.patrick.view;

/**
 * Clase Utilities
 * @author Andrés Felipe Chaparro Rosas
 * @version 1.0 9/02/2019
 */
public class Utilities {

	public static float height(float h, float v, float g, float t) {
		return h + (v * t) + ((t * t * g) / 2);
	}

	public static double time(float h, float g) {
		return Math.sqrt(2 * (h * -1) / g);
	}

	public static float finalSpeed(float v, float g, float t) {
		return v + g * t;
	}
}
