//import java.util.ArrayList;
//import java.util.List;
//
//public class ObstaclePool {
//    List<Obstacle> obstacles = new ArrayList<Obstacle>();
//    private int index;
//
//    public ObstaclePool() {
//        for(int i = 0; i < 100; i++) {
//            obstacles.add(new Obstacle("obj", 0, 0, 10));
//        }
//    }
//    public Obstacle getObstacle(int playerX, int playerY) {
//        Obstacle obstacle = obstacles.get(index);
//        int obstacleY = (int) (Math.random() * 300) + 50; // randomly position the obstacle vertically
//        obstacle.reset("obj", playerX, obstacleY, 10);
//        index = (index + 1) % obstacles.size();
//        return obstacle;
//    }
//}
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObstaclePool {
    private List<Obstacle> obstacles = new ArrayList<Obstacle>();
    private int index;
    private Random random = new Random();

    public ObstaclePool() {
        for(int i = 0; i < 100; i++) {
            obstacles.add(new Obstacle("obj", 0, 0, 10));
        }
    }

    public Obstacle getObstacle(int x, int windowHeight) {
        int obstacleSize = Obstacle.SIZE;
        int obstacleY;
        if (random.nextBoolean()) {
            // obstacle position for jump
            obstacleY = windowHeight - obstacleSize * 20;
        } else {
            // obstacle position for slide
            obstacleY = windowHeight - obstacleSize;
        }
        Obstacle obstacle = obstacles.get(index);
        obstacle.reset("obj", x, obstacleY, obstacleSize);
        index = (index + 1) % obstacles.size();
        return obstacle;
    }
}
