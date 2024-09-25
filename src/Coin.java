import mayflower.*;

public class Coin extends Actor {
    private MovableAnimatedActor player;
    private static double movedDown;

    public Coin() {
        player = StartScreen.getPlayer();
        setImage("src/img/Sprite/Coin.png");
    }

    public void act() {
        if (player.isPastLimit()) {
            setLocation(getX(), getY() - player.getYVelocity());
            movedDown += player.getYVelocity();
        }

        if (isTouching(Player.class)) {
            Object a = getOneIntersectingObject(Player.class);
            Player p = (Player) a;
            World w = getWorld();
            w.removeObject(this);
            p.increaseScore(10);
        }
    }
}
