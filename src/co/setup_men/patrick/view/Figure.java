package co.setup_men.patrick.view;

import java.awt.Graphics;

/**
 * Clase Entity
 * 
 * @author Andrés Felipe Chaparro Rosas
 * @version 1.0 8/02/2019
 */
public abstract class Figure {
	protected float x, y, width, height, floor;

	public Figure(int x, int y, int width, int height, int floor) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.floor = floor;
	}

	public abstract void draw(Graphics g);
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void setFloor(float floor) {
		this.floor = floor;
	}
}
