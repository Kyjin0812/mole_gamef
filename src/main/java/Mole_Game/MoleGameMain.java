package Mole_Game;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class MoleGameMain extends JFrame implements ActionListener {
    static final int WIDTH = 1024;
    static final int HEIGHT = 720;
    private JLabel label1, label2;
    Hammer hammer = new Hammer(720, 250);
    Mole mole = new Mole((int) (Math.random() * (MoleGameMain.WIDTH-100)),
            (int) (Math.random() * (MoleGameMain.HEIGHT-115)));
    class MyPanel extends JPanel {
        public MyPanel() {
            Runnable task = () -> {
                while (true) {
                    if((mole.x <= hammer.x && hammer.x <= mole.x+100)&&(mole.y <= hammer.y+100 && hammer.y+100 <= mole.y+115)&& hammer.smash_state){
                        mole.update((int) (Math.random() * (MoleGameMain.WIDTH-100)), (int) (Math.random() * (MoleGameMain.HEIGHT-115)));
                    }
                    repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ignore) {
                    }
                }
            };
            new Thread(task).start();
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            mole.draw(g);
            hammer.draw(g);
        }
    }

    public MoleGameMain() {
        MyPanel panel = new MyPanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(panel);
        pack();
        setVisible(true);
        panel.requestFocus();
        panel.setFocusable(true);

        panel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    hammer.move_left();
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    hammer.move_right();
                }
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    hammer.move_up();
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    hammer.move_down();
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    hammer.smash();
                }
            }

            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    hammer.return_hammer();
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        //repaint();
    }

    public static void main(String[] args) {
        MoleGameMain m = new MoleGameMain();
    }
}
