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
      } else if (getY() > 450) {
         setLocation(getX(), (int)(getY() - yVelocity - 1));
         pastLimit = true;
      }
      

   }

   public boolean isBlocked() {
      return this.isTouching(Block.class);
   }

   public boolean isFalling() {
      this.setLocation((double)this.getX(), (double)(this.getY() + 1));
      boolean output = this.isTouching(Block.class);

      while(this.isTouching(Block.class)) {
         this.setLocation((double)this.getX(), (double)(this.getY() - 1));
      }

      return !output;
   }

   public double getYVelocity() {
      return this.yVelocity;
   }

   public void setYVelocity(double yV) {
      this.yVelocity = yV;
   }

   public boolean isPastLimit() {
      return pastLimit;
   }
}
