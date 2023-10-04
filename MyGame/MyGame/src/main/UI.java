package main;

import Entity.Entity;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Objects;

import static java.awt.SystemColor.text;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_70B;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public boolean gameFinished = false;
    public boolean messageOn = false;
    public String message = "";
    public int commandNum = 0;


    public BufferedImage heart_full, heart_half, heart_blank;
    public BufferedImage crystal_full, crystal_blank;


    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.BOLD, 40);
        arial_70B = new Font("Arial", Font.BOLD, 70);

        SuperObject heart = new OBJ_Heart(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;
        Entity crystal = new OBJ_ManaCrystal(gp);
        crystal_full = crystal.image;
        crystal_blank = crystal.image2;

    }


    //construim interfata jocului
    // afisam pe ecran viata, nivelul... in functie de Starea jocului
    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        //Title State
        if (gp.gameState == gp.titleState)
        {
                drawPlayerLife();
                drawTitleScreen();
        }

        // Pause State
        if(gp.gameState == gp.pauseState)
        {
                drawPlayerLife();
                drawPauseScreen();
        }
        //Game Over State
        if(gp.gameState == gp.gameOverState)
        {
            drawGameOverScreen();
            g2.dispose();

        }
        if (gameFinished) {

            String text;

            int lengthText;


            text = "Ai câștigat!";
            //returneaza lungimea sirului
            lengthText = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();


            int x = gp.screenWidth[gp.currentMap] / 2 - lengthText / 2;
            int y = gp.screenHeight[gp.currentMap] / 2 - (gp.tileSize * 3);
            g2.drawString(text, x, y);

            g2.setFont(arial_70B);
            g2.setColor(Color.yellow);
            g2.setFont(arial_40);
            g2.setColor(Color.white);


            text = "Felicitări!";
            //returneaza lungimea sirului
            lengthText = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth[gp.currentMap] / 2 - lengthText / 2;
            y = gp.screenHeight[gp.currentMap] / 2 - (gp.tileSize * 2);
            g2.drawString(text, x, y);


//            gp.gameThread = null;

        } else if (gp.gameState != gp.titleState) {
            {
                drawPlayerLife();
                g2.setFont(arial_40);
                g2.setColor(Color.white);
                g2.drawString("Coins: " + gp.player.coins, gp.tileSize * 4, 40);

                playTime += (double) 1 / 60;
                g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize * 10, 40);

                g2.setFont(arial_40);
                g2.setColor(Color.white);
                g2.drawString("Level " +(gp.currentMap+1), gp.tileSize * 7, 40);

                //message

                if (messageOn) {
                    g2.drawString(message, gp.tileSize * 5, gp.tileSize * 5);
                }
            }
        }
    }

    //construirea meniului principal, cu cele 3 optiuni 1-NEW GAME 2-LOAD GAME 3-EXIT
    //inserare imagine de inceput
    public void drawTitleScreen() {

        g2.setColor(new Color(70, 120, 80));
        g2.fillRect(0, 0, gp.screenWidth[gp.currentMap], gp.screenHeight[gp.currentMap]);

        //title name
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80F));
        String text = "În inima Regatului";
        int x = getXforCenteredText(text);
        int y = gp.tileSize * 2;

        //umbra
        g2.setColor(Color.black);
        g2.drawString(text, x + 8, y + 8);

        //MAIN COLOR
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        //imagine pornire
        x = gp.screenWidth[gp.currentMap]/8 ;
        y += gp.tileSize -30;
        g2.drawImage(gp.player.img_pornire, x, y, gp.tileSize * 11, gp.tileSize * 6, null);

        //menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

        text = " NEW GAME";
        x = getXforCenteredText(text);
        y += gp.tileSize*3.75;
        g2.drawString(text,x,y);
        if(commandNum == 0)
        {
            g2.drawString(">",x-gp.tileSize,y);
        }

        text = " LOAD GAME";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text,x,y);
        if(commandNum == 1)
        {
            g2.drawString(">",x-gp.tileSize,y);
        }

        text = " QUIT";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text,x,y);
        if(commandNum == 2)
        {
            g2.drawString(">",x-gp.tileSize,y);
        }
    }

    //setam ca textul sa fie centrat pe fereastra
    public int getXforCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth[gp.currentMap] / 2 - length  /2;
        return x;
    }

    //afisam interfata in cazul in care starea jocului este de pauza
    public void drawPauseScreen()
    {
        g2.setFont(g2.getFont().deriveFont(Font.ITALIC,80F));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight[gp.currentMap]/2;
        g2.drawString(text,x,y);
    }
    //afisam interfata in cazul in care starea jocului este de GAME OVER
    public void drawGameOverScreen()
    {
        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0,0,gp.screenWidth[gp.currentMap], gp.screenHeight[gp.currentMap]);

        String text = "Game Over";
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 110F));

        int x= getXforCenteredText(text);
        int y = gp.tileSize*4;
        //umbra
        g2.setColor(Color.black);
        g2.drawString(text, x,y);

        //main
        g2.setColor(Color.white);
        g2.drawString(text,x-4,y-4);

        //Retry
        g2.setFont(g2.getFont().deriveFont(50F));
        text = "Retry";
        x = getXforCenteredText(text);
        y += gp.tileSize*4;
        g2.drawString(text,x,y);
        if(commandNum ==0)
        {
            g2.drawString(">",x-40,y);
        }

        //afara din joc
        text = "Quit";
        x= getXforCenteredText(text);
        y +=55;
        g2.drawString(text,x,y);
        if(commandNum ==1 )
        {
            g2.drawString(">",x-40,y);
        }
    }

    //afisam Viata player-ului cat si gloantele sale
    //se actualizeaza in functie de cum decurge jocul
    public void drawPlayerLife()
    {
        //gp.player.life = 4;
        int x =gp.tileSize/5;
        int y= gp.tileSize/15;
        int i=0;

        //draw MAX LIFE
        while(i < gp.player.maxLife/2)
        {
            g2.drawImage(heart_blank,x ,y,null);
            i++;
            x+= gp.tileSize;
        }

        //reset
         x = gp.tileSize/5;
         y = gp.tileSize/15;
         i = 0;

         //draw current life
        while(i < gp.player.life)
        {
            g2.drawImage(heart_half,x,y,null);
            i++;
            if(i < gp.player.life)
            {
                g2.drawImage(heart_full,x,y,null);
            }
            i++;
            x+= gp.tileSize;
        }

        if(gp.player.life == 0)
        {
            gp.gameState = gp.gameOverState;
        }

        //draw max mana
        x = gp.tileSize /2 - 32;
        y = gp.tileSize ;
        i = 0;
        while( i< gp.player.maxMana)
        {
            g2.drawImage(crystal_blank, x, y, null);
            i++;
            x += 35;

        }

        //draw mana
        x = gp.tileSize /2 -32;
        y = gp.tileSize ;
        i =0;
        while(i < gp.player.mana)
        {
            g2.drawImage(crystal_full,x,y, null);
            i++;
            x+=35;
        }

    }
}
    
