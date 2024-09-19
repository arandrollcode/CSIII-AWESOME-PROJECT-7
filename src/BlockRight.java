import mayflower.*;

public class BlockRight extends Platform {

    public BlockRight(MovableAnimatedActor main) {
        super(main);
        MayflowerImage block = new MayflowerImage("src/img/Tiles/15.png");
        block.scale(100, 100);
        setImage(block);
    }
    
    public void act() {
        super.act();
    }
}
