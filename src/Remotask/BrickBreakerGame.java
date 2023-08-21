package Remotask;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BrickBreakerGame extends JPanel implements ActionListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BALL_RADIUS = 20;
    private static final int BRICK_WIDTH = 60;
    private static final int BRICK_HEIGHT = 20;
    private static final int PADDLE_WIDTH = 100;
    private static final int PADDLE_HEIGHT = 10;
    private static final int PADDLE_INITIAL_POSITION_Y = 550;
    private static final int TIMER_DELAY = 10;

    private Timer timer;
    private int ballPositionX = WIDTH / 2;
    private int ballPositionY = HEIGHT / 2;
    private int ballDirectionX = 1;
    private int ballDirectionY = 1;
    private int paddlePositionX = WIDTH / 2 - PADDLE_WIDTH / 2;
    private boolean gameRunning = true;
    private boolean bricksVisible = true;

    public BrickBreakerGame() {
        timer = new Timer(TIMER_DELAY, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    paddlePositionX -= 20;
                    if (paddlePositionX < 0) {
                        paddlePositionX = 0;
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    paddlePositionX += 20;
                    if (paddlePositionX + PADDLE_WIDTH > WIDTH) {
                        paddlePositionX = WIDTH - PADDLE_WIDTH;
                    }
                }
            }
        });
        setFocusable(true);
    }

    private void moveBall() {
        ballPositionX += ballDirectionX;
        ballPositionY += ballDirectionY;

        if (ballPositionX < 0 || ballPositionX + BALL_RADIUS > WIDTH) {
            ballDirectionX = -ballDirectionX;
        }
        if (ballPositionY < 0 || ballPositionY + BALL_RADIUS > HEIGHT) {
            ballDirectionY = -ballDirectionY;
        }

        if (ballPositionY + BALL_RADIUS >= PADDLE_INITIAL_POSITION_Y && ballPositionX + BALL_RADIUS >= paddlePositionX && ballPositionX <= paddlePositionX + PADDLE_WIDTH) {
            ballDirectionY = -ballDirectionY;
        }
    }

    private void checkCollision() {
        if (bricksVisible && ballPositionY <= BRICK_HEIGHT) {
            int brickColumn = ballPositionX / BRICK_WIDTH;
            if (brickColumn >= 0 && brickColumn < WIDTH / BRICK_WIDTH) {
                bricksVisible = false;
                //ballDirectionY = -ballDirectionY;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameRunning) {
            moveBall();
            checkCollision();
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.RED);
        g.fillOval(ballPositionX, ballPositionY, BALL_RADIUS, BALL_RADIUS);

        g.setColor(Color.WHITE);
        g.fillRect(paddlePositionX, PADDLE_INITIAL_POSITION_Y, PADDLE_WIDTH, PADDLE_HEIGHT);

        if (bricksVisible) {
            g.setColor(Color.GREEN);
            for (int i = 0; i < WIDTH / BRICK_WIDTH; i

                    ++) {
                g.fillRect(i * BRICK_WIDTH, 0, BRICK_WIDTH, BRICK_HEIGHT);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Brick Breaker Game");
        BrickBreakerGame game = new BrickBreakerGame();
        frame.add(game);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
