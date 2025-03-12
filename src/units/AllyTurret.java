package src.units;

import src.main.Game;

import java.io.IOException;
import javax.imageio.ImageIO;

public class AllyTurret extends Unit {
    Game game;

    public AllyTurret(Game game) {
        name = "AllyTurret";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/src/res/sprites/ally_turret.png"));
            uTool.scaleImage(image, game.tileSize, game.tileSize);
            fireImage = ImageIO.read(getClass().getResourceAsStream("/src/res/sprites/ally_turret_fire.png"));
            uTool.scaleImage(image, game.tileSize, game.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
