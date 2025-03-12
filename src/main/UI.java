package src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class UI {
    Game game;
    Graphics2D g2;
    Font pixelFont;
    public boolean messageOn = false;
    public String message = "";
    private BufferedImage[] bg = new BufferedImage[2];
    private BufferedImage[] button = new BufferedImage[4];
    private BufferedImage[] unit = new BufferedImage[3];
    
    public UI(Game game) {
        this.game = game;
        // src\res\font\Pixel Madness.ttf
        InputStream is = getClass().getResourceAsStream("/src/res/font/Pixel Madness.ttf");
        try {
            pixelFont = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        getImage();
    }

    public void showMessage(String text){
        message = text;
        messageOn = true;
    }
    public void getImage(){
        try{
            bg[0] = ImageIO.read(getClass().getResourceAsStream("/src/res/title/titlebackground.png"));
            bg[1] = ImageIO.read(getClass().getResourceAsStream("/src/res/title/BG.png"));
            button[0] = ImageIO.read(getClass().getResourceAsStream("/src/res/title/Play_after.png"));
            button[1] = ImageIO.read(getClass().getResourceAsStream("/src/res/title/Quit_after.png"));
            button[2] = ImageIO.read(getClass().getResourceAsStream("/src/res/title/Play_before.png"));
            button[3] = ImageIO.read(getClass().getResourceAsStream("/src/res/title/Quit_before.png"));
            unit[0] = ImageIO.read(getClass().getResourceAsStream("/src/res/sprites/soldier.png"));
            unit[1] = ImageIO.read(getClass().getResourceAsStream("/src/res/sprites/turret.png"));
            unit[2] = ImageIO.read(getClass().getResourceAsStream("/src/res/sprites/tank.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;

        g2.setFont(pixelFont);
        if (game.gameState == game.titleState){
            drawTitleScreen();
        } else if(game.gameState == game.diffState){
            drawDiff();
        } else if (game.gameState == game.playState  || game.gameState == game.easyState || 
                game.gameState == game.normalState || game.gameState == game.hardState) {
            drawGameContent();
        } else if (game.gameState == game.endState) {
            drawEndScreen();
            game.stopMusic();
        }
    }

    public void drawTitleScreen(){
        g2.drawImage(bg[0], 0, 0, game.screenWidth, game.screenHeight, null);
        g2.drawImage(button[0], 0, 0, game.screenWidth, game.screenHeight, null);
        g2.drawImage(button[1], 0, 0, game.screenWidth, game.screenHeight, null);
    }

    public void drawDiff(){
        g2.setColor(Color.black);
        g2.drawImage(bg[1], 0, 0, game.screenWidth, game.screenHeight, null);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,70F));
        String e = "Easy", n = "Normal", h = "Hard";
        g2.setColor(Color.white);
        g2.drawString(e, game.screenWidth-1050, (game.screenHeight/2) + 30);
        g2.drawImage(unit[0], game.screenWidth-1030, (game.screenHeight/2) - 150, 100, 100, null);

        g2.drawString(n, game.screenWidth-750, (game.screenHeight/2) + 30);
        g2.drawImage(unit[1], game.screenWidth-700, (game.screenHeight/2) - 150, 100, 100, null);

        g2.drawString(h, game.screenWidth-400, (game.screenHeight/2) + 30);
        g2.drawImage(unit[2], game.screenWidth-400, (game.screenHeight/2) - 145, 150, 100, null);

    }

    public void drawGameContent() {
        g2.setFont(pixelFont);
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
        String A = "Ammo : " + game.ammo, E = "Enemy : " + game.totalUnit;
        g2.drawString(A, 650, 88);
        g2.drawString(E, 990, 88);

        // g2.drawString("Ammo : " + game.ammo, 788, 88);
        // g2.drawString("Enemy : " + game.totalUnit, 1028, 88);
    }

    public void drawEndScreen() {
        g2.setFont(pixelFont);
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
        String result;
        String message1;
        String message2 = "RETURN TO TITLE";
        if (game.gameWon) {
            result = "VICTORY";
            g2.drawString(message2, getXCenter(message2), game.screenHeight / 2 + (game.tileSize * 3));
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,100F));
            g2.drawString(result, getXCenter(result), game.screenHeight / 2);

        } else {
            result = "DEFEAT";
            message1 = String.valueOf(game.totalUnit) + " LEFT";
            g2.drawString(message1, getXCenter(message1), game.screenHeight / 2 + game.tileSize);
            g2.drawString(message2, getXCenter(message2), game.screenHeight / 2 + (game.tileSize * 3));
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,100F));
            g2.drawString(result, getXCenter(result), game.screenHeight / 2 - game.tileSize);
        }
        
    }

    public int getXCenter(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = game.screenWidth/2 - length/2;
        return x;
    }
}
