package Data;

import main.GamePanel;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveLoad {
    GamePanel gp;


    public SaveLoad( GamePanel gp)
    {
        this.gp =gp;
    }

    //salvam datele jocului(viata, banutii, nivelul, gloantele..) intr-un fisier text
    public void save() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));

            DataStorage ds = new DataStorage();

            ds.level = gp.level;
            ds.life = gp.player.life;
            ds.maxLife = gp.player.maxLife;
            ds.mana = gp.player.mana;
            ds.maxMana = gp.player.maxMana;
            ds.coins = gp.player.coins;
            ds.currentMap = gp.currentMap;

            //write
            oos.writeObject(ds);

        }
        catch (Exception e)
        {
            System.out.println("Save Exception!");
        }
    }

    //incarcamdatele jocului(viata, banutii, nivelul, gloantele..) intr-un fisier text
    // ca sa le putem folosi ulterior pt revenire in joc
    public void load()
    {
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));

            //read the dataStorage object;
            DataStorage ds =(DataStorage)ois.readObject();

            gp.level = ds.level;
            gp.player.life = ds.life;
            gp.player.maxLife = ds.maxLife;
            gp.player.mana = ds.mana;
            gp.player.maxMana = ds.maxMana;
            gp.player.coins = ds.coins;
            gp.currentMap = ds.currentMap;
        }
        catch (Exception e)
        {
            System.out.println("Load exception!");
        }
    }


}
