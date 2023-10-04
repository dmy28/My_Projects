package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Key extends SuperObject implements OBJ{

    public OBJ_Key()
    {
        System.out.println("kei is made");
        name = "Coin";
        try
        {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/goldcoin1.png")));

        }catch(IOException e)
        {
            e.printStackTrace();
        }
        collision = true;

    }
    @Override
    public OBJ makeCopy()
    {
        System.out.println("Key is being made");
        OBJ_Key key_obj= null;

        try {
            key_obj = (OBJ_Key) super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return  key_obj;
    }




}
