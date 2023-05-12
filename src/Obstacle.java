import java.awt.*;

public class Obstacle {

	public static int SIZE = 30;

	private float x, y;
	private float vx;

	private int size;
	private boolean isJump;

	private double obstacleSpeed = 1;

	public Obstacle(int x, int y, int size, boolean isJump) {
		this.x = x;
		this.y = y;
		SIZE = size;
		this.vx = 2;
		this.isJump = isJump;

	}

	public void move() {
		if (dead()) {
			return;
		}
		x -= vx * obstacleSpeed;
	}

	public int getX() {
		return (int) x;
	}

	public int getY() {
		return (int) y;
	}


	public boolean dead() {
		return x <= 0;
	}
	public boolean isJumping(){
		return isJump;
	}

	public void reset(int x, int y, int size, boolean isJump) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.isJump=isJump;
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x+20, (int)y, size-10, size);
	}

	public void increaseObstacleSpeed() {
		obstacleSpeed = obstacleSpeed + (0.0005);
	}

}