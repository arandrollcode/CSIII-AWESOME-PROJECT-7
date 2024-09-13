import mayflower.Actor;

public class GravityActor extends Actor {
   private double yVelocity = 0.0D;

   public void act() {
      this.yVelocity += 0.2D;
      this.setLocation((double)this.getX(), (double)this.getY() + this.yVelocity);
      if (this.isBlocked()) {
         this.yVelocity = 0.0D;
         this.setLocation((double)this.getX(), (double)this.getY() - this.yVelocity);
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
}
