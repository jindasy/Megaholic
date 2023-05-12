import java.awt.*;

public class Player{

    public int WIDTH = 50;
    public int HEIGHT = 100;
    private final int start_y;
    private int x, y;
    private double vy;
    public String state;
    public Boolean jumped = false;
    public Boolean slided = false;

    private PlayerState playerState;

    public Player(int start_y) {
        this.x = 100;
        this.start_y = start_y;
        this.y = start_y;
        this.vy = 2;
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
