import mayflower.*;

public class World3 extends World {
   private Tiles[][] tiles;
   private Finish finish;

   MovableAnimatedActor player;

   public World3() {
      Mayflower.showBounds(false);
      setBackground("src/img/BG/BG2.png");
      Mayflower.stopMusic("src/sounds/music/music.mp3");
      Mayflower.playMusic("src/sounds/music/music.mp3");

      player = StartScreen.getPlayer();

      tiles = new Tiles[20][8];
      for (int i = 0; i < tiles[0].length; i++) {
         tiles[19][i] = Tiles.BLOCK;
      }
      tiles[18][4] = Tiles.BLOCK;
      tiles[16][6] = Tiles.BLOCK;
      tiles[14][3] = Tiles.MOVINGBLOCK;
      tiles[12][1] = Tiles.BLOCKLEFT;
      tiles[12][2] = Tiles.BLOCKRIGHT;
      tiles[10][4] = Tiles.BLOCKLEFT;
      tiles[10][5] = Tiles.BLOCKRIGHT;
      tiles[7][4] = Tiles.MOVINGBLOCK;
      tiles[4][3] = Tiles.MOVINGBLOCK;
      tiles[1][1] = Tiles.FINISH;

      tiles[14][0] = Tiles.HAZARD;

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
               tileObject = new Hazard(2.2, 1.7);
            }

            if (tileObject != null)
               addObject(tileObject, j * 100, (i * 100) - 1400);
         }
      }

      // add the player to the world
      MovableAnimatedActor player = StartScreen.getPlayer();
      addObject(player, 100, 400);

      Platform.setIsMovingDown(true);
      // start playing music
      Mayflower.playMusic("src/sounds/music/music.mp3");
   }

   public void act() {
      if (finish.touchingPlayer()) {
         Mayflower.setWorld(new BossWorld());
         ;
      }
   }
}
