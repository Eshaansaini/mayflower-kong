import mayflower.*;

public class Jack extends AnimatedActor
{
    private String[] images;
    
    public Jack() 
    {
        images = new String[10];
        for (int i = 0; i < 10; i++)
        {
            images[i] = "img/jack/Dead (" + (10) + ").png";
        }
        Animation walk = new Animation(40, images);
        setAnimation(walk);
        walk.scale(40,50);
    }
    public void act()
    {
        super.act();
    }
}
