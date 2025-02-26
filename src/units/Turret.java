package src.units;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Turret extends Unit {
    public Turret() {
        name = "Turret";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/src/res/sprites/turret.png"));
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
