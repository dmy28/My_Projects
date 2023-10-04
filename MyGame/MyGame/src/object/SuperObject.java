package object;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    public BufferedImage image, image2, image3;


    public String name;

    public boolean collision = false;
    public int worldX = 0, worldY = 0;

    public Rectangle solidArea = new Rectangle(0,0,10,10);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;


    public void draw(Graphics2D g2, GamePanel gp ) {

            g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);

    }
}