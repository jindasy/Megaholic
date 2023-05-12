import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Window extends JFrame implements Observer {

    private int size = 600;
    private GameLogic gameLogic = new GameLogic();
    private Renderer renderer;
    private Gui gui;
    Player player = gameLogic.getPlayer();
    ImageIcon img = new ImageIcon("images/1-player-bg.png");

    private JFrame parent = this;


    public Window() {
        super();
        System.out.println("Window made");
        addKeyListener(new Controller());
        setLayout(new BorderLayout());
        renderer = new Renderer();
        add(renderer, BorderLayout.CENTER);
        gui = new Gui();
        add(gui, BorderLayout.SOUTH);
        gameLogic.addObserver(this);
        setSize(size, size);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void update(Observable o, Object arg) {
        renderer.repaint();
        gui.updateScore(gameLogic.getScore());

        if (gameLogic.isGameOver()){
            gui.showGameOverLabel();
        }

    }


    class Renderer extends JPanel {

        public Renderer() {
            setDoubleBuffered(true);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(img.getImage(), 0,0, null);
            paintObstacles(g);
            paintPlayer(g);

        }


        private void paintPlayer(Graphics g) {
            g.setColor(Color.blue);
            g.fillRect(player.getX(), player.getY(), player.WIDTH, player.HEIGHT );
        }

        private void paintObstacles(Graphics g) {
            g.setColor(Color.red);
            for(Obstacle e : gameLogic.getObstacle()) {
                int x = e.getX();
                int y = e.getY();
                g.fillRect(x,y,30, 30);
            }
        }
    }

    class Gui extends JPanel {

        private JLabel scoreLabel;
        private JButton startButton;
        private JButton replayButton;
        private JLabel gameOverLabel;

        public Gui() {
            setLayout(new FlowLayout());
            scoreLabel = new JLabel("Score: 0");
            add(scoreLabel);
            startButton = new JButton("Start");
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameLogic.start();
                    startButton.setEnabled(false);
                    Window.this.requestFocus();
                    startButton.setVisible(false);
                    replayButton.setVisible(false);
                }
            });
            add(startButton);
            replayButton = new JButton("Play again");
            replayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameLogic.start();
                    JFrame frame = new Window();
                    frame.setVisible(true);
                    frame.dispose();
                    startButton.setEnabled(false);
                    gameOverLabel.setVisible(false);
                    replayButton.setVisible(false);
                }
            });
            replayButton.setVisible(false);
            add(replayButton);
            gameOverLabel = new JLabel("GAME OVER");
            gameOverLabel.setForeground(Color.red);
            gameOverLabel.setVisible(false);
            add(gameOverLabel);
        }

        public void updateScore(int score) {
            scoreLabel.setText("Score: " + score);
        }



        public void showGameOverLabel() {
            gameOverLabel.setVisible(true);
            replayButton.setVisible(true);
            replayButton.setEnabled(true);

        }

        public JButton getStartButton() {
            return startButton;
        }

    }

    class Controller extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                System.out.println("Jump");
                player.state = "jumping";
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                System.out.println("Slide");
                player.state = "sliding";
            }

        }
        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                System.out.println("Stop sliding");
                player.state = "stopSliding";
            }
        }
    }

    public static void main(String[] args) {
        Window window = new Window();
        window.setVisible(true);

    }

}

