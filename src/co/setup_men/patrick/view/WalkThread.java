package co.setup_men.patrick.view;

import co.setup_men.patrick.runner.Constants;

/**
 * Clase FreeFallThread
 * 
 * @author Andrés Felipe Chaparro Rosas
 * @version 1.0 8/02/2019
 */
public class WalkThread extends Thread {
	private PatrickBob patricKBob;
	private GamePanel gamePanel;
	protected boolean isRightPressed;
	protected boolean isLeftPressed;
	protected boolean isFastPressed;

	public WalkThread(PatrickBob patricKBob, GamePanel gamePanel) {
		this.patricKBob = patricKBob;
		this.gamePanel = gamePanel;
		this.isRightPressed = false;
		this.isLeftPressed = false;
	}

	@Override
	public void run() {
		super.run();
		while (this.isRightPressed) {
			this.patricKBob.detectFloor();
			if (this.patricKBob.isOnFloor())
				if (this.patricKBob.isActualSprite(PatrickBob.PATRICK_BOB_WALK_RIGHT_01)) {
					this.patricKBob.setImage(PatrickBob.PATRICK_BOB_WALK_RIGHT_02);
					this.gamePanel.repaint();
				} else {
					this.patricKBob.setImage(PatrickBob.PATRICK_BOB_WALK_RIGHT_01);
					this.gamePanel.repaint();
				}
			if (this.isLeftPressed)
				break;
			if (isFastPressed)
				this.patricKBob.x += Constants.NORMAL_SPEED * 2;
			else
				this.patricKBob.x += Constants.NORMAL_SPEED;
			if (this.patricKBob.currentFloor != this.patricKBob.floor) {
				if (!this.patricKBob.isFalling())
					new FreefallThread(this.patricKBob, this.gamePanel).start();
			}
			try {
				Thread.sleep((int) (Constants.TIME_FRACTION * 1000));
			} catch (InterruptedException e) {
			}
		}

		while (this.isLeftPressed) {
			this.patricKBob.detectFloor();
			if (this.patricKBob.isOnFloor())
				if (this.patricKBob.isActualSprite(PatrickBob.PATRICK_BOB_WALK_LEFT_01)) {
					this.patricKBob.setImage(PatrickBob.PATRICK_BOB_WALK_LEFT_02);
					this.gamePanel.repaint();
				} else {
					this.patricKBob.setImage(PatrickBob.PATRICK_BOB_WALK_LEFT_01);
					this.gamePanel.repaint();
				}
			if (this.isRightPressed)
				break;
			if (isFastPressed)
				this.patricKBob.x -= Constants.NORMAL_SPEED * 2;
			else
				this.patricKBob.x -= Constants.NORMAL_SPEED;
			if (this.patricKBob.currentFloor != this.patricKBob.floor) {
				if (!this.patricKBob.isFalling())
					new FreefallThread(this.patricKBob, this.gamePanel).start();
			}
			try {
				Thread.sleep((int) (Constants.TIME_FRACTION * 1000));
			} catch (InterruptedException e) {
			}
		}

		if (this.patricKBob.isActualSprite(PatrickBob.PATRICK_BOB_WALK_LEFT_01)
				|| this.patricKBob.isActualSprite(PatrickBob.PATRICK_BOB_WALK_LEFT_02))
			this.patricKBob.setImage(PatrickBob.PATRICK_BOB_STAND_LEFT);
		else if (this.patricKBob.isActualSprite(PatrickBob.PATRICK_BOB_WALK_RIGHT_01)
				|| this.patricKBob.isActualSprite(PatrickBob.PATRICK_BOB_WALK_RIGHT_02))
			this.patricKBob.setImage(PatrickBob.PATRICK_BOB_STAND_RIGHT);
		this.gamePanel.repaint();

		this.interrupt();
	}

	public void setRightPressed(boolean isRightPressed) {
		this.isRightPressed = isRightPressed;
	}

	public void setLeftPressed(boolean isLeftPressed) {
		this.isLeftPressed = isLeftPressed;
	}

	public boolean isRightPressed() {
		return isRightPressed;
	}

	public boolean isLeftPressed() {
		return isLeftPressed;
	}

	public void setFastPressed(boolean isFastPressed) {
		this.isFastPressed = isFastPressed;
	}
}
