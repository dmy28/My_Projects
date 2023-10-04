package object;

import Entity.Entity;
import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class OBJ_ManaCrystal extends Entity {

    GamePanel gp;
    String name;
    int value;

    UtilityTool uTool = new UtilityTool();

    public OBJ_ManaCrystal(GamePanel gp)
    {
        super(gp);
        this.gp = gp;

        name = "Mana Crystal";
        value =2;

        try
        {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/manacrystal_full.png")));
            image2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/manacrystal_blank.png")));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
            image2 = uTool.scaleImage(image2, gp.tileSize, gp.tileSize);


        }catch(IOException e)
        {
            e.printStackTrace();
        }
        collision = true;

    }


}
