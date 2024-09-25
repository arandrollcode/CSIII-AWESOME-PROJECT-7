import mayflower.*;

public class Coin extends Actor {
    private MovableAnimatedActor player;

    public Coin() {
        player = StartScreen.getPlayer();
        setImage("src/img/Object/Stone.png");
    }

    public void act() {
        if (player.isPastLimit()) {
            setLocation(getX(), getY() - player.getYVelocity());
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
