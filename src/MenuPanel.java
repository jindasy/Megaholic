//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
//
//public class MenuPanel extends JFrame {
//    private JLabel title;
//    private JButton singleMode;
//    private JButton twoPlayerMode;
//    public MenuPanel() {
//        setBackground(new Color(135, 206, 235));
//        setPreferredSize(new Dimension(600, 600));
//        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
//
//        // create components in main
//        title = new JLabel("Megaholic");
//        singleMode = new JButton("1-Player");
//        twoPlayerMode = new JButton("2-Player");
//
//        // add components to panel
//        add(Box.createRigidArea(new Dimension(0,200)));
//        add(title);
//        add(Box.createRigidArea(new Dimension(0,50)));
//        add(singleMode);
//        add(twoPlayerMode);
//
//        // align text at center
//        title.setAlignmentX(Component.CENTER_ALIGNMENT);
//        singleMode.setAlignmentX(Component.CENTER_ALIGNMENT);
//        twoPlayerMode.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//        // Change text format
//        title.setFont(new Font("Verdana", Font.BOLD, 40));
//        singleMode.setFont(new Font("Verdana", Font.PLAIN, 20));
//        twoPlayerMode.setFont(new Font("Verdana", Font.PLAIN, 20));
//        singleMode.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                JFrame frame = new Window();
//                frame.setVisible(true);
//                frame.dispose();
//
//            }
//        });
//
//    }
//
//    public JButton getSingleModeButton() {
//        return singleMode;
//    }
//
//    public JButton getTwoPlayerModeButton() {
//        return twoPlayerMode;
//    }
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        MenuPanel menu = new MenuPanel(frame);
//        frame.add(menu);
//        frame.pack();
//        frame.setVisible(true);
//        frame.setAlwaysOnTop(true);
//        frame.setSize(600, 600);
//        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//    }
//
//
//}
