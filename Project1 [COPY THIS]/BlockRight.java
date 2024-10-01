import mayflower.MayflowerImage;

public class BlockRight extends Platform {

    public BlockRight() {
        MayflowerImage tile = new MayflowerImage("img/Blocks/blockRight.png");
        tile.scale(100, 75);
        setImage(tile);
    }

}
