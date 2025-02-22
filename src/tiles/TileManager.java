package src.tiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

import src.Game;

public class TileManager {
    Game game;
    public Tile[] tile;
    public int mapTilePos[][];

    public TileManager(Game game) {
        this.game = game;

        tile = new Tile[10];
        mapTilePos = new int[game.maxScreenCol][game.maxScreenRow];
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/asset/tiles/grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/asset/tiles/sand.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/asset/tiles/water.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("/asset/maps/battlefield.txt");
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

            g2.drawImage(tile[tileNum].image, worldX, worldY, game.tileSize, game.tileSize, null); 
            worldCol++;
                
            if (worldCol == game.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
