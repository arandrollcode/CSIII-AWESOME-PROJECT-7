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

        double newX = getX(), newY = getY();
        newX += (this.getCenterX() < player.getCenterX()) ? 1 : -1;
        newY += (this.getCenterY() < player.getCenterY()) ? 1 : -1;
        
        if (player.isPastLimit()) {
            newY -= player.getYVelocity();
        }

        setLocation(newX, newY);
    }
}
