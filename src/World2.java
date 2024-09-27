import mayflower.*;

public class World2 extends World {
   private Tiles[][] tiles;
   private Finish finish;

   MovableAnimatedActor player;

   public World2() {
      Mayflower.showBounds(false);
      setBackground("src/img/BG/BG2.png");

      player = StartScreen.getPlayer();

      tiles = new Tiles[20][8];
      for (int i = 0; i < tiles[0].length; i++) {
         tiles[19][i] = Tiles.BLOCK;
      }
      tiles[18][6] = Tiles.BLOCK;
      tiles[18][7] = Tiles.BLOCK;
      // tiles[18][8] = Tiles.BLOCK;
      tiles[17][6] = Tiles.BLOCK;
      tiles[17][7] = Tiles.BLOCK;
      // tiles[17][8] = Tiles.BLOCK;
      tiles[16][7] = Tiles.BLOCK;
      // tiles[16][8] = Tiles.BLOCK;
      tiles[13][1] = Tiles.BLOCK;
      tiles[15][3] = Tiles.BLOCKLEFT;
      tiles[15][4] = Tiles.BLOCKRIGHT;
      // tiles[13][1] = Tiles.BLOCK;
      tiles[11][3] = Tiles.BLOCKLEFT;
      tiles[11][4] = Tiles.BLOCKRIGHT;
      tiles[10][6] = Tiles.BLOCK;
      tiles[8][3] = Tiles.BLOCKLEFT;
      tiles[8][4] = Tiles.BLOCKRIGHT;
      tiles[6][0] = Tiles.BLOCKLEFT;
      tiles[6][1] = Tiles.BLOCKRIGHT;
      tiles[4][3] = Tiles.BLOCKLEFT;
      tiles[4][4] = Tiles.BLOCKRIGHT;
      tiles[0][6] = Tiles.FINISH;
      tiles[15][5] = Tiles.HAZARD;

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
            } else if (tiles[i][j] == Tiles.MOVINGBLOCK) {
               tileObject = new MovingBlock();
            } else if (tiles[i][j] == Tiles.HAZARD) {
               tileObject = new Hazard();
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
      if (finish.touchingPlayer()) {
         Mayflower.setWorld(new World3());;
      }
   }
}
