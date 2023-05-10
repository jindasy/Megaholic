import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    private JLabel title;
    private JButton singleMode;
    private JButton twoPlayerMode;
    public MenuPanel(CardLayout cardLayout) {
        setBackground(new Color(135, 206, 235));
        setPreferredSize(new Dimension(600, 600));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        // create components in main
        title = new JLabel("Megaholic");
        singleMode = new JButton("1-Player");
        singleMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show OnePlayerModeUI
                setVisible(false);
                OnePlayerModePanel onePlayerModeUI = new OnePlayerModePanel();
                add(onePlayerModeUI);
                setVisible(false);

            }
        });

        twoPlayerMode = new JButton("2-Player");
        twoPlayerMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show TwoPlayerModeUI
            }
        });

        // add components to panel
        add(Box.createRigidArea(new Dimension(0,200)));
        add(title);
        add(Box.createRigidArea(new Dimension(0,50)));
        add(singleMode);
        add(twoPlayerMode);

        // align text at center
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        singleMode.setAlignmentX(Component.CENTER_ALIGNMENT);
        twoPlayerMode.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Change text format
        title.setFont(new Font("Verdana", Font.BOLD, 40));
        singleMode.setFont(new Font("Verdana", Font.PLAIN, 20));
        twoPlayerMode.setFont(new Font("Verdana", Font.PLAIN, 20));



    }


}
