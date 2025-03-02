package main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameScreen extends JPanel {
    private Random random;

    private BufferedImage img;
    private ArrayList<BufferedImage> sprites;

    public GameScreen(BufferedImage img) {
        this.sprites = new ArrayList<>();
        this.img = img;
        this.random = new Random();

        this.loadSprites();
    }

    private void loadSprites() {
        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 10; ++x) {
                this.sprites.add(this.img.getSubimage(x * 32, y * 32, 32, 32));
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int y = 0; y < 20; ++y) {
            for (int x = 0; x < 20; ++x) {
                g.drawImage(this.sprites.get(this.getRandomInt()), x * 32, y * 32, null);
            }
        }

    }

    private int getRandomInt() {
        return this.random.nextInt(this.sprites.size());
    }

    private Color getRandomColor() {
        int r, g, b;

        r = this.random.nextInt(256);
        g = this.random.nextInt(256);
        b = this.random.nextInt(256);

        return new Color(r, g, b);
    }

}
