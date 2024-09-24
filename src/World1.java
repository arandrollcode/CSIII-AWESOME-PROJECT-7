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
      tiles[11][4] = Tiles.BLOCKLEFT;
      tiles[11][5] = Tiles.BLOCKRIGHT;
      tiles[9][6] = Tiles.BLOCK;
      tiles[8][3] = Tiles.BLOCKLEFT;
      tiles[8][4] = Tiles.BLOCKRIGHT;
      tiles[7][3] = Tiles.FINISH;

      for (int i = 0; i < tiles.length; i++) {
         for (int j = 0; j < tiles[0].length; j++) {
            int x = j * 100;
            int y = (i * 100) - 1400;
            if (tiles[i][j] == null)
               continue;
            if (tiles[i][j] == Tiles.BLOCK) {
               addObject(new Block(), x, y);
            } else if (tiles[i][j] == Tiles.BLOCKLEFT) {
               addObject(new BlockLeft(), x, y);
            } else if (tiles[i][j] == Tiles.BLOCKRIGHT) {
               addObject(new BlockRight(), x, y);
            } else if (tiles[i][j] == Tiles.FINISH) {
               finish = new Finish();
               addObject(finish, x, y);
            }
         }
      }

      MovableAnimatedActor player = StartScreen.getPlayer();
      addObject(player, 100, 300);

      Mayflower.playMusic("src/sounds/music/music.mp3");
   }

   public void act() {
      if (player.isDead()) {
         removeObject(player);
      } 
      if (finish.goToNextWorld()) {
         Mayflower.exit();
      }
      // System.err.println(finish.goToNextWorld());
   }
}
