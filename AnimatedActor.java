import mayflower.*;

public class AnimatedActor extends GravityActor
{
    private Animation animation;
    private Timer animationTimer;
    
    public AnimatedActor()
    {
       animationTimer = new Timer(30000000);
    }
    public void act()
    {
        super.act();
        if (animationTimer.isDone()) 
        {
            MayflowerImage n = animation.getNextFrame();
            setImage(n);
            animationTimer.reset();
        }
    }
    public void setAnimation(Animation a)
    {
        animation = a;
    }
}
