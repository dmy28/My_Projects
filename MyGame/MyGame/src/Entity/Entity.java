package Entity;

import main.GamePanel;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.sql.SQLException;
import java.util.Objects;

public  class Entity
{
    public int x,y;

    GamePanel gp;


    public int speed;
    //player
    public BufferedImage left1,left2, right1, right2,up1, up2,down1, down2, attackLeft,attackRight,sta;
    //paznic
    public  BufferedImage st1,st2,dr1,dr2,stapeloc,img_pornire;
    // camera de supraveghere
    public  BufferedImage st,dr;

    //proiectile mana
    public BufferedImage image,image2,image3;

    public String direction;


    public int spriteNum =1;
    //State
    boolean attacking = false;
    public boolean alive = true;
    public boolean dying = false;
    public boolean hpBarOn = false;

    //character status
    public int maxLife;
    public int life;
    public int attack;
    public int maxMana;
    public int mana;
    public int type;// 0- player 1-npc

    public int defense;
    public int useCost;


    //COUNTER
    public int dyingCounter=0;
    public int spriteCounter =0;
    public int hpBarCounter = 0;
    public int shotAvailableCounter = 0;

    public Projectile projectile;

     public Rectangle solidArea = new Rectangle(15 , 15,48,48);
    public Rectangle attackArea = new Rectangle(0,0,0,0);


    public Rectangle cameraStg = new Rectangle(5, 35, 20, 90);
    public Rectangle cameraDrt = new Rectangle(58, 35, 20, 90);

    public boolean invincible = false;
    public int invincibleCounter = 0;

    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public boolean collision;

    public int actionLockCounter = 0;

    public void setAction()
    {

    }

    //actualizam principalele evenimente ale jocului
    // deplasarea player-ului, coliziunile dintre player si tile-uri, obiecte, si alte entitati
    public void update() throws SQLException {

        setAction();

        collisionOn = false;
        gp.cChecker.checkTile(this);
      //  gp.cChecker.checkObject(this, false);
        gp.cChecker.checkEntity(this, gp.paz);
        boolean contactPlayer = gp.cChecker.checkPlayer(this);
        if(this.type == 1 && contactPlayer)
        {
            damagePlayer(attack);
        }

        if(!collisionOn)
        {
            switch (direction)
            {
                case "up":
                    y = y - speed;
                    break;

                case "left":

                    x = x - speed;
                    break;
                case "right":

                    x = x + speed;
                    break;
            }
        }


        spriteCounter++;
        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }

            spriteCounter = 0;
        }
        if(invincible)
        {
            invincibleCounter++;
            if(invincibleCounter > 40)
            {
                invincible = false;
                invincibleCounter=0;
            }
        }
        if(shotAvailableCounter < 30)
        {
            shotAvailableCounter++;
        }
    }

    public void damageReaction()
    {

    }

    //player-ul poate sa primeasca damage de la Paznic
    public void damagePlayer(int attack)
    {
        if(!gp.player.invincible)
        {
            // putem sa dam damage
            int damage = attack - gp.player.defense;
            if(damage <0 )
            {
                damage = 0;
            }
            gp.player.life -= damage ;
            gp.player.invincible = true;
        }
    }
    // desenam player-ul si pozitiile lui
    public void draw(Graphics2D g2)
    {
        BufferedImage image = null;
        switch (direction)
        {
            case "up":
                image = stapeloc;
                break;


            case "left":
                if(spriteNum ==1 ) {
                    image = st1;
                }

                if(spriteNum == 2)
                {
                    image = st2;
                }
                break;
            case "right":
                if(spriteNum ==1 ) {
                    image = dr1;
                }

                if(spriteNum == 2)
                {
                    image = dr2;
                }
                break;
        }
        //npc HP bar
        if(type == 1 && hpBarOn) {

            double oneScale =(double)gp.tileSize/maxLife;
            double hpBarValue = oneScale*life;

            g2.setColor(new Color(35,35,35));
            g2.fillRect(x+9,y-11,gp.tileSize-18,12);

            g2.setColor(new Color(0, 111, 255));
            g2.fillRect(x+10, y - 10, (int)hpBarValue-20, 10); //gp.tileSize-20


            hpBarCounter++;

            if(hpBarCounter > 600)
            {
                hpBarCounter = 0;
                hpBarOn = false;
            }
        }


        if(invincible )
        {
            hpBarOn = true;
            hpBarCounter = 0;
            changeAlpha(g2,0.4f);
        }
        if(dying)
        {
            dyingAnimation(g2);
        }

        g2.drawImage(image,x,y,gp.tileSize, gp.tileSize, null);

       changeAlpha(g2,1f);
    }

    void dyingAnimation(Graphics2D g2)
    {
        dyingCounter++;
        int i = 5;

        if(dyingCounter <= i)
        {

            changeAlpha(g2,0f);
        }
        if(dyingCounter > i && dyingCounter <=i*2)
        {
            changeAlpha(g2,1f);

        }
        if(dyingCounter > i*2 && dyingCounter <=i*3)
        {
            changeAlpha(g2,0f);
        }
        if(dyingCounter > i*3 && dyingCounter <= i*4)
        {
            changeAlpha(g2,1f);
        }
        if(dyingCounter > i*4 && dyingCounter <=i*5)
        {
            changeAlpha(g2,0f);
        }
        if(dyingCounter > i*5 && dyingCounter <=i*6)
        {
            changeAlpha(g2,1f);
        }
        if(dyingCounter > i*6 && dyingCounter <=i*7)
        {
            changeAlpha(g2,0f);
        }
        if(dyingCounter > i*7 && dyingCounter <=i*8)
        {
            changeAlpha(g2,1f);
        }
        if(dyingCounter > i*8)
        {
            dying = false;
            alive= false;
        }
    }


    public void changeAlpha(Graphics2D g2, float alphaValue)
    {
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alphaValue));

    }

    public Entity(GamePanel gp)
    {
        this.gp = gp;
    }


}
