import mayflower.*;

public class StartScreen extends World {
    private static MovableAnimatedActor playerCharacter;

    public StartScreen() {
        Mayflower.showBounds(true);
        setBackground("src/img/BG/gamingwall.png");
        // showText("Welcome to EPIC GAMING GAME", 45, 0, 200, Color.RED);
        // showText("Press [ENTER] to Start", 45, 0, getHeight() / 2, Color.BLACK);
    }

    public void act() {
        if (Mayflower.isKeyDown(Keyboard.KEY_ENTER)) {
            playerCharacter = new Cat();
            Mayflower.setWorld(new World1());
        }
    }

    public static MovableAnimatedActor getPlayer() {
        return playerCharacter;
    }
}
