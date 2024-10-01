import mayflower.*;

public class WinScreen extends World {
    public WinScreen() {
        setBackground("img/BG/winscreen.png");
        Mayflower.stopMusic("sounds/music/music.mp3");
        Mayflower.playMusic("sounds/gameWin.mp3");
    }

    public void act() {
        if (Mayflower.isKeyDown(Keyboard.KEY_ENTER)) {
            Mayflower.setWorld(new StartScreen());
        }
    }
}
