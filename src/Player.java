import javax.swing.*;
import java.awt.*;


public class Player extends JPanel {
    private int x;
    private int y;
    private int velocityY;
    private int width = 50;
    private int height = 100;

    private PlayerState state;

    public Player() {
        x = 100;
        y = 300;
        velocityY = 2;
        state = new RunningState(this);
    }

    public void reset() {
        x = 100;
        y = 300;
        velocityY = 2;
        width = 50;
        height = 100;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public PlayerState getState() {
        return state;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setState(PlayerState state){
        this.state = state;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(x, y, width, height); // draw the player as a rectangle
    }
}