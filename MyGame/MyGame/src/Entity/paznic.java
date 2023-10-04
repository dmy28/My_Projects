package Entity;

import main.GamePanel;
import object.OBJ_Rock;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class paznic extends  Entity{
    private boolean movingRight; // Variabilă pentru a urmări dacă jucătorul se deplasează la dreapta sau la stânga
    private long moveStartTime; // Timpul la care a început ultima deplasare


    public paznic(  GamePanel gp)
    {
        super(gp);


        this.gp = gp;
        type =1;
        maxLife = 6;
        defense =0;
        attack = 5;
        projectile = new OBJ_Rock(gp);
        life = maxLife;
        solidArea = new Rectangle();
        solidArea.x = 30;
        solidArea.y = 25;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.height=40;
        solidArea.width = 25;

        direction = "left";
        speed = 1;
        getPaznicImage();
    }
    public void getPaznicImage()
    {
        try {
            stapeloc= ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/paznic/PaznicVerdeDrept.png"))));
            st1= ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/paznic/PaznicVerdeNouSt.png"))));
            st2= ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/paznic/PaznicVerdeNouSt2.png"))));
            dr1= ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/paznic/PaznicVerdeNouDr.png"))));
            dr2= ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/paznic/PaznicVerdeNouDr2.png"))));


        }  catch(IOException e)
        {
            e.printStackTrace();
        }

    }


    public void setAction()
    {

        long currentTime = System.currentTimeMillis();

        if (!movingRight && currentTime - moveStartTime >= 4000) {
            movingRight = true; // Începe deplasarea la dreapta
            moveStartTime = currentTime;
        } else if (movingRight && currentTime - moveStartTime >= 4000) { // Jucătorul s-a deplasat timp de 7 secunde
            movingRight = false; // Începe deplasarea la stânga
            moveStartTime = currentTime;
        }

        if (movingRight) {
            direction = "right";
        } else {
            direction = "left";
        }



        int i = new Random().nextInt(100)+1;
        if(i > 99 && !projectile.alive && shotAvailableCounter == 30)
        {
            projectile.set(x,y,direction, true,this);
            gp.projectileList.add(projectile);
            shotAvailableCounter = 0;

        }



    }
    public void damageReaction()
    {
        actionLockCounter =0;
        direction = gp.player.direction;

    }

}
