import javax.swing.*;
import java.awt.*;

public class OnePlayerModePanel extends JPanel{

    private JButton backToMainButton = new JButton("Back to main");
    private JButton playAgainButton = new JButton("Play again");


    public OnePlayerModePanel() {
        setBackground(new Color(135, 206, 235));
        setPreferredSize(new Dimension(600, 600));
        setLayout(new FlowLayout());

        // set background
        JLabel background = new JLabel();
        ImageIcon img = new ImageIcon("images/1-player-bg.png");
        background.setIcon(img);
        background.setLocation(0,0);
        add(background);
        background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));

        // if the game is over
//        showGameOverComponents("Game Over", 200, background);


    }
    public void showGameOverComponents(String message, int score, JComponent parent){
        JLabel messageLabel = new JLabel(message);
        JLabel scoreLabel = new JLabel("Your score: " + score);

        parent.add(Box.createRigidArea(new Dimension(0,200)));
        parent.add(messageLabel);
        parent.add(Box.createRigidArea(new Dimension(0,20)));
        parent.add(scoreLabel);
        parent.add(Box.createRigidArea(new Dimension(0,20)));
        parent.add(playAgainButton);
        parent.add(backToMainButton);

        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        playAgainButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backToMainButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Change text format
        messageLabel.setFont(new Font("Verdana", Font.BOLD, 40));
        scoreLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
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
