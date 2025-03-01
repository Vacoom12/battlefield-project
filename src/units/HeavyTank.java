package src.units;

import src.main.Game;

import java.io.IOException;
import javax.imageio.ImageIO;

public class HeavyTank extends Unit {
    Game game;

    public HeavyTank(Game game) {
        name = "HeavyTank";
        sizeX = 4;
        sizeY = 2;
        health = sizeX * sizeY;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/src/res/sprites/heavyTank.png"));
            uTool.scaleImage(image, game.tileSize, game.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
