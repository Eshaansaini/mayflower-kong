import mayflower.*;

public class LeftSign extends Actor
{
    
    public LeftSign()
    {
        MayflowerImage m = new MayflowerImage("img/Object/Sign_2.png");
        m.scale(25,25);
        m.mirrorHorizontally();
        setImage(m);
    }
    public void act()
    {
        
    }
}
