package main;

import Data.SaveLoad;
import Entity.Entity;
import Entity.Player;
import Tile.TileManager;
import object.SuperObject;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;


public class GamePanel extends JPanel implements Runnable{

    // screen settings
    final int originalTileSize = 16;
    final int scale = 4;

    public final int tileSize = originalTileSize * scale;  //64*64

    //world settings
    public int []maxScreenCol = new int[] {14, 16,22};
    public int []maxScreenRow = new int[] {10, 13,16};
    public final int maxMap = 3;
    public int currentMap = 0;
    public int []screenWidth = new int[5];  // 768
    public int []screenHeight = new int[5];  // 576

    //FPS
    int FPS = 60;


    TileManager tileM = new TileManager(this);
    public KeyHandler key= new KeyHandler(this);
    Thread gameThread;

    public UI ui = new UI(this);


    //GAME STATE
    public  int gameState ;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState =2;
    public final int gameOverState =3;
    public int level;


    //entity and object
    public Player player  =Player.getInstance(this,key); // player Instantiere SINGLETON
    public SuperObject[][] obj = new SuperObject[maxMap][50];
    public Entity[][] paz = new Entity[maxMap][50];
    public Entity[][]camera = new Entity[maxMap][50];
    public EventHandler eHandler = new EventHandler(this, player);
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public ArrayList<Entity> projectileList = new ArrayList<>();
    SaveLoad saveload = new SaveLoad(this);



    //configurarea inițială a panoului de joc
    public GamePanel()
    {
        for(int i = 0; i < maxMap; i++) {
            screenWidth[i] = maxScreenCol[i] * tileSize;
            screenHeight[i] = maxScreenRow[i] * tileSize;
        }
        this.setPreferredSize(new Dimension(screenWidth[0],screenHeight[0]));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true);
    }

    public void setupGame()
    {
        gameState = titleState;
        aSetter.setObject();
        aSetter.setPaznic();
        aSetter.setCamera();

    }

    public void restart()
    {
        if(currentMap == 0) {
            player.setDefaultValues();
            aSetter.setPaznic();
            aSetter.setObject();
            aSetter.setCamera();
            player.coins = 0;
        }
        else if (currentMap ==1 || currentMap ==2 ) {
            player.setDefaultValues();
            currentMap = 0;
            player.coins = 0;
        }


    }
    public void retry()
    {
        player.setDefaultValues();
        aSetter.setPaznic();
        aSetter.setObject();
        player.coins=0;

        if(currentMap == 1) {
            player.setValuesLevel2();
            aSetter.setPaznic();
        }
        if(currentMap == 2)
        {
            player.setValuesLevel3();
            aSetter.setPaznic();
        }
    }

    //se creează un nou fir de execuție dedicat logicii jocului
    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    // game loop
    //gestionam cadrele jocului și  sincronizam actualizărie pentru a menține un joc consistent și fluid
    public void run()
    {
        double drawInterval= 1000000000/FPS; //0.016 sec
        double delta =0;

        long lastTime =System.nanoTime();
        long currentTime;

        long timer =0 ;
        int drawCount =0 ;

        while(gameThread != null)
        {

            currentTime = System.nanoTime();

            delta = delta + (currentTime - lastTime ) / drawInterval;
            timer = timer + (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1)
            {// update information such as character position
                try {
                    update();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                // draw  the screen with the updated information
                repaint();

                delta--;
                drawCount++;

            }

            if(timer >= 1000000000)
            {
                drawCount =0;
                timer =0 ;
            }
        }
    }

    //actualizam si sincronizam starea jocului
    public void update() throws SQLException {
        if(gameState == playState) {
            player.update();

            //paznic
            for (int i = 0; i < paz[1].length; i++) {
                if (paz[currentMap][i] != null) {
                     if (paz[currentMap][i].alive && !paz[currentMap][i].dying) {
                         paz[currentMap][i].update();
                     }
                    if (!paz[currentMap][i].alive) {
                        paz[currentMap][i] = null;
                    }
                }
            }

            // camera
            for (int i = 0; i < camera[1].length; i++) {
                if (camera[currentMap][i] != null) {
                    camera[currentMap][i].update();
                }
            }

            //proiectile
        for (int i = 0; i < projectileList.size(); i++)
        {
            if(projectileList.get(i) != null)
            {
                if(projectileList.get(i).alive )
                {
                    projectileList.get(i).update();
                }
                if(!projectileList.get(i).alive )
                {
                    projectileList.remove(i);
                }
            }
        }
        }

    }


    //desenam obiectele, entitatile pe ecran
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //TITLE SCREEN
        if(gameState == titleState)
        {
            ui.draw(g2);

        }
        //alte
        else {
            //tile
            tileM.draw(g2);

            //object
            for (int i = 0; i < obj[1].length; i++) {
                if (obj[currentMap][i] != null) {
                    obj[currentMap][i].draw(g2, this);
                }
            }

            //paznic
            for (int i = 0; i < paz[1].length; i++)
                if (paz[currentMap][i] != null)
                    paz[currentMap][i].draw(g2);

            //camera
            for (int i = 0; i < camera[1].length; i++)
                if (camera[currentMap][i] != null)
                    camera[currentMap][i].draw(g2);

            //pt proiectile//proiectile
            for(int i =0; i < projectileList.size(); i++)
            {
                if(projectileList.get(i) != null)
                {
                   projectileList.get(i).draw(g2);
                }
            }

            //player
            player.draw(g2);
        }
            //UI
            ui.draw(g2);
        g2.dispose();
    }
}
