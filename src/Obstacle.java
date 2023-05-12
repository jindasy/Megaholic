//import java.awt.*;
//
//public class Obstacle{
//
//	public static final int MAX_HEALTH = 20;
//	public static final float MAX_V = 1.0f;
//	public static int SIZE = 30;
//
//	private String name;
//	private int hp;
//	private int x, y;
//	private float vx;
//
//	private int size;
//
//
//	public Obstacle(String name, int x, int y, int size) {
//		this.name = name;
//		this.hp = 30;
//		this.x = x;
//		this.y = y;
//		SIZE = size;
//		this.vx = 2;
//	}
//
//	public void move() {
//		if (dead()) {
//			return;
//		}
//		x -= vx;
//
//	}
//
//	public int getX() {
//		return (int) x;
//	}
//
//	public int getY() {
//		return (int) y;
//	}
//
//	public boolean dead() {
//		return x <= 0;
//	}
//
//	public void reset(String name, int x, int y, int size) {
//		this.name = name;
//		this.x = x;
//		this.y = y;
//		this.size = size;
//	}
//
//	public Rectangle getBounds() {
//		return new Rectangle(x, y, SIZE, SIZE);
//	}
//
//}
import javax.swing.*;
import javax.swing.*;
import java.awt.*;

public class Obstacle {

	public static final int MAX_HEALTH = 20;
	public static final float MAX_V = 1.0f;
	public static int SIZE = 30;

	private String name;
	private int hp;
	private float x, y;
	private float vx;

	private int size;
	private boolean isJump;

	private double obstacleSpeed = 1;

	public Obstacle(String name, int x, int y, int size, boolean isJump) {
		this.name = name;
		this.hp = 30;
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

	public void reset(String name, int x, int y, int size, boolean isJump) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.size = size;
		this.isJump=isJump;
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x+20, (int)y, SIZE-10, SIZE);
	}

	public void increaseObstacleSpeed() {
		obstacleSpeed = obstacleSpeed + (0.0005);
	}

}