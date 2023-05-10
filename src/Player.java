import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Player extends JPanel implements ActionListener {

    private int playerX;
    private int playerY;
    private int playerDY;

    public Player() {
        playerX = 100;
        playerY = 300;
        playerDY = 0;

        Timer timer = new Timer(40, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    jump();
                }
            }
        });
        setFocusable(true);
    }

    private void jump() {
        if (playerY == 300) { // check if player is on the ground
            playerDY = -10; // set player's vertical velocity
        }
    }

    public void actionPerformed(ActionEvent e) {
        playerY += playerDY; // update player's position based on vertical velocity
        if (playerY < 300) { // if player is in the air
            playerDY++; // increase player's vertical velocity due to gravity
        }
        if (playerY > 300) { // if player is below the ground
            playerY = 300; // reset player's position to the ground
            playerDY = 0; // reset player's vertical velocity
        }
        repaint(); // redraw the player on the screen
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(playerX, playerY, 50, 50); // draw the player as a rectangle
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Player Jump");
        Player player = new Player();
        frame.add(player);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}