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

    // default constructor
    public Gameplay() {
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
