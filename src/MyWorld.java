import mayflower.*;

public class MyWorld extends World {
   public MyWorld() {
      Mayflower.showBounds(true);
      setBackground("src/img/BG/BG.png");
      Cat cat = new Cat();
      addObject(cat, 150, 350);
      addObject(new Block(cat), 100, 500);
      addObject(new Block(cat), 228, 372);
      addObject(new Block(cat), 400, 250);
      addObject(new Block(cat), 500, 100);

      Mayflower.playMusic("src/sounds/music/music.mp3");
   }

   public void act() {
   }
}
