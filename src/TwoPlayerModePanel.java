import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class TwoPlayerModePanel extends JPanel {

    public static final int SIZE = 600;

    private JPanel panel;
    private List<Obstacle> obstacles = new ArrayList<Obstacle>();
    private Player player = new Player("a");
    private Thread thread;
    private boolean running;

    ImageIcon img = new ImageIcon("images/2-player-bg.png");

    private JButton backToMainButton = new JButton("Back to main");
    private JButton playAgainButton = new JButton("Play again");

    private int score = 0;

    public TwoPlayerModePanel() {
        setPreferredSize(new Dimension(600, 600));
        setLayout(new FlowLayout());
        initGameData();
        panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                drawBackground(g);
                drawObstacle(g);
                drawPlayer(g);
            }
        };
        panel.setPreferredSize(new Dimension(SIZE, SIZE));
        panel.setLocation(100, 0);
        add(panel);
        add(player);
        player.requestFocus(true);
        start();

    }

    private void initGameData() {
        score = 0;
        int obstacle_size = 30;
        int start_x = SIZE;
        int start_y = SIZE - SIZE/2 - obstacle_size;
        // spawn obstacle
        // TODO use object pool
        for (int i = 0; i < 8; i++) {
            Obstacle obstacle = new Obstacle("Obs" + (i + 1), start_x, start_y, obstacle_size);
            start_x += 2* Obstacle.SIZE + 50;
            obstacles.add(obstacle);
        }

    }


    private void start() {
        running = true;


        thread = new Thread() {
            @Override
            public void run() {
                super.run();
                while (running) {
                    for (Obstacle obstacle : obstacles) {
                        if (obstacle.dead()) {
                            obstacle.reset("", SIZE+(Obstacle.SIZE+50), SIZE - SIZE/3 - Obstacle.SIZE, 30);
                        }
                        obstacle.move();
                    }
                    panel.repaint();

                    // TODO score
                    score++;
                    System.out.println(score);

                    try {
                        Thread.sleep(1000 / 60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();

    }

    private void drawBackground(Graphics g) {
        g.drawImage(img.getImage(), 0,0, null);

    }

    private void drawObstacle(Graphics g) {
        g.setColor(Color.yellow);
        for (Obstacle obstacle : obstacles) {
            if (obstacle.dead()) {
                continue;
            }
            g.fillOval(obstacle.getX(), obstacle.getY(), obstacle.SIZE, obstacle.SIZE);
        }
    }

    private void drawPlayer(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(player.getX(), player.getY(), player.WIDTH, player.HEIGHT );
    }

    private void isGameOver() {
        // TODO
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
