import mayflower.*;

public class GravityActor extends Actor {
   private double yVelocity;
   private boolean pastLimit;

   public void act() {
      yVelocity += 0.2;
      setLocation((double)getX(), (double)getY() + yVelocity);
      if (this.isBlocked()) {
         this.yVelocity = 0.0;
         this.setLocation((double)this.getX(), (double)this.getY() - this.yVelocity);
      }
      pastLimit = false;
      if (getY() < 50) {
         setLocation(getX(), getY() - yVelocity);
         pastLimit = true;
      } 
      // else if (getY() > 450) {
      //    setLocation(getX(), (int)(getY() - yVelocity - 1));
      //    pastLimit = true;
      // }
      

   }

   public boolean isBlocked() {
      return isTouching(Platform.class);
   }

   public boolean isFalling() {
      setLocation((double)getX(), (double)(getY() + 1));
      boolean output = isTouching(Platform.class);

      while(isTouching(Platform.class)) {
         setLocation((double)getX(), (double)(getY() - 1));
         yVelocity = 0;
      }

      return !output;
   }

   public double getYVelocity() {
      return yVelocity;
   }

   public void setYVelocity(double yV) {
      yVelocity = yV;
   }

   public boolean isPastLimit() {
      return pastLimit;
   }
}
