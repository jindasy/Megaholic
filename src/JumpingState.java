public class JumpingState extends PlayerState{
    private Player player;
    public JumpingState(Player player) {
        super(player);
        this.player = player;
    }

    public void move() {
        if (player.jumped && player.getY() == player.getStart_y()) {
            player.setState("Normal");
            player.setJumped(false);
        } else {
            int y = player.getY();
            double vy = player.getVy();
            if (y == player.getStart_y()) {
                vy = -18;
            }
            y += vy;
            if (y < player.getStart_y()) {
                vy++;
            }
            if (y > player.getStart_y()) {
                y = player.getStart_y();
                vy = 0;
            }
            player.setY(y);
            player.setVy(vy);
            player.setJumped(true);
        }
    }
}
