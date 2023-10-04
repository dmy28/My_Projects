package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_VerdeDiam extends SuperObject {

    public OBJ_VerdeDiam()
    {
        name= "DiamVerde";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/Objects/jewelgreen.png"));

        }catch(IOException e)
        {
            e.printStackTrace();
        }
        collision = true;
    }
}
