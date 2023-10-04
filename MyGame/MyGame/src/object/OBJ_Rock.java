package object;

import Entity.Projectile;
import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Rock extends Projectile {

    String name;
    boolean collision;

    GamePanel gp;
    UtilityTool uTool =new UtilityTool();
    public OBJ_Rock(GamePanel gp) {
        super(gp);
        this.gp= gp;


        name = "Rock";
        speed = 8;
        maxLife = 30;
        life = maxLife;
        attack = 2 ;
        alive = false;
        getImage();
    }

    public void getImage() {
        try {
            st1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Projectile/rock_down_1.png")));
            st2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Projectile/rock_down_1.png")));
            dr1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Projectile/rock_down_1.png")));
            dr2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Projectile/rock_down_1.png")));
            st1 = uTool.scaleImage(st1, gp.tileSize, gp.tileSize);
            st2 = uTool.scaleImage(st2, gp.tileSize, gp.tileSize);
            dr1 = uTool.scaleImage(dr1, gp.tileSize, gp.tileSize);
            dr2 = uTool.scaleImage(dr2, gp.tileSize, gp.tileSize);


        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
