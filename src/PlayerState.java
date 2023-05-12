import java.util.Objects;

public class PlayerState {

    private Player player;

    public PlayerState(Player player) {
        this.player = player;

    }

    public void move() {
        if (Objects.equals(player.state, "jumping")) {
            new JumpingState(player).move();
            }

        if (Objects.equals(player.state, "sliding")) {
            new SlidingState(player).move();
        }

        if (Objects.equals(player.state, "stopSliding")) {
            new StopSlidingState(player).move();
        }
    }
}
