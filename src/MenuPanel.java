import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JFrame {
    private JButton singleMode;
    private JButton twoPlayerMode;
    private JButton close;
    private ImageIcon img = new ImageIcon("images/1-player-bg.png");

    public MenuPanel() {
        setPreferredSize(new Dimension(600, 600));
        setLayout(null);
        setBackground(new Color(135, 206, 235));

        JLabel imgLabel = new JLabel(new ImageIcon("images/main-bg.png"));
        imgLabel.setVisible(true);
        add(imgLabel);
        imgLabel.setBounds(0,0,img.getIconWidth(),img.getIconHeight());

        // create components in main
        JLabel imgTitle = new JLabel(new ImageIcon("images/megaholic-title.gif"));
        singleMode = new JButton("1-Player");
        twoPlayerMode = new JButton("2-Player");
        close =new JButton("Exit");

        // add components to panel
        imgLabel.add(singleMode);
        imgLabel.add(twoPlayerMode);
        imgLabel.add(close);
        imgLabel.add(imgTitle);

        imgTitle.setBounds(100,100,420,100);
        singleMode.setBounds(250,230,100,50);
        twoPlayerMode.setBounds(250,280,100,50);
        close.setBounds(250,330,100,50);

        // Change text format
        singleMode.setFont(new Font("Verdana", Font.PLAIN, 20));
        twoPlayerMode.setFont(new Font("Verdana", Font.PLAIN, 20));
        close.setFont(new Font("Verdana", Font.PLAIN, 20));

        JFrame currentFrame = this;
        singleMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new Window();
                frame.setVisible(true);
                currentFrame.dispose();
            }
        });

        twoPlayerMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new Window2();
                frame.setVisible(true);
                currentFrame.dispose();
            }
        });

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        MenuPanel menu = new MenuPanel();
        menu.pack();
        menu.setVisible(true);
        menu.setAlwaysOnTop(true);
        menu.setSize(600, 600);
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}