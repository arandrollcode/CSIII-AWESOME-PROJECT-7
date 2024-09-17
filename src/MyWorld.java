import mayflower.Mayflower;
import mayflower.World;

public class MyWorld extends World {
   private Cat cat;

   public MyWorld() {
      Mayflower.showBounds(true);
      setBackground("src/img/BG/BG.png");
      cat = new Cat();
      addObject(cat, 150, 350);
      addObject(new Block(cat), 100, 500);
      addObject(new Block(cat), 228, 372);
      addObject(new Block(cat), 400, 250);
      addObject(new Block(cat), 500, 100);
      
   }

   public void act() {
   }
}
