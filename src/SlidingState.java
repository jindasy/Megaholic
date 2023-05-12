//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class SlidingState implements PlayerState, ActionListener {
//    private Player player;
//
//    public SlidingState(Player player) {
//        this.player = player;
//        this.action();
//
//        Timer timer = new Timer(10, this);
//        timer.start();
//    }
//    @Override
//    public void action() {
//        System.out.println("SLIDE");
//        int height = player.getHeight();
//        int width = player.getWidth();
//        player.setY((height-width)+player.getY());
//        player.setWidth(height);
//        player.setHeight(width);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
//}
