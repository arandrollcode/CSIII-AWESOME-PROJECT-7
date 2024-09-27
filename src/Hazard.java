import mayflower.*;

public class Hazard extends Actor {
    private Player player;
    private double vx, vy;

    public Hazard() {
        player = StartScreen.getPlayer();
        setImage("src\\img\\Object\\BlackHole.png");
        vx = 0;
        vy = 0;
    }

    public void act() {
        // kill the player if it touches
        if (isTouching(Player.class)) {
            player.decreaseLives(999);
        }

        // update velocity to move towards character
        vx += (this.getCenterX() < player.getCenterX()) ? 0.1 : -0.1;
        vy += (this.getCenterY() < player.getCenterY()) ? 0.1 : -0.1;

        // restrict how large velocity can get
        double vxMax = 1.6;
        vx = Math.min(vxMax, vx);
        vx = Math.max(-vxMax, vx);
        double vyMax = 1;
        vy = Math.min(vyMax, vy);
        vy = Math.max(-vyMax, vy);

        // add velocity to current position
        double newX = getX(), newY = getY();
        newX += vx;
        newY += vy;

        // take screen scrolling into account
        if (player.isPastLimit()) {
            newY -= player.getYVelocity();
        }

        setLocation(newX, newY);
    }
}
