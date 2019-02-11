package co.setup_men.patrick.view;

import java.awt.Graphics;

/**
 * Clase Platform
 * 
 * @author Andrés Felipe Chaparro Rosas
 * @version 1.0 10/02/2019
 */
public class Platform extends Figure {

	public Platform(int x, int y, int width, int height) {
		super(x, y, width, height, y);
	}

	@Override
	public void draw(Graphics g) {
		g.fillRect((int) this.x, (int) this.y, (int) this.width, (int) this.height);
	}
}
