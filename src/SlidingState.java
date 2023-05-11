import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlidingState implements PlayerState, ActionListener {
    private Player player;

    public SlidingState(Player player) {
        this.player = player;

        Timer timer = new Timer(10, this);
        timer.start();
    }
    @Override
    public void action() {
        System.out.println("SLIDE");
        int height = player.getHeight();
        int width = player.getWidth();
        player.setPlayerY((height-width)+player.getPlayerY());
        player.setWidth(height);
        player.setHeight(width);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
