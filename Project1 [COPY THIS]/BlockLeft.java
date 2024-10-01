import mayflower.MayflowerImage;

public class BlockLeft extends Platform {

    public BlockLeft() {
        MayflowerImage tile = new MayflowerImage("img/Blocks/blockLeft.png");
        tile.scale(100, 75);
        setImage(tile);
    }

}
