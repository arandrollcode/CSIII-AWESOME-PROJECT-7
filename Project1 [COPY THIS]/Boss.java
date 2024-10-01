import mayflower.*;

public class Boss extends Actor {
    private int health;
    private int nextXLocation, nextYLocation;
    private Player player;
    private boolean vulnerable;
    private Timer pauseTimer, spikeTimer;
    private MayflowerImage normal, paused, playerHit, damaged;

    public Boss() {
        health = 100;
        player = StartScreen.getPlayer();
        vulnerable = true;

        normal = new MayflowerImage("img/Boss/boss1.png");
        normal.scale(200, 200);

        paused = new MayflowerImage("img/Boss/boss2.png");
        paused.scale(200, 200);
        paused.setTransparency(50);

        playerHit = new MayflowerImage("img/Boss/boss3.png");
        playerHit.scale(200, 200);

        damaged = new MayflowerImage("img/Boss/boss4.png");
        damaged.scale(200, 200);

        setImage(normal);

        nextXLocation = (int) (Math.random() * 200) + 200;
        nextYLocation = (int) (Math.random() * 300);
    }

    public int getHealth() {
        return health;
    }

    public void act() {
        if (vulnerable) {
            if (health <= 25) {
                setImage(damaged);
            } else {
                setImage(normal);
            }
            if (Integer.signum(nextXLocation - getX()) == 0)
                nextXLocation = (int) (Math.random() * 200) + 200;
            else
                setLocation(getX() + Integer.signum(nextXLocation - getX()), getY());
            if (Integer.signum(nextYLocation - getY()) == 0)
                nextYLocation = (int) (Math.random() * 300);
            else

                setLocation(getX(), getY() + Integer.signum(nextYLocation - getY()));

            if (isTouching(Player.class)) {
                vulnerable = false;
                pauseTimer = new Timer(Integer.MAX_VALUE);
                if (getY() < player.getY() + player.getHeight() - 10) {
                    player.respawn();
                    nextYLocation = 100;
                    setImage(playerHit);
                } else {
                    player.setYVelocity(-5);
                    ;
                    health -= 25;
                    setImage(paused);
                }
            }
        }
        if (pauseTimer != null && pauseTimer.isDone()) {
            vulnerable = true;
            pauseTimer = null;
        }

    }
}
