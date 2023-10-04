package Data;

import main.GamePanel;

import java.io.*;
import java.sql.*;

public class SaveLoad22 {
    GamePanel gp;
    Connection c = null;
    Statement stmt = null;


    public SaveLoad22( GamePanel gp)
    {
        this.gp =gp;
    }

    public void save() {
        try {
            DataStorage ds = new DataStorage();
            ds.level = gp.level;
            ds.life = gp.player.life;
            ds.maxLife = gp.player.maxLife;
            ds.mana = gp.player.mana;
            ds.maxMana = gp.player.maxMana;
            ds.coins = gp.player.coins;
            ds.currentMap = gp.currentMap;

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:game_data.db");
            stmt = c.createStatement();
            String sql = "CREATE TABLE game_data" + "(COINS," + " LIFE, " + " MAXLIFE, " + " MAXMANA, " + " LEVEL, " + " CURRENTMAP)";
            stmt.executeUpdate(sql);
            c.setAutoCommit(false);
            String sql1 = "INSERT INTO game_data (COINS)" + "VALUES ("+ds.coins+");";
            String sql2 = "INSERT INTO game_data (LIFE)" + "VALUES ("+ds.life+");";
            String sql3 = "INSERT INTO game_data (MAXLIFE)" + "VALUES ("+ds.maxLife+");";
            String sql4 = "INSERT INTO game_data (MANA)" + "VALUES ("+ds.mana+");";
            String sql5 = "INSERT INTO game_data (MAXMANA)" + "VALUES ("+ds.maxMana+");";
            String sql6 = "INSERT INTO game_data (LEVEL)" + "VALUES ("+ds.level+");";
            String sql7 = "INSERT INTO game_data (CURRENTMAP)" + "VALUES ("+ds.currentMap+");";

            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);
            stmt.executeUpdate(sql4);
            stmt.executeUpdate(sql5);
            stmt.executeUpdate(sql6);
            stmt.executeUpdate(sql7);

            System.out.println("A intrat");

            stmt.close();
            c.commit();
            c.close();

        }
        catch (SQLException | ClassNotFoundException e)
        {
            System.out.println("Save Exception!");
        }
    }

    public void load()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:game_data.db");

            stmt = c.createStatement();

            //de aci
            String sql = "SELECT column1, column2 FROM table_name WHERE condition;";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // Extrageți datele dorite din ResultSet
                String column1Value = rs.getString("column1");
                int column2Value = rs.getInt("column2");

                //Procesează datele extrase
                System.out.println("Column1: " + column1Value + ", Column2: " + column2Value);
            }

            rs.close();
        }

        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Load exception!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
