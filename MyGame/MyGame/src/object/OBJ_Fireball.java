package object;
import Entity.Entity;
import Entity.Projectile;
import main.GamePanel;
import  main.UtilityTool;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;


public class OBJ_Fireball extends Projectile
{
    String name;
    boolean collision;

    GamePanel gp;
    UtilityTool uTool =new UtilityTool();
    public OBJ_Fireball(GamePanel gp) {
        super(gp);
        this.gp= gp;


        name = "Fireball";
        speed = 5;
        maxLife = 80;
        life = maxLife;
        attack = 2 ;
        alive = false;
        useCost =1;
        getImage();
    }

    public void getImage() {
        try {
            st1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Projectile/fireball_left_1.png")));
            st2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Projectile/fireball_left_2.png")));
            dr1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Projectile/fireball_right_1.png")));
            dr2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Projectile/fireball_right_2.png")));
            st1 = uTool.scaleImage(st1, gp.tileSize, gp.tileSize);
            st2 = uTool.scaleImage(st2, gp.tileSize, gp.tileSize);
            dr1 = uTool.scaleImage(dr1, gp.tileSize, gp.tileSize);
            dr2 = uTool.scaleImage(dr2, gp.tileSize, gp.tileSize);


        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }

    public boolean haveResource( Entity user)
    {
        boolean haveResource = false;
        if(user.mana >= useCost)
        {
            haveResource = true;
        }
        return  haveResource;
    }

    public void substractResource(Entity user)
    {
        user.mana -=useCost;
    }


}
