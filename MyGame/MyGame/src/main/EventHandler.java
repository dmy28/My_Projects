package main;

import java.awt.*;
import java.sql.SQLException;

import static main.Main.resizeWindow;
import static main.Main.win;
import Entity.Player;
import static main.Main.AddScoreDB;

public class EventHandler {

    GamePanel gp;

    public Player player;

    EventRect[][][] eventRect;


    public EventHandler(GamePanel gp, Player player)
    {
        this.gp = gp;
        this.player = player;
        eventRect = new EventRect[gp.maxMap][gp.maxScreenCol[gp.currentMap]][gp.maxScreenRow[gp.currentMap]];

        int map=0;
        int col =0;
        int row = 0;
        while(map < gp.maxMap && col < gp.maxScreenCol[gp.currentMap] && row< gp.maxScreenRow[gp.currentMap] ) {
            eventRect[map][col][row] = new EventRect();
            eventRect[map][col][row].x = 23;
            eventRect[map][col][row].y = 23;
            eventRect[map][col][row].width = 2;
            eventRect[map][col][row].height = 2;
            eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
            eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;

            col++;
            if(col == gp.maxScreenCol[gp.currentMap]){
                col= 0;
                row++;

                if(row == gp.maxScreenRow[gp.currentMap])
                {
                    row =0;
                    map++;
                }
            }
        }
    }

    // verificam evenimentele jocului ( trecerea intre nivele)
    // pentru a verifica și gestiona interacțiunile jucătorului cu diferite evenimente din joc
    public void checkEvent() throws SQLException {
        if(hit(0,5,9,"right"))
        {
            damage(gp.gameState);
        }

        // facem tranzitia catre NIVEL 2
        if(hit(0,10,5,"diamant"))
        {
            AddScoreDB(gp.player.coins);

            gp.level =2;
            teleport(1,1,11);
            gp.setPreferredSize(new Dimension(gp.screenWidth[1],gp.screenHeight[1]));
            resizeWindow(gp.screenWidth[1],gp.screenHeight[1]);
            player.setValuesLevel2();
            gp.saveload.save();

        }

        //facem tranzitia catre NIVEL 3
        if(player.coins >=15)  // restrictionam posibilitatea de a trece la nivelul 3
        {//player-ul trebuie sa adune un numar minim de banuti ca sa poata sa treaca in urmatoarea etapa a jocului
            if (hit(1, 9, 8, "diamant")) {
                AddScoreDB(gp.player.coins);

                gp.level =3;
                teleport(2, 1, 14);
                gp.setPreferredSize(new Dimension(gp.screenWidth[2], gp.screenHeight[2]));
                resizeWindow(gp.screenWidth[2], gp.screenHeight[2]);
                player.setValuesLevel3();
                gp.saveload.save();

            }
        }

    }

    //verificam dacă există o coliziune între zona solidă a jucătorului și o anumită zonă eveniment pe harta curentă
    public boolean hit(int map, int col, int row, String reqDirection)
    {
        boolean hit = false;
        if(map == gp.currentMap) {

            gp.player.solidArea.x = gp.player.x + gp.player.solidArea.x;
            gp.player.solidArea.y = gp.player.y + gp.player.solidArea.y;
            eventRect[map][col][row].x = col * gp.tileSize + eventRect[map][col][row].x;
            eventRect[map][col][row].y = row * gp.tileSize + eventRect[map][col][row].y;

            if (gp.player.solidArea.intersects(eventRect[map][col][row])) {
                if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("diamant")) {
                    hit = true;
                }
            }
            gp.player.solidArea.x = gp.player.solidAreaDefaultX;
            gp.player.solidArea.y = gp.player.solidAreaDefaultY;
            eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
            eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;

        }
        return hit;
    }
    public void damage(int gameState)
    {
        gp.gameState= gameState;
        gp.player.life --;
    }

    //functia de teleportare ne ajuta sa facem trecerea dintre nivele
    public void teleport(int map, int col, int row)
    {
        gp.currentMap = map;
        gp.player.x= gp.tileSize *col;
        gp.player.y= gp.tileSize *row;


    }
}

