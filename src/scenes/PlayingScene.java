package scenes;

import main.Game;
import managers.TileManager;
import utils.LevelEditor;

import java.awt.*;

public class PlayingScene extends GameScene implements SceneMethods {

    private int[][] lvl;
    private TileManager tileManager;

    public PlayingScene(Game game) {
        super(game);

        this.lvl = LevelEditor.getLevelData();
        this.tileManager = new TileManager();
    }

    @Override
    public void render(Graphics g) {
        for (int y = 0; y < this.lvl.length; ++y) {
            for (int x = 0; x < this.lvl[y].length; ++x) {
                int id = this.lvl[y][x];
                g.drawImage(this.tileManager.getSprite(id), x * 32, y * 32, null);
            }
        }
    }

    @Override
    public void mouseClicked(int x, int y) {

    }

    @Override
    public void mouseMoved(int x, int y) {

    }

    @Override
    public void mousePressed(int x, int y) {

    }

    @Override
    public void mouseReleased(int x, int y) {

    }
}
