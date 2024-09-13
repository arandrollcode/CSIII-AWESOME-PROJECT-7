import java.util.ArrayList;
import mayflower.Actor;

public class Block extends Actor {
   private static ArrayList<Block> blocks = new ArrayList();

   public Block() {
      this.setImage("Project1/src/img/Tiles/2.png");
   }

   public void act() {
   }

   public static ArrayList<Block> getBlocks() {
      return blocks;
   }
}
