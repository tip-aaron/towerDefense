package scenes;

import main.Game;

import java.awt.*;

public class PlayingScene extends GameScene implements SceneMethods {
    public PlayingScene(Game game) {
        super(game);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, 640, 640);
    }
}
