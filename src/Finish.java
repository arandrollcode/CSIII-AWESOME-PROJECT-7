public class Finish extends Platform {

    public Finish() {
        setImage("src/img/Object/Stone.png");
    }

    public boolean touchingPlayer() {
        return isTouching(Player.class);
    }

}
