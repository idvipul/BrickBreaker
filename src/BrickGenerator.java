import java.awt.*;

public class BrickGenerator {
    public int map[][];
    public int brickHeight = 50;
    public int brickWidth = 75;

    public BrickGenerator(int row, int col) {
        map = new int[row][col];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                // 1 indicates brick is present
                map[i][j] = 1;
            }
        }
    }

    // draw the bricks
    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    g.setColor(Color.white);
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                    // draw black border between the bricks
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                }
            }
        }
    }

    public void setBrickVAlue(int value, int row, int col) {
        map[row][col] = value;
    }

}

