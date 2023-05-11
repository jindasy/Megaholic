public class RunningState implements PlayerState{
    private Player player;
    public RunningState(Player player) {
        this.player = player;
    }

    @Override
    public void action() {
        System.out.println("RUNNING");
        player.reset();
    }
}
