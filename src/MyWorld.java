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
      tiles[18][0] = Tiles.BLOCK;
      tiles[15][3] = Tiles.BLOCK;
      tiles[12][6] = Tiles.BLOCK;
      tiles[4][1] = Tiles.BLOCK;
      tiles[18][7] = Tiles.BLOCK;
      tiles[16][5] = Tiles.BLOCK;
      tiles[14][3] = Tiles.BLOCK;
      tiles[12][2] = Tiles.BLOCK;
      tiles[10][5] = Tiles.BLOCK;
      tiles[13][1] = Tiles.BLOCK;
      tiles[9][3] = Tiles.BLOCK;
      

      
      cat = new Cat();
      addObject(cat, 150, 350);
      for (int i = 0; i < tiles.length; i++) {
         for (int j = 0; j < tiles[0].length; j++) {
            if (tiles[i][j] == Tiles.BLOCK) {
               addObject(new Block(cat), j * 100, (i * 100) - 1400);
            }
         }
      }
      
   }

   public void act() {
   }
}
