import mayflower.*;

public class Hazard extends Actor {
    private Player player;
    private double vx, vy;
    private double vxMax, vyMax;

    public Hazard(double vxMax, double vyMax) {
        player = StartScreen.getPlayer();
        MayflowerImage image = new MayflowerImage("src\\img\\Object\\BlackHole.png");
        image.crop(0, 12, 75, 50);
        setImage(image);
        vx = 0;
        vy = 0;

        this.vxMax = vxMax;
        this.vyMax = vyMax;
    }

    public void act() {
        // kill the player if it touches
        if (isTouching(Player.class)) {
            player.decreaseLives(999);
        }

        // update velocity to move towards character
        vx += (this.getCenterX() < player.getCenterX()) ? 0.1 : -0.1;
        vy += (this.getCenterY() < player.getCenterY()) ? 0.05 : -0.05;

        // restrict how large velocity can get
        vx = Math.min(vxMax, vx);
        vx = Math.max(-vxMax, vx);
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
