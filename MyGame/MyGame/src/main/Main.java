package main;

import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static JFrame win;

    public static void main(String[] args)
    {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("În inima Regatului");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        win = window;

        gamePanel.setupGame();
        gamePanel.startGameThread();


    }

    //stocare in baza de date
    public static void AddScoreDB(int s) throws SQLException {
        Connection c = null;
        Statement stmt = null;
        try {//"(May2019," + " May2018, " + " Change, " + " ProgrammingLanguage, " + " Ratings)"
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:In_inima_Regatului.db");
            stmt = c.createStatement();
           // String sql = "CREATE TABLE In_inima_Regatului" + "(COINS)";
           // stmt.executeUpdate(sql);
            c.setAutoCommit(false);
            String sql1 = "INSERT INTO In_inima_Regatului (COINS)" + "VALUES ("+s+");";

            stmt.executeUpdate(sql1);


            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

    //actualizam fereastra pentru nivelele 2 si 3 care necesita o fereastra mai mare
    public static void resizeWindow(int x, int y) {
        win.setSize(x, y);
    }

}