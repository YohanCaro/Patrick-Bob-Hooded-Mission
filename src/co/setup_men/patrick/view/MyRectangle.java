package co.setup_men.patrick.view;

import java.awt.Graphics;

public class MyRectangle extends Figure {

	public MyRectangle(int x, int y, int width, int height, int floor) {
		super(x, y, width, height, floor);
	}

	@Override
	public void draw(Graphics g) {
		g.fillRect((int) x, (int) y, (int) width, (int) height);
	}
}
