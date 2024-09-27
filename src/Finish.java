public class Finish extends Platform {

    public Finish() {
        setImage("src/img/sprite/finishLine.png");
    }

    public boolean goToNextWorld() {
        return isTouching(MovableAnimatedActor.class);
    }

}
