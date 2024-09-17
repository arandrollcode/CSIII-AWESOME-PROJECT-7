import java.util.ArrayList;
import mayflower.Actor;
import mayflower.MayflowerImage;

public class Block extends Actor {
   private MovableAnimatedActor main;

   public Block(MovableAnimatedActor main) {
      MayflowerImage block = new MayflowerImage("src/img/Tiles/2.png");
      block.scale(100, 100);
      setImage(block);
      
      this.main = main;
   }

   public void act() {
      if (main.isPastLimit()) {
         setLocation(getX(), getY() - main.getYVelocity());
      }
   }

}
