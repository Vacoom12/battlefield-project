package src.units;

import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class Soldier extends Unit {
    public Soldier() {
        name = "Soldier";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/asset/sprites/soldier.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public void getImage() {
    // //     try {
    // //         image = ImageIO.read(getClass().getResourceAsStream("/res/sprites/soldier.png"));
    // //     } catch (IOException e) {
    // //         e.printStackTrace();
    // //     }
    // // }
    // }
}
