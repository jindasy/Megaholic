import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class GameLogic extends JFrame {

    public static final int SIZE = 800;

    private JPanel panel;
    private List<Obstacle> obstacles = new ArrayList<Obstacle>();
    private Player player;
    private Thread thread;
    private boolean running;
    Timer timer = new Timer();

    private int score = 0;

    public GameLogic() {
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
//        player = new Player();
//        add(player);

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
                        timer.scheduleAtFixedRate(new TimerTask() {
                            @Override
                            public void run() {
                                obstacle.increaseObstacleSpeed();
                                obstacle.move();
                            }
                        }, 5, 5*60*1000);
                        isGameOver();
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
            g.fillOval(obstacle.getX(), obstacle.getY(), obstacle.SIZE, obstacle.SIZE);
        }
    }

    private void drawPlayer(Graphics g) {
//        g.setColor(Color.blue);
//        g.fillRect(100,100, 100, 400 );
    }

    public boolean checkCollision(Obstacle obstacle, Player player) {

        int distanceX = Math.abs(player.getX() - obstacle.getX());
        int distanceY = Math.abs(player.getY() - obstacle.getY());
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        return distance < 25 + Obstacle.SIZE;
    }


    private void isGameOver() {
        for (Obstacle obstacle : obstacles) {
            if (checkCollision(obstacle, player)) {
                running = false;
                break;
            }
        }
    }

    public static void main(String[] args) {
        GameLogic game = new GameLogic();
        game.setVisible(true);
        game.setDefaultCloseOperation(EXIT_ON_CLOSE);
        game.start();
    }

}
