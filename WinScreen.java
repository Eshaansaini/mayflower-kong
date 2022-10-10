import mayflower.*;
public class WinScreen extends World {
    public WinScreen() 
    {
        setBackground("img/BG/BG - Win.png");
        //adds happy and alive characters
        addObject(new EmptyCat(), 200, 455);
        addObject(new EmptyJack(), 300, 457);
        addObject(new EmptyDog(), 500, 457);
        addObject(new EmptyNinja(), 400, 450);
        for (int i = 0; i < 16; i++)
        {
            addObject(new Block(),i*50,550); //fills bottom row with blocks
        }
    }
    public void act()
    {
        
    }
    
}

