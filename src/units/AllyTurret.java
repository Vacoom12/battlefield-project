package src.units;

import src.main.Game;

import java.io.IOException;
import javax.imageio.ImageIO;

public class AllyTurret extends Unit {
    Game game;

    public AllyTurret(Game game) {
        name = "AllyTurret";
        fireStatus = (game.keyH.canShoot) ? "ally_turret" : "ally_turret_fire";
        sizeX = 2;
        sizeY = 2;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/src/res/sprites/" + fireStatus + ".png"));
            uTool.scaleImage(image, game.tileSize, game.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
