package main;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {
    private Game game;
    private Dimension size;

    public GameScreen(Game game) {
        this.game = game;

        this.setPanelSize();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.game.getRenderer().render(g);
    }

    private void setPanelSize() {
        this.size = new Dimension(640, 640);

        this.setMinimumSize(this.size);
        this.setMaximumSize(this.size);
        this.setPreferredSize(this.size);
    }
}
