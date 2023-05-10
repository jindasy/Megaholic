import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    private JPanel panelController = new JPanel();
    private MenuPanel menuPanel;
    private OnePlayerModePanel onePlayerModePanel;
    private TwoPlayerModePanel twoPlayerModePanel;

    private JMenuBar menuBar;

    private JButton button1 = new JButton("Button 1");
    private JButton button2 = new JButton("Button 2");

    CardLayout cardLayout;

    public Game() {
        menuPanel = new MenuPanel(cardLayout);
        onePlayerModePanel = new OnePlayerModePanel();
        twoPlayerModePanel = new TwoPlayerModePanel();
        cardLayout = new CardLayout();
        panelController.setLayout(cardLayout);

        menuPanel.add(button1);
        onePlayerModePanel.add(button2);

        panelController.add(menuPanel, "1");
        panelController.add(onePlayerModePanel, "2");
        cardLayout.show(panelController, "1");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelController, "2");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelController, "1");
            }
        });


        add(panelController);
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }





    public static void main(String[] args) {
        new Game();
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new GameLayout();
//            }
//        });
    }
}
