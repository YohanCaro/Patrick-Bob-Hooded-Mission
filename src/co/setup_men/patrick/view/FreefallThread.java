package co.setup_men.patrick.view;

import co.setup_men.patrick.runner.Constants;

/**
 * Clase FreeFallThread
 * 
 * @author Andr�s Felipe Chaparro Rosas
 * @version 1.0 8/02/2019
 */
public class FreefallThread extends Thread {
	private PatrickBob patricKBob;
	private GamePanel gamePanel;
	private boolean isRightPressed;
	private boolean isLeftPressed;

	public FreefallThread(PatrickBob patricKBob, GamePanel gamePanel) {
		this.patricKBob = patricKBob;
		this.gamePanel = gamePanel;
	}

	@Override
	public void run() {
		super.run();
		float time = Constants.TIME_FRACTION;
		this.patricKBob.setFalling(true);
		this.patricKBob.setOnFloor(false);
		
		while (this.patricKBob.currentFloor >= this.patricKBob.y + this.patricKBob.height) {
			this.patricKBob.detectFloor();
			this.patricKBob.y = Utilities.height(this.patricKBob.y, 0, Constants.GRAVITY, time);
			time += Constants.TIME_FRACTION;
			if (isLeftPressed) {
				this.patricKBob.setImage(PatrickBob.PATRICK_BOB_FALLING_LEFT_01);
			} else if (isRightPressed) {
				this.patricKBob.setImage(PatrickBob.PATRICK_BOB_FALLING_RIGHT_01);
			}
			this.gamePanel.repaint();
			if (this.patricKBob.currentFloor <= this.patricKBob.y + this.patricKBob.height) {
				this.patricKBob.y = this.patricKBob.currentFloor - this.patricKBob.height;
				break;
			} else
				this.patricKBob.setFalling(true);
			try {
				Thread.sleep((int) (Constants.TIME_FRACTION * 1000));
			} catch (InterruptedException e) {
			}
		}
		
		this.patricKBob.floor=this.patricKBob.currentFloor;

		if (isLeftPressed) {
			this.patricKBob.setImage(PatrickBob.PATRICK_BOB_FALLING_LEFT_02);
		} else if (isRightPressed) {
			this.patricKBob.setImage(PatrickBob.PATRICK_BOB_FALLING_RIGHT_02);
		}
		this.gamePanel.repaint();
		try {
			Thread.sleep((int) (Constants.TIME_FRACTION * 1000));
		} catch (InterruptedException e) {
		}
		if (isLeftPressed) {
			this.patricKBob.setImage(PatrickBob.PATRICK_BOB_STAND_LEFT);
		} else if (isRightPressed) {
			this.patricKBob.setImage(PatrickBob.PATRICK_BOB_STAND_RIGHT);
		}
		this.gamePanel.repaint();
		this.patricKBob.setFalling(false);
		this.patricKBob.setOnFloor(true);
		this.interrupt();
	}

	public void setRightPressed(boolean isRightPressed) {
		this.isRightPressed = isRightPressed;
	}

	public void setLeftPressed(boolean isLeftPressed) {
		this.isLeftPressed = isLeftPressed;
	}
}
