import mayflower.*;

public class StartScreen extends World {
    private static Player playerCharacter;

    public StartScreen() {
        setBackground("src/img/BG/gamingwall.png");
    }

    // When enter is pressed, go from starting screen to world 1
    public void act() {
        if (Mayflower.isKeyDown(Keyboard.KEY_ENTER)) {
            playerCharacter = new Player();
            Mayflower.setWorld(new BossWorld());
        }
    }

    public static Player getPlayer() {
        return playerCharacter;
    }
}
