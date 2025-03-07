package src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class UI {
    Game g;
    Graphics2D g2;
    Font arial_40, arial_80B;
    public boolean messageOn = false;
    public String message = "";
    
    public UI(Game g) {
        this.g = g;
    }
    public void showMessage(String text){
        message = text;
        messageOn = true;
    }
    public void draw(Graphics2D g2){
        this.g2 = g2;

        g2.setFont(arial_40); 
        if(g.gameState == g.titleState){
            drawTitleScreen();
        }
    }
    public void drawTitleScreen(){
        ImageIcon bg = new ImageIcon("/src/res/title/Title.png");
        // g2.setColor(new Color(70,120,80));
        // g2.fillRect(0, 0, g.screenWidth, g.screenHeight);
        g2.drawImage(bg.getImage(), 0, 0, null);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Battlefield";
        int x = getXCenter(text);
        int y = g.tileSize*3;

        g2.setColor(Color.black);
        g2.drawString(text, x+5, y+5);
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
        text = "Play";
        x = getXCenter(text);
        y += g.tileSize*6;
        g2.drawString(text, x, y);

        text = "Quit";
        x = getXCenter(text);
        y += g.tileSize*2;
        g2.drawString(text, x, y);
    }
    public int getXCenter(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = g.screenWidth/2 - length/2;
        return x;
    }
}
