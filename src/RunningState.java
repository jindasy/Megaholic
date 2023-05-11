public class RunningState implements PlayerState{
    private Player player;
    public RunningState(Player player) {
        this.player = player;
        this.action();
    }

    @Override
    public void action() {
        System.out.println("RUNNING");
        player.reset();
    }
}
