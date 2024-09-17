import mayflower.Actor;

public class GravityActor extends Actor {
   private double yVelocity = 0.0D;

   public void act() {
      yVelocity += 0.2D;
      setLocation((double)getX(), (double)getY() + yVelocity);
      if (isBlocked()) {
         yVelocity = 0.0D;
         setLocation((double)getX(), (double)getY() - yVelocity);
      }

   }

   public boolean isBlocked() {
      return isTouching(Block.class);
   }

   public boolean isFalling() {
      setLocation((double)getX(), (double)(getY() + 1));
      boolean output = isTouching(Block.class);

      while(isTouching(Block.class)) {
         setLocation((double)getX(), (double)(getY() - 1));
      }

      return !output;
   }

   public double getYVelocity() {
      return yVelocity;
   }

   public void setYVelocity(double yV) {
      yVelocity = yV;
   }
}
