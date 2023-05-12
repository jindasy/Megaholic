import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class GameLogic2 extends Observable {

    public static final int SIZE = 800;
    private List<Obstacle> obstacles = new ArrayList<Obstacle>();
    private Player player1 = new Player("a", 390);
    private Player player2 = new Player("b", 110);
    private Thread thread;
    private boolean running;
    public int winner;


    public GameLogic2() {
        // TODO use object pool

    }


    public void start() {
        running = true;
        obstacles.clear();
        player1.initializeState();
        player2.initializeState();
        int obstacle_size = 30;
        int start_x = SIZE;
        for (int i = 0; i < 8; i++) {
            Obstacle obstacle1 = new Obstacle("Obs" + (i + 1), start_x, 200, obstacle_size);
            Obstacle obstacle2 = new Obstacle("Obs" + (i + 1), start_x, 350, obstacle_size);
            start_x += 2* Obstacle.SIZE + 100;
            obstacles.add(obstacle1);
            obstacles.add(obstacle2);
        }



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
                            obstacle.reset("", SIZE+(Obstacle.SIZE+50), SIZE - SIZE/3 - Obstacle.SIZE, 30);
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
