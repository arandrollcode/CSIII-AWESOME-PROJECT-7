import mayflower.*;

public class AnimatedActor extends GravityActor {
   private Animation animation;
   private Timer animationTimer = new Timer(1000);

   public void setAnimation(Animation a) {
      animation = a;
      animationTimer = new Timer(a.getFrameRate());
   }

   public void act() {
      super.act();
      if (animation != null && animationTimer.isDone()) {
         animationTimer.reset();
         setImage(animation.getNextFrame());
      }

   }
}
