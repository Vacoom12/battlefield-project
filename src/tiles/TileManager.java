package src.tiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

import src.main.Game;
import src.main.KeyHandler;

public class TileManager {
    Game game;
    KeyHandler keyH;
    public Tile[] tile;
    public int mapTilePos[][];

    public TileManager(Game game, KeyHandler keyH) {
        this.game = game;
        this.keyH = keyH;

        tile = new Tile[10];
        mapTilePos = new int[game.maxScreenCol][game.maxScreenRow];

        getTileImage();
        loadMap();
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/src/res/tiles/grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/src/res/tiles/sand.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/src/res/tiles/earth.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/src/res/tiles/tree.png"));
        } catch (IOException e) {
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

            g2.drawImage(tile[tileNum].image, worldX, worldY, game.tileSize, game.tileSize, null); 
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
            // System.out.println(tileX + " : " + tileY);
    
            if (tileX >= 0 && tileX < game.maxWorldCol && tileY >= 0 && tileY < game.maxWorldRow && mapTilePos[tileX][tileY] == 1) {
                mapTilePos[tileX][tileY] = 2;
            }
        }

        keyH.mouseClicked = false;
    }
}
