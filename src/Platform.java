import mayflower.*;

public class Platform extends Actor {
    private MovableAnimatedActor player;
    private static double movedDown;


   public void act() {
      if (player.isPastLimit()) {
         setLocation(getX(), getY() - player.getYVelocity());
         movedDown += player.getYVelocity();
      } 
   }

   public static double getMovedDown() {
      return movedDown;
   }

}
