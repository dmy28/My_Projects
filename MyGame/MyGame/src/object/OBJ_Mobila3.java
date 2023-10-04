package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Mobila3 extends SuperObject implements  OBJ{
    public OBJ_Mobila3()
    {
        System.out.println("mobila3 is made");
        name ="Mobila3";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/Objects/BlackOnyxWallCabinet.png"));

        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public OBJ makeCopy()
    {
        System.out.println("mobila3 is being made");
        OBJ_Mobila3 mobila3_obj= null;

        try {
            mobila3_obj = (OBJ_Mobila3) super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return  mobila3_obj;
    }
}
