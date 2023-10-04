package Entity;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;
import object.OBJ_Fireball;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class Player extends Entity{

    GamePanel gp;

    KeyHandler key;

    public static Player instance;  //SINGLETON
    public int coins = 0;

    public Player(GamePanel gp, KeyHandler key)
    {
        super(gp);
        this.gp = gp;
        this.key= key;

        attackArea.width = 40;
        attackArea.height = 70;


        solidArea = new Rectangle();
        solidArea.x = 35;
        solidArea.y = 0;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.height=64;
        solidArea.width = 25;


        setDefaultValues();
        getPlayerImage();
    }

    //SINGLETON instantiere
    public static Player getInstance(GamePanel gp, KeyHandler keyh)
    {
        synchronized (Player.class){
            if(instance == null)
            {
                instance = new Player(gp,keyh);
            }
        }
        return  instance;
    }

    //declaram principalele Sprite-uri ale player-ului
    public void getPlayerImage()
    {
        try {
             left1= ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/Player/La_st11.png"))));
             left2= ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/Player/St1.png"))));
             right1= ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/Player/La_dr1.png"))));
             right2= ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/Player/La_dr2.png"))));
             up1= ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/Player/Cu_spatele.png"))));
             up2= ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/Player/Cu_spatele2.png"))));
             down1= ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/Player/Cu_fata1.png"))));
             down2= ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/Player/Cu_fata2.png"))));
             attackLeft= ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/Player/St1_ataca.png"))));
             attackRight= ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/Player/La_dr2_ataca.png"))));
             sta= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Pe_loc.png")));
             img_pornire=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/Imagine Pornire.png")));

        }  catch(IOException e)
            {
                e.printStackTrace();
            }

    }


    //setam valorile player-ului in mod implicit
    public void setDefaultValues()
    {
        x = 100;
        y = 510;


        speed =2;
        direction= "down";

        //player status
        maxLife = 6;
        maxMana = 8;
        projectile = new OBJ_Fireball(gp);

        //restore life and mana
        life = maxLife;
        mana = maxMana;
        invincible = false;
        gp.level = 1;


    }
    public void setValuesLevel2()
    {
        x=80;
        y=705;

        //player status
        maxLife = 6;
        maxMana = 12;
        projectile = new OBJ_Fireball(gp);

        //restore life and mana
        life = maxLife;
        mana = maxMana;
        invincible = false;
    }
    public void setValuesLevel3()
    {
        x=80;
        y=897;

        //player status
        maxLife = 8;
        maxMana = 18;
        projectile = new OBJ_Fireball(gp);

        //restore life and mana
        life = maxLife;
        mana = maxMana;
        invincible = false;
    }

    //functie pt teleportarea player-ului in harta de joc (lift)
    public void teleport(int x1, int y1, int x2, int y2)
    {
        //764 510 / 122
        if(gp.cChecker.simple_collision(this, x1, y1)) {
            x = x2;
            y = y2;
        }

    }

    //actualizam principalele evenimente ale jocului
    // deplasarea player-ului, coliziunile dintre player si tile-uri, obiecte, si alte entitati
    // caracteristica player-ului de a arunca cu gloante/ proiectile
    public void update() throws SQLException {
        if(attacking )
        {
            attacking();
        }

        else if(key.upPressed || key.rightPressed  || key.leftPressed || key.downPressed) {


            if (key.upPressed) {
                direction = "up";


            } else if (key.downPressed) {
                direction = "down";

            } else if (key.leftPressed) {
                direction = "left";


            } else if (key.rightPressed) {
                direction = "right";

            }

            if(key.spacePressed && key.rightPressed){

                direction = "attackRight";
                //x = x + speed;
            }
            else if (key.spacePressed && key.leftPressed ) {
                direction = "attackLeft";
                // x = x + speed;
            }



            // verif tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //check object collision
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            //verif paznic coliziunea
            int pazIndex = gp.cChecker.checkEntity(this,gp.paz);
            interactPaznic(pazIndex);

            //verif paznic coliziunea
            int pazIndex2 = gp.cChecker.checkEntity(this,gp.paz);
            contactPaznic(pazIndex2);

            //verif camera coliziunea
            int camIndex = gp.cChecker.checkCamera(this,gp.camera);
            interactCamera(camIndex);

            //check event
            gp.eHandler.checkEvent();

            //teleport
            if(gp.currentMap == 0)
                teleport(825,510,764,122);

            if(gp.currentMap == 1)
                teleport(925,740,900,125);

            if(gp.currentMap == 2) {
                teleport(560, 510, 560, 897);
                teleport(1264,897,1264, 130);
            }


            // coliziunea este falsa, jucatorul se poate misca
            if(!collisionOn )
            {
                switch (direction)
                {
                    case "up":
                        y = y - speed;
                        break;
                    case "down":
                        y = y + speed;
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
        }
        if(key.shotKeyPressed && !projectile.alive && shotAvailableCounter ==30
                && projectile.haveResource(this)) //shotAvailableCounter==30
        {
            // set default coordinates, direction and user
            projectile.set(x,y,direction,true,this);

            //scadem costul
            projectile.substractResource(this);

            shotAvailableCounter = 0;
            //add it to the list
            gp.projectileList.add(projectile);
        }


        //This needs to be outside of key if statement
        if(invincible)
        {
            invincibleCounter++;
            if(invincibleCounter > 60)
            {
                invincible = false;
                invincibleCounter=0;
            }
        }
        if(shotAvailableCounter < 30)
        {
            shotAvailableCounter++;
        }
        if(life > maxLife)
        {
            life = maxLife;
        }
        if(mana > maxMana)
        {
            mana= maxMana;
        }
        if(life <= 0)
        {
            gp.gameState =gp.gameOverState;
        }

    }

    //posibilitatea player-ului de a ataca inamicul cu sabia este verifica aici
    public void attacking()
    {
        spriteCounter++;

        if(spriteCounter <= 5)
        {
            spriteNum =1;
        }
        if(spriteCounter > 5 && spriteCounter <=25)
        {
            spriteNum = 2;
            //verificam coliziunea sabiei cu player-ul
            int swordIndex = gp.cChecker.sword_collision();
            damagePaznic(swordIndex, attack);

        }
        if(spriteCounter > 25)
        {
            spriteNum = 1;
            spriteCounter = 0;
            attacking = false;
        }

    }

    //posibilitatea player-ului de a revendica bunuri
    // de a interactiona cu ele
    public void pickUpObject(int i)
    {
        if(i != 99999 ) {



            String objectName = gp.obj[gp.currentMap][i].name;

            switch (objectName) {

                case "Coin":
                    coins++;
                    gp.obj[gp.currentMap][i] = null;
                    System.out.println("Coins:" + coins);
                    break;

                case "DiamAlb":

                    break;
                case "Mobila":
                    break;

                case "Mobila2":
                    break;

                case "Mobila3":
                    break;

                case"DiamVerde":
                    if(coins >=25) { // jocul se termina doar daca, pe langa obstacole, playerul a reusit sa adune
                        gp.ui.gameFinished = true;              //un nr mimin de banuti
                    }
                    break;
            }
        }
    }

    //se verifica daca player-ul interactioneaza cu inamicul
    public void interactPaznic(int i)
    {

            if (i != 99999) {
                if(!invincible)
                {
                    gp.player.life -= 1;
                    invincible = true;
                }
            }
            else if(gp.key.spacePressed)
            {
                attacking = true;
            }

    }
    //se verifica daca player-ul interactioneaza cu camera de supraveghere
    public void interactCamera(int i)
    {
        if(i!=99999)
        {

        }
    }
    public void contactPaznic(int i )
    {
        if( i!= 99999)
        {
            if(!invincible)
            {
                int damage = gp.paz[gp.currentMap][i].attack;
                if(damage < 0)
                {
                    damage =0;
                }
                life -= damage;
                invincible =true;
            }
        }
    }


    public void damagePaznic(int i, int attack)
    {
        if(i != 99999){
          if(!gp.paz[gp.currentMap][i].invincible)
          {
              int damage = attack - gp.paz[gp.currentMap][i].defense;
              if( damage < 0)
              {
                  damage = 0;
              }
              gp.paz[gp.currentMap][i].life -= damage;
              gp.paz[gp.currentMap][i].invincible = true;
              gp.paz[gp.currentMap][i].damageReaction();

              if(gp.paz[gp.currentMap][i].life <=0)
              {
                  gp.paz[gp.currentMap][i].dying = true;
                  gp.paz[gp.currentMap][i]=null;

              }
          }
        }
    }

    //desenam/incarcam sprit-urile playerului in functie de conditie
    public void draw(Graphics2D g2)
    {

        BufferedImage image = null;
        switch (direction)
        {
            case "up":
                if(spriteNum ==1 ) {
                    image = up1;
                }

                if(spriteNum ==2)
                {
                    image = up2;
                }
                break;

            case "down":
                if(spriteNum ==1 ) {
                    image = down1;
                }

                if(spriteNum ==2)
                {
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum ==1 ) {
                    image = left1;
                }

                if(spriteNum == 2)
                {
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum ==1 ) {
                    image = right1;
                }

                if(spriteNum == 2)
                {
                    image = right2;
                }
                    break;


            case "attackLeft":
                if(spriteNum ==1 ) {
                    image = attackLeft;
                }

                if(spriteNum == 2)
                {
                    image = attackLeft;
                }
                break;

            case "attackRight":
                if(spriteNum ==1 ) {
                    image = attackRight;
                }

                if(spriteNum == 2)
                {
                    image = attackRight;
                }
                break;

        }
        if(invincible)
        {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.4F));
        }
        g2.drawImage(image,x,y,gp.tileSize, gp.tileSize, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1F));
    }

}
