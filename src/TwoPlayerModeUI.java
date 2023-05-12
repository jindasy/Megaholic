import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

public class TwoPlayerModeUI extends JFrame implements Observer {

    private int size = 600;
    private TwoPlayerModeLogic gameLogic = new TwoPlayerModeLogic();
    private Renderer renderer;
    private Gui gui;
    Player player1 = gameLogic.getPlayer1();
    Player player2 = gameLogic.getPlayer2();
    Image imageObstacle;
    Image imageObstacle2;
    JFrame parent = this;
    ImageIcon img = new ImageIcon("images/2-player-bg.png");
    ImageIcon imgPlayer = new ImageIcon("images/magman-run.gif");
    ImageIcon imgPlayerSlide = new ImageIcon("images/magman-slide.gif");


    public TwoPlayerModeUI() {
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
        imageObstacle = new ImageIcon("images/obs1.png").getImage();
        imageObstacle2 = new ImageIcon("images/obs2.png").getImage();
    }

    @Override
    public void update(Observable o, Object arg) {
        renderer.repaint();

        if (gameLogic.isGameOver()){
            String message;
            if (gameLogic.winner == 1) {
                message = "Player 1 wins!";
            }
            else {
                message = "Player 2 wins!";
            }
            gui.showGameOverLabel(message);
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
            if (player1.slided) {
                g.drawImage(imgPlayerSlide.getImage(), player1.getX(), player1.getY(), player1.WIDTH, player1.HEIGHT, null);
            } else {
                g.drawImage(imgPlayer.getImage(), player1.getX(), player1.getY(), player1.WIDTH, player1.HEIGHT, null);
            }
            g.drawString("Player 1", player1.getX(), player1.getY()-10);

            if (player2.slided) {
                g.drawImage(imgPlayerSlide.getImage(), player2.getX(), player2.getY(), player2.WIDTH, player2.HEIGHT, null);
            } else {
                g.drawImage(imgPlayer.getImage(), player2.getX(), player2.getY(), player2.WIDTH, player2.HEIGHT, null);
            }
            g.drawString("Player 2", player2.getX(), player2.getY()-10);
        }

        private void paintObstacles(Graphics g) {
            g.setColor(Color.red);
            for(Obstacle e : gameLogic.getObstacle()) {
                if (e.dead()) {
                    continue;
                }
                if (e.isJumping()) {
                    g.drawImage(imageObstacle2,e.getX(), e.getY(), 60, 60, null, null);
                } else {
                    g.drawImage(imageObstacle,e.getX(), e.getY(), 60, 60, null, null);
                }
            }
        }
    }

    class Gui extends JPanel {

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
            startButton = new JButton("Start");
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameLogic.start();
                    startButton.setEnabled(false);
                    TwoPlayerModeUI.this.requestFocus();
                    startButton.setVisible(false);
                    replayButton.setVisible(false);
                }
            });
            add(startButton);
            replayButton = new JButton("Play again");
            replayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame frame = new TwoPlayerModeUI();
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

        public void showGameOverLabel(String message) {
            gameOverLabel.setVisible(true);
            gameOverLabel.setText(message);
            replayButton.setVisible(true);
            replayButton.setEnabled(true);
        }
    }

    class Controller extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                player1.state = "jumping";
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                player1.state = "sliding";
            }
            if (e.getKeyCode() == KeyEvent.VK_W) {
                player2.state = "jumping";
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                player2.state = "sliding";
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                player1.state = "stopSliding";
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                player2.state = "stopSliding";
            }
        }
    }
}

