import mayflower.*;

public class Player extends MovableAnimatedActor {
   private Animation walkRight, walkLeft, idleRight, idleLeft, fallRight, fallLeft;
   private int score, lives;

   public Player() {
      initializeAnimations();
      score = 0;
      lives = 3;
   }

   private void updateText() {
      World w = getWorld();
      w.removeText(10, 30);
      w.showText("Score: " + score + " | Lives: " + lives, 10, 30, Color.BLACK);
   }

   public void increaseScore(int amount) {
      score += amount;
   }

   private void initializeAnimations() {
      String[] frames = new String[10];

      for (int i = 1; i <= 10; i++) {
         frames[i - 1] = "src/img/sprite/Walk (" + i + ").png";
      }
      walkRight = new Animation(50000000, frames);
      walkRight.scale(100, 87);
      walkRight.setBounds(18, 5, 54, 80);
      walkLeft = new Animation(50000000, frames);
      walkLeft.scale(100, 87);
      walkLeft.mirrorHorizontally();
      walkLeft.setBounds(28, 5, 54, 80);

      for (int i = 1; i <= 10; i++) {
         frames[i - 1] = "src/img/sprite/Idle (" + i + ").png";
      }
      idleRight = new Animation(50000000, frames);
      idleRight.scale(100, 87);
      idleRight.setBounds(18, 5, 54, 80);
      idleLeft = new Animation(50000000, frames);
      idleLeft.scale(100, 87);
      idleLeft.mirrorHorizontally();
      idleLeft.setBounds(27, 5, 54, 80);

      String[] fallFrames = new String[8];
      for (int i = 1; i <= 8; i++) {
         fallFrames[i - 1] = "src/img/sprite/Fall (" + i + ").png";
      }
      fallRight = new Animation(50000000, fallFrames);
      fallRight.scale(100, 87);
      fallRight.setBounds(12, 2, 55, 80);
      fallLeft = new Animation(50000000, fallFrames);
      fallLeft.scale(100, 87);
      fallLeft.mirrorHorizontally();
      fallLeft.setBounds(32, 2, 55, 80);

      setWalkRightAnimation(walkRight);
      setWalkLeftAnimation(walkLeft);
      setIdleRightAnimation(idleRight);
      setIdleLeftAnimation(idleLeft);
      setFallRightAnimation(fallRight);
      setFallLeftAnimation(fallLeft);
   }

   public void act() {
      super.act();
      if (isDead() && lives > 0) {
         // Respawn at bottom and reset platforms
         respawn();
         Platform.setMovedDown(0);
      } else if (lives <= 0) {
         // Set to game over screen when out of lives
         Mayflower.setWorld(new StartScreen());
      }
      updateText();
   }

   public void respawn() {
      setDead(false);
      setLocation(100, 400);
      lives--;
   }
}
