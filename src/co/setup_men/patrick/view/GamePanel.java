package co.setup_men.patrick.view;

import java.awt.Graphics;

import javax.swing.JPanel;

import co.setup_men.patrick.controller.KeyController;

public class GamePanel extends JPanel {

	private PatrickBob patricKBob;
	private Level level;

	public GamePanel() {
		KeyController.getInstance().setGamePanel(this);
		this.level = new Level();
		this.patricKBob = new PatrickBob((int) this.level.getFloor().floor);
		this.patricKBob.setPlatforms(this.level.getPlatforms());
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		this.level.draw(g);
		this.patricKBob.draw(g);
	}

}
