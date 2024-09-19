import mayflower.*;

public class Block extends Platform {

   public Block(MovableAnimatedActor main) {
      super(main);
      MayflowerImage block = new MayflowerImage("src/img/Tiles/14.png");
      block.scale(100, 100);
      setImage(block);
   }

   public void act() {
      super.act();
   }


}
