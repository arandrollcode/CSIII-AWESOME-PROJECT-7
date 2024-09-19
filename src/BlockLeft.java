import mayflower.*;

public class BlockLeft extends Platform {
    public BlockLeft(MovableAnimatedActor main) {
        super(main);
        MayflowerImage block = new MayflowerImage("src/img/Tiles/13.png");
        block.scale(100, 100);
        setImage(block);
    }
    
    public void act() {
        super.act();
    }
}
