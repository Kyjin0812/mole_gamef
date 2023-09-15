package Mole_Game;

import javax.swing.*;
import java.awt.*;

class Hammer {
    int x, y;
    Image img;

    Hammer(int x, int y) {
        this.x = x;
        this.y = y;
        ImageIcon icon = new ImageIcon("src\\main\\java\\Mole_Game\\hammer.png");
        img = icon.getImage();
    }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, null);
    }

    public void move_left() {
        x -= 10;
        if(x<0) {
            x=0;
        }
    }

    public void move_right() {
        x += 10;
        if(x>MoleGameMain.WIDTH-139) {
            x = MoleGameMain.WIDTH-139;
        }
    }

    public void move_up() {
        y -= 10;
        if(y<0) {
            y=0;
        }
    }

    public void move_down() {
        y += 10;
        if(y>MoleGameMain.HEIGHT-164) {
            y=MoleGameMain.HEIGHT-164;
        }
    }

    public void smash() {
        ImageIcon icon = new ImageIcon("src\\main\\java\\Mole_Game\\smash.png");
        img = icon.getImage();
    }

    public void return_hammer() {
        ImageIcon icon = new ImageIcon("src\\main\\java\\Mole_Game\\hammer.png");
        img = icon.getImage();
    }
}
