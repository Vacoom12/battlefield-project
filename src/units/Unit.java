package src.units;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import src.main.Game;
import src.main.UtilityTool;


public class Unit {
    public int x, y;
    protected int sizeX, sizeY; 
    protected int health;      
    protected String name;
    public BufferedImage image;  
    UtilityTool uTool = new UtilityTool();

    public void draw(Graphics2D g2, Game game) {
        g2.drawImage(image, x, y, game.tileSize * sizeX, game.tileSize * sizeY, null);
    }
}
