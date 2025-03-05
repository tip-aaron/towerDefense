package scenes;

import main.Game;
import utils.NumberUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MenuScene extends GameScene implements SceneMethods {
    private BufferedImage spriteSheet;
    private ArrayList<BufferedImage> sprites;

    public MenuScene(Game game) {
        super(game);

        this.sprites = new ArrayList<>();

        this.importImg();
        this.loadSprites();
    }

    @Override
    public void render(Graphics g) {
        for (int y = 0; y < 20; ++y) {
            for (int x = 0; x < 20; ++x) {
                g.drawImage(this.sprites.get(NumberUtils.randomInt(this.sprites.size() - 1)), x * 32, y * 32, null);
            }
        }
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/spriteatlas.png");

        try {
            assert is != null;

            this.spriteSheet = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadSprites() {
        assert this.spriteSheet != null;
        assert this.sprites != null;

        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 10; ++x) {
                this.sprites.add(this.spriteSheet.getSubimage(x * 32, y * 32,
                                                              32, 32));
            }
        }
    }
}
