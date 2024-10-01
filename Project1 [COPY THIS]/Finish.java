public class Finish extends Platform {
    public Finish() {
        setImage("img/Object/finishLine.png");
    }

    public boolean touchingPlayer() {
        return isTouching(Player.class);
    }

}
