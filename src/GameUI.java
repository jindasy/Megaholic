import javax.swing.*;
import java.awt.*;


public class GameUI extends JFrame {

    public GameUI() {
        JPanel panelController = new PanelController();
        add(panelController);
        setPreferredSize(new Dimension(600, 633));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();

    }

    public static void main(String[] args) {
        new GameUI();
    }
}
