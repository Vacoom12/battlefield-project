package src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class UI {
    Game game;
    Graphics2D g2;
    Font arial_40, arial_80B;
    public boolean messageOn = false;
    public String message = "";
    private BufferedImage bg;
    private JButton[] button = new JButton[2];
    public boolean gameWon = false;
    
    public UI(Game game) {
        this.game = game;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);

        getImage();
    }

    public void showMessage(String text){
        message = text;
        messageOn = true;
    }
    public void getImage(){
        try{
            bg = ImageIO.read(getClass().getResourceAsStream("/src/res/title/titlebackground.png"));
            button[0] = new JButton(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/src/res/title/playbutton.png"))));
            button[1] = new JButton(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/src/res/title/quitbutton.png"))));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;

        g2.setFont(arial_40); 
        if (game.gameState == game.titleState){
            drawTitleScreen();
        } else if(game.gameState == game.diffState){
            drawDiff();
        } else if (game.gameState == game.playState) {
            drawGameContent();
        } else if (game.gameState == game.endState) {
            drawEndScreen();
            game.stopMusic();
        }
    }
    public void drawTitleScreen(){
        // g2.setColor(new Color(70,120,80));
        // g2.fillRect(0, 0, game.screenWidth, game.screenHeight);
        g2.drawImage(bg, 0, 0, game.screenWidth, game.screenHeight, null);
        g2.drawImage(((ImageIcon) button[0].getIcon()).getImage(), 0, 0, game.screenWidth, game.screenHeight, null);
        // window.add(button[0]);
        g2.drawImage(((ImageIcon) button[1].getIcon()).getImage(), 0, 0, game.screenWidth, game.screenHeight, null);

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
    public void drawDiff(){
        g2.setColor(Color.black);
        g2.fillRect(0, 0, game.screenWidth, game.screenHeight);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
        String e = "Easy", n = "Normal", h = "Hard";
        g2.setColor(Color.white);
        g2.drawString(e, game.screenWidth-1050, game.screenHeight/2);
        g2.drawString(n, game.screenWidth-750, game.screenHeight/2);
        g2.drawString(h, game.screenWidth-400, game.screenHeight/2);
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
        String result;
        String message1;
        String message2 = "RETURN TO TITLE";
        if (gameWon) {
            result = "VICTORY";
            g2.drawString(result, getXCenter(result), game.screenHeight / 2);
        } else {
            result = "DEFEAT";
            message1 = String.valueOf(game.totalUnit) + " LEFT";
            g2.drawString(result, getXCenter(result), game.screenHeight / 2 - game.tileSize);
            g2.drawString(message1, getXCenter(message1), game.screenHeight / 2 + game.tileSize);
            g2.drawString(message2, getXCenter(message2), game.screenHeight / 2 + (game.tileSize * 3));
        }
        
    }

    public int getXCenter(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = game.screenWidth/2 - length/2;
        return x;
    }
}
