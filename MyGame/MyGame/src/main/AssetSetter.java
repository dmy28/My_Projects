package main;

import Entity.camera_filmat;
import object.*;
import Entity.paznic;


public class AssetSetter {

    GamePanel gp;

    CloneFactory obj_maker = new CloneFactory();
    AssetSetter(GamePanel gp)
    {
        this.gp =gp;
    }

    //punem obiectele pe harta
    public void setObject()
    {//obiecte create cu PROTOTYPE
        int i=0;
        int mapNum =0;

        gp.obj[mapNum][i] = new OBJ_Key();
        OBJ_Key x = (OBJ_Key) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);//PROTOTYPE
        gp.obj[mapNum][i].worldX = 8 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
        i++;


        gp.obj[mapNum][i] = x;
        gp.obj[mapNum][i].worldX = 4 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 5 * gp.tileSize;
        i++;


        gp.obj[mapNum][i] = new OBJ_albastrDiam();
        gp.obj[mapNum][i].worldX = 11 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 5 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Key();
        x = (OBJ_Key) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);//PROTOTYPE
        gp.obj[mapNum][i].worldX = 4 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
        i++;


        gp.obj[mapNum][i] =x;
        gp.obj[mapNum][i].worldX = 5 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 2 * gp.tileSize;
        i++;


        gp.obj[mapNum][i] = new OBJ_Key();
        x = (OBJ_Key) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);//PROTOTYPE
        gp.obj[mapNum][i].worldX = 11 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 2 * gp.tileSize;
        i++;

        //mobila
        gp.obj[mapNum][i] = new OBJ_Mobila();
        OBJ_Mobila y = (OBJ_Mobila) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 2 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_MObila2();
        OBJ_MObila2 z = (OBJ_MObila2) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 4* gp.tileSize;
        gp.obj[mapNum][i].worldY = 2 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = y;
        gp.obj[mapNum][i].worldX = 5 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 5 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Mobila();
        y = (OBJ_Mobila) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 5 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = z;
        gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 8 * gp.tileSize;


        //NIVEL 2
        i =0;
        mapNum =1;
        //banuti
        gp.obj[mapNum][i] = x;
        gp.obj[mapNum][i].worldX = 2 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
        i++;

        //diamant
        gp.obj[mapNum][i] = new OBJ_galbenDiam();
        gp.obj[mapNum][i].worldX = 8 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
        i++;

        //banuti
        gp.obj[mapNum][i] = new OBJ_Key();
        x = (OBJ_Key) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);//PROTOTYPE
        gp.obj[mapNum][i].worldX = 2 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 11 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = x;
        gp.obj[mapNum][i].worldX = 11 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 11 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Key();
        x = (OBJ_Key) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);//PROTOTYPE
        gp.obj[mapNum][i].worldX = 13 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = x;
        gp.obj[mapNum][i].worldX = 13 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 5 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Key();
        x = (OBJ_Key) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);//PROTOTYPE
        gp.obj[mapNum][i].worldX = 4 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 5 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = x;
        gp.obj[mapNum][i].worldX = 12* gp.tileSize;
        gp.obj[mapNum][i].worldY = 2 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Key();
        x = (OBJ_Key) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);//PROTOTYPE
        gp.obj[mapNum][i].worldX = 5 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 2 * gp.tileSize;
        i++;

        //mobila
        gp.obj[mapNum][i] = y;
        gp.obj[mapNum][i].worldX = 8 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 2 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Mobila();
        y = (OBJ_Mobila) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 6 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 5 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] =y;
        gp.obj[mapNum][i].worldX = 6 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 5 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Mobila();
        y = (OBJ_Mobila) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 12 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = y;
        gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 11 * gp.tileSize;
        i++;

        //mobila2
        gp.obj[mapNum][i] = new OBJ_MObila2();
        z = (OBJ_MObila2) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 7 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 11 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = z;
        gp.obj[mapNum][i].worldX = 12* gp.tileSize;
        gp.obj[mapNum][i].worldY = 5 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_MObila2();
        z = (OBJ_MObila2) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 3* gp.tileSize;
        gp.obj[mapNum][i].worldY = 2 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Mobila3();
        OBJ_Mobila3 t = (OBJ_Mobila3) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 6 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Mobila();
        y = (OBJ_Mobila) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = gp.tileSize;
        gp.obj[mapNum][i].worldY = 8 * gp.tileSize;



        //NIVEL 3
        i=0;
        mapNum =2;
        gp.obj[mapNum][i] = z;
        gp.obj[mapNum][i].worldX = 2* gp.tileSize;
        gp.obj[mapNum][i].worldY = 14 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = y;
        gp.obj[mapNum][i].worldX = 2* gp.tileSize;
        gp.obj[mapNum][i].worldY = 11 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = t;
        gp.obj[mapNum][i].worldX = 9* gp.tileSize;
        gp.obj[mapNum][i].worldY = 11 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_VerdeDiam();
        gp.obj[mapNum][i].worldX = 15* gp.tileSize;
        gp.obj[mapNum][i].worldY = 5 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_MObila2();
        z = (OBJ_MObila2) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 16* gp.tileSize;
        gp.obj[mapNum][i].worldY = 11 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Mobila();
        y = (OBJ_Mobila) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 11* gp.tileSize;
        gp.obj[mapNum][i].worldY = 14 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Mobila3();
        t = (OBJ_Mobila3) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 17* gp.tileSize;
        gp.obj[mapNum][i].worldY = 14 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = z;
        gp.obj[mapNum][i].worldX = 11* gp.tileSize;
        gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] =y;
        gp.obj[mapNum][i].worldX = 15* gp.tileSize;
        gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = t;
        gp.obj[mapNum][i].worldX = 3* gp.tileSize;
        gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_MObila2();
        z = (OBJ_MObila2) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 10* gp.tileSize;
        gp.obj[mapNum][i].worldY = 5 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Mobila();
        y = (OBJ_Mobila) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 2* gp.tileSize;
        gp.obj[mapNum][i].worldY = 5 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Mobila3();
        t = (OBJ_Mobila3) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 19* gp.tileSize;
        gp.obj[mapNum][i].worldY = 5 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = z;
        gp.obj[mapNum][i].worldX = 16* gp.tileSize;
        gp.obj[mapNum][i].worldY = 2 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = y;
        gp.obj[mapNum][i].worldX = 12* gp.tileSize;
        gp.obj[mapNum][i].worldY = 2 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = t;
        gp.obj[mapNum][i].worldX = 2*gp.tileSize;
        gp.obj[mapNum][i].worldY = 2 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] =x;
        gp.obj[mapNum][i].worldX = 18* gp.tileSize;
        gp.obj[mapNum][i].worldY = 2 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Key();
        x = (OBJ_Key) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 11* gp.tileSize;
        gp.obj[mapNum][i].worldY = 2 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = x;
        gp.obj[mapNum][i].worldX = gp.tileSize;
        gp.obj[mapNum][i].worldY = 2 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Key();
        x = (OBJ_Key) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 8* gp.tileSize;
        gp.obj[mapNum][i].worldY = 5 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = x;
        gp.obj[mapNum][i].worldX =  gp.tileSize;
        gp.obj[mapNum][i].worldY = 5 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Key();
        x = (OBJ_Key) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 18* gp.tileSize;
        gp.obj[mapNum][i].worldY = 5 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = x;
        gp.obj[mapNum][i].worldX = 10* gp.tileSize;
        gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Key();
        x = (OBJ_Key) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 16* gp.tileSize;
        gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = x;
        gp.obj[mapNum][i].worldX = 2* gp.tileSize;
        gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Key();
        x = (OBJ_Key) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 11* gp.tileSize;
        gp.obj[mapNum][i].worldY = 11 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = x;
        gp.obj[mapNum][i].worldX = 15* gp.tileSize;
        gp.obj[mapNum][i].worldY = 11 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Key();
        x = (OBJ_Key) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 3* gp.tileSize;
        gp.obj[mapNum][i].worldY = 11 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = x;
        gp.obj[mapNum][i].worldX = 6* gp.tileSize;
        gp.obj[mapNum][i].worldY = 11 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Key();
        x = (OBJ_Key) obj_maker.getClone((OBJ) gp.obj[mapNum][i]);
        gp.obj[mapNum][i].worldX = 10* gp.tileSize;
        gp.obj[mapNum][i].worldY = 14 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = x;
        gp.obj[mapNum][i].worldX = 15* gp.tileSize;
        gp.obj[mapNum][i].worldY = 14 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Key();
        gp.obj[mapNum][i].worldX = 3* gp.tileSize;
        gp.obj[mapNum][i].worldY = 14 * gp.tileSize;

    }

    //punem inamicii pe harta
    public void setPaznic()
    {
        int i=0;
        int mapNum =0;
        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 2;
        gp.paz[mapNum][i].y = gp.tileSize * 2;
        i++;

        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 3;
        gp.paz[mapNum][i].y = gp.tileSize * 8;
        i++;

        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 6;
        gp.paz[mapNum][i].y = gp.tileSize * 5;

        //NIVEL 2
        i =0;
        mapNum =1;
        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 9;
        gp.paz[mapNum][i].y = gp.tileSize * 11;
        i++;

        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 7;
        gp.paz[mapNum][i].y = gp.tileSize * 8;
        i++;

        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 8;
        gp.paz[mapNum][i].y = gp.tileSize * 5;
        i++;

        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 3;
        gp.paz[mapNum][i].y = gp.tileSize * 5;
        i++;

        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 3;
        gp.paz[mapNum][i].y = gp.tileSize * 2;
        i++;

        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 7;
        gp.paz[mapNum][i].y = gp.tileSize * 2;





        //NIVEL 3
        i=0;
        mapNum =2;
        i++;

        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 4;
        gp.paz[mapNum][i].y = gp.tileSize * 11;
        i++;

        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 10;
        gp.paz[mapNum][i].y = gp.tileSize * 11;
        i++;

        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 10;
        gp.paz[mapNum][i].y = gp.tileSize * 14;
        i++;

        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 5;
        gp.paz[mapNum][i].y = gp.tileSize * 8;
        i++;

        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 10;
        gp.paz[mapNum][i].y = gp.tileSize * 8;
        i++;



        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 16;
        gp.paz[mapNum][i].y = gp.tileSize * 8;
        i++;

        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 9;
        gp.paz[mapNum][i].y = gp.tileSize * 5;
        i++;

        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 4;
        gp.paz[mapNum][i].y = gp.tileSize * 5;
        i++;

        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 14;
        gp.paz[mapNum][i].y = gp.tileSize * 5;
        i++;

        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 18;
        gp.paz[mapNum][i].y = gp.tileSize * 5;
        i++;

        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 6;
        gp.paz[mapNum][i].y = gp.tileSize * 2;
        i++;

        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 13;
        gp.paz[mapNum][i].y = gp.tileSize * 2;
        i++;

        gp.paz[mapNum][i] = new paznic(gp);
        gp.paz[mapNum][i].x = gp.tileSize * 18;
        gp.paz[mapNum][i].y = gp.tileSize * 2;




    }

    //punem camerele pe harta
    public void setCamera()
    {
        int i=0;
        int mapNum =0;
        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 7 * gp.tileSize;
        gp.camera[mapNum][i].y = 7 * gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 9 * gp.tileSize;
        gp.camera[mapNum][i].y = gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 8 * gp.tileSize;
        gp.camera[mapNum][i].y = 4 * gp.tileSize;

        //NIVEL 2
        i =0;
        mapNum =1;
        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x =  gp.tileSize;
        gp.camera[mapNum][i].y = 7 * gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 6 * gp.tileSize;
        gp.camera[mapNum][i].y = 10 * gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 11* gp.tileSize;
        gp.camera[mapNum][i].y = 10 * gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 6 * gp.tileSize;
        gp.camera[mapNum][i].y = 7 * gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 11 * gp.tileSize;
        gp.camera[mapNum][i].y = 7 * gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 4 * gp.tileSize;
        gp.camera[mapNum][i].y = 4 * gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 9 * gp.tileSize;
        gp.camera[mapNum][i].y = 4 * gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 11 * gp.tileSize;
        gp.camera[mapNum][i].y = gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 3 * gp.tileSize;
        gp.camera[mapNum][i].y =  gp.tileSize;




        //NIVEL 3
        i=0;
        mapNum =2;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 12 * gp.tileSize;
        gp.camera[mapNum][i].y = 10* gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 6 * gp.tileSize;
        gp.camera[mapNum][i].y = 10 * gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 17 * gp.tileSize;
        gp.camera[mapNum][i].y = 10 * gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 14 * gp.tileSize;
        gp.camera[mapNum][i].y = 13 * gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 5 * gp.tileSize;
        gp.camera[mapNum][i].y = 7 * gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 13 * gp.tileSize;
        gp.camera[mapNum][i].y = 4 * gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 17 * gp.tileSize;
        gp.camera[mapNum][i].y = 7 * gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 5 * gp.tileSize;
        gp.camera[mapNum][i].y = 4 * gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 17 * gp.tileSize;
        gp.camera[mapNum][i].y = 4 * gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 9 * gp.tileSize;
        gp.camera[mapNum][i].y = 4 * gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 6 * gp.tileSize;
        gp.camera[mapNum][i].y =  gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 17 * gp.tileSize;
        gp.camera[mapNum][i].y =  gp.tileSize;
        i++;

        gp.camera[mapNum][i] = new camera_filmat(gp);
        gp.camera[mapNum][i].x = 10 * gp.tileSize;
        gp.camera[mapNum][i].y =gp.tileSize;

    }
}
