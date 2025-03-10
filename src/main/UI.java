package src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class UI {
    Game game;
    Graphics2D g2;
    Font arial_40, arial_80B;
    public boolean messageOn = false;
    public String message = "";
    private BufferedImage bg;
    public boolean gameFinished = false;
    public boolean gameWon = false;
    
    public UI(Game game) {
        this.game = game;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
    }
    public void showMessage(String text){
        message = text;
        messageOn = true;
    }
    public void draw(Graphics2D g2){
        this.g2 = g2;

        g2.setFont(arial_40); 
        if (game.gameState == game.titleState){
            drawTitleScreen();
        } else if (game.gameState == game.playState) {
            drawGameContent();
        } else if (game.gameState == game.endState) {
            drawEndScreen();
        }
    }
    public void drawTitleScreen(){
        try{
            bg = ImageIO.read(getClass().getResourceAsStream("/src/res/title/Title.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        // g2.setColor(new Color(70,120,80));
        // g2.fillRect(0, 0, game.screenWidth, game.screenHeight);
        g2.drawImage(bg, 0, 0, game.screenWidth, game.screenHeight, null);

        // g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        // String text = "Battlefield";
        // int x = getXCenter(text);
        // int y = game.tileSize*3;

        // g2.setColor(Color.black);
        // g2.drawString(text, x+5, y+5);
        // g2.setColor(Color.white);
        // g2.drawString(text, x, y);

        // g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
        // text = "Play";
        // x = getXCenter(text);
        // y += game.tileSize*6;
        // g2.drawString(text, x, y);

        // text = "Quit";
        // x = getXCenter(text);
        // y += game.tileSize*2;
        // g2.drawString(text, x, y);
    }

    public void drawGameContent() {
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        g2.drawString("Ammo : " + game.ammo, 888, 88);
        g2.drawString("Enemy : " +  game.totalUnit, 1128, 88);
    }

    public void drawEndScreen() {
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        String result = (gameWon) ? "VICTORY" : "DEFEAT\n" + game.totalUnit + " Left";
        g2.drawString(result, getXCenter(result), game.screenHeight/2);
    }

    public int getXCenter(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = game.screenWidth/2 - length/2;
        return x;
    }
}
