import mayflower.*;
import java.util.ArrayList;

public class Platform extends Actor {
   private MovableAnimatedActor player;
   private double movedDown;
   private static ArrayList<Platform> platforms = new ArrayList<Platform>();
   private static boolean isMovingDown;

   public Platform() {
      player = StartScreen.getPlayer();
      platforms.add(this);
      isMovingDown = true;
   }

   public void act() {
      if (player.isPastLimit() && isMovingDown) {
         setLocation(getX(), getY() - player.getYVelocity());
         movedDown -= player.getYVelocity();
      }

   }

   public double getMovedDown() {
      return movedDown;
   }

   public static void setMovedDown(double move) {
      for (Platform platform : platforms) {
         platform.setLocation(platform.getX(), platform.getY() - (platform.getMovedDown() - move));
         platform.movedDown = 0;
      }
   }

   public static boolean getIsMovingDown() {
      return isMovingDown;
   }

   public static void setIsMovingDown(boolean moving) {
      isMovingDown = moving;
   }

}
