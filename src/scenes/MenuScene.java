package scenes;

import inputs.TowerDefenseMouseListener;
import main.Game;
import main.GameStates;
import ui.TowerDefenseButton;

import java.awt.*;

public class MenuScene extends GameScene implements SceneMethods {
    private TowerDefenseButton playingBtn, settingsBtn, exitBtn;

    public MenuScene(Game game) {
        super(game);

        this.initButtons();
    }

    @Override
    public void render(Graphics g) {
        this.drawButtons(g);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (this.playingBtn.isInBounds(x, y)) {
            GameStates.setGameState(GameStates.PLAYING);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        this.playingBtn.setMouseHovered(this.playingBtn.isInBounds(x, y));
    }

    @Override
    public void mousePressed(int x, int y) {
        this.playingBtn.setMousePressed(this.playingBtn.isInBounds(x, y));
        this.playingBtn.setMouseHovered(false);
    }

    @Override
    public void mouseReleased(int x, int y) {
        this.resetButtons();
    }

    private void initButtons() {
        this.playingBtn = new TowerDefenseButton("Play", 100, 100, 100, 50);
        this.settingsBtn = new TowerDefenseButton("Settings", 100, 200, 100, 50);
        this.exitBtn = new TowerDefenseButton("Exit", 100, 300, 100, 50);
    }

    private void drawButtons(Graphics g) {
        this.playingBtn.draw(g);
    }

    private void resetButtons() {
        this.playingBtn.resetBooleans();
    }
}
