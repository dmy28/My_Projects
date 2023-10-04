package Entity;
import main.GamePanel;

public class Projectile extends Entity{

    Entity user;


    public Projectile(GamePanel gp)
    {
        super(gp);
    }

    public void set(int x, int y, String direction, boolean alive, Entity user )
    {
        this.x =x;
        this.y =y;
        this.direction = direction;
        this.alive = alive;
        this.user =user;
        this.life = this.maxLife;
    }

    public void update()
    {
        if(user == gp.player)
        {
            int pazIndex = gp.cChecker.checkEntity(this, gp.paz);
            if(pazIndex != 99999)
            {
                gp.player.damagePaznic(pazIndex, attack);
                alive = false;
            }
        }
        if(user != gp.player)
        {
            boolean contactPlayer = gp.cChecker.checkPlayer(this);
            if(!gp.player.invincible && contactPlayer)
            {
                damagePlayer(attack);
                alive = false;
            }

        }
        switch (direction)
        {
            case "left":
                 x-= speed; break;
            case "right":
                 x += speed; break;
            default:
        }
        life--;
        if(life <= 0)
        {
            alive = false;
        }

        spriteCounter++;
        if(spriteCounter > 12)
        {
            if(spriteNum == 1)
            {
                spriteNum =2;

            } else if (spriteNum == 2)
            {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

    }
    public boolean haveResource( Entity user)
    {
        boolean haveResource = false;

        return  haveResource;
    }
    public void substractResource(Entity user)
    {
        user.mana -=useCost;
    }


}
