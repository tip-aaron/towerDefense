package main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Renderer {
    private Game game;

    public Renderer(Game game) {
        this.game = game;
    }

    public void render(Graphics g) {
        switch (GameStates.gameState) {
            case MENU -> this.game.getMenuScene().render(g);
            case PLAYING -> this.game.getPlayingScene().render(g);
            case SETTINGS -> this.game.getSettingsScene().render(g);
        }
    }
}
