package co.setup_men.patrick.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import co.setup_men.patrick.view.GamePanel;
import co.setup_men.patrick.view.JumpThread;
import co.setup_men.patrick.view.PatrickBob;
import co.setup_men.patrick.view.WalkThread;

public class KeyController implements KeyListener {

	private static KeyController keyController = null;

	private WalkThread walkThread;
	private GamePanel gamePanel;
	private PatrickBob patricKBob;

	ArrayList<Integer> keys;

	private KeyController() {
		keys = new ArrayList<>();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		addKey(e.getKeyCode());
		keyDirector();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		deleteKey(e.getKeyCode());
		keyDirector();
	}

	void keyDirector() {
		for (int i = 0; i < keys.size(); i++) {
			switch (keys.get(i)) {
			case KeyEvent.VK_LEFT:
				if (this.walkThread != null) {
					if (!this.walkThread.isLeftPressed()) {
						this.walkThread.setRightPressed(false);
						this.walkThread = null;
					}
				}
				if (this.walkThread == null) {
					this.walkThread = new WalkThread(this.patricKBob, this.gamePanel);
					this.walkThread.setLeftPressed(true);
					this.walkThread.start();
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (this.walkThread != null)
					if (!this.walkThread.isRightPressed()) {
						this.walkThread.setLeftPressed(false);
						this.walkThread = null;
					}
				if (this.walkThread == null) {
					this.walkThread = new WalkThread(this.patricKBob, this.gamePanel);
					this.walkThread.setRightPressed(true);
					this.walkThread.start();
				}
				break;
			case KeyEvent.VK_X:
				JumpThread thread = new JumpThread(this.patricKBob, this.gamePanel);
				if (this.patricKBob.isOnFloor()) {
					if (this.walkThread != null) {
						thread.setRightPressed(this.walkThread.isRightPressed());
						thread.setLeftPressed(this.walkThread.isLeftPressed());
					}
					this.patricKBob.setOnFloor(false);
					thread.start();
				}
				break;
			case KeyEvent.VK_Z:
				if (this.walkThread != null)
					this.walkThread.setFastPressed(true);
				break;
			}
		}
	}

	void addKey(int code) {
		if (!keys.contains(code)) {
			keys.add(code);
		}
	}

	void deleteKey(int code) {
		for (int i = 0; i < keys.size(); i++) {
			if (code == keys.get(i)) {
				if (this.walkThread != null)
					if (code == KeyEvent.VK_RIGHT)
						this.walkThread.setRightPressed(false);
					else if (code == KeyEvent.VK_LEFT)
						this.walkThread.setLeftPressed(false);
					else if (code == KeyEvent.VK_Z)
						this.walkThread.setFastPressed(false);
				keys.remove(i);
			}
		}
	}

	public static KeyController getInstance() {
		if (keyController == null)
			keyController = new KeyController();
		return keyController;
	}

	public void setPatricKBob(PatrickBob patricKBob) {
		this.patricKBob = patricKBob;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
