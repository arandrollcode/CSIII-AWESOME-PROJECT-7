import mayflower.*;

public class Hazard extends Actor {
    private Player player;

    public Hazard() {
        player = StartScreen.getPlayer();
        setImage("src/img/Object/Crate.png");
    }

    public void act() {
        if (isTouching(Player.class)) {
            player.decreaseLives(1);
        }
    }
}
