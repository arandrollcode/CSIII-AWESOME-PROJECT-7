import mayflower.*;

public class Block extends Actor {
   private MovableAnimatedActor player;

   public Block() {
      setImage("src/img/Tiles/2.png");
      player = StartScreen.getPlayer();
   }

   public void act() {
      if (player.isPastLimit()) {
         setLocation(getX(), getY() - player.getYVelocity());
      }
   }

}
