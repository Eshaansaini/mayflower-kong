import mayflower.*;

public class EmptyJack extends Actor
{
    public EmptyJack()
    {
        MayflowerImage m = new MayflowerImage("img/jack/Idle (1).png");
        m.scale(80,100);
        setImage(m);
    }
    public void act()
    {
    }
}
    