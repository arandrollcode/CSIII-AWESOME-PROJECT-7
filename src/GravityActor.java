import mayflower.*;

public class GravityActor extends Actor {
   private double yVelocity;
   private boolean pastLimit;

   public void act() {
      yVelocity += 0.2;
      setLocation((double) getX(), (double) getY() + yVelocity);
      if (isBlocked()) {
         yVelocity = 0.0;
         setLocation((double) getX(), (double) getY() - yVelocity);
      }
      pastLimit = false;
      if (getY() < 100) {
         setLocation(getX(), getY() - yVelocity);
         pastLimit = true;
      }

   }

   public boolean isBlocked() {
      return isTouching(Platform.class);
   }

   public boolean isFalling() {
      setLocation((double) getX(), (double) (getY() + 1));
      boolean output = isTouching(Platform.class);
      boolean onTop, onLeft, onRight;

      // Move player if standing on top of moving block
      if (isTouching(MovingBlock.class)) {
         MovingBlock moving = getOneIntersectingObject(MovingBlock.class);
         setLocation(getX() + moving.getDirection(), getY());
      }

      // Control player interaction with blocks
      // Move to top of block if standing on top
      // Move to right slightly if touching left side
      // Move to left slightly if touching right side
      Platform platform = getOneIntersectingObject(Platform.class);
      while (isTouching(Platform.class)) {
         yVelocity = 0;
         // Evaluates to true if on top of a platform
         onTop = getY() + getHeight() > platform.getY() && getY() < platform.getY();
         // Evaluates to true if touching the left of a platform
         onLeft = !(getX() + getWidth() > platform.getX() + 3);
         // Evaluates to true if touching the right of a platform
         onRight = !(getX() + 3 < platform.getX() + platform.getWidth());

         // Keeps player above block if it's resting on top
         if (!onLeft && !onRight) {
            if (onTop)
               setLocation((double) getX(), (double) (getY() - 1));
            else
               setLocation((double) getX(), (double) (getY() + 1));

         }
         // Moves it to left if it's touching the left side, 
         //moves to right if it's touching the right side
         else if (onLeft) {
            setLocation((double) getX() - 1, (double) (getY() - 1));
            break;
         } else if (onRight) {
            setLocation((double) getX() + 1, (double) (getY() - 1));
            break;
         }
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
