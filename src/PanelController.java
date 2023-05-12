//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class PanelController extends JPanel {
////    private MenuPanel menuPanel = new MenuPanel();
//    private Window onePlayerModePanel = new Window();
//    private Window2 twoPlayerModePanel = new Window2();
//
//
//    public PanelController() {
//        // main button for player 1 mode
//        JButton mainButtonOne = onePlayerModePanel.getStartButton();
//        // play again button for player 1 mode
//        JButton playAgainOne = onePlayerModePanel.getPlayAgainButton();
//        // main button in player 2 mode
//        JButton mainButtonTwo = twoPlayerModePanel.getMainButton();
//        // play again button for player 2 mode
//        JButton playAgainTwo = twoPlayerModePanel.getPlayAgainButton();
//
//        add(menuPanel);
//
//        Container container = this;
//        menuPanel.getSingleModeButton().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                container.removeAll();
//                container.add(onePlayerModePanel);
//                container.revalidate();
//                container.repaint();
//            }
//        });
//
////        setUpButtonAction(menuPanel.getSingleModeButton(), onePlayerModePanel, this);
//        setUpButtonAction(menuPanel.getTwoPlayerModeButton(), twoPlayerModePanel, this);
//        setUpButtonAction(mainButtonOne, menuPanel, this);
//        setUpButtonAction(playAgainOne, onePlayerModePanel, this);
//        setUpButtonAction(mainButtonTwo, menuPanel, this);
//        setUpButtonAction(playAgainTwo, twoPlayerModePanel, this);
//
//
//
//    }
//
//    public void setUpButtonAction(JButton button, JPanel toChangeToPanel, Container container) {
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                container.removeAll();
//                container.add(toChangeToPanel);
//                container.revalidate();
//                container.repaint();
//            }
//        });
//
//    }
//
//}
