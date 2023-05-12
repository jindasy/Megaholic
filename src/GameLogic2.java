import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

public class GameLogic2 extends Observable {

    public static final int SIZE = 800;
    private List<Obstacle> obstacles = new ArrayList<Obstacle>();
    private Player player1 = new Player("a", 345);
    private Player player2 = new Player("b", 80);
    private Thread thread;
    private boolean running;
    public int winner;
    private ObstaclesPool obstaclePool = new ObstaclesPool();


    public GameLogic2() {
        obstacles.clear();
        int obstacle_size = 30;
        int start_x = SIZE;
        int min_y1 = 250; // obstacle appears only at y >= 200
        int max_y1 = 390 ;
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            Obstacle obstacle2 = obstaclePool.getObstacle(start_x, random.nextInt(120 - 100) + 100);
            Obstacle obstacle1 = obstaclePool.getObstacle(start_x, random.nextInt(390 - min_y1) + min_y1);

            start_x += 2* Obstacle.SIZE + 100;
            obstacles.add(obstacle1);
            obstacles.add(obstacle2);
            while (start_x < 50000) {
                int obstacle_y1 = random.nextInt(390 - min_y1) + min_y1;
                int obstacle_y2 = random.nextInt(120 - 100) + 100;
                Obstacle lastObstacle = obstacles.get(obstacles.size() - 1);
                if (start_x - lastObstacle.getX() > obstacle_size * 6) {
                    obstacles.add(obstaclePool.getObstacle(start_x, obstacle_y1));
                    obstacles.add(obstaclePool.getObstacle(start_x, obstacle_y2));
                }
                start_x += obstacle_size * 6;
            }
        }

    }


    public void start() {
        running = true;
        player1.initializeState();
        player2.initializeState();
        thread = new Thread() {
            @Override
            public void run() {
                super.run();
                while (running) {
                    for (Obstacle obstacle : obstacles) {
                        if ((player1.getBounds().intersects(obstacle.getBounds()))) {
                           // game over
                            running = false;
                            winner = 1;

                        } else if ((player2.getBounds().intersects(obstacle.getBounds()))) {
                            // game over
                            running = false;
                            winner = 2;

                        }
                        if (obstacle.dead()) {
                            obstacle.reset("", SIZE+(Obstacle.SIZE+500), SIZE - SIZE/3 - Obstacle.SIZE+500, 30,false);
                        }
                        obstacle.move();
                    }
                    player1.move();
                    player2.move();
                    // TODO score
                    setChanged();
                    notifyObservers();

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

    public boolean isGameOver() {
        return !running;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public List<Obstacle> getObstacle() {
        return obstacles;
    }
}