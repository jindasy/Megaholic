import javax.swing.*;
import java.awt.*;


public class Player extends JPanel {
    private int playerX;
    private int playerY;
    private int velocityY;
    private int width = 50;
    private int height = 100;

    private PlayerState state;

    public Player() {
        playerX = 100;
        playerY = 300;
        velocityY = 2;
        state = new RunningState(this);
    }

    public void reset() {
        playerX = 100;
        playerY = 300;
        velocityY = 2;
        width = 50;
        height = 100;
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
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

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
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
        g.fillRect(playerX, playerY, width, height); // draw the player as a rectangle
    }
}