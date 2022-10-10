import mayflower.*;
public class MyWorld extends World {
    private Timer spawnTimer;
    private Cat cat;
    private String[][] tiles;
    private int worldIndex;
    private int onOff;
    private Cat c;
    public MyWorld() 
    {
        setBackground("img/BG/BG.png");
        spawnTimer = new Timer(1000000000); //buffer the spawning of rocks
        tiles = new String[12][16]; //2d array that is used to build tiled world
        buildWorld1();
        onOff = 0;
        worldIndex = 1;
        c = new Cat();
        addObject(c, 50, 500);
        addObject(new Jack(), 100, 300);
        addObject(new GoodMushroom(true), 550, 330);
        addObject(new GoodMushroom(true), 200, 430);
        addObject(new GoodMushroom(true), 300, 330);
        showText("Score:"+c.getScore()+" Lives: "+c.getLives(), 10, 30, Color.BLACK); //text that displays lives and points
    }
    public void act()
    {
        if (spawnTimer.isDone())
        {
            spawnRocks();
            spawnTimer.reset();
        }
    }
    public void spawnRocks()
    {
        if (worldIndex == 1)
        {
            if (onOff == 3) //used to buffer timer even more
            {
            //spawn rocks
            addObject(new Rock(), 500, 400);
            addObject(new Rock(), 250, 300);
            onOff = 0;
            }
            else onOff++; 
        }
    }
    public void buildWorld1()
    {
        for (int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[0].length; j++) {
                tiles[i][j] = ""; //fills every tile value to avoid null pointer exceptions
            }
        }   
        for (int c = 0; c < tiles[0].length; c++)
        {
            tiles[11][c] = "ground"; //sets the bottom row of tiles to ground
        }
        
        //assigning Strings to the array to be built later in the method
        tiles[7][11] = "rightRamp";
        tiles[7][10] = "rightRamp";
        tiles[7][9] = "rightRamp";
        tiles[7][8] = "rightRamp";
        tiles[7][7] = "rightRamp";
        tiles[7][6] = "rightRamp";
        tiles[7][5] = "rightRamp";
        tiles[7][4] = "rightRamp";
        tiles[7][3] = "ground";
        tiles[7][2] = "ground";
        tiles[7][1] = "ground";
        
        tiles[8][9] = "ladder";
        tiles[10][2] = "ladder";
        
        tiles[9][10] = "leftRamp";
        tiles[9][9] = "leftRamp";
        tiles[9][8] = "leftRamp";
        tiles[9][7] = "leftRamp";
        tiles[9][6] = "leftRamp";
        tiles[9][5] = "leftRamp";
        tiles[9][4] = "leftRamp";
        tiles[9][3] = "leftRamp";
        tiles[9][2] = "leftRamp";
        tiles[9][1] = "leftRamp";
        tiles[9][0] = "ground";
        //takes strings and adds objects based on String
        for (int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[0].length; j++) {
                if (tiles[i][j] == "ground") 
                {
                    addObject(new Block(), j*50, i*50);
                }
                if (tiles[i][j] == "rightRamp")
                {
                    addObject(new RightRamp(), j*50, i*50);
                    addObject(new RightSign(), j*50 + 20, i*50); //adds a sign that would point in the direction the conveyer platform was moving in
                }
                if (tiles[i][j] == "leftRamp")
                {
                    addObject(new LeftRamp(), j*50, i*50);
                    addObject(new LeftSign(), j*50 + 20, i*50); //adds a sign that would point in the direction the conveyer platform was moving in
                }
                if (tiles[i][j] == "ladder")
                {
                    addObject(new Ladder(), j*50, i*50-49);
                }
            }
        }
    }
}