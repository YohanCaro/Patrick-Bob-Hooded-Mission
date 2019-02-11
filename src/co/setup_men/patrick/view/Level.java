package co.setup_men.patrick.view;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Clase Level
 * 
 * @author Andrés Felipe Chaparro Rosas
 * @version 1.0 10/02/2019
 */
public class Level {
	private ArrayList<Platform> platforms;

	public Level() {
		this.platforms = new ArrayList<>();
		this.init();
	}

	private void init() {
		platforms.add(new Platform(100, 450, 200, 40));
		platforms.add(new Platform(350, 380, 200, 40));
		platforms.add(new Platform(100, 310, 200, 40));
		platforms.add(new Platform(350, 240, 200, 40));

		// Plataforma suelo al final
		platforms.add(new Platform(0, 520, 1000, 70));
	}

	public void draw(Graphics graphics) {
		for (Platform platform : platforms) {
			platform.draw(graphics);
		}
	}

	public Platform getFloor() {
		return this.platforms.get(this.platforms.size() - 1);
	}

	public ArrayList<Platform> getPlatforms() {
		return this.platforms;
	}
}
