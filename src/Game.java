import javax.swing.*;


public class Game extends JFrame {

    public Game() {
        JPanel panelController = new PanelController();
        add(panelController);
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Game();
    }
}
