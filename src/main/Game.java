package main;

import inputs.KeyboardListener;
import inputs.TowerDefenseMouseListener;
import scenes.MenuScene;
import scenes.PlayingScene;
import scenes.SettingsScene;

import javax.swing.*;

public class Game extends JFrame implements Runnable {
    // Settings
    private double FPS_SET = 120.0;
    private double UPS_SET = 60.0;

    // Listeners
    private TowerDefenseMouseListener mouseListener;
    private KeyboardListener keyboardListener;

    // Classes
    private Thread gameThread;
    private GameScreen gameScreen;
    private Renderer renderer;
    private MenuScene menuScene;
    private SettingsScene settingsScene;
    private PlayingScene playingScene;

    public Game() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.initClasses();
        this.add(this.gameScreen);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public Renderer getRenderer() {
        return this.renderer;
    }

    public MenuScene getMenuScene() {
        return menuScene;
    }

    public SettingsScene getSettingsScene() {
        return settingsScene;
    }

    public PlayingScene getPlayingScene() {
        return playingScene;
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheckInMs = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        long nowInNanoTime;
        long nowInMilliTime;

        while (true) {
            nowInNanoTime = System.nanoTime();
            nowInMilliTime = System.currentTimeMillis();

            // Render
            if (nowInNanoTime - lastFrame >= timePerFrame) {
                gameScreen.repaint();

                lastFrame = nowInNanoTime;
                frames += 1;
            }

            // Update
            if (nowInNanoTime - lastUpdate >= timePerUpdate) {
                this.updateGame();

                lastUpdate = nowInNanoTime;
                updates += 1;
            }

            if (nowInMilliTime - lastTimeCheckInMs >= 1000) {
                System.out.println("FPS: " + frames +" | UPS: " + updates);

                frames = 0;
                updates = 0;
                lastTimeCheckInMs = nowInMilliTime;
            }
        }
    }

    private void initClasses() {
        this.gameThread = new Thread(this) {};
        this.renderer = new Renderer(this);
        this.gameScreen = new GameScreen(this);
        this.menuScene = new MenuScene(this);
        this.settingsScene = new SettingsScene(this);
        this.playingScene = new PlayingScene(this);
    }

    private void initInputs() {
        this.mouseListener = new TowerDefenseMouseListener();
        this.keyboardListener = new KeyboardListener();

        this.addMouseListener(this.mouseListener);
        this.addMouseMotionListener(this.mouseListener);
        this.addKeyListener(this.keyboardListener);

        this.requestFocus();
    }

    private void start () {
        gameThread.start();
    }

    private void updateGame() {}

    public static void main(String[] args) {
        Game game = new Game();
        game.initInputs();
        game.start();
    }
}
