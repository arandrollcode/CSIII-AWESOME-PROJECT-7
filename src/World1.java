import mayflower.*;

public class World1 extends World {
   private Tiles[][] tiles;

   public World1() {
      Mayflower.showBounds(true);
      setBackground("src/img/BG/BG2.png");

      tiles = new Tiles[20][8];
      for (int i = 0; i < tiles[0].length; i++) {
         tiles[19][i] = Tiles.BLOCK;
      }
      tiles[18][(int) (Math.random() * 8)] = Tiles.BLOCKLEFT;
      for (int i = tiles.length - 3; i >= 0; i--) {
         int blockLocation;
         do {
            blockLocation = (int) (Math.random() * 6 + 1);
         } while (tiles[i + 1][blockLocation] == Tiles.BLOCKLEFT || tiles[i + 1][blockLocation - 1] == Tiles.BLOCKLEFT
               || tiles[i + 1][blockLocation + 1] == Tiles.BLOCKLEFT
               || (tiles[i + 2][blockLocation] == Tiles.BLOCKLEFT && i < 17));
         tiles[i][blockLocation] = Tiles.BLOCKLEFT;
      }

      MovableAnimatedActor player = StartScreen.getPlayer();
      addObject(player, 100, 500);
      for (int i = 0; i < tiles.length; i++) {
         for (int j = 0; j < tiles[0].length; j++) {
            if (tiles[i][j] == Tiles.BLOCK) {
               addObject(new Block(), j * 100, (i * 100) - 1400);
            } else if (tiles[i][j] == Tiles.BLOCKLEFT && j < tiles[0].length - 1) {
               tiles[i][j + 1] = Tiles.BLOCKRIGHT;
               addObject(new BlockLeft(), j * 100, (i * 100) - 1400);
               addObject(new BlockRight(), (j + 1) * 100, (i * 100) - 1400);
            }
         }
      }

      Mayflower.playMusic("src/sounds/music/music.mp3");
   }

   public void act() {
      MovableAnimatedActor player = StartScreen.getPlayer();
      if (player.isDead()) {
         removeObject(player);
      }
   }
}
