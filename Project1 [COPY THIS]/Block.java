import mayflower.MayflowerImage;

public class Block extends Platform {

   public Block() {
      super();
      MayflowerImage tile = new MayflowerImage("img/Blocks/block.png");
      tile.scale(100, 100);
      setImage(tile);
   }

}
