import mayflower.*;


public class StartScreen extends World {

    private Cat cat;
  //  private Dog dog;
    private Jack jack;
    
    public StartScreen() 
    {
        setBackground("img/BG/BG - Start.png");
        
        for (int i = 0; i < 16; i++)
        {
            addObject(new Block(),i*50,550);
        }
        
        addObject(new RightRamp(), 200,450);
        addObject(new RightRamp(), 150,450);
        addObject(new RightRamp(), 100,450);
        addObject(new RightRamp(), 50,450);
        addObject(new RightRamp(), 0,450);
        addObject(new LeftRamp(), 600,450);
        addObject(new LeftRamp(), 650,450);
        addObject(new LeftRamp(), 700,450);
        addObject(new LeftRamp(), 750,450);
        addObject(new Ladder() , 600,451);
        addObject(new Ladder() ,150 ,451);
        addObject(new LeftRamp(), 550,450);
        addObject(new GoodMushroom(false) , 50 ,420);
        addObject(new GoodMushroom(false) , 700 ,420);
        //addObject(new BadMushroom() , 200 ,100);
        //dog = new Dog();
        //addObject(dog , 200 , 200);
        //jack = new Jack();
       //addObject(jack , 350 , 300);
       cat = new Cat();
        addObject(cat, 400, 500);
    }
    
    public void act()
    {
        
    }
    
}