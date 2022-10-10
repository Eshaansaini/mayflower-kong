import mayflower.*;
public class Rock extends AnimatedActor
{
    private MayflowerImage im;
    private Animation ani;
    private MayflowerImage[] frames;
    public Rock()
    {
       frames = new MayflowerImage[20];
       //creates rolling animation for rocks
       for (int i = 0; i < frames.length; i++)
       {
       im = new MayflowerImage("img/Object/Stone.png");
       im.scale(10,10);
       im.rotate(18 * i); //rotates the rock by a little each frame. Rotates a full 360 over 20 frames.
       frames[i] = im;
       }
       ani = new Animation(40, frames);
       setAnimation(ani);
       ani.setBounds(0,0,10,10);
       setLaddersOff(); //keeps the rocks from getting stuck onto ladders
       setGroundOff(); //allows the rocks to fall below the map
    }
    public void act()
    {
        super.act(); //applies gravity to rock
        setImage(ani.getNextFrame());
    }
}