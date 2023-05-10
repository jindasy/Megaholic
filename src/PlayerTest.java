import javax.swing.*;

public class PlayerTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Player Jump");
        Player player = new Player();
        frame.add(player);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
