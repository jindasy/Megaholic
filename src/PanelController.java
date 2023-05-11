import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelController extends JPanel {
    private MenuPanel menuPanel = new MenuPanel();
    private OnePlayerModePanel onePlayerModePanel = new OnePlayerModePanel();
    private TwoPlayerModePanel twoPlayerModePanel = new TwoPlayerModePanel();


    public PanelController() {
        // main button for player 1 mode
        JButton mainButtonOne = onePlayerModePanel.getMainButton();
        // play again button for player 1 mode
        JButton playAgainOne = onePlayerModePanel.getPlayAgainButton();
        // main button in player 2 mode
        JButton mainButtonTwo = twoPlayerModePanel.getMainButton();
        // play again button for player 2 mode
        JButton playAgainTwo = twoPlayerModePanel.getPlayAgainButton();


        add(menuPanel);

        Container container = this;

        menuPanel.getSingleModeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.removeAll();
                container.add(onePlayerModePanel);
                container.revalidate();
                container.repaint();
            }
        });
        menuPanel.getTwoPlayerModeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.removeAll();
                container.add(twoPlayerModePanel);
                container.revalidate();
                container.repaint();
            }
        });
        mainButtonOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.removeAll();
                container.add(menuPanel);
                container.revalidate();
                container.repaint();
            }
        });
        playAgainOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.removeAll();
                container.add(onePlayerModePanel);
                container.revalidate();
                container.repaint();
            }
        });

        mainButtonTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.removeAll();
                container.add(menuPanel);
                container.revalidate();
                container.repaint();
            }
        });

        playAgainTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.removeAll();
                container.add(twoPlayerModePanel);
                container.revalidate();
                container.repaint();
            }
        });
    }
}
