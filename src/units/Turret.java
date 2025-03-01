package src.units;

import src.main.Game;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Turret extends Unit {
    Game game;

    public Turret(Game game) {
        name = "Turret";
        sizeX = 2;
        sizeY = 2;
        health = sizeX * sizeY;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/src/res/sprites/turret.png"));
            uTool.scaleImage(image, game.tileSize, game.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
