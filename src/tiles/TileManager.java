package src.tiles;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

import src.main.Game;
import src.main.KeyHandler;
import src.main.UtilityTool;
import src.main.AssetSetter;

public class TileManager {
    Game game;
    AssetSetter aSetter;
    KeyHandler keyH;
    public Tile[] tile;
    public int mapTilePos[][];

    public TileManager(Game game, KeyHandler keyH, AssetSetter aSetter) {
        this.game = game;
        this.keyH = keyH;
        this.aSetter = aSetter;

        tile = new Tile[10];
        mapTilePos = new int[game.maxScreenCol][game.maxScreenRow];

        getTileImage();
        loadMap();
    }

    public void getTileImage() {
        setup(0, "grass");
        setup(1, "sand");
        setup(2, "earth");
        setup(3, "tree");
    }

    public void setup(int index, String imageName) {
        UtilityTool uTool = new UtilityTool();

        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/src/res/tiles/" + imageName + ".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, game.tileSize , game.tileSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("/src/res/maps/battlefield.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < game.maxWorldCol && row < game.maxWorldRow) {
                String line = br.readLine();

                while (col < game.maxWorldCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTilePos[col][row] = num;
                    col++;
                }

                if (col == game.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < game.maxWorldCol && worldRow < game.maxWorldRow) {
            int tileNum = mapTilePos[worldCol][worldRow];
            int worldX = worldCol * game.tileSize;
            int worldY = worldRow * game.tileSize;

            g2.drawImage(tile[tileNum].image, worldX, worldY, null); 
            worldCol++;
                
            if (worldCol == game.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }

    public void update() {
        if (keyH.mouseClicked) {
            int tileX = keyH.mouseX / game.tileSize;
            int tileY = keyH.mouseY / game.tileSize;
    
            if (tileX >= 0 && tileX < game.maxWorldCol && tileY >= 0 && tileY < game.maxWorldRow && mapTilePos[tileX][tileY] == 1 && mapTilePos[tileX][tileY] != 2) {
                mapTilePos[tileX][tileY] = 2;
                int unitX, unitY;

                for (int[] arr : aSetter.occupiedUnits) {
                    unitX = arr[0] / game.tileSize;
                    unitY = arr[1] / game.tileSize;

                    if (tileX >= unitX && tileX < unitX + arr[2] &&
                        tileY >= unitY && tileY < unitY + arr[3]) {
                        arr[4]--;
                        System.out.println(arr[4]);
                        break;
                    }
                }
            }
        }

        keyH.mouseClicked = false;
    }


}
