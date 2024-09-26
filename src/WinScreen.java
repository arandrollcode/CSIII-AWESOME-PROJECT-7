import mayflower.*;

public class WinScreen extends World {
    public WinScreen() {
        setBackground("src/img/BG/winscreen.png");
    }

    public void act() {
        if (Mayflower.isKeyDown(Keyboard.KEY_ENTER)) {
            Mayflower.setWorld(new StartScreen());
        }
    }
}
