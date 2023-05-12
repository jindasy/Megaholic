import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.*;

public class GameLogic extends Observable {

    public static final int SIZE = 600;
    private List<Obstacle> obstacles = new ArrayList<Obstacle>();
    private Player player = new Player("a", 320);
    private Thread thread;
    private boolean running;

    private int score = 0;

    public GameLogic() {
        score = 0;
        // TODO use object pool
    }

    public void start() {
        running = true;
        score = 0;
        obstacles.clear();
        player.initializeState();
        System.out.println(player.getX());
        int obstacle_size = 30;
        int start_x = SIZE;
        int start_y = SIZE - SIZE/2 - obstacle_size;
        for (int i = 0; i < 8; i++) {
            Obstacle obstacle = new Obstacle("Obs" + (i + 1), start_x, start_y, obstacle_size);
            start_x += 2* Obstacle.SIZE + 50;
            obstacles.add(obstacle);
        }



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
                            obstacle.reset("", SIZE+(Obstacle.SIZE+50), SIZE - SIZE/3 - Obstacle.SIZE, 30);
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
