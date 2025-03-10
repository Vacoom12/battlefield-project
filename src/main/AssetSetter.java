package src.main;

import java.util.ArrayList;

import src.units.*;    

public class AssetSetter {
    Game game;
    public ArrayList<int[]> occupiedUnits = new ArrayList<>();

    public AssetSetter(Game game) {
        this.game = game;
    }

    public int RandomPosX(int sizeX) {
         //12-26
        return (int) (Math.random() * (16 - sizeX)) + 12;
    }

    public int RandomPosY(int sizeY) {
         //3-12
         return (int) (Math.random() * (10 - sizeY)) + 3;
    }

    public boolean isOverlap(int newX, int newY, int width, int height) {
        for (int[] occupied : occupiedUnits) {
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
        occupiedUnits.add(new int[]{x, y, sizeX, sizeY, unit.health}); // Store the occupied unit infos
    }

    public void setObject1() {
        game.totalUnit = 7;

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
}
