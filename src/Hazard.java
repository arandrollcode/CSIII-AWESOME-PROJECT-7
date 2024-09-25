import mayflower.*;

public class Hazard extends Actor {
    private Player player;

    public Hazard() {
        player = StartScreen.getPlayer();
        setImage("src\\img\\Object\\BlackHole.png");
    }

    public void act() {
        if (isTouching(Player.class)) {
            player.decreaseLives(999);
        }

        if (player.isPastLimit()) {
            setLocation(getX(), getY() - player.getYVelocity());
        }
    }
}
