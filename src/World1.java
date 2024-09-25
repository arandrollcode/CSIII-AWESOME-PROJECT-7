import mayflower.*;

public class World1 extends World {
   private Tiles[][] tiles;
   private Finish finish;

   MovableAnimatedActor player;

   public World1() {
      Mayflower.showBounds(false);
      setBackground("src/img/BG/BG2.png");

      player = StartScreen.getPlayer();

      tiles = new Tiles[20][8];
      for (int i = 0; i < tiles[0].length; i++) {
         tiles[19][i] = Tiles.BLOCK;
      }
      tiles[18][2] = Tiles.BLOCK;
      tiles[17][4] = Tiles.BLOCK;
      tiles[16][6] = Tiles.BLOCK;
      tiles[14][3] = Tiles.BLOCKLEFT;
      tiles[14][4] = Tiles.BLOCKRIGHT;
      tiles[13][1] = Tiles.BLOCK;
      tiles[11][3] = Tiles.BLOCKLEFT;
      tiles[11][4] = Tiles.BLOCKRIGHT;
      tiles[9][6] = Tiles.BLOCK;
      tiles[8][3] = Tiles.BLOCKLEFT;
      tiles[8][4] = Tiles.BLOCKRIGHT;
      tiles[7][1] = Tiles.BLOCKLEFT;
      tiles[7][2] = Tiles.BLOCKRIGHT;
      tiles[3][3] = Tiles.BLOCKLEFT;
      tiles[3][4] = Tiles.BLOCKRIGHT;
      tiles[2][4] = Tiles.FINISH;

      // randomize the positions of the coins on the map
      for (int numCoins = 10; numCoins > 0; numCoins--) {
         int row, col;
         do {
            row = (int) (Math.random() * 20);
            col = (int) (Math.random() * 8);
         } while (tiles[row][col] != null);
         tiles[row][col] = Tiles.COIN;
      }

      // place the correct items on the grid from the 2d array
      for (int i = 0; i < tiles.length; i++) {
         for (int j = 0; j < tiles[0].length; j++) {
            if (tiles[i][j] == null)
               continue;

            Actor tileObject = null;
            if (tiles[i][j] == Tiles.BLOCK) {
               tileObject = new Block();
            } else if (tiles[i][j] == Tiles.BLOCKLEFT) {
               tileObject = new BlockLeft();
            } else if (tiles[i][j] == Tiles.BLOCKRIGHT) {
               tileObject = new BlockRight();
            } else if (tiles[i][j] == Tiles.COIN) {
               tileObject = new Coin();
            } else if (tiles[i][j] == Tiles.FINISH) {
               finish = new Finish();
               tileObject = finish;
            }

            if (tileObject != null)
               addObject(tileObject, j * 100, (i * 100) - 1400);
         }
      }

      // add the player to the world
      MovableAnimatedActor player = StartScreen.getPlayer();
      addObject(player, 100, 400);

      // start playing music
      Mayflower.playMusic("src/sounds/music/music.mp3");
   }

   public void act() {
      if (player.isDead()) {
         removeObject(player);
      }
      if (finish.goToNextWorld()) {
         Mayflower.setWorld(new World2());
      }
   }
}
