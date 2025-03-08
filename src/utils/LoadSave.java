package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave {

    public static BufferedImage getSpriteAtlas() throws IOException {
        InputStream is = LoadSave.class.getClassLoader().getResourceAsStream("./spriteatlas.png");

        assert is != null;

        return ImageIO.read(is);
    }

}
