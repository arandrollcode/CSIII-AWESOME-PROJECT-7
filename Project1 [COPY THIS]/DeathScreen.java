import mayflower.*;

public class DeathScreen extends World {
    public DeathScreen() {
        setBackground("img/BG/deathscreen.png");
        Mayflower.stopMusic("sounds/music/music.mp3");
        Mayflower.stopMusic("sounds/music/boss.mp3");
        Mayflower.playMusic("sounds/sadtrombone.mp3");
    }

    public void act() {
        if (Mayflower.isKeyPressed(Keyboard.KEY_ENTER)) {
            Mayflower.setWorld(new StartScreen());
        }
    }
}
