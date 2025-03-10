package inputs;

import main.Game;
import main.GameStates;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class TowerDefenseMouseListener implements MouseListener,
        MouseMotionListener {
    private Game game;

    public TowerDefenseMouseListener(Game game) {
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (GameStates.gameState) {
            case MENU:
                game.getMenu().mouseClicked(e.getX(), e.getY());
                break;
            case PLAYING:
                break;
            case SETTINGS:
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            switch (GameStates.gameState) {
                case MENU:
                    this.game.getMenu().mousePressed(e.getX(), e.getY());
                    break;
                case PLAYING:
                    break;
                case SETTINGS:
                    break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (GameStates.gameState) {
            case MENU:
                game.getMenu().mouseReleased(e.getX(), e.getY());
                break;
            case PLAYING:
                break;
            case SETTINGS:
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch (GameStates.gameState) {
            case MENU:
                this.game.getMenu().mouseMoved(e.getX(), e.getY());
                break;
            case PLAYING:
                break;
            case SETTINGS:
                break;
        }
    }
}
