import java.awt.event.KeyEvent;

public class PlayerController{
    private Player player;
    private boolean isPressed = false;

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }

    public PlayerController(Player player) {
        this.player = player;
    }

    public void handleInput(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W){
            player.setState(new JumpingState(player));
            player.getState().action();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S ){

            if (!(player.getState() instanceof SlidingState)) {
                player.setState(new SlidingState(player));
                player.getState().action();
            }
            if (!isPressed) {
                player.setState(new RunningState(player));
                player.getState().action();
            }
        }
        else {
            player.setState(new RunningState(player));
            player.getState().action();
        }
    }


}
