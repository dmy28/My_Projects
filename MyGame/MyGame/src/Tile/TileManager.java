package Tile;

import main.GamePanel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {
    GamePanel gp;
    public tile[] tile;
   public int[][][] mapTileNum;



    public TileManager(GamePanel gp)
    {
        this.gp = gp;
        tile = new tile[20];
        getTileImage();
        mapTileNum = new int[5][][];
        for(int i = 0; i < gp.maxMap; i++)
            mapTileNum[i] = new int[gp.maxScreenCol[i]][gp.maxScreenRow[i]];

        loadMap("/maps/Map01.txt",0);
        loadMap("/maps/Map02.txt",1);
        loadMap("/maps/Map03.txt",2);


    }
    //declaram tile-urile pe cale se vom folosi pe parcursul jocului
    public void getTileImage()
    {
        try
        {   tile[0] = new tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/castleCenter.png"));

            tile[1] = new tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/StoneFloorTexture.png"));
            //coliziuni
            tile[1].collision = true;

            tile[2] = new tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/umbra.png"));

            tile[3] = new tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Objects/lift.png"));

            tile[4] = new tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Objects/Scari4.jpg"));

            tile[5] = new tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/Objects/castledoors.png"));

            tile[6] = new tile();
            tile[6].image = ImageIO.read((getClass().getResourceAsStream("/Objects/door_openMid.png")));


        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    //incarcam harta dintr-un fisier text
    public void loadMap(String filePath, int map)
    {
        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader( new InputStreamReader(is));

            int col =0;
            int row =0;

            while(col <gp.maxScreenCol[map] && row < gp.maxScreenRow[map])
            {
                String line = br.readLine();

                while(col < gp.maxScreenCol[map])
                {
                    String  numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[map][col][row]=num;
                    col++;
                }
                if(col == gp.maxScreenCol[map])
                {
                    col=0;
                    row++;
                }
            }
            br.close();
        }


        catch(Exception ignored)
        {

        }
    }
    //desenam harta
    public void draw(Graphics2D g2)
    {
        //while loop
            int col =0;
            int row =0;
            int x =0;
            int y = 0;

            while(col<gp.maxScreenCol[gp.currentMap] && row < gp.maxScreenRow[gp.currentMap])
            {
                int tileNum = mapTileNum[gp.currentMap][col][row];
                g2.drawImage(tile[tileNum].image, x, y ,  gp.tileSize, gp.tileSize ,null);
                col++;
                x = x+ gp.tileSize;
                if(col == gp.maxScreenCol[gp.currentMap])
                {
                    col =0;
                    x= 0;
                    row++;
                    y= y+ gp.tileSize;
                }
            }


    }



}
