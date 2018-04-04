import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame obj = new JFrame();

        obj.setSize(800, 600);
//        obj.setBounds(10,10,800,600);
        obj.setTitle("Brick Breaker");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
