import mayflower.Mayflower;
import mayflower.World;

public class MyWorld extends World {
   private Cat cat;

   public MyWorld() {
      Mayflower.showBounds(true);
      this.setBackground("src/img/BG/BG.png");
      this.cat = new Cat();
      this.addObject(this.cat, 400, 100);
      this.addObject(new Block(), 400, 500);
      this.addObject(new Block(), 528, 372);
      Mayflower.playMusic("src/sounds/music/music.mp3");
   }

   public void act() {
   }
}
