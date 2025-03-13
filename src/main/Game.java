package src.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import src.entities.*;
import src.tiles.TileManager;
import src.units.Unit;

public class Game extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 28;
    public final int maxScreenRow = 16;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    public final int maxWorldCol = maxScreenCol;
    public final int maxWorldRow = maxScreenRow;

    public int gameState;
    public final int titleState = 0;
    public final int diffState = 1;
    public final int easyState = 4;
    public final int normalState = 5;
    public final int hardState = 6;
    public final int playState = 2;
    public final int endState = 3;
    
    Thread gameThread;
    int FPS = 60;
    public KeyHandler keyH = new KeyHandler(this);
    public AssetSetter aSetter = new AssetSetter(this);
    TileManager tileM;
    public UI ui = new UI(this);
    Sound bgm = new Sound();
    Sound sfx = new Sound();
    public boolean gameWon = false;
    
    public Unit[] allyObj = new Unit[5];
    public Unit[] obj;
    public int totalUnit;
    public int ammo;
    public ArrayList<Cross> crossList;
    
    public Game() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.addMouseListener(keyH);
        this.setFocusable(true);
    }
    
    public void setupGame() {
        gameState = titleState;
        tileM = new TileManager(this, keyH, aSetter);
        gameWon = false;
        obj = new Unit[10];
        crossList = new ArrayList<>();
        aSetter.setAlly();
        playMusic(0);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        // int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                // drawCount++;
            }

            if (timer >= 1000000000) {
                // drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        if (gameState == playState  || gameState == easyState || gameState == normalState || gameState == hardState)
            tileM.update();
        
       
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        if(gameState == titleState){
            ui.draw(g2);
        } else {
            tileM.draw(g2);

            for (Unit ally : allyObj) {
                if (ally != null)
                    ally.draw(g2, this);
            }

            for (Unit enemy : obj) {
                if (enemy != null && enemy.isDestroy)
                    enemy.draw(g2, this);
            }

            for (Cross cross : crossList) 
                cross.draw(g2, this);

            ui.draw(g2);
        }

        g2.dispose();
    }

    public void playMusic(int i) {
        bgm.setFile(i);
        bgm.play();
        bgm.loop();
    }

    public void stopMusic() {
        bgm.stop();
    }

    public void playSE(int i) {
        sfx.setFile(i);
        sfx.play();
    }
}
