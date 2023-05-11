import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

public class GameLogic extends JFrame {

    public static final int SIZE = 800;

    private JPanel panel;
    private List<Obstacle> obstacles = new ArrayList<Obstacle>();
    private ObstaclePool obstaclePool = new ObstaclePool();
    private Player player;
    private Thread thread;
    private boolean running;

    private int score = 0;
    private Image imageCell;
    public GameLogic() {
        imageCell = new ImageIcon("img/obs1.png").getImage();
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
        add(panel);

        pack();
    }

    private void initGameData() {
        score = 0;
        int start_x = SIZE;
        Random random = new Random();
        int obstacle_size = 30;
        int min_y = obstacle_size*3;
        int max_y = SIZE-obstacle_size*2;
        for (int i = 0; i < 100; i++) {
            int obstacle_y = random.nextInt(max_y - min_y) + min_y;
            obstacles.add(obstaclePool.getObstacle(start_x, obstacle_y));
            start_x += obstacle_size * 6;
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
                            obstacle.reset("", SIZE+(Obstacle.SIZE+500), SIZE - SIZE/3 - Obstacle.SIZE+500, 500);
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
        g.setColor(Color.white);
        g.fillRect(0, 0, SIZE, SIZE);
    }

    private void drawObstacle(Graphics g) {
        g.setColor(Color.yellow);
        for (Obstacle obstacle : obstacles) {
            if (obstacle.dead()) {
                continue;
            }
            g.drawImage(imageCell,obstacle.getX(), obstacle.getY(), obstacle.SIZE+100, obstacle.SIZE+100, null, null);

        }
    }

    private void drawPlayer(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(100,100, 100, 400 );
    }

    private void isGameOver() {
        // TODO
    }

    public static void main(String[] args) {
        GameLogic game = new GameLogic();
        game.setVisible(true);
        game.setDefaultCloseOperation(EXIT_ON_CLOSE);
        game.start();
    }

}
