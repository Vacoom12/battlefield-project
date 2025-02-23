package src;

import src.units.*;

public class AssetSetter {
    Game game;

    public AssetSetter(Game game) {
        this.game = game;
    }

    public void setObject () {
        game.obj[0] = new Soldier();
        game.obj[0].x = 15 * game.tileSize;
        game.obj[0].y = 9 * game.tileSize; 
    }
}
