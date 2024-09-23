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

      Platform platform = getOneIntersectingObject(Platform.class);
      while(isTouching(Platform.class)) {
         yVelocity = 0;
         if (getY() <= platform.getY()) {
            setLocation((double)getX(), (double)(getY() - 1));
         }
         else if (getY() - 1 < platform.getY() + platform.getHeight()) {
            setLocation((double)getX(), (double)(getY() + 1));

         }
         // System.err.println(getX() + " " + platform.getX() + " " + getWidth());
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
