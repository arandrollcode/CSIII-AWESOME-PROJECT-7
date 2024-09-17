import mayflower.Mayflower;
import mayflower.World;

public class MyWorld extends World {
   private Cat cat;

   public MyWorld() {
      Mayflower.showBounds(true);
      setBackground("src/img/BG/BG.png");
      cat = new Cat();
      addObject(cat, 400, 100);
      addObject(new Block(), 400, 500);
      addObject(new Block(), 528, 372);
   }

   public void act() {
   }
}
