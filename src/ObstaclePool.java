
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObstaclePool {
    private List<Obstacle> obstacles = new ArrayList<Obstacle>();
    private int index;
    private Random random = new Random();

    public ObstaclePool() {
        for(int i = 0; i < 1000000; i++) {
            obstacles.add(new Obstacle("obj", 0, 0, 19));
        }
    }

    public Obstacle getObstacle(int x, int y) {
        int obstacleSize = Obstacle.SIZE;
        int obstacleY;
        if (random.nextBoolean()) {
            // obstacle position for jump
            obstacleY = y - obstacleSize * 20;
        } else {
            // obstacle position for slide
            obstacleY = y - obstacleSize;
        }
        int obstacleX = Math.max(x, Math.min(Obstacle.SIZE - obstacleSize, x*2));

        Obstacle obstacle = obstacles.get(index);
        obstacle.reset("obj", x, obstacleY, obstacleSize);
        index = (index + 1) % obstacles.size();
        return obstacle;
    }
}
