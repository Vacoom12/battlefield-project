package src.main;

import java.util.ArrayList;
import src.units.*;    

public class AssetSetter {
    Game game;
    public ArrayList<int[]> occupiedUnits = new ArrayList<>();
    String fireStatus = "ally_turret";

    public AssetSetter(Game game) {
        this.game = game;
    }

    public int RandomPosX(int sizeX) {
         //11-25
        return (int) (Math.random() * (16 - sizeX)) + 11;
    }

    public int RandomPosY(int sizeY) {
         //3-12
         return (int) (Math.random() * (11 - sizeY)) + 3;
    }

    public boolean isOverlap(int newX, int newY, int width, int height) {
        for (int[] occupied : occupiedUnits) {
            int ox = occupied[0], oy = occupied[1], ow = occupied[2], oh = occupied[3];

            if (newX < ox + ow * game.tileSize &&
                newX + width * game.tileSize > ox &&
                newY < oy + oh * game.tileSize &&
                newY + height * game.tileSize > oy) {
                return true; 
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
        occupiedUnits.add(new int[]{x, y, sizeX, sizeY, unit.health}); 
    }

    public void setAlly() {
        game.allyObj[0] = new AllySoldier(game);
        game.allyObj[0].x = 3 * game.tileSize;
        game.allyObj[0].y = 3 * game.tileSize;

        game.allyObj[1] = new AllySoldier(game);
        game.allyObj[1].x = 3 * game.tileSize;
        game.allyObj[1].y = 12 * game.tileSize;

        game.allyObj[2] = new AllySoldier(game);
        game.allyObj[2].x = 1 * game.tileSize;
        game.allyObj[2].y = 7 * game.tileSize;

        game.allyObj[3] = new AllySoldier(game);
        game.allyObj[3].x = 1 * game.tileSize;
        game.allyObj[3].y = 9 * game.tileSize;

        game.allyObj[4] = new AllyTurret(game);
        game.allyObj[4].x = 3 * game.tileSize;
        game.allyObj[4].y = 5 * game.tileSize;

        game.allyObj[5] = new AllyTurret(game);    
        game.allyObj[5].x = 3 * game.tileSize;
        game.allyObj[5].y = 9 * game.tileSize;
    }

    public void setEasyObj() {
        game.totalUnit = 7;
        game.ammo = 100;
    
        game.obj[0] = new Soldier(game);
        placeUnit(game.obj[0], game.obj[0].sizeX, game.obj[0].sizeY);
    
        game.obj[1] = new Soldier(game);
        placeUnit(game.obj[1], game.obj[1].sizeX, game.obj[1].sizeY);
    
        game.obj[2] = new Turret(game);
        placeUnit(game.obj[2], game.obj[2].sizeX, game.obj[2].sizeY);
    
        game.obj[3] = new Turret(game);
        placeUnit(game.obj[3], game.obj[3].sizeX, game.obj[3].sizeY);
    
        game.obj[4] = new Tank(game);
        placeUnit(game.obj[4], game.obj[4].sizeX, game.obj[4].sizeY);
    
        game.obj[5] = new Tank(game);
        placeUnit(game.obj[5], game.obj[5].sizeX, game.obj[5].sizeY);
    
        game.obj[6] = new HeavyTank(game);
        placeUnit(game.obj[6], game.obj[6].sizeX, game.obj[6].sizeY);
    }

    public void setNormalObj() {
        game.totalUnit = 8;
        game.ammo = 80;
    
        game.obj[0] = new Soldier(game);
        placeUnit(game.obj[0], game.obj[0].sizeX, game.obj[0].sizeY);
    
        game.obj[1] = new Soldier(game);
        placeUnit(game.obj[1], game.obj[1].sizeX, game.obj[1].sizeY);
    
        game.obj[2] = new Turret(game);
        placeUnit(game.obj[2], game.obj[2].sizeX, game.obj[2].sizeY);
    
        game.obj[3] = new Turret(game);
        placeUnit(game.obj[3], game.obj[3].sizeX, game.obj[3].sizeY);
    
        game.obj[4] = new Turret(game);
        placeUnit(game.obj[4], game.obj[4].sizeX, game.obj[4].sizeY);
    
        game.obj[5] = new Tank(game);
        placeUnit(game.obj[5], game.obj[5].sizeX, game.obj[5].sizeY);
    
        game.obj[6] = new Tank(game);
        placeUnit(game.obj[6], game.obj[6].sizeX, game.obj[6].sizeY);
    
        game.obj[7] = new HeavyTank(game);
        placeUnit(game.obj[7], game.obj[7].sizeX, game.obj[7].sizeY);
    }

    public void setHardObj() {
        game.totalUnit = 10;
        game.ammo = 75;
    
        game.obj[0] = new Soldier(game);
        placeUnit(game.obj[0], game.obj[0].sizeX, game.obj[0].sizeY);
    
        game.obj[1] = new Soldier(game);
        placeUnit(game.obj[1], game.obj[1].sizeX, game.obj[1].sizeY);
    
        game.obj[2] = new Soldier(game);
        placeUnit(game.obj[2], game.obj[2].sizeX, game.obj[2].sizeY);

        game.obj[3] = new Soldier(game);
        placeUnit(game.obj[3], game.obj[3].sizeX, game.obj[3].sizeY);
    
        game.obj[4] = new Turret(game);
        placeUnit(game.obj[4], game.obj[4].sizeX, game.obj[4].sizeY);
    
        game.obj[5] = new Turret(game);
        placeUnit(game.obj[5], game.obj[5].sizeX, game.obj[5].sizeY);
    
        game.obj[6] = new Tank(game);
        placeUnit(game.obj[6], game.obj[6].sizeX, game.obj[6].sizeY);
    
        game.obj[7] = new Tank(game);
        placeUnit(game.obj[7], game.obj[7].sizeX, game.obj[7].sizeY);
    
        game.obj[8] = new HeavyTank(game);
        placeUnit(game.obj[8], game.obj[8].sizeX, game.obj[8].sizeY);

        game.obj[9] = new HeavyTank(game);
        placeUnit(game.obj[9], game.obj[9].sizeX, game.obj[9].sizeY);
    }
}
