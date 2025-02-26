package src.main;

import src.units.*;

public class AssetSetter {
    Game game;

    public AssetSetter(Game game) {
        this.game = game;
    }

    public int RandomPosX() {
         // Random integer from 3 to 12
        int x = (int) (Math.random() * 15) + 12;
        return x;
    }

    public int RandomPosY() {
         // Random integer from 3 to 12
        int y = (int) (Math.random() * 10) + 3;
        return y;
    }

    public void setObject () {
        game.obj[0] = new Soldier(game);
        game.obj[0].x = 13 * game.tileSize;
        game.obj[0].y = 9 * game.tileSize; 

        game.obj[1] = new Turret(game);
        game.obj[1].x = 15 * game.tileSize;
        game.obj[1].y = 8 * game.tileSize; 

        game.obj[2] = new Tank(game);
        game.obj[2].x = 18 * game.tileSize;
        game.obj[2].y = 8 * game.tileSize; 

        game.obj[3] = new HeavyTank(game);
        game.obj[3].x = 22 * game.tileSize;
        game.obj[3].y = 8 * game.tileSize; 
    }

    public void setObject1 () {
        game.obj[0] = new Soldier(game);
        game.obj[0].x = RandomPosX() * game.tileSize;
        game.obj[0].y = RandomPosY() * game.tileSize; 

        game.obj[1] = new Turret(game);
        game.obj[1].x = RandomPosX() * game.tileSize;
        game.obj[1].y = RandomPosY() * game.tileSize; 

        game.obj[2] = new Tank(game);
        game.obj[2].x = RandomPosX() * game.tileSize;
        game.obj[2].y = RandomPosY() * game.tileSize; 

        game.obj[3] = new HeavyTank(game);
        game.obj[3].x = RandomPosX() * game.tileSize;
        game.obj[3].y = RandomPosY() * game.tileSize; 
    }
}
