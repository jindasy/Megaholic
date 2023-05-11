import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerTest implements KeyListener{
    private Player player;
    private PlayerController controller;

    public PlayerTest() {
        player = new Player();
        controller = new PlayerController(player);

        JFrame frame = new JFrame("Player Jump");
        JPanel panel = new JPanel();

        panel.addKeyListener(this);
        panel.setFocusable(true);
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(player);
        panel.setVisible(true);
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        controller.handleInput(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        new PlayerTest();

    }
}
