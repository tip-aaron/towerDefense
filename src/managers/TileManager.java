package managers;

import objects.Tile;
import utils.LoadSave;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TileManager {

    public Tile GRASS, WATER, ROAD;
    public BufferedImage spriteAtlas;
    public ArrayList<Tile> tiles;

    public TileManager() {
        this.tiles = new ArrayList<>();

        this.loadAtlas();
        this.createTiles();
    }

    private void createTiles() {
        this.tiles.add(GRASS = new Tile(this.getSprite(9, 0)));
        this.tiles.add(WATER = new Tile(this.getSprite(0, 0)));
        this.tiles.add(ROAD = new Tile(this.getSprite(8, 0)));
    }

    private void loadAtlas() {
        try {
            this.spriteAtlas = LoadSave.getSpriteAtlas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getSprite(int id) {
        return this.tiles.get(id).getSprite();
    }

    private BufferedImage getSprite(int x, int y) {
        return this.spriteAtlas.getSubimage(x * 32, y * 32, 32, 32);
    }
}
