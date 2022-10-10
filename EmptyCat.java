import mayflower.*;

public class EmptyCat extends Actor
{
    public EmptyCat()
    {
        MayflowerImage m = new MayflowerImage("img/cat/Idle (1).png");
        m.scale(100,100);
        setImage(m);
    }
    public void act()
    {
    }
}
    