import mayflower.*;

public class ProjectRunner extends RightRamp 
{
    public static void main(String[] args) 
    {
        new MyMayflower();
        String filepath = "img/Music/16 Stage Theme 1-2.wav";
        PlayMusic m = new PlayMusic();
        m.music(filepath);
        
        
    }
}