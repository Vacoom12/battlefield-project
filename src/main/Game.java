package src.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
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
    public final int playState = 1;
    public final int titleState = 0;
    
        Thread gameThread;
        int FPS = 60;
        public KeyHandler keyH = new KeyHandler(this);
        public AssetSetter aSetter = new AssetSetter(this);
        TileManager tileM = new TileManager(this, keyH, aSetter);
        UI ui = new UI(this);
        
        public Unit obj[] = new Unit[10];
    
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
            // gameState = titleState;
            gameState = titleState;
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
        if(gameState == titleState){
            int playButtonX = ui.getXCenter("Play");
            float playButtonY = (float) (tileSize * 9.5);
            int buttonWidth = 100;
            int buttonHeight = 20;
    
            if (keyH.mouseX >= playButtonX && keyH.mouseX <= playButtonX + buttonWidth && keyH.mouseY >= playButtonY - tileSize && keyH.mouseY <= playButtonY + buttonHeight) {
                gameState = playState;
            }
            keyH.mouseClicked = false;
            playButtonX = ui.getXCenter("Quit");
            playButtonY += tileSize * 2;
            
            if (keyH.mouseX >= playButtonX && keyH.mouseX <= playButtonX + buttonWidth && keyH.mouseY >= playButtonY - tileSize && keyH.mouseY <= playButtonY + buttonHeight) {
                System.exit(0);
            }
            keyH.mouseClicked = false;

        }
        // if(gameState == playState){}
        else{
            tileM.update();
        }
       
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        if(gameState == titleState){
            ui.draw(g2);
        }
        if(gameState == playState){
            tileM.draw(g2);

            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null && obj[i].isDestroy) {
                    obj[i].draw(g2, this);
                }
            }
        }

        g2.dispose();
    }
}
