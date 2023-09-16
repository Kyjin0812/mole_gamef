package Mole_Game;

import javax.swing.*;
import java.awt.*;

class Mole {
    int x, y;
    Image img;

    Mole(int x, int y) {
        this.x = x;
        this.y = y;
        ImageIcon icon = new ImageIcon("src\\main\\java\\Mole_Game\\Mole.png");
        img = icon.getImage();
    }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, null);
    }

    public void update(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
