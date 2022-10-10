import mayflower.*;

public class Cat extends MovableAnimatedActor
{
    private String[] images;
    private String[] idl;
    private String[] lef;
    private String[] lefIdl;
    private String[] fal;
    private String[] lefFal;
    private int lives; 
    private int score;
    private Timer invTimer;
    public Cat() 
    {
        lives = 3;
        images = new String[10]; //image list to become animation
        invTimer = new Timer(1000000000); //Timer to prevent getting hit multiple times at once by one rock
        //creating all animations
        for (int i = 0; i < 10; i++)
        {
            images[i] = "img/cat/Walk (" + (i+1) + ").png";
        }
        Animation walk = new Animation(40, images);
        walk.scale(40, 35);
        idl = new String[10];
        for (int i = 0; i < 10; i++)
        {
            idl[i] = "img/cat/Idle (" + (i+1) + ").png";
        }
        Animation idle = new Animation(40, idl);
        idle.scale(40,35);
        walk.setBounds(7, 3, 22, 32);
        idle.setBounds(7, 3, 22, 32);
        setWalkRightAnimation(walk);
        setIdleAnimation(idle);
        
        lefIdl = new String[10];
        for (int i = 0; i < 10; i++)
        {
            lefIdl[i] = "img/cat/Idle (" + (i+1) + ").png";
        }
        Animation leftIdle = new Animation(40, lefIdl);
        leftIdle.scale(40, 35);
        leftIdle.mirrorHorizontally(); // the right idle animation mirrored
        leftIdle.setBounds(11, 3, 22, 32);
        setLeftIdleAnimation(leftIdle);
        
        fal = new String[8];
        for (int i = 0; i < 8; i++)
        {
            fal[i] = "img/cat/Fall (" + (i+1) + ").png";
        }
        Animation falling = new Animation(40, fal);
        falling.scale(40, 35);
        falling.setBounds(7, 3, 22, 32);
        setFallingAnimation(falling);
        
        lefFal = new String[8];
        for (int i = 0; i < 8; i++)
        {
            lefFal[i] = "img/cat/Fall (" + (i+1) + ").png";
        }
        Animation leftFalling = new Animation(40, lefFal);
        leftFalling.scale(40, 35);
        leftFalling.mirrorHorizontally();
        leftFalling.setBounds(10, 3, 22, 32);
        setLeftFallingAnimation(leftFalling);
        
        setAnimation(idle);
        lef = new String[10];
        for (int i = 0; i < 10; i++)
        {
            lef[i] = "img/cat/Walk (" + (i+1) + ").png";
        }
        Animation walkLeft = new Animation(40, lef);
        walkLeft.scale(40, 35);
        walkLeft.mirrorHorizontally(); //just the right walking animation mirrored
        walkLeft.setBounds(11, 3, 22, 32);
        setWalkLeftAnimation(walkLeft);
    }
    public void act()
    {
        super.act();
        if(isTouching(Jack.class)) Mayflower.setWorld(new MyWorld2()); //touching the character at the end of the level progresses the game to the next level
        if(isTouching(Dog.class)) Mayflower.setWorld(new MyWorld3());
        if(isTouching(Ninja.class)) Mayflower.setWorld(new WinScreen()); //final friend to save, brings game to win screen
        if(isTouching(Rock.class) && invTimer.isDone()) 
        {
            decreaseLives();
            setStunned(true);
            invTimer.reset(); //method has to wait until invTimer finishes before starting again
        }
        if (lives == 0) Mayflower.setWorld(new LoseScreen()); //running out of lives send you to the lose screen
    }
    public void increaseScore(int amount){
        score+=amount;
        updateText(); //method that deletes current text and adds new text with the new value of the variables
        }
        
   public int getScore(){
         return score;
        }
   public int getLives(){
    
       return lives;
    }
   public void decreaseLives(){
       lives -= 1;
       updateText();
    }
   private void updateText(){
        World w = getWorld();
        w.removeText(10, 30);
        w.showText("Score: " + score + " Lives: "+lives , 10, 30, Color.BLACK);
    }
}
