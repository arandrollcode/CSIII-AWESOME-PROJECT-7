import mayflower.*;

public class Coin extends Actor {

    public Coin() {
        setImage("src/img/Object/Stone.png");
    }

    public void act() {
        if (isTouching(Player.class)) {
            Object a = getOneIntersectingObject(Player.class);
            Player p = (Player) a;
            World w = getWorld();
            w.removeObject(this);
            p.increaseScore(10);
        }
    }
}
