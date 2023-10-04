package object;

public class CloneFactory {

    public OBJ getClone(OBJ  obiect)
    {
        return obiect.makeCopy();
    }
}
