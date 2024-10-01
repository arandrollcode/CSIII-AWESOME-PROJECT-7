public class MovingBlock extends Block {
    private int leftBounds, rightBounds, direction;

    public MovingBlock() {
        super();
        leftBounds = 100;
        rightBounds = 600;
        direction = Math.random() < 0.5 ? -1 : 1;
    }

    public MovingBlock(int leftBounds, int rightBounds) {
        super();
        this.leftBounds = leftBounds;
        this.rightBounds = rightBounds;
        direction = Math.random() < 0.5 ? -1 : 1;
    }

    public void act() {
        super.act();
        setLocation(getX() + direction, getY());
        if ((getX() > rightBounds || getX() < leftBounds)) {
            direction *= -1;
        }
    }

    public int getDirection() {
        return direction;
    }
}
