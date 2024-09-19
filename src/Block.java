import mayflower.*;

public class Block extends Actor {
   private MovableAnimatedActor main;

   public Block(MovableAnimatedActor main) {
      setImage("src/img/Tiles/2.png");
      this.main = main;
   }

   public void act() {
      if (main.isPastLimit()) {
         setLocation(getX(), getY() - main.getYVelocity());
      }
   }

}
