import mayflower.Mayflower;
import mayflower.World;

public class MyMayflower extends Mayflower {
   public MyMayflower() {
      super("Lab 4", 800, 600);
   }

   public void init() {
      Mayflower.setFullScreen(false);
      World w = new MyWorld();
      Mayflower.setWorld(w);
   }
}
