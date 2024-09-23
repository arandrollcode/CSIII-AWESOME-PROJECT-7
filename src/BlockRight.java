import mayflower.MayflowerImage;

public class BlockRight extends Platform {

    public BlockRight() {
        MayflowerImage tile = new MayflowerImage("src/img/Tiles/15.png");
        tile.scale(100, 75);
        setImage(tile);
    }

}
