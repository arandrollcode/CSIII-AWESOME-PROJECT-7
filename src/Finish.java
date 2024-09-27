

public class Finish extends Platform {


    public Finish() {
        setImage("src/img/sprite/finishLine.png");
    }

    public boolean touchingPlayer() {
        return isTouching(Player.class);
    }

}
