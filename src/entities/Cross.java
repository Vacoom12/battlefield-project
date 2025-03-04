package src.entities;

import src.main.Game;

import java.io.IOException;
import javax.imageio.ImageIO;


public class Cross extends Entity{
    Game game;

    public Cross(Game game) {

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/src/res/sprites/cross.png"));
            uTool.scaleImage(image, game.tileSize, game.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
