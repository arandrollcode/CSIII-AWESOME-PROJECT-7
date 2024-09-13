import mayflower.*;

public class MyMayflower extends Mayflower
{
    public MyMayflower() {
        super("Lab 4", 800, 600);
    }

    public void init()
    {
        //Change this to true to run this program in fullscreen mode
        Mayflower.setFullScreen(false);
        World w = new MyWorld();
        Mayflower.setWorld(w);
    }
}