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

      Platform platform = getOneIntersectingObject(Platform.class);
      while (isTouching(Platform.class)) {
         yVelocity = 0;
         onTop = getY() + getHeight() > platform.getY() && getY() < platform.getY();
         onLeft = !(getX() + getWidth() > platform.getX() + 3);
         onRight = !(getX() + 3 < platform.getX() + platform.getWidth());

         // Keeps player above block if it's resting on top
         if (!onLeft && !onRight) {
            if (onTop) {
               setLocation((double) getX(), (double) (getY() - 1));
            } else
               setLocation((double) getX(), (double) (getY() + 1));

         }
         // Moves it to left if it's touching the left side, moves to right if it's
         // touching the right side
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
