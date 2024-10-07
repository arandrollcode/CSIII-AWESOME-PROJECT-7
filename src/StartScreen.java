import mayflower.*;

public class StartScreen extends World {
    private static Player playerCharacter;

    public StartScreen() {
        setBackground("src/img/BG/gamingwall.png");
    }

    // When enter is pressed, go from starting screen to world 1
    public void act() {
        if (Mayflower.isKeyPressed(Keyboard.KEY_ENTER)) {
            playerCharacter = new Player();
            Mayflower.setWorld(new World1());
        }

        // Developer hacks
        if (Mayflower.isKeyPressed(Keyboard.KEY_LSHIFT)) {
            playerCharacter = new Player();
            Mayflower.setWorld(new World3());
        }
    }

    public static Player getPlayer() {
        return playerCharacter;
    }
}
