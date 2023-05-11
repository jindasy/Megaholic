import javax.swing.*;
import java.awt.*;

public class TwoPlayerModePanel extends JPanel{

    private JButton mainButton = new JButton("Main");
    public TwoPlayerModePanel() {
        setBackground(new Color(135, 206, 235));
        setPreferredSize(new Dimension(600, 633));
        setLayout(new FlowLayout());

        // set background
        JLabel background = new JLabel();
        ImageIcon img = new ImageIcon("images/2-player-bg.png");
        background.setIcon(img);
        background.setLocation(0,0);
        add(background);
        background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));

        // add main button at the top
        background.add(mainButton);


    }

    public JButton getMainButton() {
        return mainButton;
    }
}
