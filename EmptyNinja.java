import mayflower.*;

public class EmptyNinja extends Actor
{
    public EmptyNinja()
    {
        MayflowerImage m = new MayflowerImage("img/ninjagirl/Idle__001.png");
        m.scale(60,100);
        setImage(m);
    }
    public void act()
    {
    }
}
    