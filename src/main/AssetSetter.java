package src.main;

import java.util.ArrayList;

import src.units.*;

public class AssetSetter {
    Game game;
    ArrayList<int[]> occupiedTiles = new ArrayList<>();

    public AssetSetter(Game game) {
        this.game = game;
    }

    public int RandomPosX(int sizeX) {
         //12-26
        return (int) (Math.random() * (15 - sizeX)) + 12;
    }

    public int RandomPosY(int sizeY) {
         //3-12
         return (int) (Math.random() * (10 - sizeY)) + 3;
    }

    public boolean isOverlap(int newX, int newY, int width, int height) {
        for (int[] occupied : occupiedTiles) {
            int ox = occupied[0], oy = occupied[1], ow = occupied[2], oh = occupied[3];

            // Check if new unit overlaps with an existing one
            if (newX < ox + ow * game.tileSize &&
                newX + width * game.tileSize > ox &&
                newY < oy + oh * game.tileSize &&
                newY + height * game.tileSize > oy) {
                return true; // Overlapping detected
            }
        }
        return false;
    }

    public void placeUnit(Unit unit, int sizeX, int sizeY) {
        int x, y;

        do {
            x = RandomPosX(sizeX) * game.tileSize;
            y = RandomPosY(sizeY) * game.tileSize;
        } while (isOverlap(x, y, sizeX, sizeY));

        unit.x = x;
        unit.y = y;
        System.out.println("x: " + x / game.tileSize + " y: " + y / game.tileSize);
        occupiedTiles.add(new int[]{x, y, sizeX, sizeY}); // Store the occupied area
    }

    public void setObject1() {
        game.obj[0] = new Soldier(game);
        placeUnit(game.obj[0], game.obj[0].sizeX, game.obj[0].sizeY);

        game.obj[1] = new Soldier(game);
        placeUnit(game.obj[1], game.obj[1].sizeX, game.obj[1].sizeY);

        game.obj[2] = new Soldier(game);
        placeUnit(game.obj[2], game.obj[2].sizeX, game.obj[2].sizeY);

        game.obj[3] = new Turret(game);
        placeUnit(game.obj[3], game.obj[3].sizeX, game.obj[3].sizeY);

        game.obj[4] = new Turret(game);
        placeUnit(game.obj[4], game.obj[4].sizeX, game.obj[4].sizeY);

        game.obj[5] = new Tank(game);
        placeUnit(game.obj[5], game.obj[5].sizeX, game.obj[5].sizeY);

        game.obj[6] = new HeavyTank(game);
        placeUnit(game.obj[6], game.obj[6].sizeX, game.obj[6].sizeY);
    }

    // public void setObject () {
    //     game.obj[0] = new Soldier(game);
    //     game.obj[0].x = 13 * game.tileSize;
    //     game.obj[0].y = 9 * game.tileSize; 

    //     game.obj[1] = new Turret(game);
    //     game.obj[1].x = 15 * game.tileSize;
    //     game.obj[1].y = 8 * game.tileSize; 

    //     game.obj[2] = new Tank(game);
    //     game.obj[2].x = 18 * game.tileSize;
    //     game.obj[2].y = 8 * game.tileSize; 

    //     game.obj[3] = new HeavyTank(game);
    //     game.obj[3].x = 22 * game.tileSize;
    //     game.obj[3].y = 8 * game.tileSize; 
    // }

    // public void setObject1 () {
    //     game.obj[0] = new Soldier(game);
    //     game.obj[0].x = RandomPosX() * game.tileSize;
    //     game.obj[0].y = RandomPosY() * game.tileSize; 

    //     game.obj[1] = new Soldier(game);
    //     game.obj[1].x = RandomPosX() * game.tileSize;
    //     game.obj[1].y = RandomPosY() * game.tileSize; 

    //     game.obj[2] = new Soldier(game);
    //     game.obj[2].x = RandomPosX() * game.tileSize;
    //     game.obj[2].y = RandomPosY() * game.tileSize; 

    //     game.obj[3] = new Turret(game);
    //     game.obj[3].x = RandomPosX() * game.tileSize;
    //     game.obj[3].y = RandomPosY() * game.tileSize; 

    //     game.obj[4] = new Turret(game);
    //     game.obj[4].x = RandomPosX() * game.tileSize;
    //     game.obj[4].y = RandomPosY() * game.tileSize; 

    //     game.obj[5] = new Tank(game);
    //     game.obj[5].x = RandomPosX() * game.tileSize;
    //     game.obj[5].y = RandomPosY() * game.tileSize; 

    //     game.obj[6] = new HeavyTank(game);
    //     game.obj[6].x = RandomPosX() * game.tileSize;
    //     game.obj[6].y = RandomPosY() * game.tileSize; 
    // }
}
