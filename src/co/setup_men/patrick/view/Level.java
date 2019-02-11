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
	protected float x, y;
	private ArrayList<Platform> platforms;

	public Level() {
		this.platforms = new ArrayList<>();
		this.x = 0;
		this.y = 0;
		this.init();
	}

	private void init() {
		platforms.add(new Platform((int) this.x + 100, (int) this.y + 450, 200, 40));
		platforms.add(new Platform((int) this.x + 350, (int) this.y + 380, 200, 40));
		platforms.add(new Platform((int) this.x + 100, (int) this.y + 310, 200, 40));
		platforms.add(new Platform((int) this.x + 350, (int) this.y + 240, 200, 40));

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

	public void setPlatforms(ArrayList<Platform> platforms) {
		this.platforms = platforms;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void addX(float x) {
		this.x += x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void addY(float y) {
		this.y += y;
	}

}
