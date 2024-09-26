import mayflower.*;
import java.util.ArrayList;

public class Platform extends Actor {
   private MovableAnimatedActor player;
   private double movedDown;
   private static ArrayList<Platform> platforms = new ArrayList<Platform>();

   public Platform() {
      player = StartScreen.getPlayer();
      platforms.add(this);
   }

   public void act() {
      if (player.isPastLimit()) {
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




}
