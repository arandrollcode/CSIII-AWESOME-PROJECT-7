import mayflower.Timer;

public class AnimatedActor extends GravityActor {
   private Animation animation;
   private Timer animationTimer = new Timer(1000);

   public void setAnimation(Animation a) {
      this.animation = a;
      this.animationTimer = new Timer(a.getFrameRate());
   }

   public void act() {
      super.act();
      if (this.animation != null && this.animationTimer.isDone()) {
         this.animationTimer.reset();
         this.setImage(this.animation.getNextFrame());
      }

   }
}
