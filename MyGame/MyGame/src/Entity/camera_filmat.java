package Entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Random;

public class camera_filmat extends  Entity{

    public String name;
    public camera_filmat(  GamePanel gp)
    {
        super(gp);

        direction = "left";
        speed = 3;

        getCameraImage();
    }
    public void getCameraImage()
    {

        try {

            st= ImageIO.read((getClass().getResourceAsStream("/camera_filmat/Camera_stanga.png")));
            dr= ImageIO.read((getClass().getResourceAsStream("/camera_filmat/Camera_dreapta.png")));



        }  catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    public void setAction()
    {
        actionLockCounter ++;

        if(actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;  // luam un numar de la 1 la 100


            if ( i <= 50) {
                direction = "left";
            }
            if (i > 50) {
                direction = "right";
            }

            actionLockCounter = 0;
        }

    }

    @Override
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (direction)
        {
            case "left":
                image = st;
                break;
            case "right":
                image = dr;
                break;
        }
        g2.drawImage(image,x,y,gp.tileSize *2, gp.tileSize*2 , null);

    }

    @Override
    public void update() {

        setAction();

    }
}
