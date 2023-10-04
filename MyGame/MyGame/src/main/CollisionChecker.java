package main;

import Entity.Entity;

import java.awt.*;
import Entity.camera_filmat;

public class CollisionChecker {

    GamePanel gp;
    UI ui;
    public CollisionChecker(GamePanel gp)
    {
        this.gp=gp;
    }

    //verificam coliziunea dintre player si tile-uri
    public void checkTile(Entity entity)
    {
        //tratam coliziunea (pers principal)
        int entityLeftWorldX = entity.x + entity.solidArea.x;
        int entityRightWorldX = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY= entity.y+ entity.solidArea.y;
        int entityBottomWorldY = entity.y + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol= entityLeftWorldX/ gp.tileSize;
        int entityRightCol= entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow= entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        switch(entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
                tileNum2 =gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow];
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)
                {
                    entity.collisionOn=true;
                }
                break;

            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityBottomRow];
                tileNum2 =gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)
                {
                    entity.collisionOn=true;
                }

                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
                tileNum2 =gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)
                {
                    entity.collisionOn=true;
                }

                break;


            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow];
                tileNum2 =gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow];
                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)
                {
                    entity.collisionOn=true;
                }

                break;
        }
    }
    // verificam coliziunea dintre player si obiecte
    public int checkObject(Entity entity, boolean player)
    {
        int index = 99999;
        //verificam  daca jucatorul interactioneaza cu obiectele
        for (int i = 0; i < gp.obj[1].length; ++i)
        {
            if(gp.obj[gp.currentMap][i] != null)
            {
                // get entity's solid area position
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;

                // get the object's solid area position
                gp.obj[gp.currentMap][i].solidArea.x = gp.obj[gp.currentMap][i].worldX + gp.obj[gp.currentMap][i].solidArea.x;
                gp.obj[gp.currentMap][i].solidArea.y = gp.obj[gp.currentMap][i].worldY + gp.obj[gp.currentMap][i].solidArea.y;

                switch(entity.direction)
                {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea))
                        {

                            if (gp.obj[gp.currentMap][i].collision )
                            {
                             entity.collisionOn = true;
                            }
                            if(player)
                            {
                                index = i;

                            }



                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea))
                    {
                        if (gp.obj[gp.currentMap][i].collision )
                        {
                            entity.collisionOn = true;
                        }
                        if(player )
                        {
                            index = i;

                        }

                    }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea))
                        {

                            if (gp.obj[gp.currentMap][i].collision )
                            {
                                entity.collisionOn = true;
                            }
                            if(player )
                            {
                                index = i;

                            }

                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea))
                        {
                            if (gp.obj[gp.currentMap][i].collision )
                            {
                                entity.collisionOn = true;
                            }
                            if(player )
                            {
                                index = i;
                            }
                        }
                        break;
                }

            }
            entity.solidArea.x = entity.solidAreaDefaultX;
            entity.solidArea.y = entity.solidAreaDefaultY;
            if(  gp.obj[gp.currentMap][i] != null) {
                gp.obj[gp.currentMap][i].solidArea.x = gp.obj[gp.currentMap][i].solidAreaDefaultX;
                gp.obj[gp.currentMap][i].solidArea.y = gp.obj[gp.currentMap][i].solidAreaDefaultY;
            }
        }

        return index;

    }

    //verificam coliziunea dintre player si paznic
    public int checkEntity(Entity entity, Entity [][] target)
    {
        int index = 99999;
        for (int i = 0; i < target[gp.currentMap].length; ++i)
        {
            if(target[gp.currentMap][i] != null)
            {
                if(target[gp.currentMap][i].solidArea.x != entity.solidArea.x && target[gp.currentMap][i].solidArea.y != entity.solidArea.y) {
                    // get entity's solid area position
                    entity.solidArea.x = entity.x + entity.solidArea.x;
                    entity.solidArea.y = entity.y + entity.solidArea.y;

                    // get the object's solid area position
                    target[gp.currentMap][i].solidArea.x = target[gp.currentMap][i].x + target[gp.currentMap][i].solidArea.width;
                    target[gp.currentMap][i].solidArea.y = target[gp.currentMap][i].y + target[gp.currentMap][i].solidArea.height;

                    switch (entity.direction) {
                        case "up":
                            entity.solidArea.y -= entity.speed;
                            if (entity.solidArea.intersects(target[gp.currentMap][i].solidArea)) {
                                entity.collisionOn = true;
                                index = i;

                            }
                            break;
                        case "down":
                            entity.solidArea.y += entity.speed;
                            if (entity.solidArea.intersects(target[gp.currentMap][i].solidArea)) {
                                entity.collisionOn = true;
                                index = i;

                            }
                            break;
                        case "left":
                            entity.solidArea.x -= entity.speed;
                            if (entity.solidArea.intersects(target[gp.currentMap][i].solidArea)) {
                                entity.collisionOn = true;
                                index = i;

                            }
                            break;
                        case "right":
                            entity.solidArea.x += entity.speed;
                            if (entity.solidArea.intersects(target[gp.currentMap][i].solidArea)) {
                                entity.collisionOn = true;
                                index = i;

                            }
                            break;
                    }

                }
            }
            entity.solidArea.x = entity.solidAreaDefaultX;
            entity.solidArea.y = entity.solidAreaDefaultY;


            if (target[gp.currentMap][i] != null) {
                target[gp.currentMap][i].solidArea.x = target[gp.currentMap][i].solidAreaDefaultX;
                target[gp.currentMap][i].solidArea.y = target[gp.currentMap][i].solidAreaDefaultY;
            }

        }

        return index;

    }
    //verificam coliziunea dintre paznic si player
    public boolean checkPlayer(Entity entity)
    {

        boolean contactPlayer = false;
        // get entity's solid area position
        entity.solidArea.x = entity.x + entity.solidArea.x;
        entity.solidArea.y = entity.y + entity.solidArea.y;

        // get the object's solid area position
        gp.player.solidArea.x = gp.player.x + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.y + gp.player.solidArea.y;

        switch(entity.direction)
        {
            case "up":
                entity.solidArea.y -= entity.speed;

                break;
            case "down":
                entity.solidArea.y += entity.speed;

                break;
            case "left":
                entity.solidArea.x -= entity.speed;

                break;
            case "right":
                entity.solidArea.x += entity.speed;

                break;
        }

        if(entity.solidArea.intersects(gp.player.solidArea))
        {
            entity.collisionOn = true;
            contactPlayer =true;
        }
    entity.solidArea.x = entity.solidAreaDefaultX;
    entity.solidArea.y = entity.solidAreaDefaultY;
           if (gp.player != null) {
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
    }

           return  contactPlayer;
    }

    // verificam coliziunea dintre player si camera de filmat
    public int checkCamera(Entity entity, Entity [][] target)
    {
        int index = 99999;


        for (int i = 0; i < target[1].length; ++i)
        {
            if(target[gp.currentMap][i] != null)
            {
                // get entity's solid area position
                entity.solidArea.x = entity.x  + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;

                // get the object's solid area position
                target[gp.currentMap][i].cameraStg.x = target[gp.currentMap][i].x + target[gp.currentMap][i].cameraStg.x;
                target[gp.currentMap][i].cameraStg.y = target[gp.currentMap][i].y + target[gp.currentMap][i].cameraStg.y;

                target[gp.currentMap][i].cameraDrt.x = target[gp.currentMap][i].x + target[gp.currentMap][i].cameraDrt.x + 60;
                target[gp.currentMap][i].cameraDrt.y = target[gp.currentMap][i].y + target[gp.currentMap][i].cameraDrt.y;

                switch(entity.direction)
                {
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(target[gp.currentMap][i].cameraStg) && target[gp.currentMap][i].direction.equals("left"))
                        {
                            entity.collisionOn = true;
                            index=i;
                            gp.gameState = gp.gameOverState;



                        }
                        if(entity.solidArea.intersects(target[gp.currentMap][i].cameraDrt) && target[gp.currentMap][i].direction.equals("right"))
                        {
                            entity.collisionOn = true;
                            index=i;
                            gp.gameState = gp.gameOverState;


                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(target[gp.currentMap][i].cameraStg) && target[gp.currentMap][i].direction.equals("left"))
                        {
                            entity.collisionOn = true;
                            index=i;
                            gp.gameState = gp.gameOverState;

                        }
                        if(entity.solidArea.intersects(target[gp.currentMap][i].cameraDrt) && target[gp.currentMap][i].direction.equals("right"))
                        {
                            entity.collisionOn = true;
                            index=i;
                            gp.gameState = gp.gameOverState;

                        }
                        break;
                }
                target[gp.currentMap][i].cameraStg.x = target[gp.currentMap][i].x - target[gp.currentMap][i].cameraStg.x+120;
                target[gp.currentMap][i].cameraStg.y = target[gp.currentMap][i].y - target[gp.currentMap][i].cameraStg.y;

                target[gp.currentMap][i].cameraDrt.x = target[gp.currentMap][i].x - target[gp.currentMap][i].cameraDrt.x;
                target[gp.currentMap][i].cameraDrt.y = target[gp.currentMap][i].y - target[gp.currentMap][i].cameraDrt.y;



            }
            entity.solidArea.x = entity.solidAreaDefaultX;
            entity.solidArea.y = entity.solidAreaDefaultY;


            if (target[gp.currentMap][i] != null) {
                target[gp.currentMap][i].solidArea.x = target[gp.currentMap][i].solidAreaDefaultX;
                target[gp.currentMap][i].solidArea.y = target[gp.currentMap][i].solidAreaDefaultY;
            }

        }
        return index;
    }

    //aceasta functie ne ajuta sa elaboram functia de teleportare
    public boolean simple_collision(Entity e, int x, int y)
    {
        Rectangle r = new Rectangle(x, y, 64, 64);
        Rectangle p = new Rectangle(e.x, e.y, 64, 64);
        return r.intersects(p);
    }

    //verificam coliziunea dintre sabia player-ului si inamic
    public int sword_collision()
    {
        Rectangle sabie = null;
        switch (gp.player.direction)
        {
            case "attackRight":
                sabie = new Rectangle(gp.player.x + gp.player.solidArea.x, gp.player.y + gp.player.solidArea.y, gp.player.attackArea.width, gp.player.attackArea.height); break;
            case "attackLeft":
                sabie = new Rectangle(gp.player.x - gp.player.solidArea.x, gp.player.y - gp.player.solidArea.y, gp.player.attackArea.width, gp.player.attackArea.height); break;
            default: sabie = new Rectangle(0, 0, 1, 1);
        }

        int index = 99999;
        Rectangle t = null;
        for(int i = 0; i < gp.paz[1].length; i++) {
            if(gp.paz[gp.currentMap][i] != null) {
                t = new Rectangle(gp.paz[gp.currentMap][i].x + gp.paz[gp.currentMap][i].solidArea.x, gp.paz[gp.currentMap][i].y + gp.paz[gp.currentMap][i].solidArea.y, gp.paz[gp.currentMap][i].solidArea.width, gp.paz[gp.currentMap][i].solidArea.height);
                if (sabie.intersects(t)) {
                    index = i;
                }
            }
        }
        return index;
    }
}
