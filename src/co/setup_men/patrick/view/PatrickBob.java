package co.setup_men.patrick.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import co.setup_men.patrick.controller.KeyController;
import co.setup_men.patrick.runner.Constants;

/**
 * Clase PatricKBob
 * 
 * @author Andrés Felipe Chaparro Rosas
 * @version 1.0 8/02/2019
 */
public class PatrickBob extends Figure {
	public static final Image PATRICK_BOB_STAND_LEFT = new ImageIcon("./res/images/pb_stand_left.png").getImage();
	public static final Image PATRICK_BOB_STAND_RIGHT = new ImageIcon("./res/images/pb_stand_right.png").getImage();
	public static final Image PATRICK_BOB_STAND_FRONT = new ImageIcon("./res/images/pb_stand_front.png").getImage();
	public static final Image PATRICK_BOB_WALK_LEFT_01 = new ImageIcon("./res/images/pb_walk_left_01.png").getImage();
	public static final Image PATRICK_BOB_WALK_LEFT_02 = new ImageIcon("./res/images/pb_walk_left_02.png").getImage();
	public static final Image PATRICK_BOB_WALK_RIGHT_01 = new ImageIcon("./res/images/pb_walk_right_01.png").getImage();
	public static final Image PATRICK_BOB_WALK_RIGHT_02 = new ImageIcon("./res/images/pb_walk_right_02.png").getImage();
	public static final Image PATRICK_BOB_FALLING_LEFT_01 = new ImageIcon("./res/images/pb_stand_left.png").getImage();
	public static final Image PATRICK_BOB_FALLING_LEFT_02 = new ImageIcon("./res/images/pb_stand_left.png").getImage();
	public static final Image PATRICK_BOB_FALLING_RIGHT_01 = new ImageIcon("./res/images/pb_stand_right.png")
			.getImage();
	public static final Image PATRICK_BOB_FALLING_RIGHT_02 = new ImageIcon("./res/images/pb_stand_right.png")
			.getImage();
	public static final Image PATRICK_BOB_FALLING_FRONT_01 = new ImageIcon("./res/images/pb_stand_front.png")
			.getImage();
	public static final Image PATRICK_BOB_FALLING_FRONT_02 = new ImageIcon("./res/images/pb_stand_front.png")
			.getImage();

	protected float currentFloor;
	private boolean isFalling, isOnFloor;
	private Image image;
	private ArrayList<Platform> platforms;

	public PatrickBob(int floor) {
		super(Constants.PB_X, floor - Constants.PB_HEIGHT, Constants.PB_WIDTH, Constants.PB_HEIGHT, floor);
		this.currentFloor = floor;
		KeyController.getInstance().setPatricKBob(this);
		this.isFalling = false;
		this.isOnFloor = true;
		this.image = PATRICK_BOB_STAND_FRONT;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.drawLine((int) (this.x + this.width / 2), (int) (this.y - this.height / 3), (int) (this.x + this.width / 2),
				(int) (this.y + this.height * 4 / 3));

		g.drawImage(this.image, (int) this.x, (int) this.y, (int) this.width, (int) this.height, null);
	}

	public void detectFloor() {
		ArrayList<Platform> auxPlatforms = new ArrayList<>();
		for (Platform platform : this.platforms) {
			if (platform.x <= this.x + this.width / 2 && platform.x + platform.width >= this.x + this.width / 2) {
				auxPlatforms.add(platform);
			}
		}

		if (auxPlatforms.size() == 1)
			this.currentFloor = auxPlatforms.get(0).y;
		else
			for (int i = 0; i < auxPlatforms.size() - 1; i++) {
				if (auxPlatforms.get(i).y >= this.y + this.height)
					this.currentFloor = auxPlatforms.get(i).y;
			}
		System.out.println(this.currentFloor);
	}

	public boolean isActualSprite(Image sprite) {
		return this.image == sprite;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public boolean isFalling() {
		return isFalling;
	}

	public void setFalling(boolean isFalling) {
		this.isFalling = isFalling;
	}

	public boolean isOnFloor() {
		return isOnFloor;
	}

	public void setOnFloor(boolean isOnFloor) {
		this.isOnFloor = isOnFloor;
	}

	public void setPlatforms(ArrayList<Platform> platforms) {
		this.platforms = platforms;
	}

}
