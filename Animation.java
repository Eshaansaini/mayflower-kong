import mayflower.*;

public class Animation
{
    private MayflowerImage[] frames;
    private int framerate;
    private int currentFrame;
    private Timer animationTimer;
    private int size;
    public Animation(int frameR, String[] images)
    {
        this.framerate = frameR;
        currentFrame = 0;
        size = images.length-1;
        frames = new MayflowerImage[images.length];
        animationTimer = new Timer(2000000000 * 1/(frameR+1));
        for (int i = 0; i < images.length; i++) 
        {
            frames[i] = new MayflowerImage(images[i]);
        }
    }
    public Animation(int frameR, MayflowerImage[] frames)
    {
        this.framerate = frameR;
        currentFrame = 0;
        this.size = frames.length - 1;
        int i = 0;
        this.frames = new MayflowerImage[frames.length];
        for (MayflowerImage may: frames)
        {
            this.frames[i] = frames[i];
            i++;
        }
        animationTimer = new Timer(2000000000 * 1/(frameR+1));
    }
    public int getFrameRate()
    {
        return this.framerate;
    }
    public MayflowerImage getNextFrame()
    {
        currentFrame++;
        if (currentFrame > (this.size - 1)) currentFrame = 0;
        return frames[currentFrame];
    }
    public void scale(int w, int h) 
    {
        for(int i = 0; i < frames.length; i++) 
        {
            frames[i].scale(w,h);
        }
    }
    public void setTransparency(int t)
    {
        for(int i = 0; i < frames.length; i++) 
        {
            frames[i].setTransparency(t);
        }
    }
    public void mirrorHorizontally()
    {
        for(int i = 0; i < frames.length; i++) 
        {
            frames[i].mirrorHorizontally();
        }
    }
    public void setBounds(int x, int y, int w, int h)
    {
        for(int i = 0; i < frames.length; i++) 
        {
            frames[i].crop(x, y, w, h);
        }
    }
}
