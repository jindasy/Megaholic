import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player extends JPanel implements ActionListener {

    public static final int MAX_HEALTH = 20;
    public static final float MAX_V = 1.0f;
    public static final int WIDTH = 50;
    public static final int HEIGHT = 150;
    private String name;
    private int hp;
    private float x, y;
    private double vx, vy;
    private double ax, ay;

    public Player(String name) {
        this.name = name;
        this.hp = 30;
        this.x = 100;
        this.y = 200;
        this.vx = 2;
        this.vy = 2;
        this.ax = 0;
        this.ay = 9.8;

        setFocusable(true);

        Timer timer = new Timer(20, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    jump();
                }
            }
        });
        setFocusable(true);
    }

    public void move() {
        if (dead()) {
            return;
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

    public void jump() {
        if (y == 312) { // check if player is on the ground
            vy = -10; // set player's vertical velocity
        }
    }

    public void actionPerformed(ActionEvent e) {
        y += vy; // update player's position based on vertical velocity
        if (y < 312) { // if player is in the air
            vy++; // increase player's vertical velocity due to gravity
        }
        if (y > 312) { // if player is below the ground
            y = 312; // reset player's position to the ground
            vy = 0; // reset player's vertical velocity
        }
    }



}
