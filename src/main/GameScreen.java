package main;

import inputs.KeyboardListener;
import inputs.TowerDefenseMouseListener;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {
    private Game game;
    private Dimension size;

    // Listeners
    private TowerDefenseMouseListener mouseListener;
    private KeyboardListener keyboardListener;

    public GameScreen(Game game) {
        this.game = game;

        this.setPanelSize();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.game.getRenderer().render(g);
    }

    public void initInputs() {
        this.mouseListener = new TowerDefenseMouseListener(this.game);
        this.keyboardListener = new KeyboardListener();

        this.addMouseListener(this.mouseListener);
        this.addMouseMotionListener(this.mouseListener);
        this.addKeyListener(this.keyboardListener);

        this.requestFocus();
    }

    private void setPanelSize() {
        this.size = new Dimension(640, 640);

        this.setMinimumSize(this.size);
        this.setMaximumSize(this.size);
        this.setPreferredSize(this.size);
    }
}
