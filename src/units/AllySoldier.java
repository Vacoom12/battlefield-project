package src.units;

import src.main.Game;

import java.io.IOException;
import javax.imageio.ImageIO;

public class AllySoldier extends Unit {
    Game game;

    public AllySoldier(Game game) {
        name = "AllySoldier";
        sizeX = 1;
        sizeY = 1;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/src/res/sprites/ally_soldier.png"));
            uTool.scaleImage(image, game.tileSize, game.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
