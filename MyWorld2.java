import mayflower.*;
public class MyWorld2 extends World {
    private Timer spawnTimer;
    private Cat cat;
    private String[][] tiles;
    private int worldIndex;
    private int onOff;
    private Cat c;
    public MyWorld2() 
    {
        setBackground("img/BG/BG.png");
        spawnTimer = new Timer(1000000000);
        tiles = new String[12][16];
        buildWorld2();
        onOff = 0;
        c = new Cat();
        worldIndex = 2;
        addObject(c, 50, 500);
        addObject(new Dog(), 450, 200);
        addObject(new GoodMushroom(true), 200, 430);
        addObject(new GoodMushroom(true), 300, 430);
        addObject(new GoodMushroom(true), 300, 330);
        addObject(new GoodMushroom(true), 50, 400);
        addObject(new GoodMushroom(true), 100, 220);
        addObject(new GoodMushroom(true), 150, 320);
        Mayflower.showBounds(false);
        showText("Score:"+c.getScore()+" Lives: "+c.getLives(), 10, 30, Color.BLACK);
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
        if (worldIndex == 2)
        {
            if (onOff == 2)
            {
            addObject(new Rock(), 500, 400);
            addObject(new Rock(), 150, 300);
            addObject(new Rock(), 400, 200);
            onOff = 0;
            }
            else onOff++;
        }
    }
    public void buildWorld2()
    {
        worldIndex = 2;
        for (int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[0].length; j++) {
                tiles[i][j] = "";
            }
        }   
        for (int c = 0; c < tiles[0].length; c++)
        {
            tiles[11][c] = "ground";
        }
        
        tiles[5][11] = "ground";
        tiles[5][10] = "ground";
        tiles[5][9] = "ground";
        tiles[5][8] = "leftRamp";
        tiles[5][7] = "leftRamp";
        tiles[5][6] = "leftRamp";
        tiles[5][5] = "leftRamp";
        tiles[5][4] = "leftRamp";
        tiles[5][3] = "leftRamp";
        tiles[5][2] = "leftRamp";
        tiles[5][1] = "leftRamp";
        
        tiles[7][11] = "rightRamp";
        tiles[7][10] = "rightRamp";
        tiles[7][9] = "rightRamp";
        tiles[7][8] = "rightRamp";
        tiles[7][7] = "rightRamp";
        tiles[7][6] = "rightRamp";
        tiles[7][5] = "rightRamp";
        tiles[7][4] = "rightRamp";
        tiles[7][3] = "rightRamp";
        
        tiles[8][9] = "ladder";
        tiles[10][2] = "ladder";
        tiles[6][4] = "ladder";
        
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
        for (int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[0].length; j++) {
                if (tiles[i][j] == "ground") 
                {
                    addObject(new Block(), j*50, i*50);
                }
                if (tiles[i][j] == "rightRamp")
                {
                    addObject(new RightRamp(), j*50, i*50);
                    addObject(new RightSign(), j*50 + 20, i*50);
                }
                if (tiles[i][j] == "leftRamp")
                {
                    addObject(new LeftRamp(), j*50, i*50);
                    addObject(new LeftSign(), j*50 + 20, i*50);
                }
                if (tiles[i][j] == "ladder")
                {
                    addObject(new Ladder(), j*50, i*50-49);
                }
            }
        }
    }
    
}