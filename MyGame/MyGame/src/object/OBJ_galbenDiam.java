package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_galbenDiam extends  SuperObject{

    public OBJ_galbenDiam()
    {
        name= "DiamGalb";
        try
        {
               image = ImageIO.read(getClass().getResourceAsStream("/Objects/jewelyellow.png"));

        }catch(IOException e)
        {
            e.printStackTrace();
        }
        collision = true;

    }

}
