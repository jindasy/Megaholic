import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Player extends JPanel implements ActionListener {

    private int playerX;
    private int playerY;
    private int playerDY;

    private PlayerState state;

    public Player() {
        playerX = 100;
        playerY = 300;
        playerDY = 0;

//        Timer timer = new Timer(10, this);
//        timer.start();
//
//        addKeyListener(new KeyAdapter() {
//            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//                    jump();
//                }
//            }
//        });
//        setFocusable(true);
    }

    private void jump() {
        state.jump();
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

}