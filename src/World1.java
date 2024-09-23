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

      for (int i = 0; i < tiles.length; i++) {
         for (int j = 0; j < tiles[0].length; j++) {
            if (tiles[i][j] == null)
               continue;
            if (tiles[i][j] == Tiles.BLOCK) {
               addObject(new Block(), j * 100, (i * 100) - 1400);
            } else if (tiles[i][j] == Tiles.BLOCKLEFT) {
               addObject(new BlockLeft(), j * 100, (i * 100) - 1400);
            } else if (tiles[i][j] == Tiles.BLOCKRIGHT) {
               addObject(new BlockRight(), j * 100, (i * 100) - 1400);
            }
         }
      }

      MovableAnimatedActor player = StartScreen.getPlayer();
      addObject(player, 100, 400);

      Mayflower.playMusic("src/sounds/music/music.mp3");
   }

   public void act() {
      MovableAnimatedActor player = StartScreen.getPlayer();
      if (player.isDead()) {
         removeObject(player);
      }
   }
}
