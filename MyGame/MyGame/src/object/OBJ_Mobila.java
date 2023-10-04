package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Mobila extends SuperObject implements OBJ{
    public OBJ_Mobila()
    {
        System.out.println("mobila is made");
        name ="Mobila";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/Objects/Cabinet.png"));

        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public OBJ makeCopy()
    {
        System.out.println("mobila is being made");
        OBJ_Mobila mobila_obj= null;

        try {
            mobila_obj = (OBJ_Mobila) super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return  mobila_obj;
    }
}
