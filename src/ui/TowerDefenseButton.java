package ui;

import java.awt.*;

public class TowerDefenseButton {
    private String text;
    private int x, y, width, height;

    private boolean mouseHovered, mousePressed;

    private Rectangle bounds;

    public TowerDefenseButton(String text, int x, int y, int width, int height) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.initBounds();
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    public boolean getMouseHovered() {
        return this.mouseHovered;
    }

    public boolean getMousePressed() {
        return this.mousePressed;
    }

    public void setMouseHovered(boolean mouseHovered) {
        this.mouseHovered = mouseHovered;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

    public void draw(Graphics g) {
        this.drawBody(g);
        this.drawBorder(g);
        this.drawText(g);
    }

    public boolean isInBounds(int x, int y) {
        return this.bounds.contains(x, y);
    }

    public void resetBooleans() {
        this.mouseHovered = false;
        this.mousePressed = false;
    }

    private void initBounds() {
        this.bounds = new Rectangle(this.x, this.y, this.width, this.height);
    }

    private void drawBody(Graphics g) {
        if (this.mouseHovered) {
            g.setColor(Color.LIGHT_GRAY);
        } else {
            g.setColor(Color.WHITE);
        }

        g.fillRect(this.x, this.y, this.width, this.height);
    }

    private void drawBorder(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(this.x, this.y, this.width, this.height);

        if (this.mousePressed) {
            g.drawRect(this.x + 1, this.y + 1, this.width - 2, this.height - 2);
            g.drawRect(this.x + 2, this.y + 2, this.width - 4, this.height - 4);
        }
    }

    private void drawText(Graphics g) {
        int width, height, posX, posY;

        width = g.getFontMetrics().stringWidth(this.text);
        height = g.getFontMetrics().getHeight();

        posX = this.x - width / 2 + this.width / 2;
        posY = this.y + height / 2 + this.height / 2;

        g.drawString(this.text, posX, posY);
    }

}
