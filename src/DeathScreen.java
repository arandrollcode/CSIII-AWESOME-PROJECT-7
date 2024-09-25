import mayflower.*;

public class DeathScreen extends World {
    public DeathScreen() {
        setBackground("src/img/BG/deathscreen.png");
        Mayflower.playMusic("src/sounds/sadtrombone.mp3");
    }

    public void act() {
        if (Mayflower.isKeyDown(Keyboard.KEY_ENTER)) {
            Mayflower.setWorld(new StartScreen());
        }
    }
}
