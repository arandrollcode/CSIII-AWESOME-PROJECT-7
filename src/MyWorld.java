import mayflower.Mayflower;
import mayflower.World;

public class MyWorld extends World {
   private Cat cat;
   private Tiles[][] tiles;

   public MyWorld() {
      Mayflower.showBounds(false);
      setBackground("src/img/BG/BG.png");

      tiles = new Tiles[20][8];

      for (int i = 0; i < tiles[0].length; i++) {
         tiles[19][i] = Tiles.BLOCK;
      }

      tiles[18][(int)(Math.random() * 8)] = Tiles.BLOCKLEFT;

      for (int i = tiles.length - 3; i >= 0; i--) {
         int blockLocation;
         do {
            blockLocation = (int)(Math.random() * 6 + 1);
         } while (tiles[i + 1][blockLocation] == Tiles.BLOCKLEFT || tiles[i + 1][blockLocation - 1] == Tiles.BLOCKLEFT || tiles[i + 1][blockLocation + 1] == Tiles.BLOCKLEFT || (tiles[i + 2][blockLocation] == Tiles.BLOCKLEFT && i < 17));
         tiles[i][blockLocation] = Tiles.BLOCKLEFT;
      }
      
      
      
      cat = new Cat();
      addObject(cat, 100, 500);
      for (int i = 0; i < tiles.length; i++) {
         for (int j = 0; j < tiles[0].length; j++) {
            if (tiles[i][j] == Tiles.BLOCK) {
                  addObject(new Block(), j * 100, (i * 100) - 1400);
            } else if (tiles[i][j] == Tiles.BLOCKLEFT) {
               tiles[i][j + 1] = Tiles.BLOCKRIGHT;
               addObject(new BlockLeft(cat), j * 100, (i * 100) - 1400);
               addObject(new BlockRight(cat), (j + 1) * 100, (i * 100) - 1400);
            }
         }
      }
      
   }

   public void act() {
      if (cat.isDead()) {
         removeObject(cat);
         // Switch to game over screen
      }
   }
}
