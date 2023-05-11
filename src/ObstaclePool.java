
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObstaclePool {
    private List<Obstacle> obstacles = new ArrayList<Obstacle>();
    private int index;
    private Random random = new Random();

    public ObstaclePool() {
        for(int i = 0; i < 1000; i++) {
            obstacles.add(new Obstacle("obj", 0, 0, 19,false));
        }
    }


    public Obstacle getObstacle(int x, int y) {
        int obstacleSize = Obstacle.SIZE;
        int obstacleY;
        boolean isJump=false;
        int obstacleX = Math.max(x, Math.min(obstacleSize/3, x*2));
        if (random.nextBoolean()) {
            // obstacle position for jump
            obstacleY = y - obstacleSize * 10;
            isJump=true;
        } else {
            // obstacle position for slide
            obstacleY = y - obstacleSize;
            isJump=false;
        }

        Obstacle obstacle = obstacles.get(index);
        obstacle.reset("obj", obstacleX, obstacleY, obstacleSize,isJump);
        index = (index + 1) % obstacles.size();

        return obstacle;
    }
}
