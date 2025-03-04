package src.entities;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import src.main.Game;
import src.main.UtilityTool;

public class Entity {
    public int x, y;
    public BufferedImage image;
    UtilityTool uTool = new UtilityTool();

    public void draw(Graphics2D g2, Game game) {
        g2.drawImage(image, x, y, game.tileSize, game.tileSize, null);
    }
}
