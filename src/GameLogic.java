import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

import javax.swing.*;

public class GameLogic extends Observable {

    public static final int SIZE = 600;
    private List<Obstacle> obstacles = new ArrayList<Obstacle>();
    private Player player = new Player("a", 320);
    private Thread thread;
    private boolean running;
    private ObstaclesPool obstaclePool = new ObstaclesPool();


    private int score = 0;

    public GameLogic() {
        score = 0;
        obstacles.clear();

        int obstacle_size = 30;
        int min_y = 200 + obstacle_size*3; // obstacle appears only at y >= 200
        int max_y = 400 - obstacle_size*2;
        int start_x = SIZE;
        Random random = new Random();
        obstacles.add(obstaclePool.getObstacle(start_x, random.nextInt(max_y - min_y) + min_y));
        while (start_x < 50000) {
            int obstacle_y = random.nextInt(max_y - min_y) + min_y;
            Obstacle lastObstacle = obstacles.get(obstacles.size() - 1);
            if (start_x - lastObstacle.getX() > obstacle_size * 6) {
                obstacles.add(obstaclePool.getObstacle(start_x, obstacle_y));
            }
            start_x += 2* Obstacle.SIZE + 50;
        }

    }

    public void start() {
        running = true;
        score = 0;
        player.initializeState();
        System.out.println(player.getX());
        thread = new Thread() {
            @Override
            public void run() {
                super.run();
                while (running) {
                    for (Obstacle obstacle : obstacles) {
                        if ((player.getBounds().intersects(obstacle.getBounds()))) {
                           // game over
                            running = false;
                        }
                        if (obstacle.dead()) {
                            obstacle.reset("", SIZE+(Obstacle.SIZE+500), SIZE - SIZE/3 - Obstacle.SIZE+500, 30,false);
                        }
                        obstacle.move();
                    }
                    player.move();
                    // TODO score
                    score++;
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
        if (isGameOver()) {
            obstacles.clear();
            player = new Player("n", 315);
        }

    }

    public int getScore() {
        return score;
    }

    public boolean isGameOver() {
        return !running;
    }


    public Player getPlayer() {
        return player;
    }

    public List<Obstacle> getObstacle() {
        return obstacles;
    }
}
