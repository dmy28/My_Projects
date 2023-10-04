package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_MObila2 extends SuperObject implements OBJ {
    public OBJ_MObila2()
    {
        System.out.println("mobila2 is made");
        name ="Mobila2";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/Objects/bookshelf_2.png"));

        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public OBJ makeCopy()
    {
        System.out.println("mobila2 is being made");
        OBJ_MObila2 mobila2_obj= null;

        try {
            mobila2_obj = (OBJ_MObila2) super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return  mobila2_obj;
    }
}
