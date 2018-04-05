import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.Timer;

// KeyListener --> detect arrow movements
// ActionListener --> detect ball movement
public class Gameplay extends JPanel implements KeyListener, ActionListener{
    // add some properties
    private boolean play = false;
    private int score = 0;

    //  3 cols * 7 rows
    private int totalBricks = 21;

    // to set time to the ball -- speed of the ball
    private Timer timer;
    // timer speed
    private int delay = 8;

    // starting pos of the slider
    private int playerX = 310;

    // starting position of ball
    private int ballposX = 120;
    private int ballposY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;

    private BrickGenerator brick;

    // default constructor
    public Gameplay() {
        // create object of BrickGenerator
        brick = new BrickGenerator(3,7);
        // detect arrow movements
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    // to draw different shapes
    public void paint(Graphics g) {
        // background
        g.setColor(Color.black);
        g.fillRect(1, 1 , 692, 592);

        // call draw function for drawing bricks
        brick.draw((Graphics2D)g);

        // borders;
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);

        // slider
        g.setColor(Color.green);
        g.fillRect(playerX, 550, 100, 8);

        // ball
        g.setColor(Color.yellow);
        g.fillOval(ballposX, ballposY, 20, 20);

        g.dispose();
    }

    // Action Listener Method
    public void actionPerformed (ActionEvent e) {
        timer.start();

        if(play) {

            // collision detection between ball and slider
            // convert oval to rectangle
            Rectangle oval = new Rectangle(ballposX, ballposY, 20, 20);
            Rectangle rectangle = new Rectangle(playerX, 550, 100, 8);
            if (oval.intersects(rectangle ) ) {
                ballYdir = -ballYdir;
            }

            // detect collision betwenn bricks and ball
            for (int i = 0; i < brick.map.length; i++) {
                for (int j = 0; j < brick.map[0].length; j++) {
                    if (brick.map[i][j] > 0) {
                        int brickWidth = brick.brickWidth;
                        int brickHeight = brick.brickHeight;
                        int brickX = j * brick.brickWidth + 75;
                        int brickY = i * brick.brickWidth + 50;

                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
                        Rectangle brickRect = rect;

                        // when ball and brick intersects
                        if(ballRect.intersects(brickRect)) {
                            brick.setBrickVAlue(0, i ,j);
                        }
                    }
                }
            }

            // change direction of the ball when it hits the border
            ballposX = ballposX + ballXdir;
            ballposY = ballposY + ballYdir;

            // for left border
            if (ballposX < 0) {
                ballXdir = -ballXdir;
            }
            // for top border
            if (ballposY < 0) {
                ballYdir = -ballYdir;
            }
            // for right border
            if (ballposX > 670) {
                ballXdir = -ballXdir;
            }
        }

        // repaint method draws the slider again after moving to a new position
        repaint();
    }

    // Key Event Methods:
    @Override
    public void keyTyped(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerX >= 600) {
                // if playerX goes beyond border, keep it at border
                playerX = 600;
            } else {
                moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerX < 10) {
                // if playerX goes beyond border, keep it at border
                playerX = 10;
            } else {
                moveLeft();
            }
        }
    }

    public void moveRight() {
        play = true;
        playerX = playerX + 20;
    }

    public void moveLeft() {
        play = true;
        playerX = playerX - 20;
    }

}
