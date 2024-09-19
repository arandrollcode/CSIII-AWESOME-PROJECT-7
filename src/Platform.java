import mayflower.*;

public class Platform extends Actor {
    private MovableAnimatedActor main;
    private static double movedDown;

    public Platform(MovableAnimatedActor main) {
      
        this.main = main;
   }

   public void act() {
      if (main.isPastLimit()) {
         setLocation(getX(), getY() - main.getYVelocity());
         movedDown += main.getYVelocity();
      } 
   }

   public static double getMovedDown() {
      return movedDown;
   }

}
