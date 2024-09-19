import mayflower.*;

public class World1 extends World {
   public World1() {
      Mayflower.showBounds(true);
      setBackground("src/img/BG/BG.png");
      MovableAnimatedActor player = StartScreen.getPlayer();
      addObject(player, 150, 350);
      addObject(new Block(), 100, 500);
      addObject(new Block(), 228, 372);
      addObject(new Block(), 400, 250);
      addObject(new Block(), 500, 100);

      Mayflower.playMusic("src/sounds/music/music.mp3");
   }

   public void act() {
   }
}
