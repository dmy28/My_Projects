package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_albastrDiam extends SuperObject{

    public OBJ_albastrDiam()
    {
        name= "DiamAlb";
        try
        {
           image = ImageIO.read(getClass().getResourceAsStream("/Objects/jewelblue_0.png"));

        }catch(IOException e)
        {
            e.printStackTrace();
        }
        collision = true;


    }


}
