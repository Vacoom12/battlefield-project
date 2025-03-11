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
    public final int playState = 2;
    public final int endState = 3;
    
    Thread gameThread;
    int FPS = 60;
    public KeyHandler keyH = new KeyHandler(this);
    public AssetSetter aSetter = new AssetSetter(this);
    TileManager tileM = new TileManager(this, keyH, aSetter);
    public UI ui = new UI(this);
    Sound bgm = new Sound();
    Sound sfx = new Sound();
        
    public Unit obj[] = new Unit[10];
    public int totalUnit;
    public int ammo;
    public ArrayList<Cross> crossList = new ArrayList<>();
    
    public Game() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.addMouseListener(keyH);
        this.setFocusable(true);
    }
    
    public void setupGame() {
        aSetter.setObject1();
        gameState = titleState;
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
        int ButtonX = 0;
        int ButtonY = 0;
        int buttonWidth = 0;
        int buttonHeight = 0;
        if (gameState == titleState){
            ButtonX = screenWidth - 820;
            ButtonY = screenHeight - 300;
            buttonWidth = 290;
            buttonHeight = 20;
    
            if (keyH.mouseX >= ButtonX && keyH.mouseX <= ButtonX + buttonWidth && keyH.mouseY >= ButtonY - tileSize && keyH.mouseY <= ButtonY + buttonHeight) {
                gameState = diffState;
            }
            keyH.mouseClicked = false;

            ButtonX += 20;
            ButtonY += 100;
            buttonWidth -= 40;
            if (keyH.mouseX >= ButtonX && keyH.mouseX <= ButtonX + buttonWidth && keyH.mouseY >= ButtonY - tileSize && keyH.mouseY <= ButtonY + buttonHeight) {
                System.exit(0);
            }
            keyH.mouseClicked = false;

        }else if(gameState == diffState){
            ButtonX = screenWidth - 1050;
            ButtonY = screenHeight / 2;
            buttonWidth = 150;
            buttonHeight = 20;
    
            if (keyH.mouseX >= ButtonX && keyH.mouseX <= ButtonX + buttonWidth && keyH.mouseY >= ButtonY - tileSize && keyH.mouseY <= ButtonY + buttonHeight) {
                gameState = playState;
            }
            keyH.mouseClicked = false;

            ButtonX += 300;

            if (keyH.mouseX >= ButtonX && keyH.mouseX <= ButtonX + buttonWidth && keyH.mouseY >= ButtonY - tileSize && keyH.mouseY <= ButtonY + buttonHeight) {
                System.exit(0);
            }
            keyH.mouseClicked = false;

            ButtonX += 350;
            if (keyH.mouseX >= ButtonX && keyH.mouseX <= ButtonX + buttonWidth && keyH.mouseY >= ButtonY - tileSize && keyH.mouseY <= ButtonY + buttonHeight) {
                System.exit(0);
            }
            keyH.mouseClicked = false;
        } else if (gameState == playState) {
            tileM.update();
        } else if (gameState == endState) {
            ButtonX = screenWidth - 850;
            ButtonY = (screenHeight / 2) + (tileSize * 3);
            buttonWidth = 350;
            buttonHeight = 20;
    
            if (keyH.mouseX >= ButtonX && keyH.mouseX <= ButtonX + buttonWidth && keyH.mouseY >= ButtonY - tileSize && keyH.mouseY <= ButtonY + buttonHeight) {
                gameState = titleState;
            }
            keyH.mouseClicked = false;
        }
       
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        if(gameState == titleState){
            ui.draw(g2);
        } else {
            tileM.draw(g2);

            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null && obj[i].isDestroy) {
                    obj[i].draw(g2, this);
                }
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
