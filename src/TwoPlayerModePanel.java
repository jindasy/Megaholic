import javax.swing.*;
import java.awt.*;

public class TwoPlayerModePanel extends JPanel{

    private JButton mainButton = new JButton("Main");
    public TwoPlayerModePanel() {
        setBackground(new Color(135, 206, 235));
        setPreferredSize(new Dimension(600, 600));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(mainButton);
    }

    public JButton getMainButton() {
        return mainButton;
    }
}
