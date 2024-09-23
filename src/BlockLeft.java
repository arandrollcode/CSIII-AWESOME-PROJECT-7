import mayflower.MayflowerImage;

public class BlockLeft extends Platform {

    public BlockLeft() {
        MayflowerImage tile = new MayflowerImage("src/img/Tiles/13.png");
        tile.scale(100, 75);
        setImage(tile);
    }

}
