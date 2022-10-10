import mayflower.*;


public class MyWorld3 extends World {
    private Timer spawnTimer;
    private Cat cat;
    private String[][] tiles;
    private int worldIndex;
    private int onOff;
    public MyWorld3() 
    {
        setBackground("img/BG/BG.png");
        spawnTimer = new Timer(1000000000);
        tiles = new String[12][16];
        buildWorld3();
        onOff = 0;
        worldIndex = 3;
        cat = new Cat();
        addObject(cat, 50, 500);
        addObject(new Ninja(), 50, 100);
        addObject(new GoodMushroom(true), 200, 430);
        addObject(new GoodMushroom(true), 300, 430);
        addObject(new GoodMushroom(true), 300, 330);
        addObject(new GoodMushroom(true),150,130);
        addObject(new GoodMushroom(true),200,130);
        addObject(new GoodMushroom(true),250,130);
        addObject(new GoodMushroom(true),300,130);
        addObject(new GoodMushroom(true),350,130);
        addObject(new GoodMushroom(true),550,230);
        showText("Score:"+cat.getScore()+" Lives: "+cat.getLives(), 10, 30, Color.BLACK);
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
        if (worldIndex == 3)
        {
            if (onOff == 3)
            {
            addObject(new Rock(), 730, 400);
            addObject(new Rock(), 750, 200);
            addObject(new Rock(), 750, 70);
            onOff = 0;
            }
            else onOff++;
        }
    }
    public void buildWorld3()
    {
        for (int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[0].length; j++) {
                tiles[i][j] = "";
            }
        }   
        for (int c = 0; c < tiles[0].length; c++)
        {
            tiles[11][c] = "ground";
        }
        
        tiles[3][15] = "leftRamp";
        tiles[3][14] = "leftRamp";
        tiles[3][13] = "leftRamp";
        tiles[3][12] = "leftRamp";
        tiles[3][11] = "leftRamp";
        tiles[3][10] = "leftRamp";
        
        tiles[3][7] = "leftRamp";
        tiles[3][6] = "leftRamp";
        tiles[3][5] = "leftRamp";
        tiles[3][4] = "leftRamp";
        tiles[3][3] = "leftRamp";
        tiles[3][2] = "ground";
        tiles[3][1] = "ground";
        tiles[3][0] = "ground";
        
        tiles[5][15] = "leftRamp";
        tiles[5][14] = "leftRamp";
        tiles[5][13] = "leftRamp";

        tiles[5][11] = "leftRamp";
        tiles[5][10] = "leftRamp";
        tiles[5][9] = "leftRamp";
        tiles[5][8] = "leftRamp";
        tiles[5][7] = "leftRamp";
        tiles[5][6] = "leftRamp";

        tiles[5][4] = "leftRamp";
        tiles[5][3] = "leftRamp";
        tiles[5][2] = "leftRamp";
        tiles[5][1] = "leftRamp";
        
        tiles[7][15] = "rightRamp";
        tiles[7][14] = "rightRamp";
        tiles[7][13] = "rightRamp";
        tiles[7][12] = "rightRamp";
        tiles[7][11] = "rightRamp";
        tiles[7][10] = "rightRamp";
        tiles[7][9] = "rightRamp";
        tiles[7][8] = "rightRamp";

        tiles[7][6] = "rightRamp";
        tiles[7][5] = "rightRamp";
        tiles[7][4] = "rightRamp";
        tiles[7][3] = "rightRamp";
        tiles[7][2] = "rightRamp";
        tiles[7][1] = "rightRamp";
        
        tiles[8][14] = "ladder";
        tiles[10][2] = "ladder";
        tiles[6][2] = "ladder";
        tiles[4][14] = "ladder";
        
        tiles[9][14] = "leftRamp";
        tiles[9][13] = "leftRamp";
        tiles[9][12] = "leftRamp";
        tiles[9][11] = "leftRamp";
        tiles[9][10] = "leftRamp";
        
        tiles[9][8] = "leftRamp";
        tiles[9][7] = "leftRamp";
        tiles[9][6] = "leftRamp";
        tiles[9][5] = "leftRamp";
        tiles[9][4] = "leftRamp";
        tiles[9][3] = "leftRamp";
        tiles[9][2] = "leftRamp";
        tiles[9][1] = "leftRamp";
        
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