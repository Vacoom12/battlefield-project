package src.units;

import src.Game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Unit {
    public int x, y;    
    protected int width, height; 
    protected int health;      
    protected String name;
    public BufferedImage image;  

    // public Unit(String name, int x, int y, int width, int height, int health) {
    //     this.name = name;
    //     this.x = x;
    //     this.y = y;
    //     this.width = width;
    //     this.height = height;
    //     this.health = health;
    // }

    public void takeDamage() {
        if (health > 0) 
            health--;
    }

    public boolean isDestroyed() {
        return health == 0;
    }

    public void draw(Graphics2D g2, Game game) {
        // int screenX = worldX - gp.player.worldX + gp.player.screenX;
        // int screenY = worldY - gp.player.worldY + gp.player.screenY;
        int posX = x * game.tileSize;
        int posY = y * game.tileSize;

        g2.drawImage(image, posX, posY, game.tileSize, game.tileSize, null);
    }
}
