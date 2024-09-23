public class Finish extends Platform {
    
    public Finish() {
        setImage("src/img/Object/Stone.png");
    }

    public boolean goToNextWorld() {
        return isTouching(MovableAnimatedActor.class);
    }

}
