import java.awt.*;
import java.util.Objects;

public class Player{

    public static final float MAX_V = 1.0f;
    public int WIDTH = 50;
    public int HEIGHT = 100;
    private final int start_y;
    private String name;
    private int x, y;
    private double vx, vy;
    private double ax, ay;
    public String state;
    public Boolean jumped = false;
    public Boolean slided = false;

    private PlayerState playerState;

    public Player(String name, int start_y) {
        this.name = name;
        this.x = 100;
        this.start_y = start_y;
        this.y = start_y;
        this.vx = 2;
        this.vy = 2;
        this.ax = 0;
        this.ay = 9.8;
        this.playerState = new PlayerState(this);
    }

    public void move() {
        playerState.move();
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public int getStart_y() {
        return start_y;
    }

    public double getVy() {
        return vy;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setJumped(Boolean jumped) {
        this.jumped = jumped;
    }

    public void setSlided(Boolean slided) {
        this.slided = slided;
    }

    public void initializeState() {
        jumped = false;
        slided = false;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }


}
