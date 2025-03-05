package inputs;

import main.GameStates;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int pressedKeyCode = e.getKeyCode();

        switch (pressedKeyCode) {
            case KeyEvent.VK_ESCAPE -> GameStates.gameState = GameStates.MENU;
            case KeyEvent.VK_ENTER -> GameStates.gameState = GameStates.PLAYING;
            case KeyEvent.VK_S -> GameStates.gameState = GameStates.SETTINGS;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
