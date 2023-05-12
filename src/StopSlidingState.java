public class StopSlidingState extends PlayerState{
    private Player player;
    public StopSlidingState(Player player) {
        super(player);
        this.player = player;
//        player.setState("stopSliding");
    }

    public void move() {
        int H = player.getHEIGHT();
        player.setHEIGHT(player.getWIDTH());
        player.setWIDTH(H);
        player.setState("Normal");
        player.setSlided(false);
        player.setJumped(false);
        player.setY(player.getStart_y());
    }
}
