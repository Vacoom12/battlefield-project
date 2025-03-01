package src.units;

import src.main.Game;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Soldier extends Unit {
    Game game;

    public Soldier(Game game) {
        name = "Soldier";
        sizeX = 1;
        sizeY = 1;
        health = sizeX * sizeY;
        isDestroy = false;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/src/res/sprites/soldier.png"));
            uTool.scaleImage(image, game.tileSize, game.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
