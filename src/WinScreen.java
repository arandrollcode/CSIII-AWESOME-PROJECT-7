import mayflower.*;

public class WinScreen extends World {
    public WinScreen() {
        setBackground("src/img/BG/winscreen.png");
        Mayflower.stopMusic("src/sounds/music/music.mp3");
        Mayflower.stopMusic("src/sounds/music/boss.mp3");
        Mayflower.playMusic("src/sounds/gameWin.mp3");
    }

    public void act() {
        if (Mayflower.isKeyPressed(Keyboard.KEY_ENTER)) {
            Mayflower.setWorld(new StartScreen());
        }
    }
}
