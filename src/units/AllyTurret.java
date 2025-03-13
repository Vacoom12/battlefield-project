package src.units;

import src.main.Game;

import java.io.IOException;
import javax.imageio.ImageIO;

public class AllyTurret extends Unit {
    Game game;

    public AllyTurret(Game game, String imageName) {
        name = "AllyTurret";
        sizeX = 2;
        sizeY = 2;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/src/res/sprites/" + imageName + ".png"));
            uTool.scaleImage(image, game.tileSize, game.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
