public class Cat extends MovableAnimatedActor {
    private Animation walkRight;
    private Animation walkLeft;
    private Animation idleRight;
    private Animation idleLeft;
    private Animation fallRight;
    private Animation fallLeft;
 
    public Cat() {
       String[] frames = new String[10];
 
       for(int i = 1; i <= 10; ++i) {
          frames[i - 1] = "Project1/src/img/cat/Walk (" + i + ").png";
       }
 
       this.walkRight = new Animation(50000000, frames);
       this.walkRight.scale(100, 87);
       this.walkRight.setBounds(18, 5, 54, 80);
       this.walkLeft = new Animation(50000000, frames);
       this.walkLeft.scale(100, 87);
       this.walkLeft.mirrorHorizontally();
       this.walkLeft.setBounds(28, 5, 54, 80);
 
       for(int i = 1; i <= 10; ++i) {
          frames[i - 1] = "Project1/src/img/cat/Idle (" + i + ").png";
       }
 
       this.idleRight = new Animation(50000000, frames);
       this.idleRight.scale(100, 87);
       this.idleRight.setBounds(18, 5, 54, 80);
       this.idleLeft = new Animation(50000000, frames);
       this.idleLeft.scale(100, 87);
       this.idleLeft.mirrorHorizontally();
       this.idleLeft.setBounds(27, 5, 54, 80);
       String[] fallFrames = new String[8];
 
       for(int i = 1; i <= 8; ++i) {
          fallFrames[i - 1] = "Project1/src/img/cat/Fall (" + i + ").png";
       }
 
       this.fallRight = new Animation(50000000, fallFrames);
       this.fallRight.scale(100, 87);
       this.fallRight.setBounds(12, 2, 55, 82);
       this.fallLeft = new Animation(50000000, fallFrames);
       this.fallLeft.scale(100, 87);
       this.fallLeft.mirrorHorizontally();
       this.fallLeft.setBounds(32, 2, 55, 82);
       this.setWalkRightAnimation(this.walkRight);
       this.setWalkLeftAnimation(this.walkLeft);
       this.setIdleRightAnimation(this.idleRight);
       this.setIdleLeftAnimation(this.idleLeft);
       this.setFallRightAnimation(this.fallRight);
       this.setFallLeftAnimation(this.fallLeft);
    }
 
    public void act() {
       super.act();
    }
 }
 