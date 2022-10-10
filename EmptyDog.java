import mayflower.*;

public class EmptyDog extends Actor
{
    public EmptyDog()
    {
        MayflowerImage m = new MayflowerImage("img/dog/idle (10).png");
        m.scale(100,100);
        setImage(m);
    }
    public void act()
    {
    }
}
    