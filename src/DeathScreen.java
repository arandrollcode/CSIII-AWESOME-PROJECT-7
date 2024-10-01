import mayflower.*;

public class DeathScreen extends World {
    public DeathScreen() {
        setBackground("src/img/BG/deathscreen.png");
        Mayflower.stopMusic("src/sounds/music/music.mp3");
        Mayflower.stopMusic("src/sounds/music/boss.mp3");
        Mayflower.playMusic("src/sounds/sadtrombone.mp3");
    }

    public void act() {
        if (Mayflower.isKeyDown(Keyboard.KEY_ENTER)) {
            Mayflower.setWorld(new StartScreen());
        }
    }
}
