import java.awt.*;
import java.util.Objects;

public class Player{

    public static final int MAX_HEALTH = 20;
    public static final float MAX_V = 1.0f;
    public int WIDTH = 50;
    public int HEIGHT = 150;
    private final int start_y;
    private String name;
    private int hp;
    private int x, y;
    private double vx, vy;
    private double ax, ay;
    public String state;
    public Boolean jumped = false;
    public Boolean slided = false;

    public Player(String name, int start_y) {
        this.name = name;
        this.hp = 30;
        this.x = 100;
        this.start_y = start_y;
        this.y = start_y;
        this.vx = 2;
        this.vy = 2;
        this.ax = 0;
        this.ay = 9.8;


    }

    public void move() {
        if (Objects.equals(state, "jumping")) {
            if (jumped && y == start_y) {
                state = "Normal";
                jumped = false;
            }
            else {
                System.out.println("x");
                if (y == start_y) {
                    vy = -20;
                }
                y += vy;
                if (y < start_y) {
                    vy++;
                }
                if (y > start_y) {
                    y = start_y;
                    vy = 0;
                }
                jumped = true;
            }
        }
        if (Objects.equals(state, "sliding") && !slided) {
            System.out.println("1");
            int H = HEIGHT;
            HEIGHT = WIDTH;
            WIDTH = H;
            y = y - (HEIGHT - WIDTH);
            slided = true;

        }
        if (Objects.equals(state, "stopSliding")) {
            int H = HEIGHT;
            HEIGHT = WIDTH;
            WIDTH = H;
            state = "Normal";
            slided = false;
            y = start_y;
        }

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

    public void initializeState() {
        jumped = false;
        slided = false;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }


}
