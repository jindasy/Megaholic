import javax.swing.*;
import java.awt.*;

public class TwoPlayerModePanel extends JPanel{

    private JButton backToMainButton = new JButton("Back to main");
    private JButton playAgainButton = new JButton("Play again");

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

        // if player 1 hit obstacle:
        // message1 = "Player 1 loses"
        // message2 = "Player 2 wins"
        // elif player 2 hit obstacle:
        // message1 = "Player 1 wins"
        // message2 = "Player 2 loses"
//        showGameOverComponents("Player 1 wins", "Player 2 loses", background);

    }

    public void showGameOverComponents(String messageOne, String messageTwo, JComponent parent){
        JLabel messageLabel1 = new JLabel(messageOne);
        JLabel messageLabel2 = new JLabel(messageTwo);

        JPanel buttonsLine = new JPanel();
        buttonsLine.setOpaque(false);
        buttonsLine.setBackground(new Color(0,0,0,0));
        buttonsLine.setLayout(new BoxLayout(buttonsLine, BoxLayout.LINE_AXIS));
        buttonsLine.add(playAgainButton);
        buttonsLine.add(backToMainButton);

        parent.add(Box.createRigidArea(new Dimension(0,50)));
        parent.add(messageLabel1);
        parent.add(Box.createRigidArea(new Dimension(0,190)));
        parent.add(buttonsLine);
        parent.add(Box.createRigidArea(new Dimension(0,40)));
        parent.add(messageLabel2);


        messageLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        messageLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        playAgainButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backToMainButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Change text format
        messageLabel1.setFont(new Font("Verdana", Font.BOLD, 40));
        messageLabel2.setFont(new Font("Verdana", Font.BOLD, 40));
        playAgainButton.setFont(new Font("Verdana", Font.PLAIN, 20));
        backToMainButton.setFont(new Font("Verdana", Font.PLAIN, 20));


    }

    public JButton getMainButton() {
        return backToMainButton;
    }

    public JButton getPlayAgainButton() {
        return playAgainButton;
    }


}
