//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Jumping extends JPanel implements ActionListener {
//    Player player;
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        playerY += playerDY; // update player's position based on vertical velocity
//        if (playerY < 300) { // if player is in the air
//            playerDY++; // increase player's vertical velocity due to gravity
//        }
//        if (playerY > 300) { // if player is below the ground
//            playerY = 300; // reset player's position to the ground
//            playerDY = 0; // reset player's vertical velocity
//        }
//        repaint();
//    }
//}
