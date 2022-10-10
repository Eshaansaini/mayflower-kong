import mayflower.*;

public class GoodMushroom extends Actor
{
    private boolean isScore;
    public GoodMushroom(boolean t)
    {
       MayflowerImage p = new MayflowerImage ("img/Object/Mushroom_1.png");
       p.scale(0.3);
       setImage(p);
       isScore = t;
    }
    public void act()
    {
       if (isTouching(Cat.class))
    {
        Object a = getOneIntersectingObject(Cat.class);
        Cat c = (Cat) a;
        if (isScore)c.increaseScore(1);
        setLocation(1100,1000);
    }  
    }
}
