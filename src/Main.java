import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame obj = new JFrame();
        Gameplay gamePlay = new Gameplay();

        // create JFrame
        obj.setSize(700, 730);
//        obj.setBounds(10,10,700,730);
        obj.setTitle("Brick Breaker");
//        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add gamePlay object inside JFrame
        obj.add(gamePlay);
    }
}
