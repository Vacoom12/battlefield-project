package src.units;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import src.main.Game;


public class Unit {
    public int x, y;
    protected int width, height; 
    protected int health;      
    protected String name;
    public BufferedImage image;  

    public void draw(Graphics2D g2, Game game) {
        g2.drawImage(image, x, y, game.tileSize * 2, game.tileSize * 2, null);
    }
}
