import mayflower.*;

public class StartScreen extends World {
    private static Player playerCharacter;

    public StartScreen() {
        setBackground("img/BG/gamingwall.png");
    }

    // When enter is pressed, go from starting screen to world 1
    public void act() {
        if (Mayflower.isKeyDown(Keyboard.KEY_ENTER)) {
            playerCharacter = new Player();
            Mayflower.setWorld(new World1());
        }
    }

    public static Player getPlayer() {
        return playerCharacter;
    }
}
