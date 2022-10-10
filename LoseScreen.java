import mayflower.*;
public class LoseScreen extends World {
    public LoseScreen() 
    {
        setBackground("img/BG/BG - Loss.png");
        for (int i = 0; i < 16; i++)
        {
            addObject(new Block(),i*50,550); //fills bottom row with blocks
        }
        addObject(new DeadCat(), 300, 455); //cat died nooo!
    }
    public void act()
    {
        
    }
    
}

