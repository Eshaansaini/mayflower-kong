import mayflower.*;

public class MovableAnimatedActor extends AnimatedActor
{
    private Animation walkRight;
    private Animation idle;
    private Animation leftIdle;
    private String currentAction;
    private Animation walkLeft;
    private String direction;
    private Animation falling;
    private Animation leftFalling;
    private Timer cooldownTimer;
    private Timer jumpTimer;
    private boolean isStunned;
    private Timer stunTimer;
    private String jumpState;
    private Timer downTimer;
    private int t;
    private int y;
    public MovableAnimatedActor()
    {
        walkRight = null;
        idle = null;
        currentAction = null;
        walkLeft = null;
        leftIdle = null;
        falling = null;
        leftFalling = null;
        direction = "right";
        cooldownTimer = new Timer(500000000);
        jumpTimer = new Timer(170000000);
        downTimer = new Timer(170000000);
        isStunned = false;
        stunTimer = new Timer(800000000);
        jumpState = null;
        t = 0;
        y=0;
    }
    public void act()
    {
       super.act();
       boolean ladder = isLadder();
       String newAction = null;
       if (currentAction == null) newAction = "idle";
       int x = getX();
       int y = getY();
       int w = getWidth();
       int h = getHeight();
       if(!isStunned)
       {
       setAllOn();
       jump();
       if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && x + w < 800 && !allOff())
       {
           if (!isLadder()) setLocation(x+3,y);
           newAction = "walkRight";
           direction = "right";
           jump();
           if (isBlockedByAny() && !isLadder() && !allOff()) setLocation(x-3,y);
       }
       else if (Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0 && isLadder())
       {
           setLocation(x,y-3);
           newAction = "ladder";
       }
       else if (Mayflower.isKeyDown(Keyboard.KEY_DOWN) && y < 800-h && isLadder() && !allOff())
       {
           setLocation(x,y+3);
           newAction = "ladder";
       }
       else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > 0 && !isLadder() && !allOff())
       {
           setLocation(x-3,y);
           newAction = "walkLeft";
           direction = "left";//needed for setting animation
           jump(); //doesn't really jump every time, as there is a conditional in the jump method itself
           if (isBlockedByAny()) setLocation(x+3,y); //pushes player back if they attempt to walk into a wall
        }
    //cheat codes
       else if (Mayflower.isKeyDown(Keyboard.KEY_S)) {
           Mayflower.setWorld(new MyWorld());
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_I)) {
           Mayflower.setWorld(new MyWorld2());
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_O)) {
           Mayflower.setWorld(new MyWorld3());
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_P)) {
           Mayflower.setWorld(new WinScreen());
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_M)) {
           Mayflower.setWorld(new WaterWorld());
        }
       else if (isFalling()) newAction = "falling";
       else newAction = "idle"; 
       }
       else if (isStunned || allOff()) 
       {
           setAllOff(); //method that turns off collision
           isStunned = true; //makes sure the two states across classes are symmetrical
           if (t < 2 && stunTimer.isDone()) //buffers the timer to take 3x as long to execute actual codes
           {
               t++;
               stunTimer.reset();
           }
           if (stunTimer.isDone()) 
           {
               setAllOn(); //method that turns on collision
               setStunned(false);
               t = 0;
           }
       }
       if (direction != null && direction.equals("left") && newAction == "idle")
       {
           newAction = "idleLeft";
       }
       if (newAction != null && !newAction.equals(currentAction))
       {
          //sets the animation according to the new action
          if (newAction.equals("walkRight")) 
          {
              setAnimation(walkRight);
              currentAction = newAction;
          }
          if (newAction.equals("walkLeft"))
          {
              setAnimation(walkLeft);
              currentAction = newAction;
          }
          if (newAction.equals("idle") || newAction.equals("ladder"))
          {
              setAnimation(idle);
              currentAction = newAction;
          }
          if (newAction.equals("idleLeft"))
          {
              setAnimation(leftIdle);
              currentAction = newAction;
          }
          if (direction != null && newAction.equals("falling") && direction == "right" || newAction.equals("stunned"))
          {
              setAnimation(falling);
              currentAction = newAction;
          }
          else if (direction != null && newAction.equals("falling") && direction == "left")
          {
              setAnimation(leftFalling);
              currentAction = newAction;
          }
        }  
    }
    public void setAnimation(Animation a)
    {
        super.setAnimation(a); //set the current animation of the actor
    }
    //sets the private animation objects to the inputted animations
    public void setWalkRightAnimation(Animation ani)
    {
        walkRight = ani;
    }
    public void setIdleAnimation(Animation ani)
    {
         idle = ani;
    }
    public void setWalkLeftAnimation(Animation ani)
    {
         walkLeft = ani;
    }
    public void setLeftIdleAnimation(Animation ani)
    {
         leftIdle = ani;
    }
    public void setFallingAnimation(Animation ani)
    {
         falling = ani;
    }
    public void setLeftFallingAnimation(Animation ani)
    {
         leftFalling = ani;
    }
    public void setStunned(boolean b)
    {
        isStunned = b;
    }
    public boolean isStunned() {
        return isStunned;
    }
    public void jump()
    {
       int x = getX(); //gets locational values
       int y = getY();
       if (Mayflower.isKeyDown(Keyboard.KEY_SPACE) && !isLadder() && !allOff()) //only executes when the space key is pressed and the character isnt on a ladder and collision isnt off
       {
           if (jumpState == null && cooldownTimer.isDone())
           {    
             jumpState = "up"; //first portion of the jump which is an upward motion
             jumpTimer.reset();
           }
           if (jumpState == "up" && jumpTimer.isDone()) //the first jump state has to have gone through
           {    
             jumpState = "down"; //second portion of the jump which is a downward motion
             downTimer.reset();
           }
           if (jumpState == "down" && downTimer.isDone()) //only executes after the down portion of the jump has fully gone through
           {    
             jumpState = null; //resets back to where it began at null
             cooldownTimer.reset();
           }
           //actual location setting based upon jumpState
           if (jumpState == "up")
                {
                 setLocation(x,y-3);
                }
           if (jumpState == "down")
                {
                 setLocation(x,y-1);
                }
       }
    }
}

