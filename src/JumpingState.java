import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JumpingState implements PlayerState, ActionListener {
    private Player player;
    public JumpingState(Player player) {
        this.player = player;

        Timer timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void action() {
        System.out.println("JUMP");

        if (player.getPlayerY() == 300) { // check if player is on the ground
//            System.out.println("OnGround");
            player.setVelocityY(-10);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.setPlayerY(player.getPlayerY() + player.getVelocityY());
//        System.out.println(player.getPlayerY());
        if (player.getPlayerY() < 300) {
//            System.out.println("Up");
            player.setVelocityY(player.getVelocityY() + 1);
//            System.out.println(player.getPlayerY());

        }
        else if (player.getPlayerY() > 300) {
//            System.out.println("Down");
            player.setPlayerY(300);
            player.setVelocityY(0);
        }
    }
}
