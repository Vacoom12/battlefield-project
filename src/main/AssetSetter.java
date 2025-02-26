package src.main;

import src.units.*;

public class AssetSetter {
    Game game;
    int posX, posY;

    public AssetSetter(Game game) {
        this.game = game;
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
        game.obj[0].x = 13 * game.tileSize;
        game.obj[0].y = 9 * game.tileSize; 

        game.obj[1] = new Turret(game);
        game.obj[1].x = 15 * game.tileSize;
        game.obj[1].y = 8 * game.tileSize; 

        game.obj[2] = new Tank(game);
        game.obj[2].x = 18 * game.tileSize;
        game.obj[2].y = 8 * game.tileSize; 

        game.obj[3] = new HeavyTank(game);
        game.obj[3].x = 21 * game.tileSize;
        game.obj[3].y = 8 * game.tileSize; 
    }

    
}
