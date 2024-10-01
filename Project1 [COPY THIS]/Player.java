import mayflower.*;

public class Player extends MovableAnimatedActor {
   private Animation walkRight, walkLeft, idleRight, idleLeft, fallRight, fallLeft;
   private int score, lives;

   public Player() {
      initializeAnimations();
      score = 0;
      lives = 3;
   }

   // updates score when coins are picked up
   // updates lives if fallen down
   private void updateText() {
      World w = getWorld();
      w.removeText(10, 30);
      w.showText("Score: " + score + " | Lives: " + lives, 10, 30, Color.BLACK);
   }

   public void increaseScore(int amount) {
      score += amount;
   }

   public void decreaseLives(int amount) {
      lives -= amount;
   }

   // Checks if player is dead
   public void act() {
      super.act();
      if (isDead() && lives > 0) {
         // Respawn at bottom and reset platforms
         respawn();
         Platform.setMovedDown(0);
      } else if (lives <= 0) {
         // Set to game over screen when out of lives
         Mayflower.setWorld(new DeathScreen());
      }
      updateText();
   }

   public void respawn() {
      setDead(false);
      setLocation(300, 400);
      lives--;
   }

   // Initializes walking/idle/fall animations
   private void initializeAnimations() {
      String[] frames = new String[10];

      for (int i = 1; i <= 10; i++) {
         frames[i - 1] = "img/sprite/Walk (" + i + ").png";
      }
      int WIDTH = 45;
      int HEIGHT = 74;

      walkRight = new Animation(50000000, frames);
      walkRight.scale(100, 87);
      walkRight.setBounds(24, 10, WIDTH, HEIGHT);
      walkLeft = new Animation(50000000, frames);
      walkLeft.scale(100, 87);
      walkLeft.mirrorHorizontally();
      walkLeft.setBounds(29, 10, WIDTH, HEIGHT);

      for (int i = 1; i <= 10; i++) {
         frames[i - 1] = "img/sprite/Idle (" + i + ").png";
      }
      idleRight = new Animation(50000000, frames);
      idleRight.scale(100, 87);
      idleRight.setBounds(25, 13, WIDTH, HEIGHT);
      idleLeft = new Animation(50000000, frames);
      idleLeft.scale(100, 87);
      idleLeft.mirrorHorizontally();
      idleLeft.setBounds(30, 13, WIDTH, HEIGHT);

      String[] fallFrames = new String[8];
      for (int i = 1; i <= 8; i++) {
         fallFrames[i - 1] = "img/sprite/Fall (" + i + ").png";
      }
      fallRight = new Animation(50000000, fallFrames);
      fallRight.scale(100, 87);
      fallRight.setBounds(18, 10, WIDTH, HEIGHT);
      fallLeft = new Animation(50000000, fallFrames);
      fallLeft.scale(100, 87);
      fallLeft.mirrorHorizontally();
      fallLeft.setBounds(37, 10, WIDTH, HEIGHT);

      setWalkRightAnimation(walkRight);
      setWalkLeftAnimation(walkLeft);
      setIdleRightAnimation(idleRight);
      setIdleLeftAnimation(idleLeft);
      setFallRightAnimation(fallRight);
      setFallLeftAnimation(fallLeft);
   }
}
