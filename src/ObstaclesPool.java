
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObstaclesPool {
    private List<Obstacle> obstacles = new ArrayList<Obstacle>();
    private int index;
    private static ObstaclesPool instance;
    private Random random = new Random();
    public static ObstaclesPool getInstance(){
        if (instance == null){
            instance = new ObstaclesPool();
        }
        return instance;
    }

    public ObstaclesPool() {
        for(int i = 0; i < 1000; i++) {
            obstacles.add(new Obstacle(0, 0, 19,false));
        }
    }

    public Obstacle getObstacle(int x, int y) {
        int obstacleSize = Obstacle.SIZE;
        int obstacleY;
        boolean isJump=false;
        int obstacleX = Math.max(x, Math.min(obstacleSize/3, x*2));
        if (random.nextBoolean()) {
            // obstacle position for slide
            obstacleY = y - obstacleSize;
            isJump=true;
        } else {
            // obstacle position for jump
            obstacleY = y - obstacleSize+100;
            isJump=false;
        }
        Obstacle obstacle = obstacles.get(index);
        obstacle.reset( obstacleX, obstacleY, obstacleSize,isJump);
        index = (index + 1) % obstacles.size();
        return obstacle;
    }
}