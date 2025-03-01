package src.units;

import src.main.Game;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Tank extends Unit {
    Game game;

    public Tank(Game game) {
        name = "Tank";
        sizeX = 3;
        sizeY = 2;
        health = sizeX * sizeY;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/src/res/sprites/tank.png"));
            uTool.scaleImage(image, game.tileSize, game.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
