import java.util.*;
import mayflower.*;

public class Block extends Actor {
   private static ArrayList<Block> blocks = new ArrayList();

   public Block() {
      setImage("src/img/Tiles/2.png");
   }

   public void act() {
   }

   public static ArrayList<Block> getBlocks() {
      return blocks;
   }
}
