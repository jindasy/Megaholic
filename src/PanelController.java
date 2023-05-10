import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelController extends JPanel {
    private MenuPanel menuPanel;
    private OnePlayerModePanel onePlayerModePanel;
    private TwoPlayerModePanel twoPlayerModePanel;

    private CardLayout card = new CardLayout();


    private JButton button1 = new JButton("Button 1");
    private JButton mainButtonOne = new JButton("Main");
    private JButton mainButtonTwo = new JButton("Main");
    public PanelController() {
        menuPanel = new MenuPanel();
        onePlayerModePanel = new OnePlayerModePanel();
        twoPlayerModePanel = new TwoPlayerModePanel();
        setLayout(card);

//        menuPanel.add(button1);
        onePlayerModePanel.add(mainButtonOne);
        twoPlayerModePanel.add(mainButtonTwo);

        add(menuPanel, "menu");
        add(onePlayerModePanel, "one");
        add(twoPlayerModePanel, "two");
        card.show(this, "menu");

        Container container = this;

        menuPanel.getSingleModeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(container, "one");
            }
        });
        menuPanel.getTwoPlayerModeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(container, "two");
            }
        });
        mainButtonOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(container, "menu");
            }
        });

        mainButtonTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(container, "menu");
            }
        });
    }
}
