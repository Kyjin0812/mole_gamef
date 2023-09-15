package BouncingBalls;

import java.awt.*;
import javax.swing.*;

class Ball {
    private int Red_x = 100;
    private int Red_y = 100;
    private int Green_x = 100;
    private int Green_y = 100;
    private int Blue_x = 100;
    private int Blue_y = 100;
    private int size = 30;
    private int Red_xSpeed = 10;
    private int Red_ySpeed = 10;
    private int Green_xSpeed = 20;
    private int Green_ySpeed = 10;
    private int Blue_xSpeed = 10;
    private int Blue_ySpeed = 20;
    public void draw_red(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(Red_x, Red_y, size, size);
    }

    public void draw_green(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(Green_x, Green_y, size, size);
    }

    public void draw_blue(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(Blue_x, Blue_y, size, size);
    }

    public void update() {
        Red_x += Red_xSpeed;
        Red_y += Red_ySpeed;
        Green_x += Green_xSpeed;
        Green_y += Green_ySpeed;
        Blue_x += Blue_xSpeed;
        Blue_y += Blue_ySpeed;
        if ((Red_x + size) > BouncingBallsTest.BOARD_WIDTH - size || Red_x < 0) {
            Red_xSpeed = -Red_xSpeed;
        }
        if ((Red_y + size) > BouncingBallsTest.BOARD_HEIGHT - size || Red_y < 0) {
            Red_ySpeed = -Red_ySpeed;
        }
        if ((Green_x + size) > BouncingBallsTest.BOARD_WIDTH - size || Green_x < 0) {
            Green_xSpeed = -Green_xSpeed;
        }
        if ((Green_y + size) > BouncingBallsTest.BOARD_HEIGHT - size || Green_y < 0) {
            Green_ySpeed = -Green_ySpeed;
        }
        if ((Blue_x + size) > BouncingBallsTest.BOARD_WIDTH - size || Blue_x < 0) {
            Blue_xSpeed = -Blue_xSpeed;
        }
        if ((Blue_y + size) > BouncingBallsTest.BOARD_HEIGHT - size || Blue_y < 0) {
            Blue_ySpeed = -Blue_ySpeed;
        }
    }
}

public class BouncingBallsTest extends JPanel{
    static final int BOARD_WIDTH = 600;
    static final int BOARD_HEIGHT = 300;
    public Ball ball1 = new Ball();
    public Ball ball2 = new Ball();
    public Ball ball3 = new Ball();
    public BouncingBallsTest() {
        this.setBackground(Color.WHITE);
        Runnable task = () -> {
            while (true) {
                ball1.update();
                ball2.update();
                ball3.update();
                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ignore) {
                }
            }
        };
        new Thread(task).start();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball1.draw_red(g);
        ball2.draw_green(g);
        ball3.draw_blue(g);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(BouncingBallsTest.BOARD_WIDTH, BouncingBallsTest.BOARD_HEIGHT);
        frame.add(new BouncingBallsTest());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
