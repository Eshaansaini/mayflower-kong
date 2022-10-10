import mayflower.*;

public class GravityActor extends Actor
{
    private boolean laddersOff;
    private boolean groundOff;
    private boolean allOff;
    public GravityActor()
    {
      laddersOff = false;
      groundOff = false;
      allOff = false;
    }
    public void act()
    {
      
       int x = getX();
       int y = getY();
       int w = getWidth();
       int h = getHeight();
       if (allOff) super.setLocation(x,y+1);
       else {
       if (!isLadder()) super.setLocation(x,y+1);
       if (isBlockedByBlock() && !allOff) {
           {
           super.setLocation(x,y-1);
           }
        }
       if (isBlockedByRight() && !isLadder() && x < 800 - w && !allOff) {
           {
           super.setLocation(x,y-1);
           super.setLocation(x+2,y);
           }
        }
       if (isBlockedByLeft() && !isLadder() && x > 0-w/2 && !allOff) {
           {
           super.setLocation(x,y-1);
           super.setLocation(x-2,y);
           }
        }
       }
    }   
    public boolean isBlockedByBlock()
    {
        if(allOff) return false;
        if (!groundOff)
        {
            if (!(isTouching(RightRamp.class) || isTouching(LeftRamp.class)))return isTouching(Block.class);
            return false;
        }
        else return false;
    }
    public boolean isBlockedByRight()
    {
        if(allOff) return false;
        if (isTouching(RightRamp.class)) return true;
        else return false;
    }
    public boolean isBlockedByLeft()
    {
        if(allOff) return false;
        if (isTouching(LeftRamp.class)) return true;
        else return false;
    }
    public boolean isBlockedByAny()
    {
        if(allOff) return false;
        if (!groundOff)
        {
            if (isTouching(LeftRamp.class) || isTouching(RightRamp.class) || isTouching(Block.class)) return true;
            else return false;
        }
        else 
        {
            if (isTouching(LeftRamp.class) || isTouching(RightRamp.class)) return true;
            else return false;
        }
     
    }
    public boolean isFalling()
    {
        if(allOff) return true;
        boolean ret;
        setLocation(getX(), getY() + 1);
        ret = !isTouching(Block.class) && !isLadder();
        setLocation(getX(), getY()-1);
        return ret;
    }
    public boolean isLadder()
    {
        if(allOff) return false;
        if (laddersOff) return false;
        else return isTouching(Ladder.class);
    }
    public void setLaddersOff()
    {
        laddersOff = true;
    }
    public void setGroundOff()
    {
        groundOff = true;
    }
    public void setAllOff()
    {
        allOff = true;
    }
    public void setAllOn()
    {
        allOff = false;
    }
    public boolean allOff()
    {
        return allOff;
    }
}
