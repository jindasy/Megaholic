public class SlidingState extends PlayerState {
    private Player player;

    public SlidingState(Player player) {
        super(player);
        this.player = player;
    }

    public void move() {
        if (!player.slided) {
            int H = player.getHEIGHT();
            player.setHEIGHT(player.getWIDTH());
            player.setWIDTH(H);
            int y = player.getY() - (player.getHEIGHT() - player.getWIDTH());
            player.setY(y);
            player.setSlided(true);
        }
    }
}
