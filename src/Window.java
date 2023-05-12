import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

public class Window extends JFrame implements Observer {

    private int size = 600;
    private GameLogic gameLogic = new GameLogic();
    private Renderer renderer;
    private Gui gui;
    Player player = gameLogic.getPlayer();
    ImageIcon img = new ImageIcon("images/1-player-bg.png");
    ImageIcon imgPlayer = new ImageIcon("images/magman-run.gif");
    ImageIcon imgPlayerSlide = new ImageIcon("images/magman-slide.gif");


    private JFrame parent = this;
    ImageIcon imageObstacle;
    ImageIcon imageObstacle2;


    public Window() {
        super();
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
        imageObstacle = new ImageIcon("images/obs1.png");
        imageObstacle2 = new ImageIcon("images/obs2.png");
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
            if (player.slided) {
                g.drawImage(imgPlayerSlide.getImage(), player.getX(), player.getY(), player.WIDTH, player.HEIGHT, null);
            } else {
                g.drawImage(imgPlayer.getImage(), player.getX(), player.getY(), player.WIDTH, player.HEIGHT, null);
            }
        }

        private void paintObstacles(Graphics g) {
            g.setColor(Color.red);
            for(Obstacle e : gameLogic.getObstacle()) {
                if (e.dead()) {
                    continue;
                }
                if (e.isJumping()) {
                    g.drawImage(imageObstacle2.getImage(),e.getX(), e.getY(), 60, 60, null, null);
                } else {
                    g.drawImage(imageObstacle.getImage(),e.getX(), e.getY(), 60, 60, null, null);
                }
            }
        }
    }

    class Gui extends JPanel {

        private JLabel scoreLabel;
        private JButton startButton;
        private JButton replayButton;
        private JLabel gameOverLabel;
        private JButton backToMain;

        public Gui() {
            setLayout(new FlowLayout());
            gameOverLabel = new JLabel("GAME OVER");
            gameOverLabel.setForeground(Color.red);
            gameOverLabel.setVisible(false);
            add(gameOverLabel);
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
                    JFrame frame = new Window();
                    frame.setVisible(true);
                    parent.dispose();
                    startButton.setEnabled(false);
                    startButton.setEnabled(true);
                    gameOverLabel.setVisible(false);
                    replayButton.setVisible(false);
                }
            });
            replayButton.setVisible(false);
            add(replayButton);


            backToMain = new JButton("Back to main");
            backToMain.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame frame = new MenuPanel();
                    frame.setVisible(true);
                    frame.setSize(new Dimension(600, 600));
                    parent.dispose();
                    startButton.setEnabled(false);
                    gameOverLabel.setVisible(false);
                    replayButton.setVisible(false);
                }
            });
            backToMain.setVisible(true);
            add(backToMain);
        }

        public void updateScore(int score) {
            scoreLabel.setText("Score: " + score);
        }

        public void showGameOverLabel() {
            gameOverLabel.setVisible(true);
            replayButton.setVisible(true);
            replayButton.setEnabled(true);

        }

    }

    class Controller extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                player.state = "jumping";
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                player.state = "sliding";
            }

        }
        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                player.state = "stopSliding";
            }
        }
    }


}

