import javax.swing.JPanel;

import java.awt.*;

public class Gameplay extends JPanel {

    // default constructor
    public Gameplay() { }

    // to draw different shapes
    public void paint(Graphics g) {
        // background
        g.setColor(Color.black);
        g.fillRect(1, 1 , 692, 592);

        // borders;
        g.setColor(Color.yellow);
        // upper border
        g.fillRect(0, 0, 692, 3);
        // left border
        g.fillRect(0, 0, 3, 592);
        // right border
        g.fillRect(691, 0, 3, 592);

        // slider
        g.setColor(Color.green);
        g.fillRect(310, 550, 100, 8);

        // ball
        g.setColor(Color.yellow);
        g.fillRect(120, 350, 20, 20);

    }
}
