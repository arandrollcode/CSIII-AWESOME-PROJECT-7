import mayflower.MayflowerImage;

public class Block extends Platform {

   public Block() {
      MayflowerImage tile = new MayflowerImage("src/img/Tiles/2.png");
      tile.scale(100, 100);
      setImage(tile);
   }

}
