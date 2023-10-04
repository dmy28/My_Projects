package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

import Entity.Entity;
import main.GamePanel;
import main.UtilityTool;

public class OBJ_Heart extends SuperObject
{
    GamePanel gp;
    UtilityTool uTool =new UtilityTool();
    Entity entity = new Entity(gp);
    public int value;


    public OBJ_Heart(GamePanel gp)
    {

        this.gp=gp;

        name = "Heart";

        value =2;
        try
        {
              image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/heart_full.png")));
              image2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/heart_half.png")));
              image3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/heart_blank.png")));
              image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
              image2 = uTool.scaleImage(image2, gp.tileSize, gp.tileSize);
              image3 = uTool.scaleImage(image3, gp.tileSize, gp.tileSize);


        }catch(IOException e)
        {
            e.printStackTrace();
        }
        collision = true;
    }




}
