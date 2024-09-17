public class Cat extends MovableAnimatedActor {
    private Animation walkRight, walkLeft, idleRight, idleLeft, fallRight, fallLeft;
 
    public Cat() {
       String[] frames = new String[10];
 
       for(int i = 1; i <= 10; ++i) {
          frames[i - 1] = "src/img/cat/Walk (" + i + ").png";
       }
 
       walkRight = new Animation(50000000, frames);
       walkRight.scale(100, 87);
       walkRight.setBounds(18, 5, 54, 80);
       walkLeft = new Animation(50000000, frames);
       walkLeft.scale(100, 87);
       walkLeft.mirrorHorizontally();
       walkLeft.setBounds(28, 5, 54, 80);
 
       for(int i = 1; i <= 10; ++i) {
          frames[i - 1] = "src/img/cat/Idle (" + i + ").png";
       }
 
       idleRight = new Animation(50000000, frames);
       idleRight.scale(100, 87);
       idleRight.setBounds(18, 5, 54, 80);
       idleLeft = new Animation(50000000, frames);
       idleLeft.scale(100, 87);
       idleLeft.mirrorHorizontally();
       idleLeft.setBounds(27, 5, 54, 80);
       String[] fallFrames = new String[8];
 
       for(int i = 1; i <= 8; ++i) {
          fallFrames[i - 1] = "src/img/cat/Fall (" + i + ").png";
       }
 
       fallRight = new Animation(50000000, fallFrames);
       fallRight.scale(100, 87);
       fallRight.setBounds(12, 2, 55, 82);
       fallLeft = new Animation(50000000, fallFrames);
       fallLeft.scale(100, 87);
       fallLeft.mirrorHorizontally();
       fallLeft.setBounds(32, 2, 55, 82);
       setWalkRightAnimation(walkRight);
       setWalkLeftAnimation(walkLeft);
       setIdleRightAnimation(idleRight);
       setIdleLeftAnimation(idleLeft);
       setFallRightAnimation(fallRight);
       setFallLeftAnimation(fallLeft);
    }
 
    public void act() {
       super.act();
    }
 }
 